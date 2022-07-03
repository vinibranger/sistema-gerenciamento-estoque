package br.com.vinicius.sistoque;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class CadastroProdutoController implements Initializable {

    @FXML
    private ComboBox comboxUnidadeProduto;
    @FXML
    private ComboBox fornecedorCombox;

    @FXML
    void select(ActionEvent event) {
        String unidadeProduto = comboxUnidadeProduto.getSelectionModel().getSelectedItem().toString();
    }

    @FXML
    void selectFornecedor(ActionEvent event) {
        String fornecedor = fornecedorCombox.getSelectionModel().getSelectedItem().toString();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> unidade = FXCollections.observableArrayList("KG", "UN");
        comboxUnidadeProduto.setItems(unidade);
        
        ObservableList<String> fornecedor = FXCollections.observableArrayList("AAA", "BBB","CCC");
        fornecedorCombox.setItems(fornecedor);
    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        App.setRoot("Principal");

    }

}
