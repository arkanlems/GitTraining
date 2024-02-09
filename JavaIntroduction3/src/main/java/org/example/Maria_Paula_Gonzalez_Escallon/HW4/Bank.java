package org.example.Maria_Paula_Gonzalez_Escallon.HW4;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<User> users;

    public Bank() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }
}
