package Dia_4.GitTraining.JavaIntroduction3.Tareas_Tomas_Duque.Tarea_4;

public class Account {
   private String accountNumber;
   private String openingDate;
   private double balance;


   public Account(String accountNumber,String openingDate, double balance){
       this.accountNumber = accountNumber;
       this. openingDate = openingDate;
       this.balance = balance;
   }

   public void deposit(double amount){
       if(amount >= 1){
           balance += amount;
           System.out.println("Se depositaron " + amount + " dolares correctamente.");
       }else{
           System.out.println("¡El deposito tiene que ser mayor a 0!");
       }
   }

   public void withdraw(double amount){
       double tax = amount < 1000 ? 200:200 + amount * 0.15;
       if (balance >= amount + tax && amount >= 1){
           balance -=(amount + tax);
           System.out.println("Se retiraron " + (amount + tax) + " dolares correctamente. \n El nuevo saldo es de: " + balance );
       }else{
           System.out.println("Fondos insuficientes.");
       }
   }

   public void transfer(double amount, Account recipientAccount){
       double tax = 100.0;
       if (balance >= amount + tax && amount >= 1){
           balance -= (amount + tax);
           recipientAccount.balance += amount;
           System.out.println("Se transfirieron " + amount + " con una comisión de 100 dólares a la cuenta " + recipientAccount.accountNumber);
       } else{
           System.out.println("Fondos insuficientes.");
       }
   }

   public double getBalance(){
       return balance;
   }

}
