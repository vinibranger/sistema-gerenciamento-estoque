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

public class ConsultarClienteController implements Initializable {

    @FXML
    private TableColumn<Cliente, String> bairroCliente;

    @FXML
    private TableColumn<Cliente, String> cidadeCliente;

    @FXML
    private TableColumn<Cliente, String> cnpj_cpfCliente;

    @FXML
    private TableColumn<Cliente, Integer> codCliente;

    @FXML
    private TableColumn<Cliente, String> emailCliente;

    @FXML
    private TableColumn<Cliente, String> nomeCliente;

    @FXML
    private TableColumn<Cliente, String> numeroCliente;

    @FXML
    private TableColumn<Cliente, String> ruaCliente;
    @FXML
    private TableColumn<Cliente, String> telefoneCliente;
    @FXML
    private TextField nomePesquisa;
    @FXML
    private TableView<Cliente> tableCliente;

    public ObservableList<Cliente> cliente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.codCliente.setCellValueFactory(new PropertyValueFactory<>("codigoCliente"));
        this.nomeCliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.cnpj_cpfCliente.setCellValueFactory(new PropertyValueFactory<>("cnpjCpf"));
        this.emailCliente.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.telefoneCliente.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        this.ruaCliente.setCellValueFactory(new PropertyValueFactory<>("rua"));
        this.numeroCliente.setCellValueFactory(new PropertyValueFactory<>("numeEndereco"));
        this.bairroCliente.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        this.cidadeCliente.setCellValueFactory(new PropertyValueFactory<>("cidade"));

        this.cliente = this.tableCliente.getItems();
        
        ClienteDAO daoDeCliente = new ClienteDAO();
        List<Cliente> clienteNoBanco = daoDeCliente.getAll();
        this.cliente.addAll(clienteNoBanco);
        

    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        App.setRoot("Principal");

    }
    
    @FXML
    private void pesquisarCliente(ActionEvent event) throws IOException {
        ClienteDAO daoDeCliente = new ClienteDAO();
        List<Cliente> clienteDAONoBanco = daoDeCliente.mostraPeloNome(nomePesquisa.getText());

        this.cliente.clear();//limpa para nao duplicar 
        this.cliente.addAll(clienteDAONoBanco);//sozinho duplica os produtos da lista
    }
     @FXML
    void remover() throws IOException {
        Cliente clienteSelecionado = this.tableCliente.getSelectionModel().getSelectedItem();
        //quando for remover vem a confirmaçao de remover
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remover");
        alert.setHeaderText(clienteSelecionado.getCodigoCliente()+ " " + clienteSelecionado.getNome());
        alert.setContentText("Deseja Remover o Registro ? ");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            this.cliente.remove(clienteSelecionado);
        }
        this.tableCliente.refresh();
         ClienteDAO daoDoCliente= new  ClienteDAO();
        daoDoCliente.delete(clienteSelecionado);
        this.tableCliente.refresh();
    }
    @FXML
    private void novo(ActionEvent event) throws IOException {
        App.setRoot("CadastroCliente");

    }
    
     @FXML
    void editar() throws IOException {
        Cliente clienteSelecionado = this.tableCliente.getSelectionModel().getSelectedItem();
        if (clienteSelecionado != null) {
            CadastroClienteController.cliente = clienteSelecionado;

            App.setRoot("CadastroCliente");

            Cliente clienteAlterado = CadastroClienteController.cliente;

            clienteSelecionado.setCodigoCliente(clienteAlterado.getCodigoCliente());
            clienteSelecionado.setNome(clienteAlterado.getNome());
            clienteSelecionado.setCnpjCpf(clienteAlterado.getCnpjCpf());
            clienteSelecionado.setEmail(clienteAlterado.getEmail());
            clienteSelecionado.setTelefone(clienteAlterado.getTelefone());
            clienteSelecionado.setRua(clienteAlterado.getRua());
            clienteSelecionado.setNumeEndereco(clienteAlterado.getNumeEndereco());
            clienteSelecionado.setBairro(clienteAlterado.getBairro());
            clienteSelecionado.setCidade(clienteAlterado.getCidade());

            this.tableCliente.refresh();

            ClienteDAO daoDoCliente = new ClienteDAO();
            daoDoCliente.update(clienteSelecionado);
            

        }
    }

}
