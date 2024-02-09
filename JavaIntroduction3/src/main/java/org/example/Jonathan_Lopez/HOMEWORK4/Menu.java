package org.example.Jonathan_Lopez.HOMEWORK4;

import java.util.Scanner;
public class Menu {

    public static void Navigate(){
        System.out.println("Welcome to Globant Bank!");
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Print clients");
            System.out.println("2. Withdraw money");
            System.out.println("3. Deposit money");
            System.out.println("4. Transfer money");
            System.out.println("5. Create user");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bank.printClients();
                    break;
                case 2:
                    System.out.print("Write your username: ");
                    String withdrawUsername = scanner.next();
                    System.out.print("Enter your password: ");
                    String withdrawPassword = scanner.next();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdraw(withdrawUsername, withdrawPassword, withdrawAmount);
                    break;
                case 3:
                    System.out.print("Write your username: ");
                    String depositUsername = scanner.next();
                    System.out.print("Write your password: ");
                    String depositPassword = scanner.next();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(depositUsername, depositPassword, depositAmount);
                    break;
                case 4:
                    System.out.print("Write your username: ");
                    String fromUsername = scanner.next();
                    System.out.print("Write your password: ");
                    String fromPassword = scanner.next();
                    System.out.print("Enter the target account number: ");
                    String toAccountNumber = scanner.next();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    bank.transfer(fromUsername, fromPassword, toAccountNumber, transferAmount);
                    break;
                case 5: System.out.print("Follow the steps please ");
                    bank.createUser();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        System.out.println("Thank you for using Globant Bank. Goodbye!");
        scanner.close();
    }
}
