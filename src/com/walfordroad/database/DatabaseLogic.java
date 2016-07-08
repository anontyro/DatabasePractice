/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.database;

import java.sql.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author Alex
 */
public class DatabaseLogic {
    
    private final String SQL_CON = "jdbc:mysql://";
    private String connection = "";
    private String username ="";
    private Connection mycon = null;
    private Statement myst = null;
    private ResultSet myrs = null;
    
    /**
     * Constructor that takes three variables 
     * @param url
     * @param database
     * @param username 
     */
    public DatabaseLogic(String url, String database, String username){
        connection = SQL_CON + url + database;
        this.username = username;
        
        String userPass = enterPass();
        
        try{
            testConnection(username,userPass);
        }
        catch(SQLException e){
            System.err.println("Unable to connect to database: \n" +e);
        }
    }
    
    
    public void testConnection(String username, String password) throws SQLException{
        String output ="";
        this.username = username;
        
        try{
            mycon = DriverManager.getConnection(connection, username, password);
            if(mycon!=null){
                System.out.println("Connected to database: ");
            }
        }
        catch(SQLException e){
            System.err.println(e);
        }
        finally{
            mycon.close();
        }

    }
    
     
    
    
    public String getConnection(){
        
        return connection;
    }
    
    public void setConnection(String connection){
        this.connection = connection;
    }
    
    private String enterPass(){
        String password ="";
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter password: ");
        password = input.nextLine();
        
        return password;
    }
    
}
