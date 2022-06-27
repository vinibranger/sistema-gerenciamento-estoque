
package br.com.vinicius.sistoque;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class CadasFornecedorController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     }     
    
    
    
    @FXML
    
    private void voltar (ActionEvent event) throws IOException {
        App.setRoot("Principal");
    }
        
     
    
}
