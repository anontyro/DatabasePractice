
package com.databasepractice.test;

import java.sql.*;

/**
 *
 * @author Alex
 */
public class Login {
    
    public static void main(String[]args) throws SQLException{
        
        Connection con = null;
        PreparedStatement pst = null;
        
        String url = "jdbc:mysql://localhost:3306/login";
        String user = "root";
        String password = "";
        String username ="Admin";
        String userpass = "Admin";
        String queryUsername ="SELECT * FROM login WHERE username = ?";
        String queryCheck ="SELECT password FROM login WHERE password = ?";
        
        try{
            //sets up a connection to the database
            con = DriverManager.getConnection(url, user, password);
            
            /*
            create the prepareStatement for the query to check the username
            */
            pst = con.prepareStatement(queryUsername);
            pst.setString(1, username); //used to set the string value of first '?' to username
            ResultSet rs = pst.executeQuery(); // executes and asks the database
            /*
            control statement to check the username using the results obtained
            from the database, this will just check if it exists if not it will
            print an error
            */
            if(rs.next()){
                /*
                next the password check is done using similar values and checks 
                the database once more to ensure all is correct
                */
                pst = con.prepareStatement(queryCheck);
                pst.setString(1, userpass);
                rs = pst.executeQuery();
                //nested if statement to check for password
                if(rs.next()){
                    System.out.println("logged in correctly! as: " + username); //logged in
                }
                else{
                    System.out.println("Invalid password");
                }
            }
            else{
                System.out.println("Invalid username");
            }
            //pst = con.prepareStatement(queryCheck);
            
            //pst.executeQuery();
        }
        catch(SQLException e){
            System.err.println(e);
        }
        //will close the connection to the database at the end
        finally{
            con.close();
            
        }
        
    }
}
