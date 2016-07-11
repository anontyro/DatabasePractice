/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.database;

import java.sql.SQLException;

/**
 *
 * @author Alex
 */
public class Test {
    
    public static void main(String[]args){
        
        DatabaseLogic database = new DatabaseLogic("mysqlcluster15.registeredsite.com/","login_wfr",LoginDetails.username, LoginDetails.password);
        
        try{
            //database.addToDB();
            //database.login("admin", "admin000");
           System.out.println(database.queryDB("username", "login", "admin"));
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
