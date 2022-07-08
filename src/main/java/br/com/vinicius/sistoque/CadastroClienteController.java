package br.com.vinicius.sistoque;

import static br.com.vinicius.sistoque.CadasFornecedorController.fornecedor;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class CadastroClienteController implements Initializable {

    public static Cliente cliente;

    @FXML
    private TextField bairroClientTextField;

    @FXML
    private TextField cidadeClientTextField;

    @FXML
    private TextField cnpjCpfClientTextField;

    @FXML
    private TextField codClientTextField;

    @FXML
    private TextField emailClientTextField;

    @FXML
    private TextField nomeClientTextField;

    @FXML
    private TextField numeroClientTextField;

    @FXML
    private TextField ruaClientTextField;

    @FXML
    private TextField telefoneClientTextField;

    @FXML
    private Button buttonVoltar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void salvar() throws IOException {
        if (!this.codClientTextField.getText().isEmpty() //
                && !this.telefoneClientTextField.getText().isEmpty() //
                && !this.ruaClientTextField.getText().isEmpty() //
                && !this.numeroClientTextField.getText().isEmpty() //
                && !this.nomeClientTextField.getText().isEmpty() //
                && !this.emailClientTextField.getText().isEmpty() //
                && !this.cnpjCpfClientTextField.getText().isEmpty() //
                && !this.cidadeClientTextField.getText().isEmpty() //
                && !this.bairroClientTextField.getText().isEmpty()) {
                
            cliente=new Cliente(//
                    Integer.parseInt(this.codClientTextField.getText()), // 
                    this.telefoneClientTextField.getText(), //
                    this.ruaClientTextField.getText(), //
                    this.numeroClientTextField.getText(), //
                    this.nomeClientTextField.getText(), //
                    this.emailClientTextField.getText(), //
                    this.cnpjCpfClientTextField.getText(), //
                    this.cidadeClientTextField.getText(), //
                    this.bairroClientTextField.getText());
                        

            ClienteDAO daoDoCliente = new ClienteDAO();
            daoDoCliente.salvar(cliente);
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cliente Cadastrado!");
        alert.setHeaderText("Deseja fazer um novo cadastro?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            this.codClientTextField.setText(null);
            this.telefoneClientTextField.setText(null);
            this.numeroClientTextField.setText(null);
            this.ruaClientTextField.setText(null);
            this.nomeClientTextField.setText(null);
            this.emailClientTextField.setText(null);
            this.cnpjCpfClientTextField.setText(null);
            this.cidadeClientTextField.setText(null);
            this.bairroClientTextField.setText(null);
            
        } else {
            App.setRoot("Principal");
        }

    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        App.setRoot("Principal");

    }

}
