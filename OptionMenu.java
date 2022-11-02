
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    /* Validate Login information customer number and pin number */

    public void getLogin() throws IOException {
        int x = 1;

        do {
            try {
                /*
                 * Accounts in a HashMap, key = customer number, value = pin
                 * number
                 */
                data.put(11111111, 1111);
                data.put(22222222, 2222);
                data.put(33333333, 3333);
                data.put(44444444, 4444);

                System.out.println("------Welcome to the CDM Machine------");

                System.out.print("Enter Your Customer Card Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter Your Pin Number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
                x = 2;
            }
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else
                System.out.println("\n" + "Wrong Customer Card Number or Pin Number." + "\n");
        } while (x == 1);
    }

    /* Display Account Type Menu with selection */

    public void getAccountType() {
        System.out.println("Select the Account you want to access: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.print("Choice: ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank You for using this CDM, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
        }
    }

    /* Display Checking Account Menu with selections */

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("checking account balance: "+ (getCheckingBalance()) + "\n");
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using this CDM, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getChecking();
        }
    }

    /* Display Saving Account Menu with selections */

    public void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("saving account balance: "+ (getSavingBalance()) + "\n");
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("--------Thank You for using this CDM, bye.---------");
                break;

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getSaving();
        }
    }

    int selection;
}