
package br.com.vinicius.sistoque;

public class Cliente {
    
    int codigoCliente,numeEndereco,cnpjCpf,telefone;

    public Cliente(int codigoCliente, int cnpjCpf, int telefone, int numeEndereco, //
            String nome, String email, String rua, String bairro, String cidade) {
        this.codigoCliente = codigoCliente;
        this.numeEndereco = numeEndereco;
        this.cnpjCpf = cnpjCpf;
        this.telefone = telefone;
        this.nome = nome;
        this.email = email;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getNumeEndereco() {
        return numeEndereco;
    }

    public void setNumeEndereco(int numeEndereco) {
        this.numeEndereco = numeEndereco;
    }

    public int getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(int cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    String nome,email,rua,bairro,cidade;

}