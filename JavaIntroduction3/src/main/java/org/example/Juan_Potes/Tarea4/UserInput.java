package org.example.Juan_Potes.Tarea4;

import java.util.Scanner;

public class UserInput {
    public static Date scanDate(){
        int year = scanYear(1980, 2024);
        int month = scanMonth(year);
        int day = scanDay(month, year);

        return new Date(day, month, year);
    }

    private static int scanDay(int month, int year){
        Scanner scan = new Scanner(System.in);
        int day = 0;
        int[] maxDays = {31,28,31,30,31,30,31,31,30,31,30,31};

        if(month == 2 && Date.isLeapYear(year)){
            maxDays[1] = 29;
        }

        while(day < 1 || day > maxDays[month-1]){
            System.out.print("Please type the DAY of the date: ");
            if(scan.hasNextInt()){
                day = scan.nextInt();
            }
            if(day < 1 || day > maxDays[month-1]){
                System.out.println("INVALID VALUE. (Type only a day between 1 and " + maxDays[month-1] + ").");
            }
        }
        return day;
    }

    private static int scanMonth(int year){
        Scanner scan = new Scanner(System.in);
        int month = 0;
        while(month < 1 || month > 12){
            System.out.print("Please type the MONTH of the date: ");
            if(scan.hasNextInt()){
                month = scan.nextInt();
            }
            if(month < 1 || month > 12){
                System.out.println("INVALID VALUE. (Type only a months between 1 and 12).");
            }
        }
        return month;
    }

    private static int scanYear(int minYear, int maxYear){
        Scanner scan = new Scanner(System.in);
        int year = 0;
        while(year < minYear || year > maxYear){
            System.out.print("Please type the YEAR of the date: ");
            if(scan.hasNextInt()){
                year = scan.nextInt();
            }
            if(year < minYear || year > maxYear){
                System.out.println("INVALID VALUE. (Type only a year between " + minYear +" and " + maxYear + ").");
            }
        }
        return year;
    }
}
