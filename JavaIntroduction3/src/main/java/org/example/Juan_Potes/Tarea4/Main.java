package org.example.Juan_Potes.Tarea4;

public class Main {
    public static void main(String[] args){
        int option = 0;
        Bank bank = new Bank();

        bank.addClient("client1","password1",Bank.getFreeAccNumber(),new Date(9,2,2020),0);
        bank.addClient("client2","password2",Bank.getFreeAccNumber(),new Date(10,2,2023),0);
        bank.addClient("client3","password3",Bank.getFreeAccNumber(),new Date(20,8,2021),10000);

        while(option != 3){
            UserInput.showAccessMenu();
            option = UserInput.scanInt("Type the number of the access required: ", 1, 3);

            switch(option){
                case 1:
                    bank.executeBankOptions();
                    break;
                case 2:
                    bank.executeUserOptions();
                    break;
                default:
                    break;
            }
        }
    }
}
