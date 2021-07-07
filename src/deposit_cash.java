import java.util.Scanner;
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
public class deposit_cash {
    static Connection conn;
    static PreparedStatement sql;
    Scanner scan = new Scanner(System.in);
    public deposit_cash(int i) throws SQLException{
        int userid = i;
        System.out.println("Please enter deposit amount");
        float deposit_amount = scan.nextFloat();

        database_connect cnt = new database_connect();
        cnt.connect();
        conn = cnt.con;

        try {

            sql = conn.prepareStatement("UPDATE account_balance SET balance= balance +'"+ Float.toString(deposit_amount)+"' where user_details_uid = '"+Integer.toString(userid)+"'");
            sql.executeUpdate();
            System.out.println("deposit complete, "+deposit_amount+" deposited to your account");

        } catch (SQLException ex) {
            Logger.getLogger(account_details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
