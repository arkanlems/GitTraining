package org.example.homeworkSession4;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Controller {

    private int userNumber = 0;
    private int accNumber = 0;


    public void execution (){

    }

    public User createUser (){
        userNumber++;
        Scanner sc = new Scanner(System.in);
        System.out.print("Write your name: ");
        String name = sc.nextLine();
        String userId = "USR-"+userNumber;
        System.out.print("Password: ");
        String password = sc.nextLine();
        Account userAccount = createAccount();
        return new User(userId, name, password, userAccount);

    }

    public Account createAccount (){
        accNumber++;
        return new Account("ACC-"+accNumber, new Date(), 0.0, new ArrayList<>());
    }
}
