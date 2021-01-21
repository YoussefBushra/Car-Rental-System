/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_system;

import java.util.ArrayList;

public class Employee {
    private int SSN;
    private double Salary;
    protected String username;
    protected String password;
    private String FirstName;
    private String LastName;
    private String Email;
    private String sex;
    private String Address;
    private String phone;
    protected static ArrayList<Employee> EmployeesList = new ArrayList();
    
    public Employee() {
        
    }

    public Employee(int SSN, int Salary, String username, String password, String FirstName, String LastName, String Email, String sex, String Address, String phone) {
        this.SSN = SSN;
        this.Salary = Salary;
        this.username = username;
        this.password = password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.sex = sex;
        this.Address = Address;
        this.phone = phone;
        
        EmployeesList.add(this);
    }

    
    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passsword) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" + "SSN=" + SSN + ", Salary=" + Salary + ", username=" + username + ", passsword=" + password + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", sex=" + sex + ", Address=" + Address + ", phone=" + phone + '}';
    }
    
    public boolean login(String username, String password) {
        ReservationManager Auth = new ReservationManager();
        return Auth.AuthenticateStaff(username, password);
    }
}
