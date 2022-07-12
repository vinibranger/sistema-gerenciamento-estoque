
package br.com.vinicius.sistoque;


public class Funcionario {
    
    int codfuncionario,numeroEnde, cpf, rg,telefone;
    String nome, dataNascimento, nacionalidade, email,rua,bairro,cidade;

    public Funcionario(int codfuncionario, int numeroEnde, int cpf, int rg, int telefone, //
            String nome, String dataNascimento, String nacionalidade, String email,//
            String rua, String bairro, String cidade) {
        this.codfuncionario = codfuncionario;
        this.numeroEnde = numeroEnde;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public int getCodfuncionario() {
        return codfuncionario;
    }

    public void setCodfuncionario(int codfuncionario) {
        this.codfuncionario = codfuncionario;
    }

    public int getNumeroEnde() {
        return numeroEnde;
    }

    public void setNumeroEnde(int numeroEnde) {
        this.numeroEnde = numeroEnde;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
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

   

   
}
