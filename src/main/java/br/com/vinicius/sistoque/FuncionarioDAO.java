package br.com.vinicius.sistoque;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public Funcionario obterPeloId(int codigo_funcio) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoFuncio = connection. //
                    createStatement(). //
                    executeQuery("SELECT * FROM funcionario WHERE codigo = " + codigo_funcio);

            resultadoFuncio.next();

            int codfuncionario = resultadoFuncio.getInt("codigo_funcio");
            String nome = resultadoFuncio.getString("nome");
            int cpf = resultadoFuncio.getInt("cpf");
            int rg = resultadoFuncio.getInt("rg");
            String dataNascimento = resultadoFuncio.getString("dataNascimento");
            String nacionalidade = resultadoFuncio.getString("nacionalidade");
            String email = resultadoFuncio.getString("email");
            int telefone = resultadoFuncio.getInt("telefone");
            String rua = resultadoFuncio.getString("rua");
            int numeroEnde = resultadoFuncio.getInt("numeroEnde");
            String bairro = resultadoFuncio.getString("bairro");
            String cidade = resultadoFuncio.getString("cidade");

            return new Funcionario(codfuncionario,numeroEnde,cpf,rg,telefone, //
             nome,  dataNascimento,  nacionalidade,email,//
             rua,bairro,cidade);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Funcionario> getAll() {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoFuncio = connection. //
                    createStatement(). //
                    executeQuery("SELECT * FROM funcionario");

            List<Funcionario> resultadoTodosFuncionario = new ArrayList<>();

            while (resultadoFuncio.next()) {
                
                int codfuncionario = resultadoFuncio.getInt("codigo_funcio");//igual banco
                String nome = resultadoFuncio.getString("nome");
                int cpf = resultadoFuncio.getInt("cpf");
                int rg = resultadoFuncio.getInt("rg");
                String dataNascimento = resultadoFuncio.getString("bairro");
                String nacionalidade = resultadoFuncio.getString("nacionalidade");
                String email = resultadoFuncio.getString("email");
                int telefone = resultadoFuncio.getInt("telefone");
                String rua = resultadoFuncio.getString("rua");
                int numeroEnde = resultadoFuncio.getInt("numero_ende");
                String bairro = resultadoFuncio.getString("data_nascimento");
                String cidade = resultadoFuncio.getString("cidade");

                Funcionario funcioObterDoBanco = new Funcionario(codfuncionario,numeroEnde,cpf,rg,telefone, //
             nome,  dataNascimento,  nacionalidade,email,//
             rua,bairro,cidade);
                resultadoTodosFuncionario.add(funcioObterDoBanco);
            }

            return resultadoTodosFuncionario;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void salvar(Funcionario novoFuncionario) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("INSERT INTO funcionario (codigo_funcio,nome,cpf,rg,data_nascimento,nacionalidade,email,telefone,rua,numero_ende,bairro,cidade) values (" //
                            + novoFuncionario.getCodfuncionario() //
                            + ", '" + novoFuncionario.getNome() + "'" //
                            + ", '" + novoFuncionario.getCpf() + "'" //
                            + ", '" + novoFuncionario.getRg() + "'" //
                            + ", '" + novoFuncionario.getDataNascimento() + "'" //
                            + ", '" + novoFuncionario.getNacionalidade() + "'" //
                            + ", '" + novoFuncionario.getEmail() + "'" //
                            + ", '" + novoFuncionario.getTelefone() + "'" //
                            + ", '" + novoFuncionario.getRua() + "'" //
                            + ", " + novoFuncionario.getNumeroEnde() + "" //
                            + ", '" + novoFuncionario.getBairro() + "'" //
                            + ", '" + novoFuncionario.getCidade() + "')");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Funcionario funcionarioEditado) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("UPDATE funcionario SET " //
                            + "nome = '" + funcionarioEditado.getNome() + "'" //
                            + ", cpf = '" + funcionarioEditado.getCpf()+"'"  //
                            + ", rg = '" + funcionarioEditado.getRg()+"'"  //
                            + ", data_nascimento = '" + funcionarioEditado.getDataNascimento() +"'" //
                            + ", nacionalidade = '" + funcionarioEditado.getNacionalidade()+"'"  //
                            + ", email = '" + funcionarioEditado.getEmail()+"'"  //
                            + ", telefone = '" + funcionarioEditado.getTelefone()+"'"  //
                            + ", rua = '" + funcionarioEditado.getRua()+"'"  //
                            + ", numero_ende = '" + funcionarioEditado.getNumeroEnde()+"'"  //
                            + ", bairro = '" + funcionarioEditado.getBairro()+"'" //
                            + ", cidade= '" + funcionarioEditado.getCidade()+"'" //
                            + " WHERE codigo_funcio = " + funcionarioEditado.getCodfuncionario() //
                    );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Funcionario FuncioRemover) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("DELETE FROM funcionario where codigo_funcio = " + FuncioRemover.getCodfuncionario());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Funcionario> mostraPeloNome(String pesquisaNome) {
        if (pesquisaNome == null || pesquisaNome.isBlank()) {
            return getAll();
        }
        
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadofuncio = connection. //
                    createStatement(). //
                    executeQuery("SELECT * FROM funcionario WHERE nome like '%" + pesquisaNome + "%'");

            List<Funcionario> resultadoTodosOsfuncios = new ArrayList<>();
            
          
            while (resultadofuncio.next()) {
                int codfuncionario = resultadofuncio.getInt("codigo_funcio");//igual banco
                String nome = resultadofuncio.getString("nome");
                int cpf = resultadofuncio.getInt("cpf");
                int rg = resultadofuncio.getInt("rg");
                String dataNascimento = resultadofuncio.getString("bairro");
                String nacionalidade = resultadofuncio.getString("nacionalidade");
                String email = resultadofuncio.getString("email");
                int telefone = resultadofuncio.getInt("telefone");
                String rua = resultadofuncio.getString("rua");
                int numeroEnde = resultadofuncio.getInt("numero_ende");
                String bairro = resultadofuncio.getString("data_nascimento");
                String cidade = resultadofuncio.getString("cidade");

                Funcionario funcioObterDoBanco = new Funcionario(codfuncionario,numeroEnde,cpf,rg,telefone, //
             nome,  dataNascimento,  nacionalidade,email,//
             rua,bairro,cidade);
                resultadoTodosOsfuncios.add(funcioObterDoBanco);
            }

            return resultadoTodosOsfuncios;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    

}
