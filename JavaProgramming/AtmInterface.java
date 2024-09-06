import java.io.*;
import java.util.*;

class BankAccount {
    private double balance;

    public BankAccount(double currentBalance) {
        this.balance = currentBalance;
    }

    double checkBalance() {
        return balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
             System.out.println("\n===========================");
            System.out.println(amount + " Deposited!");
        } else {
             System.out.println("\n===========================");
            System.out.println("Amount Invalid!");
        }
    }

    boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("\n===========================");
            System.out.println("Insufficient Balance or Invalid Amount!");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    void operation() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("\n\n\n\t\tThank you for using ATM! Have a nice day!\t\t\t\n");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 4);
        sc.close();
    }

    void checkBalance() {
        System.out.println("\n===========================");
        System.out.println("Current Balance: " + account.checkBalance());
        System.out.println("===========================");
    }

    void deposit(double amount) {
        account.deposit(amount);
        //System.out.println("\n===========================");
        System.out.println("Current Balance: " + account.checkBalance());
        System.out.println("===========================");
    }

    void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("\n===========================");
            System.out.println("Collect Your Cash "+amount);
        }
       
        System.out.println("Current Balance: " + account.checkBalance());
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        System.out.println("\n\n\t\t\tWelcome to the ATM\t\t\t\n");
        BankAccount user1 = new BankAccount(0.0);
        ATM b1 = new ATM(user1);
        b1.operation();
    }
}
