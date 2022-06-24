
package br.com.vinicius.sistoque;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
/**
 * FXML Controller class
 *
 * @author VINICIUS
 */
public class MostrarEstoqueController implements Initializable {
    @FXML
    private Button buttonVoltar;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
     @FXML
    private void voltar (ActionEvent event) throws IOException {
        App.setRoot("Principal");
        
    }
    
    

}
