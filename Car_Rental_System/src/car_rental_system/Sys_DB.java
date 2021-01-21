/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Youssef
 */
public class Sys_DB {
    public static Connection connectDB() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CarRentalSystem","CarRentalSystem","123");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(Sys_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
