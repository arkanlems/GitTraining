package org.example.Juan_David_Camacho.Homework_4;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    public static void mainMenu(Map<Integer, Client> userList) {

        int first_selection = 0;

        do {

            System.out.println("/* ------- Welcome to Globant Bank ------- */\n" +
                    "-- Please choose one of the following options: --\n" +
                    "1. User Login \n" +
                    "2. Admin Enviroment\n" +
                    "3. Exit");

            Scanner input = new Scanner(System.in);
            first_selection = validateInt(input);

            switch (first_selection) {
                case 1:
                    userMenu(userList);
                    break;
                case 2:
                    adminMenu(userList);
                    break;
                case 3:
                    System.out.println("Now exiting...");
                    break;
                default:
                    break;

            }
        } while (first_selection != 3);

    }

    private static void userMenu(Map<Integer, Client> userList) {

        System.out.println("*/ ---- Welcome to user login in Globant Bank ---- /* \n" +
                "*/ Please enter your user now: ");
        Scanner input = new Scanner(System.in);
        String user = input.nextLine();

        System.out.println("*/ Please enter your password now: ");
        String pwd = input.nextLine();

        LoginResponse response = userLogin(user, pwd, userList);

        if (response.getAuthSuccesfull() == true) {

            handleUserInput(response, userList);

        } else {

            System.out.println("- Incorrect credentials entered");

        }

    }

    private static void handleUserInput(LoginResponse response, Map<Integer, Client> userList) {

        int selection = 0;

        do {

            System.out.println(
                    "*/ ---- Welcome to the user menu, " + userList.get(response.getClientID()).getUser() + " ---- /*\n"
                            +
                            "Your current balance is: $"
                            + userList.get(response.getClientID()).getAccount().getBalance() + "\n" +
                            "Please choose one of the following options: \n" +
                            "1. Add money to your account \n" +
                            "2. Withdraw money from yor account \n" +
                            "3. Transfer money to another bank account \n" +
                            "4. Exit to main menu");

            Scanner input = new Scanner(System.in);
            selection = validateInt(input);

            switch (selection) {
                case 1:
                    addMoney(userList.get(response.getClientID()));
                    break;

                case 2:
                    withdrawMoney(userList.get(response.getClientID()));
                    break;

                case 3:
                    transfer(userList.get(response.getClientID()), userList);
                    break;

                case 4:
                    System.out.println("Now exiting...");
                    break;

                default:
                    System.out.println("Invalid input, reloading menu...");
                    break;
            }

        } while (selection != 4);

    }

    private static void adminMenu(Map<Integer, Client> userList) {

        int selection = 0;

        do {

            System.out.println(
                    "*/ ---- Welcome to the admin menu ---- /*\n" +
                            "*/ Please choose one of the following options: \n" +
                            "1. View all clients and their info \n" +
                            "2. Add new client \n" +
                            "3. Exit to main menu");

            Scanner input = new Scanner(System.in);
            selection = validateInt(input);

            switch (selection) {
                case 1:

                    printAllCients(userList);

                    break;

                case 2:

                    break;

                case 3:
                    System.out.println("Exiting admin mode, loading main menu...");
                    break;

                default:
                    System.out.println("Invalid input, reloading menu...");
                    break;
            }

        } while (selection != 3);

    }

    private static void addMoney(Client client) {

        System.out.println("*/ Enter the amount of money to add to your account: ");
        Scanner input = new Scanner(System.in);
        Double moneyToAdd = Double.valueOf(validateInt(input));

        client.getAccount().addMoney(moneyToAdd);

        System.out.println("*/ Succesfully added $" + moneyToAdd + " to your accont. Your new balance is: $"
                + client.getAccount().getBalance());

    }

    private static void withdrawMoney(Client client) {

        double actualMoney = client.getAccount().getBalance();

        System.out.println(
                "*/ Enter the amount of money to withdraw from your account: ($" + actualMoney + " available)");
        Scanner input = new Scanner(System.in);
        Double moneyToWithdraw = Double.valueOf(validateInt(input));

        if (moneyToWithdraw == 0) {

            System.out.println("- Incorrect input entered, you need to withdraw at least $1");

        } else if (moneyToWithdraw <= actualMoney) {

            if (moneyToWithdraw <= 1000) {

                client.getAccount().withdraw(moneyToWithdraw + 200);
                System.out.println(
                        "+ $" + moneyToWithdraw
                                + " were ucessfully withdrawn from your account.\n Your new total is : $"
                                + client.getAccount().getBalance() + ", $200 were deducted in tax.");

            } else if (moneyToWithdraw > 1000) {

                double tax = ((15 * moneyToWithdraw) / (100)) + 200;
                client.getAccount().withdraw(moneyToWithdraw + tax);
                System.out.println(
                        "+ $" + moneyToWithdraw
                                + " were ucessfully withdrawn from your account.\n Your new total is : $"
                                + client.getAccount().getBalance() + ", $" + tax + " were deducted in tax.");
            }

        } else if (moneyToWithdraw > actualMoney) {

            System.out.println("- Incorrect amount entered, you can't withdraw more than your available balance");

        }

    }

    private static void transfer(Client client, Map<Integer, Client> userList) {

        System.out.println(
                "*/ Enter the number of the account you want to transfer to");
        Scanner input = new Scanner(System.in);
        int numberToTransfer = validateInt(input);
        SavingsAccount accountToTransfer = null;

        if (numberToTransfer != 0) {

            for (Map.Entry<Integer, Client> c : userList.entrySet()) {

                if (numberToTransfer == c.getValue().getAccount().getNumber()
                        && numberToTransfer != client.getAccount().getNumber()) {

                    accountToTransfer = c.getValue().getAccount();

                }

            }

            if (accountToTransfer != null) {

                System.out.println("*/ Enter the amount of money to transfer : (" + client.getAccount().getBalance()
                        + " available)");
                int moneyToTransfer = validateInt(input);

                if (moneyToTransfer == 0) {

                    System.out.println("- Incorrect input entered, you need to transfer at least $1");

                } else if (moneyToTransfer <= client.getAccount().getBalance()) {

                    client.getAccount().withdraw(moneyToTransfer + 100);
                    accountToTransfer.addMoney(moneyToTransfer);

                    System.out.println(
                            "+ $" + moneyToTransfer
                                    + " were ucessfully transfered to " + accountToTransfer.getNumber()
                                    + ".\n Your new total is : $"
                                    + client.getAccount().getBalance() + ", $100 were deducted in tax.");

                } else if (moneyToTransfer > client.getAccount().getBalance()) {

                    System.out
                            .println("- Incorrect amount entered, you can't transfer more than your available balance");

                }

            } else {

                System.out.println("- Couldn't find the account, please try again");

            }

        } else {

            System.out.println("- Invalid inputentered, please try again.");

        }

    }

    private static void printAllCients(Map<Integer, Client> userList) {

        System.out.println("ID | User | Balance | Opening Date | Account # |");

        for (Map.Entry<Integer, Client> c : userList.entrySet()) {

            System.out.println(c.getKey() + " | " + c.getValue().getUser() + " | $"
                    + c.getValue().getAccount().getBalance() + " | " + c.getValue().getAccount().getOpeningDate()
                    + " | " + c.getValue().getAccount().getNumber());

        }

    }

    private static LoginResponse userLogin(String user, String pwd, Map<Integer, Client> userList) {

        LoginResponse response = new LoginResponse(false, 0);

        for (Map.Entry<Integer, Client> c : userList.entrySet()) {

            if (user.equals(c.getValue().getUser()) && pwd.equals(c.getValue().getPwd())) {

                response.setAuthSuccesfull(true);
                response.setClientID(c.getKey());

            }

        }

        return response;

    }

    private static int validateInt(Scanner input) {

        int selection = 0;

        try {
            selection = input.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input, please enter a number");
            input.nextLine();
        }

        return selection;

    }

}

