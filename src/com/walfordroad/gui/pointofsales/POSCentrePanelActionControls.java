/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.gui.pointofsales;

import com.walfordroad.database.PointOfSales;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Dynamic actionListener class that will pull button values and add them to the
 * list along with adding to the total at the bottom
 *
 * @author Alex
 */
public class POSCentrePanelActionControls implements ActionListener {

    private POSRightPanel rightPane;

    public POSCentrePanelActionControls(POSRightPanel rightPane) {
        this.rightPane = rightPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        for (int i = 0; i < PointOfSales.priceList.size(); i++) {
            if (command.equals(PointOfSales.productsList.get(i))) {
                //set vars for the output

                String price = "";
                price += PointOfSales.priceList.get(i);
                price = price.trim();
                rightPane.setTotal(price);
                double value = Double.parseDouble(price);
                String output = new DecimalFormat("$.00").format(value);
                rightPane.setSaleList(command + " = " + output);

                System.out.println(command + " is = " + output); //for debug
            }
        }
    }

}
