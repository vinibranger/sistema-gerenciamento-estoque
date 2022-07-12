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
                    executeQuery("select count(*) from usuario " //
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
                    executeUpdate("INSERT INTO usuario(usuario, senha) values (" 
                             + "'" + novoUsuario.getUsuario()+ "'" //
                            + ", SHA2(" + novoUsuario.getSenha()+ ",256))");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

public int retornaNivelAcesso(TextField usuarioTextField) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet conferindoUsuarioExiste = connection.createStatement(). //
                    executeQuery("Select (nivel) from usuario where usuario = '" + usuarioTextField.getText() + "'");
            
        conferindoUsuarioExiste.next();
        int qntDeUsuarioESenha = conferindoUsuarioExiste.getInt(1);

        return qntDeUsuarioESenha;
        
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        
        
    }

}

