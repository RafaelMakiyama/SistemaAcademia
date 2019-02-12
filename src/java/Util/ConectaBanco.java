package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {
    
    public static Connection getConexao(){
        Connection Conexao = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            Conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetoTcc", "postgres", "rafael");
        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        }
        
        return Conexao;
    }
    
}
