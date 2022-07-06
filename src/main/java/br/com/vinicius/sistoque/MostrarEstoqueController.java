package br.com.vinicius.sistoque;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MostrarEstoqueController implements Initializable {

    private static Produto produto;
    @FXML
    private TableColumn<Produto, Integer> codProdutoTable;
    @FXML
    private TableColumn<Produto, Integer> quantProdutoTable;
    @FXML
    private TableColumn<Produto, String> descriçaoProdutoTable;

    @FXML
    private TableColumn<Produto, String> fornecedorProdutoTable;

    @FXML
    private TableColumn<Produto, String> localEstoqueProdutoTable;

    @FXML
    private TableColumn<Produto, String> nomeProdutoTable;
    @FXML
    private TableColumn<Produto, String> unidadeProdutoTable;
    @FXML
    private TableView<Produto> tableProdutoEstoque;

    public ObservableList<Produto> produtos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.codProdutoTable.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        this.nomeProdutoTable.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.quantProdutoTable.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        this.unidadeProdutoTable.setCellValueFactory(new PropertyValueFactory<>("unidade"));
        this.localEstoqueProdutoTable.setCellValueFactory(new PropertyValueFactory<>("localEstoque"));
        this.descriçaoProdutoTable.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        this.fornecedorProdutoTable.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));

        this.produtos = this.tableProdutoEstoque.getItems();
        ProdutoDAO daoDeProdutos = new ProdutoDAO();
        List<Produto> produtosNoBanco = daoDeProdutos.mostraTudo();

        this.produtos.addAll(produtosNoBanco);

    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        App.setRoot("Principal");

    }

    @FXML
    private void entradaSaida(ActionEvent event) throws IOException {
        Produto produtoSelecionado = this.tableProdutoEstoque.getSelectionModel().getSelectedItem();
        if (produtoSelecionado != null) {
            // manda o produto para o tela de editar quantidade
            CadastroEntradaProdutoController.setProduto(produtoSelecionado);
            // Vai pra tela de entrada saida para editar a quantidade
            App.setRoot("CadastroEntradaProduto");

            Produto produtoAlterado = CadastroEntradaProdutoController.getProduto();

            produtoSelecionado.setCodigo(produtoAlterado.getCodigo());
            produtoSelecionado.setNome(produtoAlterado.getNome());
            produtoSelecionado.setQuantidade(produtoAlterado.getQuantidade());

            this.tableProdutoEstoque.refresh();
            ProdutoDAO daoDoProduto = new ProdutoDAO();
            daoDoProduto.entraSaiProduto(produtoSelecionado);
        }

    }

    @FXML
    private void cadastro(ActionEvent event) throws IOException {
        App.setRoot("CadastroEntradaProduto");

    }
        @FXML
    public void remover() {
        
        Produto produtoSelecionado = this.tableProdutoEstoque.getSelectionModel().getSelectedItem();

        
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remoção");
        alert.setHeaderText(produtoSelecionado.getCodigo() + " " + produtoSelecionado.getNome());
        alert.setContentText("Deseja remover o registro?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
 
            this.produtos.remove(produtoSelecionado);

            
            ProdutoDAO daoDoProduto = new ProdutoDAO();
            daoDoProduto.delete(produtoSelecionado);
        }
    }
}
