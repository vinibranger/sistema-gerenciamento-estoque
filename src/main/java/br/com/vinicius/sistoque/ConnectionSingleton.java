
package br.com.vinicius.sistoque;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    private static Connection connection;
    
    
        
  static Connection getConnection() throws SQLException {
       
      if(connection ==null){
          connection = DriverManager.getConnection( //
                "jdbc:mysql://localhost:3306/sistoque", //
                "root", //
                "16052001");
      }
      
      return connection;
    }
}
