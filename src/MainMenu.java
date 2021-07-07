
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainMenu {

    Scanner sc = new Scanner(System.in);
    static Connection conn;
    static PreparedStatement sql;

    public void details() throws SQLException {
        database_connect cnt = new database_connect();
        cnt.connect();
        conn = cnt.con;

    }

    public MainMenu() {
        try {
            details();
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("          ------WELCOME------         ");
        System.out.println("     ------Insert your Card------     ");
        long cardnumber = sc.nextLong();
        int cardpin = 0;
        int userid = 0;
        try {

            sql = conn.prepareStatement("select * from card_details WHERE card_number = '" + Long.toString(cardnumber) + "'");
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
                cardpin = rs.getInt("pin");
                userid = rs.getInt("user_details_uid");
            }
        } catch (SQLException ex) {
            Logger.getLogger(account_details.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("     PLease enter your pin number     ");
        int pinnumber = sc.nextInt();
        try {
            if (cardpin == pinnumber) {
            System.out.println("Pin correct");
            int balance = 0;

        System.out.println("                ATM               ");
        System.out.println("     Check 1: Account Details     ");
        System.out.println("     Check 2: Account Balance     ");
        System.out.println("     Check 3: Deposit             ");
        System.out.println("     Check 4: Transfer Money      ");
        System.out.println("     Check 5: Withdrawal          ");
        int n = sc.nextInt();

        switch (n) {
            case 1: {
                try {
                    new account_details(userid);
                } catch (SQLException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            case 2:
                
            case 3:
            {try {
                new deposit_cash(userid);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }}
            break;
            case 4:

            case 5:
        }
        } else {
            System.out.println("Pin Incorrect");
        }
        } catch (Exception e) {
        }
        
        
    }

    public static void main(String[] args) {
        MainMenu main = new MainMenu();
    }
}
