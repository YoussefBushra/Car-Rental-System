/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;  
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class ReservationManager {
    JFrame f = new JFrame();
    Connection conn = Sys_DB.connectDB();
    PreparedStatement  ps = null;
    ResultSet rs = null;
    ResultSet count_rs = null;
    ResultSet rs2 = null;
    int count;
////////////////////////////////////////////////////////////////////  For Authentication Process ////////////////////////////////////////////
    public boolean AuthenticateUser(String username, String password) {
        String login = "SELECT * FROM RENTER WHERE username=? AND password=?";
        
        try {
            ps = conn.prepareStatement(login);
            ps.setString(1,username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    public boolean AuthenticateStaff(String username, String password) {
        String login = "SELECT * FROM EMPLOYEE WHERE username=? AND password=?";
        
        try {
            ps = conn.prepareStatement(login);
            ps.setString(1,username);
            ps.setString(2, password);
            rs = null;
            rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "User not found!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//----------------------------------------------------------------------------------------------------------------------------------------//
//////////////////////////////////////////////////////////////////// For Checking and updationg car availability ///////////////////////////
    public boolean CheckAvailable(int id) {
        
        String CheckCar = "SELECT STATUS FROM CAR WHERE CID=?";
        
        try {
            rs = null;
            ps = conn.prepareStatement(CheckCar);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()) {
                if(rs.getString("STATUS").equals("Available")) { 
                    return true;
                }
            } else {
                JOptionPane.showMessageDialog(f,"Car not found");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    public void UpdateAvailablity(int id) {
        String CheckCar = "SELECT STATUS FROM CAR WHERE CID=?";
        
        try {
            ps = conn.prepareStatement(CheckCar);
            ps.setInt(1,id);
            rs = null;
            rs = ps.executeQuery();
            Statement stmt = null; 
            if(rs.next()) {
                String stat = rs.getString("STATUS");
                if(stat.equals("Available")) {
                    stat = "UnAvailable";
                } else {
                    stat = "Available";
                }
                stmt = conn.createStatement();
                stmt.executeUpdate(String.format("UPDATE CAR SET STATUS = '%s' WHERE CID = %d", stat, id));
                stmt.close();
                conn.close();
            } else {
                JOptionPane.showMessageDialog(f,"Car not found");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//-----------------------------------------------------------------------------------------------------------------------------------------//
//////////////////////////////////////////////////////////////////// For Sending Verification Mails /////////////////////////////////////////
    Properties emailProperties;
    Session mailSession;
    MimeMessage emailMessage;
    String toEmails, emailSubject, emailBody;
    public void VerifyReservation(String u) {
        try {
            String emailPort = "587";//gmail's smtp port
            
            emailProperties = System.getProperties();
            emailProperties.put("mail.smtp.port", emailPort);
            emailProperties.put("mail.smtp.auth", "true"); 
            emailProperties.put("mail.smtp.starttls.enable", "true");
            
            String Ver_Mail = "SELECT EMAIL FROM RENTER WHERE USERNAME=?";
            
            try {
                ps = conn.prepareStatement(Ver_Mail);
                ps.setString(1,u);
                rs = null;
                rs = ps.executeQuery();
                while(rs.next()) {
                    toEmails = (String) rs.getString("Email");
                }
                emailBody = "Dear Renter, Successfull Reservation.";
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
            emailSubject = "Confirmation Message";
            
            mailSession = Session.getDefaultInstance(emailProperties, null);
            emailMessage = new MimeMessage(mailSession);
            try {
                emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails));
            } catch (AddressException ex) {
                JOptionPane.showMessageDialog(null, "Email not sent");
            } catch (MessagingException ex) {
                Logger.getLogger(ReservationManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            emailMessage.setSubject(emailSubject);
            emailMessage.setContent(emailBody, "text/html");//for a html email
            //emailMessage.setText(emailBody);// for a text email
            String emailHost = "smtp.gmail.com";
            String fromUser = "example";//replace with the sender mail, just the id alone without @gmail.com
            String fromUserEmailPassword = "example"; //replace with the sender mail password
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(emailHost, fromUser, fromUserEmailPassword);
            transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
            transport.close();
            JOptionPane.showMessageDialog(null, "Verification Email sent successfully.");
        } catch (MessagingException ex) {
            Logger.getLogger(ReservationManager.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

    
    public void AuthenticateRegisteration(String fname, String lname, String mail, String user, String pass) throws SQLException {
        
        int count;
        String counter = "SELECT COUNT(*) FROM RENTER";
        
        Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        try {
            ///////////// counter to increment id automatically /////////////////////////////////
            count_rs = stm.executeQuery(counter);
            if(count_rs.first()) {
                count = count_rs.getInt(1);    
            } else {
                count = 1;
            }

            String insertRec = "INSERT INTO RENTER VALUES (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(insertRec);
            ps.setInt(1,++count);
            ps.setString(2, user);
            ps.setString(3, pass);
            ps.setString(4, fname);
            ps.setString(5, lname);
            ps.setString(6, mail);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AddReservationToDB(String ULoc, String OffLoc, String D, String M, String Y, double Duration, int CarID, String R_username) throws SQLException {
        Reservation R2 = new Reservation();
        PreparedStatement  ps1 = null;
        PreparedStatement  ps2 = null;
        
        double price = 0.00;
        double Taxes;
        int Renter_id = 0;
        
        ///////////// To get car price from its ID /////////////////////////////////////////////
        String PriceGetter = "SELECT PRICEPERHR FROM CAR WHERE CID = ?";
        ps1 = conn.prepareStatement(PriceGetter);
        ps1.setInt(1,CarID);
        rs = null;
        rs = ps1.executeQuery();
        if(rs.next()) {
            price = rs.getInt(1);
        } else {
            JOptionPane.showMessageDialog(f, "Car not found!");
        }
        Taxes = R2.CalculateTaxes(price, Duration);
        String counter = "SELECT COUNT(*) FROM RESERVATION";
        Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ///////////////////////////////////////////////////////////////////////////////////////////
        ///////////// To get Renter ID from its username ///////////////////////////////////////////////////////////
        String RenterGetter = "SELECT RID FROM RENTER WHERE USERNAME = ?";
        ps2 = conn.prepareStatement(RenterGetter);
        ps2.setString(1,R_username);
        rs = null;
        rs2 = ps2.executeQuery();
        if(rs2.next()) {
            Renter_id = rs2.getInt(1);
        } else {
            JOptionPane.showMessageDialog(null, "Renter ID not found");
        }
        
        /////////////////// counter to increment id automatically /////////////////////////////////
        try { 
            count_rs = stm.executeQuery(counter);
            if(count_rs.first()) {
                count = count_rs.getInt(1);    
            } else {
                count = 1;
            }

            String insertRec = "INSERT INTO RESERVATION VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(insertRec);
            ps.setInt(1,++count);
            ps.setString(2, ULoc);
            ps.setString(3, OffLoc);
            ps.setString(4, D);
            ps.setString(5, M);
            ps.setString(6, Y);
            ps.setDouble(7, Duration);
            ps.setDouble(8, Taxes);
            ps.setInt(9, CarID);
            ps.setInt(10, Renter_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fetch(JTable t) {
        String s = "SELECT * FROM CAR";
        try {
            ps = conn.prepareStatement(s);
            rs = null;
            rs = ps.executeQuery();
            t.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(ReservationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
