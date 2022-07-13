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
            int cnpjCpf = resultadoCliente.getInt("cnpj_cpf");
            String email = resultadoCliente.getString("email");
            int telefone = resultadoCliente.getInt("telefone");
            String rua = resultadoCliente.getString("rua");
            int numeEndereco = resultadoCliente.getInt("num_endereco");
            String bairro = resultadoCliente.getString("bairro");
            String cidade = resultadoCliente.getString("cidade");

            return new Cliente(codigoCliente, cnpjCpf, telefone, numeEndereco,//
                    nome, email, rua, bairro, cidade);

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

            while (resultadoCliente.next()) {
                int codigoCliente = resultadoCliente.getInt("idcliente");
                String nome = resultadoCliente.getString("nome");
                int cnpjCpf = resultadoCliente.getInt("cnpj_cpf");
                String email = resultadoCliente.getString("email");
                int telefone = resultadoCliente.getInt("telefone");
                String rua = resultadoCliente.getString("rua");
                int numeEndereco = resultadoCliente.getInt("num_endereco");
                String bairro = resultadoCliente.getString("bairro");
                String cidade = resultadoCliente.getString("cidade");

                Cliente ClienteObterDoBanco = new Cliente(codigoCliente, numeEndereco, cnpjCpf, telefone, nome,//
                        email, rua, bairro, cidade);
                resultadoTodosCliente.add(ClienteObterDoBanco);
            }

            return resultadoTodosCliente;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void salvar(Cliente novoCliente) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("INSERT INTO cliente (idcliente,nome,cnpj_cpf,email,telefone,"
                            + "rua,num_endereco,bairro,cidade) VALUES (" //
                            + novoCliente.getCodigoCliente() //
                            + ", '" + novoCliente.getNome() + "'" //
                            + ", '" + novoCliente.getCnpjCpf() + "'" //   
                            + ", '" + novoCliente.getEmail() + "'" //        
                            + ", '" + novoCliente.getTelefone() + "'" // 
                            + ", '" + novoCliente.getRua() + "'" //    
                            + ", '" + novoCliente.getNumeEndereco() + "'" //           
                            + ", '" + novoCliente.getBairro() + "'" //
                            + ", '" + novoCliente.getCidade() + "')");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Cliente clienteEditado) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            String comando="UPDATE cliente SET " //
                            + "nome = '" + clienteEditado.getNome() + "'" //
                            + ", cnpj_cpf = '" + clienteEditado.getCnpjCpf() + "'" //
                            + ", email = '" + clienteEditado.getEmail() + "'" //
                            + ", elefone = '" + clienteEditado.getTelefone() + "'" //
                            + ", rua = '" + clienteEditado.getRua() + "'" //
                            + ", num_endereco = '" + clienteEditado.getNumeEndereco() + "'" //
                            + ", bairro = '" + clienteEditado.getBairro() + "'" //
                            + ", cidade = '" + clienteEditado.getCidade()+"'" //
                            + " WHERE codigo = " + clienteEditado.getCodigoCliente(); 
                    
            System.out.println(comando);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(Cliente clienteRemover) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("DELETE FROM cliente where idcliente = " + clienteRemover.getCodigoCliente());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
     
    public List<Cliente> mostraPeloNome(String nomePesquisa) {
        if (nomePesquisa == null || nomePesquisa.isBlank()) {
            return getAll();
        }
        
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoCliente = connection. //
                    createStatement(). //
                    executeQuery("SELECT * FROM cliente WHERE nome like '%" + nomePesquisa + "%'");

            List<Cliente> resultadoTodosOsClientes = new ArrayList<>();

            while (resultadoCliente.next()) {
                int codigoCliente = resultadoCliente.getInt("idcliente");
                String nome = resultadoCliente.getString("nome");
                int cnpjCpf = resultadoCliente.getInt("cnpj_cpf");
                String email = resultadoCliente.getString("email");
                int telefone = resultadoCliente.getInt("telefone");
                String rua = resultadoCliente.getString("rua");
                int numeEndereco = resultadoCliente.getInt("num_endereco");
                String bairro = resultadoCliente.getString("bairro");
                String cidade = resultadoCliente.getString("cidade");

                Cliente ClienteObterDoBanco = new Cliente(codigoCliente, numeEndereco, cnpjCpf, telefone, nome,//
                        email, rua, bairro, cidade);
                resultadoTodosOsClientes.add(ClienteObterDoBanco);
            }

            return resultadoTodosOsClientes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
