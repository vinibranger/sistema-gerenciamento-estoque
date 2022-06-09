package br.com.vinicius.sistoque;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class TelaInicial {
    @FXML
    private Button buttonConsutaEstoq;
    @FXML
    private MenuButton menuButtonCadastrar;
    @FXML
    private MenuButton menuButtonEntraSaida;
    @FXML
    private MenuButton menuButtonRelaorio;
    @FXML
    private MenuButton menuButtonconsultar;
    @FXML
    private MenuItem menuItemCliente;
    @FXML
    private MenuItem menuItemConsutaClientes;
    @FXML
    private MenuItem menuItemConsutaFornecedor;
    @FXML
    private MenuItem menuItemConsutaFuncionarios;
    @FXML
    private MenuItem menuItemConsutaProdutos;
    @FXML
    private MenuItem menuItemEmitirRelatório;
    @FXML
    private MenuItem menuItemEntradaProtudo;
    @FXML
    private MenuItem menuItemFornecedor;
    @FXML
    private MenuItem menuItemFuncionarios;
    @FXML
    private MenuItem menuItemProduto;
    @FXML
    private MenuItem menuItemProdutoEstoque;
    @FXML
    private MenuItem menuItemSaidaProduto;
    
    @FXML
    void switchToEstoque() throws IOException {
        App.setRoot("MostrarEstoque");
    }
}