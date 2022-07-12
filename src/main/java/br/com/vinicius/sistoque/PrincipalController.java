
package br.com.vinicius.sistoque;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;

public class PrincipalController implements Initializable {

    @FXML
    private AnchorPane anc_pane;
  
    @FXML
    private ImageView imglogo;
    
    //FXML do botao
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imglogo.setVisible(true);

    }

    
    
     @FXML
    private void Cadastrouser(ActionEvent event) throws IOException {
        Pane UserCadastro = new FXMLLoader(App.class.getResource("UserCadastro" + ".fxml")).load();
        imglogo.setVisible(false);
        anc_pane.getChildren().add(UserCadastro);
        
    }
    @FXML
    private void CadastroCliente(ActionEvent event) throws IOException {
        Pane cadastroCliente = new FXMLLoader(App.class.getResource("CadastroCliente" + ".fxml")).load();
        imglogo.setVisible(false);
        anc_pane.getChildren().add(cadastroCliente);
        
    }

    @FXML
    private void CadastroProduto(ActionEvent event) throws IOException {
        Pane CadastroProduto = new FXMLLoader(App.class.getResource("CadastroProduto" + ".fxml")).load();
        imglogo.setVisible(false);
        anc_pane.getChildren().add(CadastroProduto);
    }

    @FXML
    private void CadastroFornecedor(ActionEvent event) throws IOException {
        Pane CadasFornecedor = new FXMLLoader(App.class.getResource("CadasFornecedor" + ".fxml")).load();
        imglogo.setVisible(false);
        anc_pane.getChildren().add(CadasFornecedor);
    }

    @FXML
    private void MostrarEstoque(ActionEvent event) throws IOException {
        Pane mostrarEstoque = new FXMLLoader(App.class.getResource("MostrarEstoque" + ".fxml")).load();
        imglogo.setVisible(false);
        anc_pane.getChildren().add(mostrarEstoque);
    }

    @FXML
    private void CadastroFuncio(ActionEvent event) throws IOException {
        Pane CadastroFuncio = new FXMLLoader(App.class.getResource("CadastroFuncio" + ".fxml")).load();
        imglogo.setVisible(false);
        anc_pane.getChildren().add(CadastroFuncio);
    }

    @FXML
    private void ConsultaFornecedor(ActionEvent event) throws IOException {
        Pane ConsuFornecedor = new FXMLLoader(App.class.getResource("ConsuFornecedor" + ".fxml")).load();
        imglogo.setVisible(false);
        anc_pane.getChildren().add(ConsuFornecedor);
    }

    @FXML
    private void ConsultaCliente(ActionEvent event) throws IOException {
        Pane ConsultarCliente = new FXMLLoader(App.class.getResource("ConsultarCliente" + ".fxml")).load();
        imglogo.setVisible(false);
        anc_pane.getChildren().add(ConsultarCliente);
    }

    @FXML
    private void ConsultaFuncio(ActionEvent event) throws IOException {
        Pane ConsultarFuncionario = new FXMLLoader(App.class.getResource("ConsultarFuncionario" + ".fxml")).load();
        imglogo.setVisible(false);
        anc_pane.getChildren().add(ConsultarFuncionario);
    }

    @FXML
    private void ConsultaProduto(ActionEvent event) throws IOException {
        Pane ConsultarProduto = new FXMLLoader(App.class.getResource("ConsultarProduto" + ".fxml")).load();
        imglogo.setVisible(false);
        anc_pane.getChildren().add(ConsultarProduto);
    }

    @FXML
    private void RelatorioEstoque(ActionEvent event) throws IOException {
        Pane RelatorioEstoque = new FXMLLoader(App.class.getResource("RelatorioEstoque" + ".fxml")).load();
        imglogo.setVisible(false);
        anc_pane.getChildren().add(RelatorioEstoque);
    }

    @FXML
    private void RelatorioEntSai(ActionEvent event) throws IOException {
        Pane RelatorioEntSai = new FXMLLoader(App.class.getResource("Relatorios" + ".fxml")).load();
        imglogo.setVisible(false);
        anc_pane.getChildren().add(RelatorioEntSai);
        
    }

}
