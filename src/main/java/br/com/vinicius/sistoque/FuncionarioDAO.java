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
            String cpf = resultadoFuncio.getString("cpf");
            String rg = resultadoFuncio.getString("rg");
            String dataNascimento = resultadoFuncio.getString("dataNascimento");
            String nacionalidade = resultadoFuncio.getString("nacionalidade");
            String email = resultadoFuncio.getString("email");
            String telefone = resultadoFuncio.getString("telefone");
            String rua = resultadoFuncio.getString("rua");
            int numeroEnde = resultadoFuncio.getInt("numeroEnde");
            String bairro = resultadoFuncio.getString("bairro");
            String cidade = resultadoFuncio.getString("cidade");

            return new Funcionario(codfuncionario, numeroEnde, nome, cpf, rg, dataNascimento, nacionalidade, email,//
                    telefone, rua, bairro, cidade);
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

            while (!resultadoFuncio.isLast()) {
                resultadoFuncio.next();

                int codfuncionario = resultadoFuncio.getInt("codigo_funcio");//igual banco
                String nome = resultadoFuncio.getString("nome");
                String cpf = resultadoFuncio.getString("cpf");
                String rg = resultadoFuncio.getString("rg");
                String dataNascimento = resultadoFuncio.getString("bairro");
                String nacionalidade = resultadoFuncio.getString("nacionalidade");
                String email = resultadoFuncio.getString("email");
                String telefone = resultadoFuncio.getString("telefone");
                String rua = resultadoFuncio.getString("rua");
                int numeroEnde = resultadoFuncio.getInt("numero_ende");
                String bairro = resultadoFuncio.getString("data_nascimento");
                String cidade = resultadoFuncio.getString("cidade");

                Funcionario funcioObterDoBanco = new Funcionario(codfuncionario,numeroEnde,  nome,  cpf,  rg,//
             dataNascimento,  nacionalidade,  email,//
             telefone,  rua,  bairro,  cidade);
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
                    executeUpdate("INSERT INTO funcionario values (" //
                            + novoFuncionario.getCodfuncionario() //
                            + ", '" + novoFuncionario.getNome() + "'" //
                            + ", '" + novoFuncionario.getCpf() + "'" //
                            + ", '" + novoFuncionario.getRg() + "'" //
                            + ", '" + novoFuncionario.getDataNascimento() + "'" //
                            + ", '" + novoFuncionario.getNacionalidade() + "'" //
                            + ", '" + novoFuncionario.getEmail() + "'" //
                            + ", '" + novoFuncionario.getTelefone() + "'" //
                            + ", '" + novoFuncionario.getRua() + "'" //
                            + ", '" + novoFuncionario.getNumeroEnde() + "'" //
                            + ", '" + novoFuncionario.getBairro() + "'" //
                            + ", " + novoFuncionario.getCidade() + ")");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Funcionario funcionarioEditado) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("UPDATE produto SET " //
                            + "nome = '" + funcionarioEditado.getNome() + "'" //
                            + ", cpf = " + funcionarioEditado.getCpf() //
                            + ", rg = " + funcionarioEditado.getRg() //
                            + ", data_nascimento = " + funcionarioEditado.getDataNascimento() //
                            + ", nacionalidade = " + funcionarioEditado.getNacionalidade() //
                            + ", email = " + funcionarioEditado.getEmail() //
                            + ", telefone = " + funcionarioEditado.getTelefone() //
                            + ", rua = " + funcionarioEditado.getRua() //
                            + ", numero_ende = " + funcionarioEditado.getNumeroEnde() //
                            + ", bairro = " + funcionarioEditado.getBairro() //
                            + ", cidade= " + funcionarioEditado.getCidade() //
                            + " WHERE codigo = " + funcionarioEditado.getCodfuncionario() //
                    );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Funcionario FuncioRemover) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("DELETE FROM produto where codigo = " + FuncioRemover.getCodfuncionario());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
