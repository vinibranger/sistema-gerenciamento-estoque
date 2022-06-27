package br.com.vinicius.sistoque;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TelaLogiController implements Initializable {
    @FXML
     Button buttonSair;
    @FXML
    PasswordField senhaPasswordField;
    @FXML
    TextField usuarioTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void login() throws IOException {
        if (usuarioTextField.getText().equals("Vini")) {
            if (senhaPasswordField.getText().equals("123")) {
                App.setRoot("Principal");
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Errorr");
                alert.setHeaderText(null);
                alert.setContentText("Senha Incorreta");
                alert.showAndWait();
            }

        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Errorr");
            alert.setHeaderText(null);
            alert.setContentText("Usuário Incorreto");
            alert.showAndWait();

        }

    }

    @FXML
    void botaoSair() {
        System.exit(0);

    }

}
