package br.com.vinicius.sistoque;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class UserCadastroController implements Initializable {

    public static Usuario usuario;

    @FXML
    private TextField nomeUser;
    @FXML
    private TextField niveldeAcesso;

    @FXML
    private TextField senhaUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.nomeUser.setText(null);
        this.senhaUser.setText(null);
        this.niveldeAcesso.setText(null);
    }

    @FXML
    public void salvar() throws IOException {

        //armazena variavel user digitou
        usuario = new Usuario( //
                this.nomeUser.getText(), //
                this.senhaUser.getText(),
               Integer.parseInt( this.niveldeAcesso.getText()));

        //salvar no banco
        UsuarioDAO daoDeUsuario = new UsuarioDAO();
        daoDeUsuario.salvar(usuario);

        //msg apos salvar
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Usuário Cadastrado!");
        alert.setHeaderText("Deseja fazer um novo cadastro?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            //Limpar text fild da tela
            this.nomeUser.setText(null);
            this.senhaUser.setText(null);

        } else {
            App.setRoot("Principal");
        }

    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        App.setRoot("Principal");

    }

}
