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
public class PointOfSales extends DatabaseLogic {

    public static ArrayList<String> productsList;
    public static ArrayList<Double>priceList;
    public static ArrayList<Integer>totalSalesList;
    public static ArrayList<Integer>stockList;

    public PointOfSales() {
        createProductLists();
        createTotalSalesList();
        createStockList();
    }

    public void createProductLists() {
        try {
            productsList = (ArrayList) getColVals("product", "sales");
            priceList = (ArrayList) getColVals("price","sales");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        if((productsList ==null) || priceList ==null){
            System.err.println("ArrayList's not initilised correctly");
        }

    }
    public void createTotalSalesList(){
        try{
            totalSalesList = (ArrayList) getColVals("totalsales","sales");
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public void createStockList(){
        try{
            stockList = (ArrayList) getColVals("stock" , "sales");
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

}
