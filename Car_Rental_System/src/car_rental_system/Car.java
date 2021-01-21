/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_system;

import java.util.ArrayList;

public class Car {
    enum CarStatus {
        Available, 
        UnAvailable
    }
    enum CarBrand {
        BMW, 
        Mercedes, 
        Volkswagen, 
        Audi, 
        Skoda, 
        Tesla
    }
    private int CID;
    private int year;
    private String Color;
    private CarBrand Brand;
    private CarStatus status;
    private double PricePerHr;
    protected static ArrayList<Car> CarsList = new ArrayList();

    public Car(int CID, int year, String Color, CarBrand Brand, CarStatus status, double PricePerHr) {
        this.CID = CID;
        this.year = year;
        this.Color = Color;
        this.Brand = Brand;
        this.status = status;
        this.PricePerHr = PricePerHr;
        CarsList.add(this);
    }
    
    

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public CarBrand getBrand() {
        return Brand;
    }

    public void setBrand(CarBrand Brand) {
        this.Brand = Brand;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public double getPricePerHr() {
        return PricePerHr;
    }

    public void setPricePerHr(double PricePerHr) {
        this.PricePerHr = PricePerHr;
    }

    @Override
    public String toString() {
        return "Car{" + "CID=" + CID + ", year=" + year + ", Color=" + Color + ", Brand=" + Brand + ", status=" + status + ", PricePerHr=" + PricePerHr + '}';
    }


      
}
