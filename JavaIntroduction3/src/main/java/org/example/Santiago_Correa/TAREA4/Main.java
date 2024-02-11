package org.example.Santiago_Correa.TAREA4;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        init(bank);
        int choice = 0;
        try {
            System.out.println("1. Menu Bank");
            System.out.println("2. Menu Client");
            System.out.println("3. Exit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayMenuBank(scanner, bank);
                    break;
                case 2:
                    displayMenuClient(scanner, bank);
                    break;
                case 3:
                    System.out.println("Goodbye...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid input");
                    scanner.close();
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
            scanner.close();
        }
    }

    static void init(Bank bank) {
        Initializer.initializerUsers(bank);
    }

    static void displayMenuBank(Scanner scanner, Bank bank) {
        int choice = 0;
        try {
            while (choice != 2) {
                System.out.println("1. Display all users");
                System.out.println("2. Exit");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        bank.displayAllUsers();
                        break;
                    case 2:
                        System.out.println("Goodbye");
                        scanner.close();
                        break;
                    default:
                        System.out.println("Invalid input");
                        scanner.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
            scanner.close();
        }
    }

    static void displayMenuClient(Scanner scanner, Bank bank) {

        System.out.println("1. Register user");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        int c = 0;
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                if (c < 1) {
                    System.out.println("You need to register first");
                    System.out.println("Enter username");
                    String username = scanner.nextLine();
                    System.out.println("Enter account number");
                    int accountNumber = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter password");
                    String password = scanner.nextLine();
                    User user = new User(accountNumber, password, username);
                    bank.registerAccount(user);
                    c++;
                    displayMenuClient(scanner, bank);
                }
                scanner.close();
                break;
            case 2:
                System.out.println("Enter account number");
                int accountNumber = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter password");
                String password = scanner.nextLine();
                Account account = bank.login(accountNumber, password);
                if (account != null) {
                    displayMenuAccount(account, scanner, bank);
                }
                System.out.println("Invalid account number or password");
                scanner.close();
                break;
            case 3:
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("Invalid input");
        }
    }


    static void displayMenuAccount(Account account, Scanner scanner, Bank bank) {
        try {
            int choice2 = 0;
            while (choice2 != 4) {
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Transfer");
                System.out.println("4. Exit");
                choice2 = Integer.parseInt(scanner.nextLine());
                switch (choice2) {
                    case 1:
                        System.out.println("Enter amount to deposit");
                        double amountDeposit = Double.parseDouble(scanner.nextLine());
                        account.deposit(amountDeposit);
                        break;
                    case 2:
                        System.out.println("Enter amount to withdraw");
                        double amountWithdraw = Double.parseDouble(scanner.nextLine());
                        account.withdraw(amountWithdraw);
                        break;
                    case 3:
                        System.out.println("Enter amount to transfer");
                        double amountTransfer = Double.parseDouble(scanner.nextLine());
                        System.out.println("Enter account number to transfer");
                        int accountNumber = Integer.parseInt(scanner.nextLine());
                        account.transfer(amountTransfer, accountNumber, bank);
                        break;
                    case 4:
                        System.out.println("Goodbye");
                        scanner.close();
                        break;
                    default:
                        System.out.println("Invalid input");
                        scanner.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
            scanner.close();
        }
    }
}