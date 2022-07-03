
package br.com.vinicius.sistoque;

public class Produto {
    int codigo;
    String nome;
    String localEst;
    String marca;
    String codeBarra;
    String descriProdu;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLocalEst(String localEst) {
        this.localEst = localEst;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCodeBarra(String codeBarra) {
        this.codeBarra = codeBarra;
    }

    public void setDescriProdu(String descriProdu) {
        this.descriProdu = descriProdu;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getLocalEst() {
        return localEst;
    }

    public String getMarca() {
        return marca;
    }

    public String getCodeBarra() {
        return codeBarra;
    }

    public String getDescriProdu() {
        return descriProdu;
    }

    public Produto(int codigo, String nome, String localEst, String marca, String codeBarra, String descriProdu) {
        this.codigo = codigo;
        this.nome = nome;
        this.localEst = localEst;
        this.marca = marca;
        this.codeBarra = codeBarra;
        this.descriProdu = descriProdu;
    }

    
    

    
    

 
    
    
}
