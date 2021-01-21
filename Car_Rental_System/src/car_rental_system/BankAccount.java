/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_system;

public class BankAccount {
    private String CardID;
    private String Username;
    private double Balance;

    public BankAccount(String CardID, String Username, double Balance) {
        this.CardID = CardID;
        this.Username = Username;
        this.Balance = Balance;
    }

    public String getCardID() {
        return CardID;
    }

    public void setCardID(String CardID) {
        this.CardID = CardID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" + "CardID=" + CardID + ", Username=" + Username + ", Balance=" + Balance + '}';
    }
    
    
}
