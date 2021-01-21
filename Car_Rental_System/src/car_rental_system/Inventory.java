/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_system;

public class Inventory {
    private int Inv_ID;
    private double Capacity;
    private String Location;

    public Inventory(int Inv_ID, double Capacity, String Location) {
        this.Inv_ID = Inv_ID;
        this.Capacity = Capacity;
        this.Location = Location;
    }

    public int getInv_ID() {
        return Inv_ID;
    }

    public void setInv_ID(int Inv_ID) {
        this.Inv_ID = Inv_ID;
    }

    public double getCapacity() {
        return Capacity;
    }

    public void setCapacity(double Capacity) {
        this.Capacity = Capacity;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    @Override
    public String toString() {
        return "Inventory{" + "Inv_ID=" + Inv_ID + ", Capacity=" + Capacity + ", Location=" + Location + '}';
    }
    
    
}
