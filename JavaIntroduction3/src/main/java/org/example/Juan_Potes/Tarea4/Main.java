package org.example.Juan_Potes.Tarea4;

public class Main {
    public static void main(String[] args){
        int option = 0;

        Bank bank = new Bank();

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
