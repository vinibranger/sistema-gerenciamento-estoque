package br.com.vinicius.sistoque;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    public Fornecedor getByCodigo(int id) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoFornecedor = connection. //
                    createStatement(). //
                    executeQuery("SELECT * FROM fornecedor WHERE id_fornecedor = " + id);

            resultadoFornecedor.next();
            int id_fornecedor = resultadoFornecedor.getInt("codigoForne");
            String nome = resultadoFornecedor.getString("nomeForne");
            String cnpj_cpf = resultadoFornecedor.getString("cnpjforne");
            String email = resultadoFornecedor.getString("email");
            String telefone = resultadoFornecedor.getString("telefone");
            String rua = resultadoFornecedor.getString("rua");
            String num_endereco = resultadoFornecedor.getString("numero");
            String bairro = resultadoFornecedor.getString("bairro");
            String cidade = resultadoFornecedor.getString("cidade");

            return new Fornecedor(id_fornecedor, nome, cnpj_cpf, email, telefone, rua, num_endereco, bairro, cidade);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Fornecedor> getAll() {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoFornecedor = connection. //
                    createStatement(). //
                    executeQuery("SELECT * FROM fornecedor ");
            List<Fornecedor> resultadoTodosOsFornecedor = new ArrayList<>();

            while (!resultadoFornecedor.isLast()) {
                resultadoFornecedor.next();

               int id_fornecedor = resultadoFornecedor.getInt("codigoForne");
                String nome = resultadoFornecedor.getString("nomeForne");
                String cnpj_cpf = resultadoFornecedor.getString("cnpjforne");
                String email = resultadoFornecedor.getString("email");
                String telefone = resultadoFornecedor.getString("telefone");
                String rua = resultadoFornecedor.getString("rua");
                String num_endereco = resultadoFornecedor.getString("numero");
                String bairro = resultadoFornecedor.getString("bairro");
                String cidade = resultadoFornecedor.getString("cidade");

                Fornecedor FornecedorObterDoBanco = new Fornecedor(id_fornecedor, nome, //
                        cnpj_cpf, email, telefone, rua, num_endereco, bairro, cidade);
                resultadoTodosOsFornecedor.add(FornecedorObterDoBanco);
            }
            return resultadoTodosOsFornecedor;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Fornecedor novoFornecedor) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("INSERT INTO produto values (" //
                            + novoFornecedor.codigoForne //
                            + ", '" + novoFornecedor.nomeForne + "'" //
                            + ", '" + novoFornecedor.cnpjforne + "'" //
                            + ", '" + novoFornecedor.email + "'" //
                            + ", '" + novoFornecedor.telefone + "'" //
                            + ", '" + novoFornecedor.rua + "'" //
                            + ", '" + novoFornecedor.numero + "'" //       
                            + ", '" + novoFornecedor.bairro + "'" //                              
                            + ", " + novoFornecedor.cidade + ")");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Fornecedor fornecedorParaRemover) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("DELETE FROM produto where codigo = " + fornecedorParaRemover.codigoForne);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
