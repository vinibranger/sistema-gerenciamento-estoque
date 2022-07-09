package br.com.vinicius.sistoque;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class CadasFornecedorController implements Initializable {

    public static Fornecedor fornecedor;

    @FXML
    private TextField bairroForneTextField;

    @FXML
    private TextField cidadeForneTextField;

    @FXML
    private TextField cnpjCpfForneTextField;

    @FXML
    private TextField codForneTextField;

    @FXML
    private TextField emailForneTextField;

    @FXML
    private TextField nomeForneTextField;

    @FXML
    private TextField numeroForneTextField;

    @FXML
    private TextField ruaForneTextField;

    @FXML
    private TextField telefoneForneTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void salvar() throws IOException {
        if (!this.codForneTextField.getText().isEmpty() //
                && !this.cnpjCpfForneTextField.getText().isEmpty() //
                && !this.numeroForneTextField.getText().isEmpty() //
                && !this.nomeForneTextField.getText().isEmpty() //
                && !this.ruaForneTextField.getText().isEmpty() //
                && !this.telefoneForneTextField.getText().isEmpty() //
                && !this.emailForneTextField.getText().isEmpty() //
                && !this.cidadeForneTextField.getText().isEmpty() //
                && !this.bairroForneTextField.getText().isEmpty()) {

            fornecedor = new Fornecedor( //
                    Integer.parseInt(this.codForneTextField.getText()), // 
                    this.cnpjCpfForneTextField.getText(), //
                    this.numeroForneTextField.getText(), //
                    this.nomeForneTextField.getText(), //
                    this.ruaForneTextField.getText(), //
                    this.telefoneForneTextField.getText(), //
                    this.emailForneTextField.getText(), //
                    this.cidadeForneTextField.getText(), //
                    this.bairroForneTextField.getText());

            FornecedorDAO daoDoFornecedor = new FornecedorDAO();
            daoDoFornecedor.salvar(fornecedor);
        }

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Fornecedor Cadastrado!");
            alert.setHeaderText("Deseja fazer um novo cadastro?");
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                 //Limpar text fild da tela
                 this.codForneTextField.setText(null);
                 this.cnpjCpfForneTextField.setText(null);
                 this.numeroForneTextField.setText(null);
                 this.nomeForneTextField.setText(null);
                 this.ruaForneTextField.setText(null);
                 this.telefoneForneTextField.setText(null);
                 this.emailForneTextField.setText(null);
                 this.cidadeForneTextField.setText(null);
                 this.bairroForneTextField.setText(null);
                 
            } else {
                App.setRoot("Principal");
            }
        
            
        

    }


    

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        App.setRoot("Principal");
    }

}
