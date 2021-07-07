
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
 * @author Kaveesha FDO
 */
public class account_balance {

    static Connection conn;
    static PreparedStatement sql;
    int balance = 0;

    public account_balance(int i) throws SQLException {
        int userid = i;
        database_connect cnt = new database_connect();
        cnt.connect();
        conn = cnt.con;

        try {
            sql = conn.prepareStatement("select * from account_balance WHERE user_details_uid = '" + userid + "'");
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
               // System.out.println(rs.getInt("account_number")
                 //       + " \n" + rs.getFloat("balance"));
                int acnum = rs.getInt("account_number");
                float bal = rs.getFloat("balance");
                System.out.println("Bank Account Number: "+ acnum);
                System.out.println("Your Account Balance: "+bal);
            }
        } catch (Exception ex) {
            Logger.getLogger(account_details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
