
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class account_details {

    static Connection conn;
    static PreparedStatement sql;

    public account_details(int i) throws SQLException {
        int userid = i;
        database_connect cnt = new database_connect();
        cnt.connect();
        conn = cnt.con;

        try {

            sql = conn.prepareStatement("select * from user_details WHERE uid = '"+ Integer.toString(userid)+"'");
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name")
                        + " \n " + rs.getString("nic") 
                        + " \n " + rs.getInt("tel_num") 
                        + " \n " + rs.getString("address") 
                        + " \n " + rs.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(account_details.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
