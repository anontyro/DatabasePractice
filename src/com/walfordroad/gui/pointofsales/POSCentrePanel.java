/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.gui.pointofsales;

import javax.swing.*;
import com.walfordroad.database.PointOfSales;
import java.awt.GridLayout;
import java.util.*;

/**
 *
 * @author Alex
 */
public class POSCentrePanel extends JPanel{


    public POSCentrePanel(POSCentrePanelActionControls actions) {
        
        this.setLayout(new GridLayout(4, 5, 10, 10));
        
        for (int i = 0; i < PointOfSales.productsList.size(); i++) {
            JButton btn = new JButton(PointOfSales.productsList.get(i));
            btn.addActionListener(actions);
            this.add(btn);
        }

    }
    
    
    
    

}
