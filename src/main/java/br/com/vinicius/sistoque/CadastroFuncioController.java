package br.com.vinicius.sistoque;

import static br.com.vinicius.sistoque.CadastroProdutoController.produto;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CadastroFuncioController implements Initializable {

    public static Funcionario funcionario;
    @FXML
    private TextField bairro;

    @FXML
    private TextField cidade;

    @FXML
    private TextField codigo;

    @FXML
    private TextField cpf;

    @FXML
    private DatePicker dataNasciDatapicker;

    @FXML
    private TextField email;

    @FXML
    private TextField nome;

    @FXML
    private TextField numero;

    @FXML
    private TextField rg;

    @FXML
    private TextField rua;

    @FXML
    private TextField telefone;
    @FXML
    private TextField nacionalidade;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void salvar() throws IOException {
        if (!this.codigo.getText().isEmpty() //
                && !this.cpf.getText().isEmpty() //
                && !this.bairro.getText().isEmpty() //
                && !this.email.getText().isEmpty() //
                && !this.nome.getText().isEmpty() //
                && !this.numero.getText().isEmpty() //
                && !this.rg.getText().isEmpty() //
                && !this.cidade.getText().isEmpty() //
                && !this.rua.getText().isEmpty() //
                && !this.nacionalidade.getText().isEmpty() //
                && !this.telefone.getText().isEmpty());
        {
            //armazena variavel user digitou

            funcionario = new Funcionario( //
                    Integer.parseInt(this.codigo.getText()), // 
                    Integer.parseInt(this.numero.getText()), //
                    Integer.parseInt(this.cpf.getText()), //
                    Integer.parseInt(this.rg.getText()), //
                    Integer.parseInt(this.telefone.getText()), //
                    this.nome.getText(), //
                    this.dataNasciDatapicker.getValue().toString(), //
                    this.nacionalidade.getText(), //
                    this.email.getText(), //
                    this.rua.getText(), //
                    this.bairro.getText(), //
                    this.cidade.getText());
            //salvar no banco
            FuncionarioDAO daoDoFuncionario = new FuncionarioDAO();
            daoDoFuncionario.salvar(funcionario);
        }
        //msg apos salvar
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Produto Cadastrado!");
        alert.setHeaderText("Deseja fazer um novo cadastro?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            //Limpar text fild da tela
            this.codigo.setText(null);
            this.cpf.setText(null);
            this.nacionalidade.setText(null);
            this.bairro.setText(null);
            this.cidade.setText(null);
            this.email.setText(null);
            this.nome.setText(null);
            this.numero.setText(null);
            this.rg.setText(null);
            this.rua.setText(null);
            this.telefone.setText(null);
            this.dataNasciDatapicker.setValue(null);

        } else {
            App.setRoot("Principal");
        }

    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        App.setRoot("Principal");

    }
}
