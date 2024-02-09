package org.example.Maria_Paula_Gonzalez_Escallon.HW4;

import java.util.Scanner;
public class GlobantBank {
    public static void VirtualBank() {
        Bank bank = new Bank();
        Account ac1 = new Account("2024-02-09",1001);
        Account ac2 = new Account("2024-02-09",1002);
        bank.addUser(new User("username1","password1",ac1));
        bank.addUser(new User("username2","password2",ac2));

        String date;
        int numAccount = 1002;

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Globant Bank");

        System.out.println("Please enter today's date (YYYY-MM-DD)");
        String inputDate = scan.nextLine();
        if (inputDate.matches("\\d{4}-\\d{2}-\\d{2}")){
            date = inputDate;
        }
        else {
            System.out.println("Invalid date. Exiting the bank");
            return;
        }
        boolean running = true;
        while (running) {
            String username;
            String password;
            User user;
            double amount = 0;

            System.out.println("What option would you like to make today? (Please enter the corresponding number)" +
                    "\n 1. Create user" +
                    "\n 2. Deposit money" +
                    "\n 3. Withdraw money" +
                    "\n 4. Send money" +
                    "\n 5. Print users" +
                    "\n 6. Exit bank");
            String option = scan.nextLine();

            switch (option) {
                case "1":
                    numAccount++;
                    Account account = new Account( date, numAccount);

                    System.out.println("Please enter a username: ");
                    username = scan.nextLine();

                    System.out.println("Please enter a password: ");
                    password = scan.nextLine();

                    user = new User(username, password, account);
                    bank.addUser(user);
                    break;
                case "2":
                    System.out.println("Please enter your username: ");
                    username = scan.nextLine();

                    System.out.println("Please enter a password: ");
                    password = scan.nextLine();
                    if(bank.isLoginValid(username,password)){
                        user = bank.getUserByUsername(username);
                        System.out.println("Please enter the amount of money that you want to deposit: ");
                        String inputAmountDeposit = scan.nextLine();
                        if (inputAmountDeposit.matches("^\\d+(\\.\\d+)?$")){
                            amount = Double.parseDouble(inputAmountDeposit);
                        }else {
                            System.out.println("Invalid amount of money. Please try again");
                            break;
                        }
                        user.getAccount().deposit(amount);
                    }else {
                        System.out.println("Invalid credentials. Please try again");
                        break;
                    }
                    break;
                case "3":
                    System.out.println("Please enter your username: ");
                    username = scan.nextLine();

                    System.out.println("Please enter a password: ");
                    password = scan.nextLine();
                    if(bank.isLoginValid(username,password)){
                        user = bank.getUserByUsername(username);
                        System.out.println("Please enter the amount of money that you want to withdraw: ");
                        String inputAmountWithdraw = scan.nextLine();
                        if (inputAmountWithdraw.matches("^\\d+(\\.\\d+)?$")){
                            amount = Double.parseDouble(inputAmountWithdraw);
                        }else {
                            System.out.println("Invalid amount of money. Please try again");
                            break;
                        }
                        user.getAccount().withdraw(amount);
                    } else {
                        System.out.println("Invalid credentials. Please try again");
                        break;
                    }
                    break;
                case "4":
                    System.out.println("Please enter your username: ");
                    username = scan.nextLine();

                    System.out.println("Please enter a password: ");
                    password = scan.nextLine();
                    if(bank.isLoginValid(username,password)){
                        user = bank.getUserByUsername(username);
                        System.out.println("Please enter the account: ");
                        String recipientAccountInput = scan.nextLine();
                        int accountNumber = 0;
                        if (recipientAccountInput.matches("^\\d+$")){
                            accountNumber = Integer.parseInt(recipientAccountInput);
                        } else {
                            System.out.println("Invalid account. Please try again");
                            break;
                        }
                        Account recipientAccount = bank.getAccountByNumber(accountNumber);
                        if(recipientAccount!=null){
                            System.out.println("Please enter the amount of money that you want to withdraw: ");
                            String inputAmountWithdraw = scan.nextLine();
                            if (inputAmountWithdraw.matches("^\\d+(\\.\\d+)?$")){
                                amount = Double.parseDouble(inputAmountWithdraw);
                            }else {
                                System.out.println("Invalid amount of money. Please try again");
                                break;
                            }
                            user.transfer(amount,recipientAccount);
                        } else {
                            System.out.println("Invalid account. Please try again");
                            break;
                        }
                    } else {
                        System.out.println("Invalid credentials. Please try again");
                        break;
                    }
                    break;
                case "5":
                    break;
                case "6":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

}
