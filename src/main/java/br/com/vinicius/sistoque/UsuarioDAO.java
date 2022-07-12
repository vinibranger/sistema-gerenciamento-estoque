package br.com.vinicius.sistoque;

import java.sql.Connection;
import java.sql.ResultSet;
import javafx.scene.control.TextField;

public class UsuarioDAO {

    public boolean existe(Usuario usuario) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet conferindoUsuarioExiste = connection. //
                    createStatement(). //
                    executeQuery("select count(*) from user_sistema " //
                            + " where usuario = '" + usuario.getUsuario() + "'"//
                            + " and senha = SHA2('" + usuario.getSenha() + "',256)");

            conferindoUsuarioExiste.next();
            int qntDeUsuarioESenha = conferindoUsuarioExiste.getInt(1);

            return qntDeUsuarioESenha > 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void salvar(Usuario novoUsuario) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("INSERT INTO user_sistema(usuario, senha, nivel) values (" 
                             + "'" + novoUsuario.getUsuario()+ "'" //                           
                             + ",SHA2(" + novoUsuario.getSenha()+ ",256)" //                           
                            + ",'" + novoUsuario.getNivelUser()+"')");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

public int retornaNivelAcesso(TextField usuarioTextField) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet conferindoNivelUser = connection.createStatement(). //
                    executeQuery("Select nivel from user_sistema where usuario = '" + usuarioTextField.getText() + "'");
            
        conferindoNivelUser.next();
        int nivelAcessoSistema = conferindoNivelUser.getInt(1);

        return nivelAcessoSistema;
        
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        
        
    }

}

