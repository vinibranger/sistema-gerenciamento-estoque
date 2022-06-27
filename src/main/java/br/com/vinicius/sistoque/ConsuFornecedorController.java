
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


public class ConsuFornecedorController implements Initializable {

     
   @FXML
    private TableColumn<Fornecedor, String> cidadeFornecedorTable;

    @FXML
    private TableColumn<Fornecedor, Integer> cnpjFornecedorTable;

    @FXML
    private TableColumn<Fornecedor, Integer> codFornecedorTable;

    @FXML
    private TableColumn<Fornecedor, String> nomeForneceTable;

    @FXML
    private TableView<Fornecedor> tableFornecedorEstoque;
    
    ObservableList<Fornecedor> fornecedores;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.codFornecedorTable.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        this.nomeForneceTable.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        this.cnpjFornecedorTable.setCellValueFactory(new PropertyValueFactory<>("CNPJ/CPF"));
        this.cidadeFornecedorTable.setCellValueFactory(new PropertyValueFactory<>("Cidade"));
        
        this.fornecedores = this.tableFornecedorEstoque.getItems();

        Fornecedor maca = new Fornecedor(11, "AAAA", 7458712, "Indaial");
        Fornecedor banana = new Fornecedor(24, "Banana", 455545,"Blumenau");
        Fornecedor pcGamer = new Fornecedor(34, "Gamer", 232323,"Timbó");
        Fornecedor teclado = new Fornecedor(44, "Teclado", 456456,"Indaial");

        fornecedores.add(maca);
        fornecedores.add(banana);
        fornecedores.add(pcGamer);
        fornecedores.add(teclado);
        
        
    }  
    
    
    
    
    
    
    @FXML
    private void voltar (ActionEvent event) throws IOException {
        App.setRoot("Principal");
    }
    
}
