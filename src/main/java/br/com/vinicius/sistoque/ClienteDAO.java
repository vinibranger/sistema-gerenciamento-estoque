package br.com.vinicius.sistoque;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public Cliente getById(int id) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoCliente = connection. //
                    createStatement(). //
                    executeQuery("SELECT * FROM cliente WHERE idcliente = " + id);

            resultadoCliente.next();
            int codigoCliente = resultadoCliente.getInt("idcliente");
            String nome = resultadoCliente.getString("nome");
            String cnpjCpf = resultadoCliente.getString("cnpj_cpf");
            String email = resultadoCliente.getString("email");
            String telefone = resultadoCliente.getString("telefone");
            String rua = resultadoCliente.getString("rua");
            String numeEndereco = resultadoCliente.getString("numero_endereco");
            String bairro = resultadoCliente.getString("bairro");
            String cidade = resultadoCliente.getString("cidade");

            return new Cliente(codigoCliente, nome, cnpjCpf, email, telefone, rua//
                    ,
                     numeEndereco, bairro, cidade);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> getAll() {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoCliente = connection. //
                    createStatement(). //
                    executeQuery("SELECT * FROM cliente");

            List<Cliente> resultadoTodosCliente = new ArrayList<>();

            while (!resultadoCliente.isLast()) {
                resultadoCliente.next();

                int codigoCliente = resultadoCliente.getInt("idcliente");
                String nome = resultadoCliente.getString("nome");
                String cnpjCpf = resultadoCliente.getString("cnpj_cpf");
                String email = resultadoCliente.getString("email");
                String telefone = resultadoCliente.getString("telefone");
                String rua = resultadoCliente.getString("rua");
                String numeEndereco = resultadoCliente.getString("num_endereco");
                String bairro = resultadoCliente.getString("bairro");
                String cidade = resultadoCliente.getString("cidade");

                Cliente ClienteObterDoBanco = new Cliente(codigoCliente, nome, cnpjCpf, email, telefone, rua//
                        ,
                         numeEndereco, bairro, cidade);
                resultadoTodosCliente.add(ClienteObterDoBanco);
            }

            return resultadoTodosCliente;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Cliente novoCliente) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("INSERT INTO cliente values (" //
                            + novoCliente.getCodigoCliente() //
                            + ", '" + novoCliente.getNome() + "'" //
                            + ", '" + novoCliente.getCnpjCpf() + "'" //
                            + ", '" + novoCliente.getEmail() + "'" //
                            + ", '" + novoCliente.getTelefone() + "'" //
                            + ", '" + novoCliente.getRua() + "'" //
                            + ", '" + novoCliente.getNumeEndereco() + "'" //
                            + ", '" + novoCliente.getBairro() + "'" //
                            + ", " + novoCliente.getCidade() + ")");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Cliente clienteEditado) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("UPDATE produto SET " //
                            + "nome = '" + clienteEditado.getNome() + "'" //
                            + "cnpj_cpf = '" + clienteEditado.getCnpjCpf() + "'" //
                            + "email = '" + clienteEditado.getEmail() + "'" //
                            + "telefone = '" + clienteEditado.getTelefone() + "'" //
                            + "rua = '" + clienteEditado.getRua() + "'" //
                            + "num_endereco = '" + clienteEditado.getNumeEndereco() + "'" //
                            + "bairro = '" + clienteEditado.getBairro() + "'" //
                            + ", cidade = " + clienteEditado.getCidade() //
                            + " WHERE codigo = " + clienteEditado.getCodigoCliente() //
                    );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
 public void delete(Cliente clienteRemover) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("DELETE FROM produto where codigo = " + clienteRemover.getCodigoCliente());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
