 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_system;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Renter {
    private int RID;
    protected String username;
    protected String password;
    private String FirstName;
    private String LastName;
    private String Email;
    protected static ArrayList<Renter> RentersList = new ArrayList();
    
    
   public Renter() {
       
   }

    // the constructor itself is used to add renters
    public Renter(int RID, String username, String password, String FirstName, String LastName, String Email) {
        this.RID = RID;
        this.username = username;
        this.password = password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        RentersList.add(this);
    }
    
    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasssword() {
        return password;
    }

    public void setPasssword(String passsword) {
        this.password = passsword;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Renter{" + "RID=" + RID + ", username=" + username + ", passsword=" + password + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + '}';
    }
    
    public boolean login(String username, String password) {
        ReservationManager Auth = new ReservationManager();
        return Auth.AuthenticateUser(username, password);
    }
    
    public void signup(String fname, String lname, String mail, String user, String pass) {
        ReservationManager Auth = new ReservationManager();
        try {
            Auth.AuthenticateRegisteration(fname, lname, mail, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Renter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void display() {
        for(int i = 0; i < RentersList.size(); i++) {
            System.out.println(RentersList.get(i));
        }
    }
    
    
}
