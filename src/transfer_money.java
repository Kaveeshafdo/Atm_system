
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
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
public class transfer_money {
    
    static Connection conn;
    static PreparedStatement sql;
    Scanner scan = new Scanner(System.in);
    public transfer_money(int i) throws SQLException{
        int userid = i;
        System.out.println("Please enter transfer amount");
        float transfer_amount = scan.nextFloat();

        database_connect cnt = new database_connect();
        cnt.connect();
        conn = cnt.con;

        try {

            sql = conn.prepareStatement("UPDATE account_balance SET balance= balance -'"+ Float.toString(transfer_amount)+"' where user_details_uid = '"+Integer.toString(userid)+"'");
            sql.executeUpdate();
            System.out.println("Transfer complete, "+transfer_amount+" credited to your account");

        } catch (SQLException ex) {
            Logger.getLogger(account_details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

