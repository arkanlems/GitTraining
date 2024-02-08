package org.example.Diego_Molina.HomeWork4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class Utils {
    private static final Scanner scan = new Scanner(System.in);

    public static int readInteger(){
        int validatedInteger = 0;
        boolean isValid = false;

        while(!isValid){
            System.out.println("Please enter an integer:");
            String input = scan.nextLine();

            try {
                validatedInteger = Integer.parseInt(input);
                isValid = true;
            }
            catch (NumberFormatException e){
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
        return validatedInteger;
    }

    public static String readString(){
        return scan.nextLine();
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());

            // Convert byte array to hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyPassword(String enteredPassword, String hashedPassword) {
        String enteredPasswordHashed = hashPassword(enteredPassword);
        return enteredPasswordHashed.equals(hashedPassword);
    }
}

