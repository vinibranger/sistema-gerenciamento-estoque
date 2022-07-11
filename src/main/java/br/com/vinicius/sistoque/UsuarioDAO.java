package br.com.vinicius.sistoque;

import java.sql.Connection;
import java.sql.ResultSet;

public class UsuarioDAO {

    public boolean existe(Usuario usuario) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet conferindoUsuarioExiste = connection. //
                    createStatement(). //
                    executeQuery("select count(*) from usuario " //
                            + " where usuario = '" + usuario.getUsuario() + "'"//
                            + " and senha = '" + usuario.getSenha() + "'");

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
                             + ", '" + novoUsuario.getUsuario()+ "'" //
                            + ", " + novoUsuario.getSenha()+ ")");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

public void retornaNivelAcesso(Usuario novoUsuario) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("INSERT INTO usuario(usuario, senha) values (" 
                             + ", '" + novoUsuario.getUsuario()+ "'" //
                            + ", " + novoUsuario.getSenha()+ ")");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

