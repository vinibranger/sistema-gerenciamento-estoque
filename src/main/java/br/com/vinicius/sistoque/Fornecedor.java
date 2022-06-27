package br.com.vinicius.sistoque;

public class Fornecedor {

    int codigoForne;
    String nomeForne;
    int cnpjforne;
    String cidadeForne;

    public Fornecedor(int codigoForne, String nomeForne, int cnpjforne, String cidadeForne) {
        this.codigoForne = codigoForne;
        this.nomeForne = nomeForne;
        this.cnpjforne = cnpjforne;
        this.cidadeForne = cidadeForne;
    }
    
    
    public int getCodigoForne() {
        return codigoForne;
    }

    public String getNomeForne() {
        return nomeForne;
    }

    public int getCnpjforne() {
        return cnpjforne;
    }

    public String getCidadeForne() {
        return cidadeForne;
    }

    public void setCodigoForne(int codigoForne) {
        this.codigoForne = codigoForne;
    }

    public void setNomeForne(String nomeForne) {
        this.nomeForne = nomeForne;
    }

    public void setCnpjforne(int cnpjforne) {
        this.cnpjforne = cnpjforne;
    }

    public void setCidadeForne(String cidadeForne) {
        this.cidadeForne = cidadeForne;
    }

   

}
