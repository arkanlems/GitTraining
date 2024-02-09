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
                    break;
                case "2":
                    break;
                case "3":

                    break;
                case "4":

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
