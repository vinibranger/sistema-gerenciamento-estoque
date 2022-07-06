
package br.com.vinicius.sistoque;

public class Cliente {
    
    int codigoCliente;
    String nome,cnpjCpf,email,telefone,rua,numeEndereco,bairro,cidade;

    public Cliente(int codigoCliente, String nome, String cnpjCpf, String email, String telefone, String rua, String numeEndereco, String bairro, String cidade) {
        this.codigoCliente = codigoCliente;
        this.nome = nome;
        this.cnpjCpf = cnpjCpf;
        this.email = email;
        this.telefone = telefone;
        this.rua = rua;
        this.numeEndereco = numeEndereco;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeEndereco() {
        return numeEndereco;
    }

    public void setNumeEndereco(String numeEndereco) {
        this.numeEndereco = numeEndereco;
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
}
