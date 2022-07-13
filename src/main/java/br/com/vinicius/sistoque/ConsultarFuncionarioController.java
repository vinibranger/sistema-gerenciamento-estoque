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
    private TextField pesquisaNome;
    
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
        this.dataNascimentoFuncio.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        this.nacionalidadeFuncio.setCellValueFactory(new PropertyValueFactory<>("nacionalidade"));
        this.emailFuncio.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.telefoneFuncio.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        this.ruaFuncio.setCellValueFactory(new PropertyValueFactory<>("rua"));
        this.numeroFuncio.setCellValueFactory(new PropertyValueFactory<>("numeroEnde"));
        this.bairroFuncio.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
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
    
    @FXML
    private void novo(ActionEvent event) throws IOException {
        App.setRoot("CadastroFuncio");

    }
    
     @FXML
    private void pesquisarFuncionario(ActionEvent event) throws IOException {
        FuncionarioDAO daoDefuncios = new FuncionarioDAO();
        List<Funcionario> funcionarioDAONoBanco = daoDefuncios.mostraPeloNome(pesquisaNome.getText());

        this.funcionarios.clear();//limpa para nao duplicar 
        this.funcionarios.addAll(funcionarioDAONoBanco);//sozinho duplica os produtos da lista
    }
     @FXML
    void editar() throws IOException {
        Funcionario funcionarioSelecionado = this.tableFuncionarios.getSelectionModel().getSelectedItem();
        if (funcionarioSelecionado != null) {
            CadastroFuncioController.funcionario = funcionarioSelecionado;

            App.setRoot("CadastroFuncio");

            Funcionario funcioAlterado = CadastroFuncioController.funcionario;

            funcionarioSelecionado.setCodfuncionario(funcioAlterado.getCodfuncionario());
            funcionarioSelecionado.setNome(funcioAlterado.getNome());
            funcionarioSelecionado.setCpf(funcioAlterado.getCpf());     
            funcionarioSelecionado.setRg(funcioAlterado.getRg());           
            funcionarioSelecionado.setDataNascimento(funcioAlterado.getDataNascimento());           
            funcionarioSelecionado.setNacionalidade(funcioAlterado.getNacionalidade());
            funcionarioSelecionado.setEmail(funcioAlterado.getEmail());           
            funcionarioSelecionado.setTelefone(funcioAlterado.getTelefone());          
            funcionarioSelecionado.setRua(funcioAlterado.getRua());                     
            funcionarioSelecionado.setNumeroEnde(funcioAlterado.getNumeroEnde());
            funcionarioSelecionado.setBairro(funcioAlterado.getBairro());
            funcionarioSelecionado.setCidade(funcioAlterado.getCidade());

            this.tableFuncionarios.refresh();

            FuncionarioDAO daoDoFuncionario = new FuncionarioDAO();
            daoDoFuncionario.update(funcionarioSelecionado);

        }
    }
    
    
     @FXML
    void remover() throws IOException {
        Funcionario funcionarioSelecionado = this.tableFuncionarios.getSelectionModel().getSelectedItem();
        //quando for remover vem a confirmaçao de remover
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remover");
        alert.setHeaderText(funcionarioSelecionado.getCodfuncionario()+ " " + funcionarioSelecionado.getNome());
        alert.setContentText("Deseja Remover o Registro ? ");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            this.funcionarios.remove(funcionarioSelecionado);
        }
        this.tableFuncionarios.refresh();
        FuncionarioDAO daoDoFuncionario = new FuncionarioDAO();
        daoDoFuncionario.delete(funcionarioSelecionado);
      
    }

}
