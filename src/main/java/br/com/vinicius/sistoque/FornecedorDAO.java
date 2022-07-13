package br.com.vinicius.sistoque;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    public Fornecedor getCodigo(int id) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoFornecedor = connection. //
                    createStatement(). //
                    executeQuery("SELECT * FROM fornecedor WHERE id_fornecedor = " + id);

            resultadoFornecedor.next();
            int codigoForne = resultadoFornecedor.getInt("id_fornecedor");
            String nomeForne = resultadoFornecedor.getString("nome");
            String cnpjForne = resultadoFornecedor.getString("cnpj_cpf");
            String email = resultadoFornecedor.getString("email");
            String telefone = resultadoFornecedor.getString("telefone");
            String rua = resultadoFornecedor.getString("rua");
            String numero = resultadoFornecedor.getString("num_endereco");
            String bairro = resultadoFornecedor.getString("bairro");
            String cidade = resultadoFornecedor.getString("cidade");

            return new Fornecedor(codigoForne, nomeForne, cnpjForne, email, telefone, rua, numero, bairro, cidade);
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

            while (resultadoFornecedor.next()) {

                int codigoForne = resultadoFornecedor.getInt("id_fornecedor");
                String nomeForne = resultadoFornecedor.getString("nome");
                String cnpjForne = resultadoFornecedor.getString("cnpj_cpf");
                String email = resultadoFornecedor.getString("email");
                String telefone = resultadoFornecedor.getString("telefone");
                String rua = resultadoFornecedor.getString("rua");
                String numero = resultadoFornecedor.getString("num_endereco");
                String bairro = resultadoFornecedor.getString("bairro");
                String cidade = resultadoFornecedor.getString("cidade");

                Fornecedor FornecedorObterDoBanco = new Fornecedor(codigoForne, nomeForne, //
                        cnpjForne, email, telefone, rua, numero, bairro, cidade);
                resultadoTodosOsFornecedor.add(FornecedorObterDoBanco);
            }
            return resultadoTodosOsFornecedor;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void salvar(Fornecedor novoForne) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("INSERT INTO fornecedor(id_fornecedor,nome,cnpj_cpf,email,rua,num_endereco,bairro,cidade) values (" //
                            + novoForne.getCodigoForne() //
                            + ", '" + novoForne.getNomeForne() + "'" //
                            + ", '" + novoForne.getCnpjForne() + "'" //
                            + ", '" + novoForne.getEmail() + "'" //
                            + ", '" + novoForne.getTelefone() + "'" //
                            + ", '" + novoForne.getRua() + "'" //
                            + ", '" + novoForne.getNumero() + "'" //
                            + ", '" + novoForne.getBairro() + "'" //
                            + ",' " + novoForne.getCidade() + "')");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Fornecedor fornecedorEditado) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("UPDATE produto SET " //
                            + "nome = '" + fornecedorEditado.getNomeForne() + "'" //
                            + "cnpj_cpf = '" + fornecedorEditado.getCnpjForne() + "'" //
                            + "email = '" + fornecedorEditado.getEmail() + "'" //
                            + "telefone = '" + fornecedorEditado.getTelefone() + "'" //
                            + "rua = '" + fornecedorEditado.getRua() + "'" //
                            + "num_endereco = '" + fornecedorEditado.getNumero() + "'" //
                            + "bairro = '" + fornecedorEditado.getBairro() + "'" //
                            + ", cidade = " + fornecedorEditado.getCidade() //
                            + " WHERE codigo = " + fornecedorEditado.getCodigoForne() //
                    );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(Fornecedor fornecedorParaRemover) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("DELETE FROM produto where codigo = " + fornecedorParaRemover.getCodigoForne());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Fornecedor getnome(String nomeForne) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoFornecedor = connection. //
                    createStatement(). //
                    executeQuery("SELECT * FROM fornecedor WHERE id_fornecedor = " + nomeForne);

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
}
