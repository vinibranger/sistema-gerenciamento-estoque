package br.com.vinicius.sistoque;

import static br.com.vinicius.sistoque.CadasFornecedorController.fornecedor;
import static br.com.vinicius.sistoque.FornecedorDAO.getnome;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import static java.util.Collections.list;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CadastroProdutoController implements Initializable {

    public static Produto produto;
     public static Cliente cliente;
    @FXML
    private ComboBox comboxUnidadeProduto;
    @FXML
    private ComboBox fornecedorCombox;

    @FXML
    private TextField codigoTextField;
    @FXML
    private TextField descriçaoTextField;
    @FXML
    private TextField localEstoqueTextField;
    @FXML
    private TextField nomeTextField;
    @FXML
    private TextField quantidadeTextField;

    @FXML
    void select(ActionEvent event) {
        String unidadeProduto = comboxUnidadeProduto.getSelectionModel().getSelectedItem().toString();
        String Foner = comboxUnidadeProduto.getSelectionModel().getSelectedItem().toString();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> unidade = FXCollections.observableArrayList("KG", "UN");
        comboxUnidadeProduto.setItems(unidade);

        ObservableList<String> fornecedor = FXCollections.observableArrayList("AAA", "BBB", "CCC");
        fornecedorCombox.setItems(fornecedor);

    }
    
    @FXML
    public void salvar() throws IOException {
        if (!this.codigoTextField.getText().isEmpty() //
                && !this.descriçaoTextField.getText().isEmpty() //
                && !this.localEstoqueTextField.getText().isEmpty() //
                && !this.nomeTextField.getText().isEmpty() //
                && !this.quantidadeTextField.getText().isEmpty());{

            cliente = new Cliente( //
                    Integer.parseInt(this.codigoTextField.getText()), // 
                    Integer.parseInt(this.quantidadeTextField.getText()), // 
                    this.descriçaoTextField.getText(), //
                    this.localEstoqueTextField.getText(), //
                    this.nomeTextField.getText());

            FornecedorDAO daoDoFornecedor = new FornecedorDAO();
            daoDoFornecedor.salvar(fornecedor);
        }

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
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
    

    public static void setProduto(Produto produto) {
        CadastroProdutoController.produto = produto;
    }

    public static Produto getProduto() {
        return CadastroProdutoController.produto;
    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        App.setRoot("Principal");

    }

    public void selectForne(ActionEvent event) {
         String Foner = comboxUnidadeProduto.getSelectionModel().getSelectedItem().toString();
        /* try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet selectForne = connection. //
                    createStatement(). //
                    executeQuery("SELECT nome FROM fornecedor ");
            ObservableList forne = FXCollections.observableArrayList();
            while (selectForne.next()) {

                forne.add(new String(selectForne.getString(1)));
            }
            fornecedorCombox.setItems(forne);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
         */
    }
}
