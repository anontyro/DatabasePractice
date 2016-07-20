/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.database;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.stream.Stream;

/**
 *
 * @author Alex
 */
public class Report extends DatabaseLogic {

    private String reportString = "";
    private Map<String, Integer> totalSales = new HashMap<>();

    public Report(String reportString) {
        super();
        this.reportString = reportString;
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

    public void toFile() {
        String filename = ".//reports//"+ "Report for ";
        // filename += (Date.from(java.time.ZonedDateTime.now().toInstant())).toString() +".rpt";
        String date = (Date.from(java.time.ZonedDateTime.now().toInstant())).toString();
        date = date.substring(0, 10);
        filename += date+".rpt";
        System.out.println(filename);
        String output = "Total sales are as follows: \n";

        for (int i = 0; i < PointOfSales.productsList.size(); i++) {
            output += salesOfFlavour(PointOfSales.productsList.get(i)) + "\n";
        }
        String[] arrayOut = output.split("\n");
        DatabaseLogic.writeToFile(filename, arrayOut);

    }

    /**
     * Method to add the total sales to the selected colomns in the SQL database
     * will push the values to the database, not currently working.
     *
     * @param flavour check against the map to find the sales and insert into
     * this colomn
     * @throws SQLException
     */
    public void addSales(String flavour) throws SQLException {
        Connection mycon = null;
        PreparedStatement pst = null;
        int noSales = totalSales.get(flavour);
        flavour = flavour.trim();

        String query = "UPDATE sales SET Total_sales = " + noSales
                + " WHERE Product = " + flavour;

        System.out.println(query);

        try {
            mycon = DriverManager.getConnection(super.connection, super.getUsername(), super.getDbPass());

            pst = mycon.prepareStatement(query);
            pst.executeUpdate();
            System.out.println("Database updated");
        } catch (SQLException ex) {
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
