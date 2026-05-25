import java.util.Scanner;

public class ATM {

    private int pin;
    private double balance;
    private Scanner scanner;

    // Constructor
    public ATM(int initialPin, double initialBalance) {
        this.pin = initialPin;
        this.balance = initialBalance;
        this.scanner = new Scanner(System.in);
    }

    // PIN Authentication
    private boolean authenticate() {
        System.out.print("Enter Your PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin == pin) {
            System.out.println("Authentication Successful");
            return true;
        } else {
            System.out.println("Invalid PIN. Access Denied");
            return false;
        }
    }

    // Display Menu
    private void showMenu() {
        System.out.println("\n=== ATM MENU ===");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Exit");
        System.out.print("Choose an Option: ");
    }

    // Check Balance
    private void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    // Deposit Money
    private void deposit() {
        System.out.print("Enter Deposit Amount: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful");
            System.out.println("Updated Balance: $" + balance);
        } else {
            System.out.println("Amount must be positive");
        }
    }

    // Withdraw Money
    private void withdraw() {
        System.out.print("Enter Withdraw Amount: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be positive");

        } else if (amount > balance) {
            System.out.println("Insufficient Balance");

        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful");
            System.out.println("Remaining Balance: $" + balance);
        }
    }

    // Start ATM System
    private void start() {
        System.out.println("=== Welcome to ATM ===");

        if (!authenticate()) {
            return;
        }

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank You for Using ATM");
                    break;
                default:
                    System.out.println("Invalid Option");
            }

        } while (choice != 4);
        scanner.close();
    }

    public static void main(String[] args) {
        // Initialize ATM
        ATM atm = new ATM(2026, 1000.00);
        atm.start();
    }
}