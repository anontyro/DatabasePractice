/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.gui.pointofsales;

import java.text.DecimalFormat;
import javax.swing.*;

/**
 * Panel that sets up the box on the right of the screen 
 * @author Alex
 */
public class POSRightPanel extends JPanel {

    private static double totalSaleValue = 0;
    private JTextArea saleList;
    private JTextField total;

    POSRightPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(saleList = new JTextArea(20, 20));
        saleList.setLineWrap(true);
        saleList.setEditable(false);
        saleList.setAutoscrolls(true);

        JScrollPane scrollbar1 = new JScrollPane(saleList);
        this.add(scrollbar1);

        this.add(total = new JTextField("Total: "));
        total.setEditable(false);

    }

    public void setSaleList(String string) {
        saleList.append(string + "\n");
    }

    public void clearSaleList() {
        saleList.setText("");
    }

    public String getSaleList() {
        String output = saleList.getText();
        return output;
    }

    public void setTotal(String value) {
        double valOut =Double.parseDouble(value);
        
        totalSaleValue += valOut;
        value = new DecimalFormat("$#.00").format(totalSaleValue);
        total.setText("Total: " + value);

    }

}
