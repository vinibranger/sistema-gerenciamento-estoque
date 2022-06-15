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
    void switchToEntradaProtudo() throws IOException {
        App.setRoot("cadastroentradaproduto");
    }

    @FXML
    void switchToSaidaProduto() throws IOException {
        App.setRoot("");
    }

    @FXML
    void switchToCadastroCliente() throws IOException {
        App.setRoot("cadastrocliente");
    }

    @FXML
    void switchToCadastroFornecedor() throws IOException {
        App.setRoot("CadastroFornecedor");
    }

    @FXML
    void switchToCadastroFuncio() throws IOException {
        App.setRoot("CadastroFuncio");
    }

    @FXML
    void switchToCadastroproduto() throws IOException {
        App.setRoot("Cadastroproduto");
    }

    @FXML
    void switchToMostrarEstoque() throws IOException {
        App.setRoot("MostrarEstoque");
    }

    @FXML
    void switchToRelatorioEstoque() throws IOException {
        App.setRoot("RelatorioEstoque");
    }

    @FXML
    void switchToRelatorios() throws IOException {
        App.setRoot("Relatorios");
    }

    @FXML
    void switchToConsultaFornecedor() throws IOException {
        App.setRoot("ConsultaFornecedor");
    }
    
    @FXML
    void switchToConsultaProduto() throws IOException {
        App.setRoot("");
    }
    
    @FXML
    void switchToConsultaCliente() throws IOException {
        App.setRoot("");
    }
    
    @FXML
    void switchToConsultaFuncionario() throws IOException {
        App.setRoot("");
    }
}
