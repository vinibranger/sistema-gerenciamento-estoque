
package br.com.vinicius.sistoque;

public class Relatorio {

  
    String nomeProduto;
    String data;
    int quantNova;
    int idSaida;

    public Relatorio(int quantNova, int idSaida, String nomeProduto, String data) {
        this.quantNova = quantNova;
        this.idSaida = idSaida;
        this.nomeProduto = nomeProduto;
        this.data = data;
    }

    public int getQuantNova() {
        return quantNova;
    }

    public void setQuantNova(int quantNova) {
        this.quantNova = quantNova;
    }

    public int getIdProduto() {
        return idSaida;
    }

    public void setIdProduto(int idProduto) {
        this.idSaida = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
   
    
}
