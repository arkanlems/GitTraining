import java.sql.Timestamp;

public class Cuenta {
    private int numero;
    private Timestamp fecha_apertura;
    private double balance;

    public Cuenta(int numero, Timestamp fecha_apertura, double balance) {
        this.numero = numero;
        this.fecha_apertura = fecha_apertura;
        this.balance = balance;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Timestamp getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(Timestamp fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
