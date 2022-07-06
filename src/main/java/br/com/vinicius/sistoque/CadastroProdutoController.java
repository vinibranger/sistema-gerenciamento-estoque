package br.com.vinicius.sistoque;

import static br.com.vinicius.sistoque.FornecedorDAO.getnome;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CadastroProdutoController implements Initializable {

    final ObservableList fornecedores = FXCollections.observableArrayList();

    public static Produto produto;
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
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> unidade = FXCollections.observableArrayList("KG", "UN");
        comboxUnidadeProduto.setItems(unidade);

//        ObservableList<String> fornecedor = FXCollections.observableArrayList("AAA", "BBB", "CCC");
//        fornecedorCombox.setItems(fornecedor);
        if (produto != null) {
            codigoTextField.setText(Integer.toString(produto.getCodigo()));
            quantidadeTextField.setText(Integer.toString(produto.getQuantidade()));
            nomeTextField.setText(produto.getNome());
            descriçaoTextField.setText(produto.getDescricao());
            localEstoqueTextField.setText(produto.getLocalEstoque());

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
        try {
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

}
