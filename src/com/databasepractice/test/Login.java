
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
        String password = "hello123";
        String username ="Admin";
        String userpass = "Admin";
        String queryUsername ="SELECT * FROM log WHERE username = ?";
        String queryCheck ="SELECT password FROM log WHERE password = ?";
        
        try{
            
            con = DriverManager.getConnection(url, user, password);
            
            pst = con.prepareStatement(queryUsername);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                pst = con.prepareStatement(queryCheck);
                pst.setString(1, userpass);
                rs = pst.executeQuery();
                if(rs.next()){
                    System.out.println("logged in correctly! as: " + username);
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
        finally{
            con.close();
            
        }
        
    }
}
