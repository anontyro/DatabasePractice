/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.databasepractice.test;

import java.sql.*;

public class AddToDB {
    
    public static void main(String[]args){
        
        Connection con = null;
        PreparedStatement pst = null;
        
        String url = "jdbc:mysql://localhost:3306/login";
        String user = "root";
        String password = "hello123";
        
        try{
            String username = "Admin";
            String userpass ="Admin";
            con = DriverManager.getConnection(url, user, password);
            
            pst = con.prepareStatement("INSERT INTO log(username,password) VALUES(?,?)");
            pst.setString(1, username);
            pst.setString(2, userpass);
            pst.executeUpdate();
        }
        catch(SQLException e){
            System.err.println(e);
        }
        
        
    }
}
