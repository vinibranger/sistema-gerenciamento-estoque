
package br.com.vinicius.sistoque;

public class Relatorio {

  
     String nomeProduto, data;
    int quantNova,idProduto;

    public Relatorio(int quantNova, int idProduto, String nomeProduto, String data) {
        this.quantNova = quantNova;
        this.idProduto = idProduto;
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
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
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
