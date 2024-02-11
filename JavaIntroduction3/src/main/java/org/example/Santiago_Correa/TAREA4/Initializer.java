package org.example.Santiago_Correa.TAREA4;

public class Initializer {

    static void initializerUsers(Bank bank) {
        User user1 = new User(1, "1234", "user1");
        User user2 = new User(2, "1234", "user2");
        User user3 = new User(3, "1234", "user3");
        bank.listAccounts.add(new Account(1, user1));
        bank.listAccounts.add(new Account(2, user2));
        bank.listAccounts.add(new Account(3, user3));
    }
}
