/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.database;

/**
 *
 * @author Alex
 */
public class DatabaseLogic {
    
    private final String SQL_CON = "jdbc:mysql://";
    private String connection = "";
    private String username ="";
    
    
    public DatabaseLogic(String url, String database){
        connection = SQL_CON + url + database;
    }
    
    
    public String getConnection(){
        
        return connection;
    }
    
}
