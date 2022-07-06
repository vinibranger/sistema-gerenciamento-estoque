package br.com.vinicius.sistoque;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

}
