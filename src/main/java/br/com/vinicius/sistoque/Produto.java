
package br.com.vinicius.sistoque;

public class Produto {
    
    int codigo, quantidade;
    String nome;
    String unidade,localEstoque,descricao;
    String fornecedor;

    public Produto(int codigo, int quantidade, String nome, String unidade, String localEstoque, String descricao, String fornecedor) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.nome = nome;
        this.unidade = unidade;
        this.localEstoque = localEstoque;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getLocalEstoque() {
        return localEstoque;
    }

    public void setLocalEstoque(String localEstoque) {
        this.localEstoque = localEstoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
