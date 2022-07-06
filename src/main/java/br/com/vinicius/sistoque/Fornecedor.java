package br.com.vinicius.sistoque;

public class Fornecedor {

    public Fornecedor(int codigoForne, String nomeForne, String cnpjForne,// 
            String email, String telefone, String rua, String numero, String bairro, String cidade) {
        this.codigoForne = codigoForne;
        this.nomeForne = nomeForne;
        this.cnpjForne = cnpjForne;
        this.email = email;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;

    }
    int codigoForne;
    String nomeForne, cnpjForne, email, telefone, rua, numero, bairro, cidade;

    public void setCodigoForne(int codigoForne) {
        this.codigoForne = codigoForne;
    }

    public void setNomeForne(String nomeForne) {
        this.nomeForne = nomeForne;
    }

    public void setCnpjForne(String cnpjForne) {
        this.cnpjForne = cnpjForne;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCodigoForne() {
        return codigoForne;
    }

    public String getNomeForne() {
        return nomeForne;
    }

    public String getCnpjForne() {
        return cnpjForne;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

}
