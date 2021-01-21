/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_system;

import static car_rental_system.Car.CarStatus.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Reservation {
    Connection conn = Sys_DB.connectDB();
    PreparedStatement  ps = null;
    ResultSet rs = null;
    ResultSet count_rs = null;
    
    private int Booking_Id;
    private String PickUp_Location, PickOff_Location, Day, Month, Year;
    private float duration;
    private double taxes;
    Car c;;
    Renter r;   
    
    protected static ArrayList<Reservation> ReservationsList = new ArrayList();
    JFrame f = new JFrame();
    
    public Reservation() {
        
    }
    
    //constructor is the same as ReserveCar function
    public Reservation(Car c,Renter r, int Booking_Id, String PickUp_Location, String PickOff_Location, String Day, String Month, String Year, float duration) throws MessagingException {
        this.c = c;
        this.r = r;
        this.Booking_Id = Booking_Id;
        this.PickUp_Location = PickUp_Location;
        this.PickOff_Location = PickOff_Location;
        this.Day = Day;
        this.Month = Month;
        this.Year = Year;
        this.duration = duration;
       
    }

    public int getBooking_Id() {
        return Booking_Id;
    }

    public void setBooking_Id(int Booking_Id) {
        this.Booking_Id = Booking_Id;
    }

    public String getPickUp_Location() {
        return PickUp_Location;
    }

    public void setPickUp_Location(String PickUp_Location) {
        this.PickUp_Location = PickUp_Location;
    }

    public String getPickOff_Location() {
        return PickOff_Location;
    }

    public void setPickOff_Location(String PickOff_Location) {
        this.PickOff_Location = PickOff_Location;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String Day) {
        this.Day = Day;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String Month) {
        this.Month = Month;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
    
    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }
    
    public double CalculateTaxes(double price, double duration) {
        taxes = price * duration;
        return taxes;
    }

    public Car getC() {
        return c;
    }

    public void setC(Car c) {
        this.c = c;
    }

    public Renter getR() {
        return r;
    }

    public void setR(Renter r) {
        this.r = r;
    }
    


    @Override
    public boolean equals(Object obj) {
        Reservation other = (Reservation) obj;
        return this.Booking_Id == other.Booking_Id;
    }
    

    @Override
    public String toString() {
        return "Reservation{" + "Booking_Id=" + Booking_Id + ", PickUp_Location=" + PickUp_Location + ", PickOff_Location=" + PickOff_Location + ", Day=" + Day + ", Month=" + Month + ", Year=" + Year + ", duration=" + duration + ", taxes=" + taxes + ", c=" + c + ", r=" + r + '}';
    }

    
    public static Reservation SearchReservations(int id) {
        for(int i = 0; i < ReservationsList.size(); i++) {
            if(id == ReservationsList.get(i).Booking_Id) {
                 return ReservationsList.get(i);
            }
        }
        return null;
    }
    public void NewReservations(int C_Id, String PickUp_Location, String PickOff_Location, String Day, String Month, String Year, double duration, String user) {
        ReservationManager Adder = new ReservationManager();
        ReservationManager Checker = new ReservationManager();
        if(Checker.CheckAvailable(C_Id)) {
            JOptionPane.showMessageDialog(f,"Successfull reservation");
            Checker.UpdateAvailablity(C_Id);
        } else {
            JOptionPane.showMessageDialog(f,"Unavailable Car");
        }
        try {
            Adder.AddReservationToDB(PickUp_Location, PickOff_Location, Day, Month, Year, duration, C_Id, user);
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void EditReservations(int id, String ULoc, String OffLoc, String D, String M, String Y, double Duration, int CarID) {
        try {
            double price = 0.00, Taxes = 0.00;
            Reservation R = new Reservation();
            Statement stmt = null;
            stmt = conn.createStatement();
            String PriceGetter = "SELECT PRICEPERHR FROM CAR WHERE CID = ?";
            ps = conn.prepareStatement(PriceGetter);
            ps.setInt(1,CarID);
            rs = ps.executeQuery();
            if(rs.next()) {
                price = rs.getDouble(1);
                ReservationManager Checker = new ReservationManager();
                if(Checker.CheckAvailable(CarID)) {
                    JOptionPane.showMessageDialog(f,"Reservation Edited Successfully");
                    Checker.UpdateAvailablity(CarID);
                    Taxes = (double) R.CalculateTaxes(price, Duration);
                    stmt.executeUpdate(String.format("UPDATE RESERVATION SET PICKUP_LOCATION='%s', PICKOFF_LOCATION='%s', DAY='%s', MONTH='%s', R_YEAR='%s', DURATION=%f, CAR_ID= %d, TAXES=%f WHERE BOOKING_ID = %d", ULoc, OffLoc, D, M, Y, Duration, CarID, Taxes, id));
                    JOptionPane.showMessageDialog(f,"Successful");
                } else {
                    JOptionPane.showMessageDialog(f,"Unavailable Car");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Car not found!");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

   public ArrayList CancelReservations(int Booking_Id) {
        // Missing checking date
        int index = ReservationsList.indexOf(SearchReservations(Booking_Id));
        ReservationsList.remove(index);
        JOptionPane.showMessageDialog(f,"Reservation number " + Booking_Id + " has been cancelled successfully");
        return ReservationsList;
    }
   
   public void display() {
        for(int i = 0; i < ReservationsList.size(); i++) {
            System.out.println(ReservationsList.get(i));
        }
    }

}