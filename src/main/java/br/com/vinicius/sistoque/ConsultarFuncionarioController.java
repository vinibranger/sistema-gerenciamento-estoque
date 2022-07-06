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

public class ConsultarFuncionarioController implements Initializable {

    @FXML
    private TableColumn<Funcionario, String> bairroFuncio;

    @FXML
    private TableColumn<Funcionario, String> cidadeFuncio;

    @FXML
    private TableColumn<Funcionario, Integer> codigoFuncio;

    @FXML
    private TableColumn<Funcionario, String> cpfFuncio;

    @FXML
    private TableColumn<Funcionario, String> dataNascimentoFuncio;

    @FXML
    private TableColumn<Funcionario, String> emailFuncio;

    @FXML
    private TableColumn<Funcionario, String> nacionalidadeFuncio;

    @FXML
    private TableColumn<Funcionario, String> nomeFuncio;

    @FXML
    private TableColumn<Funcionario, String> numeroFuncio;

    @FXML
    private TableColumn<Funcionario, String> rgFuncio;

    @FXML
    private TableColumn<Funcionario, String> ruaFuncio;
    @FXML
    private TableColumn<Funcionario, String> telefoneFuncio;
    @FXML
    private TableView<Funcionario> tableFuncionarios;

    public ObservableList<Funcionario> funcionarios;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.codigoFuncio.setCellValueFactory(new PropertyValueFactory<>("codfuncionario"));
        this.nomeFuncio.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.cpfFuncio.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        this.rgFuncio.setCellValueFactory(new PropertyValueFactory<>("rg"));
        this.dataNascimentoFuncio.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        this.nacionalidadeFuncio.setCellValueFactory(new PropertyValueFactory<>("nacionalidade"));
        this.emailFuncio.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.telefoneFuncio.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        this.ruaFuncio.setCellValueFactory(new PropertyValueFactory<>("rua"));
        this.numeroFuncio.setCellValueFactory(new PropertyValueFactory<>("numeroEnde"));
        this.bairroFuncio.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        this.cidadeFuncio.setCellValueFactory(new PropertyValueFactory<>("cidade"));

        this.funcionarios= this.tableFuncionarios.getItems();
        FuncionarioDAO daoDeFuncio=new FuncionarioDAO();
         List<Funcionario> funcionariosNoBanco = daoDeFuncio.getAll();

        this.funcionarios.addAll(funcionariosNoBanco);
    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        App.setRoot("Principal");

    }

}
