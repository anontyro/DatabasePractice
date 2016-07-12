/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alex
 */
public class Login extends DatabaseLogic{
    
    public Login(String url, String table, String username, String dbPass) {
        super(url, table, username, dbPass);
    }
    
    public Login(){
    }
    
        public boolean logInto(String loginName, String userpass) throws SQLException{
            boolean success = false;
        if(dbPass.equals("")){
            dbPass = userInput("Enter database password: ");
        }
        
        String queryUsername ="SELECT username FROM login WHERE username =?";
        String querypass ="SELECT password FROM login WHERE password =?";
        
        try{
            mycon = DriverManager.getConnection(connection, username, dbPass);
            
            pst = mycon.prepareStatement(queryUsername);
            pst.setString(1, loginName);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                pst = mycon.prepareStatement(querypass);
                pst.setString(1, userpass);
                rs = pst.executeQuery();
                if(rs.next()){
                    System.out.println("Log in successful, as: " +loginName);
                    return success = true;
                }
                else{
                    System.out.println("Invalid password");
                    return success = false;
                }
            }
            else{
                System.out.println("Invalid username");
                return success = false;
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        finally{
            mycon.close();
        }
        return success = false;
    }
    
}
