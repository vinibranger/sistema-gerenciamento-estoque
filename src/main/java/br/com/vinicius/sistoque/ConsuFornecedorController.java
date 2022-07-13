package br.com.vinicius.sistoque;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConsuFornecedorController implements Initializable {

    public static Fornecedor fornecedor;
    @FXML
    private TableColumn<Fornecedor, String> bairroFornecedorTable;

    @FXML
    private TableColumn<Fornecedor, String> cidadeFornecedorTable;

    @FXML
    private TableColumn<Fornecedor, String> cnpjForneTable;

    @FXML
    private TableColumn<Fornecedor, Integer> codFornecedorTable;

    @FXML
    private TableColumn<Fornecedor, String> emailFornecedorTable;

    @FXML
    private TableColumn<Fornecedor, String> nomeForneceTable;

    @FXML
    private TableColumn<Fornecedor, String> numeroFornecedorTable;

    @FXML
    private TableColumn<Fornecedor, String> ruaFornecedorTable;

    @FXML
    private TableColumn<Fornecedor, String> telefoneFornecedorTable;
    @FXML
    private TextField pesquisaNome;

    @FXML
    private TableView<Fornecedor> tableFornecedorEstoque;

    public static ObservableList<Fornecedor> fornecedores;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.codFornecedorTable.setCellValueFactory(new PropertyValueFactory<>("codigoForne"));
        this.nomeForneceTable.setCellValueFactory(new PropertyValueFactory<>("nomeForne"));
        this.cnpjForneTable.setCellValueFactory(new PropertyValueFactory<>("cnpjForne"));
        this.emailFornecedorTable.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.telefoneFornecedorTable.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        this.ruaFornecedorTable.setCellValueFactory(new PropertyValueFactory<>("rua"));
        this.numeroFornecedorTable.setCellValueFactory(new PropertyValueFactory<>("numero"));
        this.bairroFornecedorTable.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        this.cidadeFornecedorTable.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        this.fornecedores = this.tableFornecedorEstoque.getItems();
        //cria lista add com produtos do banco depois mostra a lista na tabela
        FornecedorDAO daoDeFornecedor = new FornecedorDAO();
        List<Fornecedor> fornecedorNoBanco = daoDeFornecedor.getAll();
        this.fornecedores.addAll(fornecedorNoBanco);
    }

    @FXML
    void remover()  {
        Fornecedor produtoSelecionado = this.tableFornecedorEstoque.getSelectionModel().getSelectedItem();
        //quando for remover vem a confirmaçao de remover
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remover");
        alert.setHeaderText(produtoSelecionado.getCodigoForne() + " " + produtoSelecionado.getNomeForne());
        alert.setContentText("Deseja Remover o Registro ? ");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            this.fornecedores.remove(produtoSelecionado);
        }
        FornecedorDAO daoDoFornecedor = new FornecedorDAO();
        daoDoFornecedor.delete(produtoSelecionado);
        
    }

    @FXML
    void editar() throws IOException {
        Fornecedor fornecedorSelecionado = this.tableFornecedorEstoque.getSelectionModel().getSelectedItem();
        if (fornecedorSelecionado != null) {
            CadasFornecedorController.fornecedor = fornecedorSelecionado;

            App.setRoot("CadasFornecedor");

            Fornecedor fornecedorAlterado = CadasFornecedorController.fornecedor;

            fornecedorSelecionado.setCodigoForne(fornecedorAlterado.getCodigoForne());
            fornecedorSelecionado.setNomeForne(fornecedorAlterado.getNomeForne());
            fornecedorSelecionado.setCnpjForne(fornecedorAlterado.getCnpjForne());
            fornecedorSelecionado.setEmail(fornecedorAlterado.getEmail());
            fornecedorSelecionado.setTelefone(fornecedorAlterado.getTelefone());
            fornecedorSelecionado.setRua(fornecedorAlterado.getRua());
            fornecedorSelecionado.setNumero(fornecedorAlterado.getNumero());
            fornecedorSelecionado.setBairro(fornecedorAlterado.getBairro());
            fornecedorSelecionado.setCidade(fornecedorAlterado.getCidade());

            this.tableFornecedorEstoque.refresh();

            FornecedorDAO daoDoFornecedor = new FornecedorDAO();
            daoDoFornecedor.update(fornecedorSelecionado);

        }
    }

    @FXML
    private void pesquisarFornecedor(ActionEvent event) throws IOException {
        FornecedorDAO daoDeProdutos = new FornecedorDAO();
        List<Fornecedor> fornecedorDAONoBanco = daoDeProdutos.mostraPeloNome(pesquisaNome.getText());

        this.fornecedores.clear();//limpa para nao duplicar 
        this.fornecedores.addAll(fornecedorDAONoBanco);//sozinho duplica os produtos da lista
    }

    public static void setFornecedor(Fornecedor fornecedor) {
        CadasFornecedorController.fornecedor = fornecedor;
    }

    public static Fornecedor getFornecedor() {
        return CadasFornecedorController.fornecedor;
    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        App.setRoot("Principal");

    }
    @FXML
    private void novo(ActionEvent event) throws IOException {
        App.setRoot("CadasFornecedor");

    }

}
