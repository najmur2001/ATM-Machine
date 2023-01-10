package Atm;

import java.text.DecimalFormat;
import java.util.*;
import java.io.IOException;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>(); // couples of records of account

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(123456, 1111);
                data.put(234567, 2222);
                data.put(345678, 3333);
                data.put(456789, 4444);
                data.put(567890, 5555);
                data.put(678901, 6666);

                System.out.println("Welcome To The MPB Bank");
                System.out.println("Enter Your Customer Number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter Your Pin Number");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + " Invalid Character(s) Only Numbers." + "\n");
                x = 2;
            }
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else
                System.out.println("\n" + "Wrong Customer Number or PIN Number" + "\n");
        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("Select the Account you want to access: ");
        System.out.println("Press 1 - current Accout \nPress 2 - Saving Account \n Press 3 - Exit ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getCurrent();
                break;

            case 2:
                getSavings();
                break;

            case 3:
                System.out.println("Thank You For Using this MPB ATM \n 'Visit Again!'\n\n");
                break;

            default:
                System.out.println("\n" + " Invalid Choice." + "\n");
                getAccountType();
        }
    }

    public void getCurrent() {
        System.out.println("You are Choosing Current Account ");
        System.out.println(" Press 1 - View Balance");
        System.out.println(" Press 2 - Withdraw Funds");
        System.out.println(" Press 3 - Deposit Funds");
        System.out.println(" Press 4 - Exit");
        System.out.println(" Choose Your Option: ");

        int selection = menuInput.nextInt();

        switch (selection) {

            case 1:
                System.out.println(" Current Account Balance: " + moneyFormat.format(getCurrentBalance()));
                getAccountType();
                break;

            case 2:
                getCurrentWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCurrentDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using MPB ATM! \n Visit Again!");
                break;

            default:
                System.out.println("\n" + "Invalid Choice " + "\n");
                getCurrent();
        }
    }

    public void getSavings() {
        System.out.println("You are Choseing Saving Account ");
        System.out.println(" Press 1 - View Balance");
        System.out.println(" Press 2 - Withdraw Funds");
        System.out.println(" Press 3 - Deposit Funds");
        System.out.println(" Press 4 - Exit");
        System.out.println(" Choice Your Options: ");

        int selection = menuInput.nextInt();
        switch (selection) {

            case 1:
                System.out.println(" Savings Account Balance: " + moneyFormat.format(getSavingsBalance()));
                getAccountType();
                break;

            case 2:
                getSavingsWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingsDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using MPB ATM! \n Visit Again!");
                break;

            default:
                System.out.println("\n" + "Invalid Choice " + "\n");
                getSavings();
        }
    }
}
