package org.example.Juan_Potes.Tarea4;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false; // Not divisible by 4, not a leap year
        } else if (year % 100 != 0) {
            return true; // Divisible by 4 and not by 100, is a leap year
        } else if (year % 400 != 0) {
            return false; // Divisible by 100 but not by 400, not a leap year
        } else {
            return true; // Divisible by 400, is a leap year
        }
    }

    public String getStringDate(){
        return this.day + " / " + this.month + " / " + this.year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
