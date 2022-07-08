package br.com.vinicius.sistoque;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class CadastroEntradaProdutoController implements Initializable {

    public int quantidaOriginal;
    public static Produto produto;
    @FXML
    private TextField codigProduTxtField;

    @FXML
    private TextField nomeProduTxtField;

    @FXML
    private TextField quantidadeProduTxtField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    quantidadeProduTxtField.setText(null);
        if (produto != null) {
           
            codigProduTxtField.setText(Integer.toString(produto.getCodigo()));
            nomeProduTxtField.setText(produto.getNome());
            quantidadeProduTxtField.setText(Integer.toString(produto.getQuantidade()));
            quantidaOriginal = produto.getQuantidade();

        }

    }

    @FXML
    private void addEstoque(ActionEvent event) throws IOException {

        int novaQuantidade = quantidaOriginal + Integer.parseInt(quantidadeProduTxtField.getText());

        produto.setQuantidade(novaQuantidade);
        ProdutoDAO dao = new ProdutoDAO();
        dao.update(produto);

        App.setRoot("Principal");

    }
    @FXML
    private void saidaEstoque(ActionEvent event) throws IOException {

        int novaQuantidade = quantidaOriginal - Integer.parseInt(quantidadeProduTxtField.getText());

        produto.setQuantidade(novaQuantidade);
        ProdutoDAO dao = new ProdutoDAO();
        dao.update(produto);

        App.setRoot("Principal");

    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        App.setRoot("Principal");
    }

    public static void setProduto(Produto produto) {
        CadastroEntradaProdutoController.produto = produto;
    }

    public static Produto getProduto() {
        return CadastroEntradaProdutoController.produto;
    }

}
