package org.example.Juan_David_Camacho.Homework_4;
public class LoginResponse {

    private boolean authSuccesfull;
    private int clientID;

    public LoginResponse(boolean authSuccesfull, int clientID) {
        this.authSuccesfull = authSuccesfull;
        this.clientID = clientID;
    }

    public boolean isAuthSuccesfull() {
        return this.authSuccesfull;
    }

    public boolean getAuthSuccesfull() {
        return this.authSuccesfull;
    }

    public void setAuthSuccesfull(boolean authSuccesfull) {
        this.authSuccesfull = authSuccesfull;
    }

    public int getClientID() {
        return this.clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

}
