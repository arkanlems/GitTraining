package org.example.Juan_Potes.Tarea4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
    public static Date scanDate(){
        int year = scanYear(1980, 2024);
        int month = scanMonth();
        int day = scanDay(month, year);

        return new Date(day, month, year);
    }

    private static int scanDay(int month, int year){
        int[] maxDays = {31,28,31,30,31,30,31,31,30,31,30,31};

        if(month == 2 && Date.isLeapYear(year)){
            maxDays[1] = 29;
        }

        return scanInt("Please type the DAY of the date: ", 1, maxDays[month-1]);
    }

    private static int scanMonth(){
        return scanInt("Please type the MONTH of the date: ", 1, 12);
    }

    private static int scanYear(int minYear, int maxYear){
        return scanInt("Please type the YEAR of the date: ", minYear, maxYear);
    }

    public static int scanInt(String requestMessage, int minValue, int maxValue){
        Scanner scan = new Scanner(System.in);

        int number = minValue - 1;

        do{
            System.out.print("\n" + requestMessage);

            if (scan.hasNextInt()){
                number = scan.nextInt();
            }

            if(number < minValue || number > maxValue){
                System.out.println("INVALID VALUE. (Type only a number between " + minValue +" and " + maxValue + ").");
            }
        }
        while(number < minValue || number > maxValue);

        return number;
    }

    public static String scanString(String requestMessage){
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile(".*[a-zA-Z]+.*");
        String name = "";
        Matcher matcher;
        boolean matches = false;

        while(!matches){
            System.out.print("\n" + requestMessage);
            name = scan.next();

            matcher = pattern.matcher(name);

            matches = matcher.matches();

            if(!matches){
                System.out.println("\nINVALID VALUE. Try again (The input must contain at least one letter).");
            }
        }

        return name;
    }

    public static double scanMoney(String requestMessage){
        Scanner scan = new Scanner(System.in);

        double amount = 0.0;

        boolean validInput = false;

        while(!validInput){
            System.out.print("\n" + requestMessage);

            if (scan.hasNextDouble()){
                amount = scan.nextDouble();
                if(amount > 0){
                    validInput = true;
                }
            }

            if(!validInput){
                System.out.println("\nINVALID VALUE. Try again (Write only positive numbers).");
            }
        }

        return amount;
    }

    public static void showAccessMenu(){
        System.out.println("\n------------------------------------");
        System.out.println("|          SELECT ACCESS           |");
        System.out.println("|  1. Enter as Bank Admin.         |");
        System.out.println("|  2. Enter as a Client.           |");
        System.out.println("|  3. Exit.                        |");
        System.out.println("------------------------------------");
    }

    public static void showBankMenu(){
        System.out.println("\n------------------------------------");
        System.out.println("|            BANK MENU             |");
        System.out.println("|  1. Show all clients.            |");
        System.out.println("|  2. Add a new client.            |");
        System.out.println("|  3. Delete a client.             |");
        System.out.println("|  4. Exit.                        |");
        System.out.println("------------------------------------");
    }
}
