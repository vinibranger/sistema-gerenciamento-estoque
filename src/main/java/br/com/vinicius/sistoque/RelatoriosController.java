
package br.com.vinicius.sistoque;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



public class RelatoriosController implements Initializable {
   
    @FXML
    private TableColumn<Relatorio, String> data;

    @FXML
    private TableColumn<Relatorio, String> nomeProduto;

    @FXML
    private TableColumn<Relatorio, Integer> qntNova;
    @FXML
    private TableColumn<Relatorio, Integer> idProduto;
    @FXML
    private TableView<Relatorio> tabelaUpProdutos;

    public ObservableList<Relatorio> relatorios;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.idProduto.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.qntNova.setCellValueFactory(new PropertyValueFactory<>("quantidade_Nova"));
        this.nomeProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.data.setCellValueFactory(new PropertyValueFactory<>("changedAt"));
        
        this.relatorios = this.tabelaUpProdutos.getItems();
        
        
       RelatorioDAO daoDeRelatorios = new RelatorioDAO();
        List<Relatorio> relatorioBanco = daoDeRelatorios.mostraRelatorio();
      this.relatorios.addAll(relatorioBanco);

    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        App.setRoot("Principal");

    }

}

