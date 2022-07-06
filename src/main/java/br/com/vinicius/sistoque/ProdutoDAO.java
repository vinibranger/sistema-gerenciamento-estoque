package br.com.vinicius.sistoque;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

   
    public Produto mostraPeloId(int cod_produ) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoProdutos = connection. //
                    createStatement(). //
                    executeQuery("SELECT * FROM produto WHERE codigo = " + cod_produ);

            resultadoProdutos.next();
            int codigo = resultadoProdutos.getInt("cod_produ");
            int quantidade = resultadoProdutos.getInt("quantidade");
            String nome = resultadoProdutos.getString("nome");
            String unidade = resultadoProdutos.getString("unidade");
            String localEstoque = resultadoProdutos.getString("local_estoque");
            String descricao = resultadoProdutos.getString("descriçao");
            String fornecedor = resultadoProdutos.getString("fornecedor");

            return new Produto(codigo, quantidade, nome, unidade, localEstoque,//
                    descricao, fornecedor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

   
    public List<Produto> mostraTudo() {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoProdutos = connection. //
                    createStatement(). //
                    executeQuery("SELECT * FROM produto");

            List<Produto> resultadoComTodosOsProdutos = new ArrayList<>();

            while (!resultadoProdutos.isLast()) {
                resultadoProdutos.next();
                int codigo = resultadoProdutos.getInt("cod_produ");
                int quantidade = resultadoProdutos.getInt("quantidade");
                String nome = resultadoProdutos.getString("nome");
                String unidade = resultadoProdutos.getString("unidade");
                String localEstoque = resultadoProdutos.getString("local_estoque");
                String descricao = resultadoProdutos.getString("descriçao");
                String fornecedor = resultadoProdutos.getString("fornecedor");

                Produto produtoObterDoBanco = new Produto(codigo, quantidade, nome, unidade, localEstoque,//
                    descricao, fornecedor);
                resultadoComTodosOsProdutos.add(produtoObterDoBanco);
            }

            return resultadoComTodosOsProdutos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

  
    public void save(Produto novoProduto) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("INSERT INTO produto values (" //
                            + novoProduto.getCodigo() //
                            + ", '" + novoProduto.getNome() + "'" //
                            + ", '" + novoProduto.getQuantidade() + "'" //
                            + ", '" + novoProduto.getUnidade() + "'" //
                            + ", '" + novoProduto.getLocalEstoque() + "'" //
                            + ", '" + novoProduto.getDescricao() + "'" //
                            + ", " + novoProduto.getFornecedor() + ")");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Produto produtoEditado) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            String comando = "UPDATE produto SET " //
                            + "nome = '" + produtoEditado.getNome() + "'" //
                            + ",quantidade = '" + produtoEditado.getQuantidade() + "'" //
                            + ",unidade = '" + produtoEditado.getUnidade() + "'" //
                            + ",local_estoque = '" + produtoEditado.getLocalEstoque() + "'" //
                            + ",descriçao = '" + produtoEditado.getDescricao() + "'" //
                            + ", fornecedor = '" + produtoEditado.getFornecedor() +"'"//
                            + "  WHERE cod_produ = " + produtoEditado.getCodigo();
            
            System.out.println(comando);
            
            connection.createStatement(). //
                    executeUpdate(comando);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Produto produtoParaRemover) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("DELETE FROM produto where cod_produ = " + produtoParaRemover.getCodigo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void entraSaiProduto(Produto produtoEntraSai) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("UPDATE produto SET " //
                            + "nome = '" + produtoEntraSai.getNome() + "'" //
                            + ",quantidade = '" + produtoEntraSai.getQuantidade() + "'" //
                            + " WHERE cod_produ = " + produtoEntraSai.getCodigo() //
                    );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    

    

}
