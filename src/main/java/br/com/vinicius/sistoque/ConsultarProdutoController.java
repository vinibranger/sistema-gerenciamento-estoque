
package br.com.vinicius.sistoque;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConsultarProdutoController implements Initializable {
    @FXML
    private TableColumn<Produto, Integer> codProdutoTable;

    @FXML
    private TableColumn<Produto, String> nomeProdutoTable;
    @FXML
    private TableColumn<Produto, String>  localEstProdutoTable;
    @FXML
    private TableColumn<Produto, String> codigoBarraProdutoTable;
    @FXML
    private TableColumn<Produto, String> marcaProdutoTable;

   
    @FXML
    private TableView<Produto> produtotable;

    ObservableList<Produto> produtos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.codProdutoTable.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        this.nomeProdutoTable.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.localEstProdutoTable.setCellValueFactory(new PropertyValueFactory<>("localEst"));
        this.codigoBarraProdutoTable.setCellValueFactory(new PropertyValueFactory<>("codeBarra"));
        this.marcaProdutoTable.setCellValueFactory(new PropertyValueFactory<>("marca"));
       
        

        this.produtos = this.produtotable.getItems();

        
        
        Produto alicate = new Produto(1868, "Alicate","Prateleira 56","AAA","45646545445","");
        Produto fonte = new Produto(289, "Fonte","Prateleira 10","bnhgjgf","685665445","");
        Produto controle = new Produto(378, "Controle","Prateleira 54","fgfgf","457868684","");
        Produto pneu = new Produto(44, "Pneu","Prateleira 05","aqwww","74878754","");

        produtos.add(alicate);
        produtos.add(fonte);
        produtos.add(controle);
        produtos.add(pneu);
    
    }    
     @FXML
    private void voltar (ActionEvent event) throws IOException {
        App.setRoot("Principal");
        
    }
    
}
