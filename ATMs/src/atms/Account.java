/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class Account {
    private int id;
    private int balance;
    private String name;
    LocalDate dateCreated = LocalDate.now();

    
    public int getId(){
        return id;
    }
    public int getBalance(){
        return balance;
    }
    public String getName(){
        return name;
    }
    public LocalDate getDate(){
        return dateCreated;
    }
    
    public void setId(int ID){
        this.id = ID;
    }
    public void setBalance(int Balance){
        this.balance = Balance;
    }
    public void setName(String Name){
        this.name = Name;
    }
    
    public void withdraw(double Amount){
        String connectionUrl = "jdbc:mysql://localhost:3306/ATM";
        String username = "root";
        String password = "Mojosmile@57";
        String query = "update ATM_Users set CurrentBalance='"+getBalance()+"' \" + \"where ID=="+getId()+"\";";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection

            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            System.out.println("Connection Established successfully");
        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query); 
            
            st.close();
            con.close();
            System.out.println("Connection Closed....");
        } catch (Exception ex) {
            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deposit(double Amount){
        String connectionUrl = "jdbc:mysql://localhost:3306/ATM";
        String username = "root";
        String password = "Mojosmile@57";
        String query = "update ATM_Users set CurrentBalance='"+getBalance()+"' \" + \"where ID=="+getId()+"\";";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection

            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            System.out.println("Connection Established successfully");
        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query); 
            
            st.close();
            con.close();
            System.out.println("Connection Closed....");
        } catch (Exception ex) {
            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void printStatement() {
        String str = "Name: "+ getName()+"\nCurrent Balance: "+getBalance()+"\nDate: "+getDate();
        JOptionPane.showMessageDialog(null, str);
    }
}
