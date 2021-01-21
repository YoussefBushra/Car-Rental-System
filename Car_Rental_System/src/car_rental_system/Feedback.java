/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_system;

public class Feedback {
    private int FID;
    private int Rate;
    private String date;
    private String Content;

    public Feedback(int FID, int Rate, String date, String Content) {
        this.FID = FID;
        this.Rate = Rate;
        this.date = date;
        this.Content = Content;
    }

    public int getFID() {
        return FID;
    }

    public void setFID(int FID) {
        this.FID = FID;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int Rate) {
        this.Rate = Rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    @Override
    public String toString() {
        return "Feedback{" + "FID=" + FID + ", Rate=" + Rate + ", date=" + date + ", Content=" + Content + '}';
    }
    
    
}
