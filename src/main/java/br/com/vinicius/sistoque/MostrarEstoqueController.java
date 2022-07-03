
package br.com.vinicius.sistoque;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;


public class MostrarEstoqueController implements Initializable {


    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
     @FXML
    private void voltar (ActionEvent event) throws IOException {
        App.setRoot("Principal");
        
    }
         @FXML
    private void cadastro (ActionEvent event) throws IOException {
        App.setRoot("CadastroProduto");
        
    }
        @FXML
    private void entradaSaida (ActionEvent event) throws IOException {
        App.setRoot("CadastroEntradaProduto");
        
    }
    
    

}
