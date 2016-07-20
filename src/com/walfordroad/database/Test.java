/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.database;

import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Alex
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<String> newArray = new ArrayList<>();
        String test = " vanilla \n"
                + "strawberry \n"
                + "strawberry \n"
                + "chocolate \n"
                + "chocolate \n"
                + "vanilla \n"
                + "banana \n";
        //DatabaseLogic database = new DatabaseLogic("mysqlcluster15.registeredsite.com/","login_wfr",LoginDetails.username, LoginDetails.password);
        // PointOfSales database = new PointOfSales();
        PointOfSales pos = new PointOfSales();
        Report database = new Report(test);
        System.out.println(database.salesOfFlavour("chocolate"));
        database.toFile();

       //Login logDB = new Login();
        //public void testMethoid(){   
       // try {
            //System.out.println(logDB.testMyConnection());
            //System.out.println(database.testMyConnection());
            //database.addSales("chocolate");
            //newArray = (ArrayList)database.getColVals("product", "sales");
            //System.out.println(newArray.toString());
            //database.addToDB();
            //database.login("admin", "admin000");
            //System.out.println(database.getColumnNames("login").toString());
            // System.out.println(database.queryDB("username", "login", "admin"));
       // } catch (SQLException e) {
            //System.err.println(e.getMessage());
      //  }
    }
}
