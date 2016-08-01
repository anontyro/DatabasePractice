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
public class POSCashPanel extends JPanel{
    JButton two,five,ten,fifty,hundred,other,back;
    
    public POSCashPanel(POSCentrePanelActionControls actions){
        this.setLayout(new GridLayout(4,2,10,10));
        
        two = new JButton("$2");
        two.addActionListener(actions);
        
        five = new JButton("$5");
        five.addActionListener(actions);
        
        ten = new JButton("$10");
        ten.addActionListener(actions);
        
        fifty = new JButton("$50");
        fifty.addActionListener(actions);
        
        hundred = new JButton("$100");
        hundred.addActionListener(actions);
        
        other = new JButton("Other");
        other.addActionListener(actions);
        
        back = new JButton("Back");
        back.addActionListener(event ->{POSFrame.displaySale();});
        
        this.add(two);
        this.add(five);
        this.add(ten);
        this.add(fifty);
        this.add(hundred);
        this.add(other);
        this.add(back);
        
        
    }
}
