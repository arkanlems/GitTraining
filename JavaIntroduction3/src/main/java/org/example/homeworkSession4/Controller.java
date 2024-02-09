package org.example.homeworkSession4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controller {

    private int userNumber = 0;
    private int accNumber = 0;
    private List<User> userList = new ArrayList<>();


    public void execution() {

        Scanner sc = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("How do you want to join?\n1. Admin\n2. Client\n3. Exit");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    adminExecution();
                    break;
                case 2:
                    User user = login();
                    clientExecution(user);
                    break;
                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        } while (option != 3);

    }

    public void adminExecution() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("1. List all users.\n2. List all accounts.\n3. Create a client\n4. Exit");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    listUsers();
                    break;
                case 2:
                    listAccounts();
                    break;
                case 3:
                    userList.add(createUser());
                    break;
                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        } while (option != 4);

    }

    public User login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your userId: ");
        String userId = sc.nextLine();
        System.out.print("Please enter your password: ");
        String password = sc.nextLine();

        return userList.stream()
                .filter(user -> user.getUserId().equals(userId) && user.getPassword().equals(password))
                .collect(Collectors.toList()).get(0);

    }

    public void clientExecution(User user) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("1. Print Balance.\n2. Send Money.\n3. Withdrawal\n4. Exit");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Account: " + user.getAccount().getNumber() +
                            "\nBalance: " + user.getAccount().getBalance());
                    break;
                case 2:
                    System.out.print("Enter the destination Account: ");
                    String destination = sc.nextLine();
                    System.out.print("Enter the amount of the transaction: ");
                    double amount = sc.nextDouble();


                    double taxes = 100;


                    user.getAccount().setBalance(user.getAccount().getBalance() - amount - taxes);

                    Account destinationAcc = userList.stream()
                            .map(User::getAccount)
                            .filter(account -> account.getNumber().equals(destination))
                            .collect(Collectors.toList()).get(0);
                    double destinationOldBalance = destinationAcc.getBalance();
                    destinationAcc.setBalance(amount + destinationOldBalance);

                    System.out.println("Your new balance is: "+user.getAccount().getBalance());


                    break;
                case 3:
                    System.out.print("Enter the amount of the transaction: ");
                    double withdrawal = sc.nextDouble();
                    double wTaxes = 0.0;
                    if (withdrawal <= 1000)
                        wTaxes = 200;
                    else
                        wTaxes = 200 + (withdrawal * 0.15);
                    user.getAccount().setBalance(user.getAccount().getBalance() - withdrawal - wTaxes);
                    System.out.println("Your new balance is: "+user.getAccount().getBalance());
                    break;
                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        } while (option != 4);


    }

    public void listUsers() {
        System.out.println("Total Users: " + userList.size());
        for (User user : userList) {
            System.out.println("UserId: " + user.getUserId() + "\nName: " + user.getName() +
                    "\n-------------------------------------");
        }
    }

    public void listAccounts() {
        List<Account> accountList = userList.stream()
                .map(User::getAccount)
                .filter(account -> account != null)
                .collect(Collectors.toList());
        System.out.println("Total Accounts: " + accountList.size());
        for (Account account : accountList) {
            System.out.println("Number: " + account.getNumber() + "\nOpening Date: " + account.getOpeningDate() +
                    "\nBalance: " + account.getBalance() + "\n-------------------------------------");
        }
    }

    public User createUser() {
        userNumber++;
        Scanner sc = new Scanner(System.in);
        System.out.print("Write your name: ");
        String name = sc.nextLine();
        String userId = "USR-" + userNumber;
        System.out.print("Password: ");
        String password = sc.nextLine();
        Account userAccount = createAccount();
        return new User(userId, name, password, userAccount);

    }

    public Account createAccount() {
        accNumber++;
        return new Account("ACC-" + accNumber, new Date(), 0.0, new ArrayList<>());
    }


}
