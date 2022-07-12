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
import javafx.stage.Stage;

public class TelaLogiController implements Initializable {

    @FXML
    Button buttonSair;
    @FXML
    PasswordField senhaPasswordField;
    @FXML
    TextField usuarioTextField;
    
    
    public int nivelDeAcesso;

    public static Usuario usuario;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void login() throws IOException {

        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuarioLogin = new Usuario(usuarioTextField.getText(), senhaPasswordField.getText());

        boolean usuarioExiste = dao.existe(usuarioLogin);

        if (usuarioExiste) {

            Stage stage = (Stage) this.usuarioTextField.getScene().getWindow();
            stage.setMaximized(true);
            stage.setResizable(true);
            
            UsuarioDAO daoDoUsuario = new UsuarioDAO();
            this.nivelDeAcesso =  daoDoUsuario.retornaNivelAcesso(usuarioTextField);
            
            

            App.setRoot("Principal");
            
            
            
            
        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Falha no Login");
            alert.setHeaderText(null);
            alert.setContentText("Usuário ou a senha inserida é inválido");

            alert.showAndWait();
        }

    }

    @FXML
    void botaoSair() {
        System.exit(0);

    }

}
