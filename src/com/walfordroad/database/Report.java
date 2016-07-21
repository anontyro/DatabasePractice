/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.database;

import java.io.File;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * This class contains the logic for the Report output found in pointofsales
 * package which is the button in POSCentrePanel
 *
 * @author Alex
 */
public class Report extends DatabaseLogic {

    private String reportString = "";
    private Map<String, Integer> totalSales = new HashMap<>();
    PointOfSales pos;

    public Report(String reportString) {
        super();
        this.reportString = reportString;
    }

    /**
     *
     */
    public void saveToDB() {
        for (int i = 0; i < PointOfSales.productsList.size(); i++) {
            salesOfFlavour(PointOfSales.productsList.get(i));

        }
    }

    /**
     * Finds the total sales of a flavour in the report String, this method also
     * stores the values in a map with flavour as the key.
     *
     * @param flavour flavour you want to find the number sold of.
     * @return String showing the total sale of flavour.
     */
    public String salesOfFlavour(String flavour) {
        String output = "";
        String report = reportString;
        report = report.toLowerCase();
        flavour = flavour.toLowerCase();

        int index = report.indexOf(flavour);
        int count = 0;
        while (index != -1) {
            count++;
            report = report.substring(index + 1);
            index = report.indexOf(flavour);
        }
        totalSales.put(flavour, count);

        output = flavour + " Sold a total of:  " + count;

        return output;
    }

    /**
     * Void method that will print the report data to a file in the reports
     * folder in the project file.
     */
    public void toFile() {
        String filename = ".//reports//" + "Report for ";
        String date = (Date.from(java.time.ZonedDateTime.now().toInstant())).toString();
        date = date.substring(0, 10);
        filename += date + ".rpt";
        System.out.println(filename);
        String output = "Total sales are as follows: \n";
        File file = new File(filename);

        for (int i = 0; i < PointOfSales.productsList.size(); i++) {
            output += salesOfFlavour(PointOfSales.productsList.get(i)) + "\n";
        }
        String[] arrayOut = output.split("\n");

        if (!file.exists()) {
            DatabaseLogic.writeToFile(filename, arrayOut);
            System.out.println("New file to create");
        } else {
            DatabaseLogic.appendToFile(filename, arrayOut);
            System.out.println("Appending to file");
        }
    }

    /**
     * Method to add all the sales currently in the map to the database.
     *
     * @throws SQLException close command required so will throw if cannot close
     * correctly
     */
    public void addSales() throws SQLException {
        boolean stocklistUpdate = false;
        Connection mycon = null;
        PreparedStatement pst = null;
        //int noSales = totalSales.get(flavour);
        // flavour = flavour.trim();

        // String query = "UPDATE sales SET totalsales = " + "(" + noSales + ")"
        //  + " WHERE product = '" + flavour + "'";
        //main body of the method that will try to update the database
        try {
            //setup the connection pulling details from the DatabaseLogic.class
            mycon = DriverManager.getConnection(super.connection,
                    super.getUsername(), super.getDbPass());
            /*
             for loop to add all of the current sales to the saved database sales
            
             */
            for (int i = 0; i < PointOfSales.productsList.size(); i++) {
                int databaseSales = PointOfSales.stockList.get(i); //database sales count
                int totalnoSales = totalSales.get(PointOfSales.productsList.get(i)); //local sales count
                if (databaseSales != totalnoSales) { //if they do no equal then do this
                    databaseSales += totalnoSales; //add together the values
                    //put the new value in the map
                    totalSales.put(PointOfSales.productsList.get(i), databaseSales);

                    //change stocklistUpdate to true which is used to refresh the local ArrayList
                    if (stocklistUpdate == false) {
                        stocklistUpdate = true;
                    }
                }
            }

            /*
             for loop that will add all of the products from the map total sales to
             the database
             */
            for (int i = 0; i < PointOfSales.productsList.size(); i++) {
                String prepState = "UPDATE sales SET totalsales = "
                        + totalSales.get(PointOfSales.productsList.get(i))
                        + "WHERE product = '" + PointOfSales.productsList + "'";

                pst = mycon.prepareStatement(prepState);
            }

            // pst = mycon.prepareStatement(query);
            pst.executeUpdate();

            //if the stocklist needs to be updated will pull new values from the server
            if (stocklistUpdate == true) {
                pos.createStockList();
                stocklistUpdate = false;
            }
            
            totalSales.clear(); //after update the map is emptied 

            System.out.println("Database updated");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            mycon.close();
        }

    }

    public static void main(String[] args) {
        String test = " vanilla \n"
                + "strawberry \n"
                + "strawberry \n"
                + "chocolate \n"
                + "chocolate \n"
                + "vanilla \n"
                + "banana \n";
        Report testReport = new Report(test);
        System.out.println(testReport.salesOfFlavour("chocolate"));
    }

}
