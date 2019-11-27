package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BancoDados {
    
    public Connection con(){
        String mariadb = "jdbc:mariadb://localhost:3306/livro";
        String user = "root";
        String passwd = "";
        Connection con = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(mariadb, user, passwd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}