package aaa2019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conexao {

    private final Connection con;
    private final Statement stmt, stmRecebimento;
    private static final String USUARIO="root";
    private static final String SENHA="";
    
    public conexao() throws SQLException {  
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcaixaeletronico", USUARIO, SENHA);
        stmt = con.createStatement();
        stmRecebimento = con.createStatement();   
    }
    
}
