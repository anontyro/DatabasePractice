
package com.databasepractice.test;

import java.sql.*;
/**
 *
 * @author Alex
 */
public class Test {
    

    
    public static void main(String[]args){
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
    
        String user ="root";
        String pass = "hello123";
        String url = "jdbc:mysql://localhost:3306/login";

        try{
            myConn = DriverManager.getConnection(url, user, pass);
            if(myConn!=null){
                System.out.println("connected");
            }

        }
        catch(Exception e){
            System.err.println(e);
    }
    }
}
