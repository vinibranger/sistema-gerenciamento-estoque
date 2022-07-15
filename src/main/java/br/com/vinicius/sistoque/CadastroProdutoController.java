package br.com.vinicius.sistoque;

import static br.com.vinicius.sistoque.CadastroFuncioController.funcionario;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class CadastroProdutoController implements Initializable {

    public static Produto produto;
    public static Fornecedor fornecedor;

    @FXML
    private ComboBox<Fornecedor> fornecedorcombo;
    @FXML
    private TextField codigoTextField;
    @FXML
    private TextField descriçaoTextField;
    @FXML
    private TextField localEstoqueTextField;
    @FXML
    private TextField nomeTextField;
    @FXML
    private TextField quantidadeTextField;
    @FXML
    private TextField unidadeTextField;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (produto != null) {
            codigoTextField.setText(Integer.toString(produto.getCodigo()));
            quantidadeTextField.setText(Integer.toString(produto.quantidade));
            nomeTextField.setText(produto.getNome());
            unidadeTextField.setText(produto.getUnidade());
            localEstoqueTextField.setText(produto.getLocalEstoque());
            descriçaoTextField.setText(produto.getDescricao());
          
            FuncionarioDAO daoDoFuncionario = new  FuncionarioDAO();
            daoDoFuncionario.update( funcionario);
        }
        
        nomeFornecedores();
    }

    @FXML
    public void salvar() throws IOException {
        if (!this.codigoTextField.getText().isEmpty() //
                && !this.descriçaoTextField.getText().isEmpty() //
                && !this.localEstoqueTextField.getText().isEmpty() //
                && !this.nomeTextField.getText().isEmpty() //
                && !this.unidadeTextField.getText().isEmpty() //
                && !this.quantidadeTextField.getText().isEmpty());
        {
            //armazena variavel user digitou

            produto = new Produto( //
                    Integer.parseInt(this.codigoTextField.getText()), // 
                    Integer.parseInt(this.quantidadeTextField.getText()), // 
                    this.nomeTextField.getText(), //
                    this.unidadeTextField.getText(), //
                    this.localEstoqueTextField.getText(), //
                    this.descriçaoTextField.getText(), //
                    this.fornecedorcombo.getValue().getNomeForne());
            //salvar no banco
            ProdutoDAO daoDoProduto = new ProdutoDAO();
            daoDoProduto.salvar(produto);
        }
        //msg apos salvar
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Produto Cadastrado!");
        alert.setHeaderText("Deseja fazer um novo cadastro?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            //Limpar text fild da tela
            this.codigoTextField.setText(null);
            this.quantidadeTextField.setText(null);
            this.descriçaoTextField.setText(null);
            this.localEstoqueTextField.setText(null);
            this.unidadeTextField.setText(null);
            this.nomeTextField.setText(null);
            this.fornecedorcombo.setValue(null);

        } else {
            App.setRoot("Principal");
        }

    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        App.setRoot("Principal");

    }

//para puxar as info para o combox
    private void nomeFornecedores() {
        FornecedorDAO dao = new FornecedorDAO();       
        ObservableList<Fornecedor> fornecedores = FXCollections.observableArrayList(dao.getAll());
        fornecedorcombo.setItems(fornecedores);
        
        fornecedorcombo.setConverter(new StringConverter<Fornecedor>() {

            @Override
            public String toString(Fornecedor fornecedor) {
                if (fornecedor == null) {
                    return null;
                }
                return fornecedor.getNomeForne();
            }

            @Override
            public Fornecedor fromString(String string) {
                return fornecedorcombo.getItems().stream().filter(fornecedor -> 
                    fornecedor.getNomeForne().equals(string)).findFirst().orElse(null);
            }
        });
        
    }

}
