/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.gui.pointofsales;

import com.walfordroad.database.PointOfSales;
import java.awt.BorderLayout;

/**
 *
 * @author Alex
 */
public class POSFrame extends QuitableJFrame{
    
    public POSFrame(){
        super("Point Of Sales", 1000,720);
        PointOfSales pos = new PointOfSales();
        POSRightPanel posRpane = new POSRightPanel();
        POSCentrePanelActionControls posCactions = new POSCentrePanelActionControls(posRpane);
        this.setLocationRelativeTo(null);
        
        this.getContentPane().setLayout(new BorderLayout());
        
        POSCentrePanel posCentPane = new POSCentrePanel(posCactions);
        
        this.getContentPane().add(posCentPane, BorderLayout.CENTER);
        this.getContentPane().add(posRpane, BorderLayout.EAST);
        
        this.pack();
        
        this.setVisible(true);
        
        
    }
    public static void main(String[]args){
    POSFrame thsFrame = new POSFrame();
    }
}
