/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.gui.pointofsales;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Alex
 */
public class POSCardPanel extends JPanel{
    JButton visa,master,other,back;
    public POSCardPanel(POSCentrePanelActionControls action){
        this.setLayout(new GridLayout(2,4,10,10));
        
        visa = new JButton("Visa");
        visa.addActionListener(action);
        
        master = new JButton("Master");
        master.addActionListener(action);
        
        other = new JButton("Other");
        other.addActionListener(action);
        
        back = new JButton("Back");
        back.addActionListener(event ->{POSFrame.displaySale();});
        
        
        this.add(visa);
        this.add(master);
        this.add(other);
        this.add(back);
    }
    
}
