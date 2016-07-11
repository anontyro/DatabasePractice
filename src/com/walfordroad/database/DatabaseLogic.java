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
 * Class to carry out the heavily lifting when connecting to a mysql database
 * @author Alex
 */
public class DatabaseLogic {
    
    private final String SQL_CON = "jdbc:mysql://";
    private final String SQL_LOCAL = "jdbc:mysql://localhost:3306/";
    private String database ="";
    private String url ="";
    protected String connection = "";
    protected String username ="";
    protected String dbPass ="";
    protected Connection mycon = null;
    protected Statement myst = null;
    protected ResultSet myrs = null;
    protected PreparedStatement pst = null;
    
    /**
     * Constructor that takes three variables to create the connection name and
     * save the username.
     * @param url
     * @param database
     * @param username 
     */
    public DatabaseLogic(String url, String database, String username, String dbPass){
        connection = SQL_CON + url + database;
        this.username = username;
        this.database = database;
        this.dbPass = dbPass;
        this.url = url;
        
        if(dbPass.equals("")){
            dbPass = userInput("Enter password: ");
        }
        
        try{
            testConnection(username,dbPass);
        }
        catch(SQLException e){
            System.err.println("Unable to connect to database: \n" +e);
        }
    }
    
    /**
     * method to test the connection to the database to ensure that one can be
     * made.
     * @param username
     * @param password
     * @throws SQLException 
     */
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
    
    /**
     * method that will ask values to be added to the database
     * @throws SQLException to close the connection this exception is thrown
     */
    public void addToDB() throws SQLException{
        String[]coloums;
        String[]values;
        int noCols = 0;
        String preparedUpdate = "INSERT INTO ";
        String coloumsToPlace ="";
        String valuesToPlace ="";
        
        //requests the table which will be written to from the user
        String table = userInput("Enter table to add to: ");
        try{
            //converts into a number
            noCols = Integer.parseInt(userInput("Number of colomns: "));
        }
        catch(Exception e){ //catches error if Integer cannot parse
            System.err.println(e);
        }
        //assign the size of the two arrays
        coloums = new String[noCols];
        values = new String[noCols];
        
        /*
        enhanced for loop used to generate all the coloums the user wants to add
        asking for the coloumn name (same as in database) followed by the requested
        value for that coloum, both put into respective arrays to be called later
        */
        for(int i = 0; i < noCols; i++){
            String userColoum = userInput("What is the coloumn name: ");
            coloums[i] = userColoum;
            String userValue = userInput("What is the value for " + userColoum +":");
            values[i] = userValue;
        }
        
        /*
        creates the two strings to be used for the update command and create the
        correct strings
        */
        for(String x:coloums){
            coloumsToPlace += x +",";
            valuesToPlace += "?,";
        }
        
        /*
        used to remove the last ',' in each of the strings to ensure that the 
        sql command works correctly
        */
        coloumsToPlace = coloumsToPlace.substring(0, (coloumsToPlace.length()-1));
        valuesToPlace = valuesToPlace.substring(0, (valuesToPlace.length()-1));

        //creates the prepared string for sql
        preparedUpdate += table + "(" + coloumsToPlace +")" + " VALUES" 
                + "(" + valuesToPlace + ")";
        
        //requests the password from the user, used to login if none exists
        if(dbPass.equals("")){
            dbPass = userInput("Enter password: ");
        }

        // if any of the arrays are not inialized will exit after this error
        if((values == null) || (coloums ==null)){
            System.err.println("No data to add, quiting");
            System.exit(1);
        }
        
        /*
        main block used to add the information to the database
        */
        try{
            //used to initilise the connection to the database
            mycon = DriverManager.getConnection(connection, username, dbPass);
            
            //set the prepareStatement using the values above
            pst = mycon.prepareStatement(preparedUpdate);
            
            // for loop to create all of the values from the prepared statment
            for(int i =0; i < values.length;i++){
                pst.setString(i+1, values[i]);
            }
            //execute the update
            pst.executeUpdate();
            System.out.println("Database updated");
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        finally{
            mycon.close();
        }
   
    }
    
    public String queryDB(String selectCol, String table, String colValu) throws SQLException{
        String output ="";
        if(dbPass.equals("")){
            dbPass = userInput("Enter database password: ");
        }
        
        String queryDB ="SELECT "+ selectCol +" FROM "+ table +" WHERE "+selectCol+" =?";
        
        
        try{
            mycon = DriverManager.getConnection(connection, username, dbPass);
            
            pst = mycon.prepareStatement(queryDB);
            pst.setString(1, colValu);
            ResultSet rs = pst.executeQuery();
            
            output = rs.getString(selectCol);
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        finally{
            mycon.close();
        }
        
        return output;
    }
    
    public Collection getColumnNames(String table) throws SQLException{
        if(dbPass.equals("")){
            dbPass = userInput("Enter database password: ");
        }
        
        String queryColumn = "SELECT * FROM " +table;
        ArrayList<String>columnList = new ArrayList<>();
        
        try{
            mycon = DriverManager.getConnection(connection, username, dbPass);
            
            pst = mycon.prepareStatement(queryColumn);
            myrs = pst.executeQuery();

            ResultSetMetaData rsmd = myrs.getMetaData();

            for(int i = 1; i <=rsmd.getColumnCount(); i++){
                columnList.add(rsmd.getColumnName(i));
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        finally{
            mycon.close();
        }
        return columnList;
    }
    
    /**
     * getter to return connection String value.
     * @return 
     */
    public String getConnection(){
        
        return connection;
    }
    
    /**
     * setter to alter the connection String value.
     * @param connection 
     */
    public void setConnection(String connection){
        this.connection = connection;
    }
    
    //utility method that will allow user input
    protected String userInput(String prompt){
        String user ="";
        
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        user = input.nextLine();
        
        return user;
    }
    
    
    
}
