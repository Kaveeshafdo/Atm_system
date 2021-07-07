
import java.util.Scanner;

public class MainMenu {
    Scanner sc = new Scanner(System.in);
    public MainMenu() {

        System.out.println("          ------WELCOME------         ");
        System.out.println("     ------Insert your Card------     ");
        System.out.println("     PLease enter your pin number    ");
        int pinnumber = sc.nextInt();

        int balance = 0, deposit, withdrawal;
        while (true) {
            System.out.println("                ATM               ");
            System.out.println("     Check 1: Account Details     ");
            System.out.println("     Check 2: Account Balance     ");
            System.out.println("     Check 3: Deposit             ");
            System.out.println("     Check 4: Transfer Money      ");
            System.out.println("     Check 5: Withdrawal          ");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("efawefaerfaer3456");
                case 2:

                case 3:

                case 4:

                case 5:
            }
        }
    }

    public static void main(String[] args) {
        MainMenu main = new MainMenu();
    }
}
