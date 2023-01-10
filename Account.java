package Atm;

import java.text.DecimalFormat;
import java.util.*;

public class Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    private int customerNumber;

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    private int pinNumber;

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    private double currentBalance = 100000;

    public double getCurrentBalance() {
        return currentBalance;

    }

    private double savingsBalance = 200000;

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public double calcCurrentWithdraw(double amount) {
        currentBalance = (currentBalance - amount);
        return currentBalance;
    }

    public double calcSavingsWithdraw(double amount) {
        savingsBalance = (savingsBalance - amount);
        return savingsBalance;
    }

    public double calcCurrentDeposit(double amount) {
        currentBalance = (currentBalance + amount);
        return currentBalance;
    }

    public double calcSavingsDeposit(double amount) {
        savingsBalance = (savingsBalance + amount);
        return savingsBalance;
    }

    public void getCurrentWithdrawInput() {
        System.out.println("Current Account Balance: " + moneyFormat.format(currentBalance));
        System.out.println("Enter the Amount You Want to Withdraw from Current Account: ");
        double amount = input.nextInt();

        if ((currentBalance - amount) >= 0) {
            calcCurrentWithdraw(amount);
            System.out.println(" New Current Account Balance: " + moneyFormat.format(currentBalance));

        } else {
            System.out.println("Insuficient Balance in Your Account");
        }
    }

    public void getSavingsWithdrawInput() {
        System.out.println("Savings Account Balance: " + moneyFormat.format(savingsBalance));
        System.out.println("Enter the Amount You Want to Withdraw from Savings Account: ");
        double amount = input.nextInt();

        if ((savingsBalance - amount) >= 0) {
            calcSavingsWithdraw(amount);
            System.out.println(" New Savings Account Balance: " + moneyFormat.format(savingsBalance));

        } else {
            System.out.println("Insuficient Balance in Your Account");
        }
    }

    public void getCurrentDepositInput() {
        System.out.println("Current Account Balance: " + moneyFormat.format(currentBalance));
        System.out.println("Enter the Amount You Want to Deposit to Current Account: ");
        double amount = input.nextInt();

        if ((currentBalance + amount) >= 0) {
            calcCurrentDeposit(amount);
            System.out.println(" New Current Account Balance: " + moneyFormat.format(currentBalance));
        } else {
            System.out.println("Balance Cannot Be Negetive" + "\n");
        }
    }

    public void getSavingsDepositInput() {
        System.out.println("Savings Account Balance: " + moneyFormat.format(savingsBalance));
        System.out.println("Enter the Amount You Want to Deposit in Your Savings Account: ");
        double amount = input.nextInt();

        if ((savingsBalance + amount) >= 0) {
            calcSavingsDeposit(amount);
            System.out.println(" New Savings Account Balance: " + moneyFormat.format(savingsBalance));
        } else {
            System.out.println("Balance Cannot Be Negetive" + "\n");
        }
    }

}
