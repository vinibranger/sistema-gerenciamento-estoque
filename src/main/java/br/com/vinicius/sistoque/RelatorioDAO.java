
package br.com.vinicius.sistoque;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class RelatorioDAO {
    
    
    
     public List<Relatorio> mostrarRelatorio() {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoRelatorioEntraSai = connection. //
                    createStatement(). //
                    executeQuery("SELECT * FROM produto_update");

            List<Relatorio> resultadoEntraSaii = new ArrayList<>();

            while (!resultadoRelatorioEntraSai.isLast()) {
                resultadoRelatorioEntraSai.next();
                int idSaida = resultadoRelatorioEntraSai.getInt("id");
                int quantNova = resultadoRelatorioEntraSai.getInt("quantidade_Nova");
                String nomeProduto = resultadoRelatorioEntraSai.getString("nome");
                String data = resultadoRelatorioEntraSai.getString("changedAt");

                Relatorio relatorioProdtcBanco = new Relatorio( idSaida,quantNova,  nomeProduto,  data);
                resultadoEntraSaii.add(relatorioProdtcBanco);
            }

            return resultadoEntraSaii;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    
    
    
}
