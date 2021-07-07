
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jamit
 */
public class database_connect {
    Connection con;
    public void connect() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/atm","root","Jamith@5000");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(database_connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
