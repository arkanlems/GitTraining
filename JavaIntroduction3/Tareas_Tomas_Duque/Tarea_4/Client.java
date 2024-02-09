package Dia_4.GitTraining.JavaIntroduction3.Tareas_Tomas_Duque.Tarea_4;

public class Client {
    private String username;
    private String password;
    private Account account;


    public Client(String username, String password, Account account) {
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public String getUsername() {
        return username;
    }
}
