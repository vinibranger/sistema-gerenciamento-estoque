package br.com.vinicius.sistoque;

public class Usuario {

    String usuario;
    String senha;
    // int nivelUser;

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        //  this.nivelUser = nivelUser;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    /*
    public int getNivelUser() {
        return nivelUser;
    }

    //public void setNivelUser(int nivelUser) {
      //  this.nivelUser = nivelUser;
    }*/
}
