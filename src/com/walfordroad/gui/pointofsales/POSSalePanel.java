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
public class POSSalePanel extends JPanel{
    JButton cash,card,back,remove;
    static JTextField report = new JTextField("$0.00");
    private POSRightPanel reportPanel;
    
    public POSSalePanel(POSCentrePanelActionControls actions){
        this.setLayout(new GridLayout(2,4,10,10));
        
        cash = new JButton("Cash");
        cash.addActionListener(actions);
        
        card = new JButton("Card");
        card.addActionListener(actions);
        
        back = new JButton("Back");
        back.addActionListener(event ->{POSFrame.displayMain();});
        
        remove = new JButton("Void");
        remove.addActionListener(actions);
        
        //this.add(new JLabel("Total to pay: "));
        //this.add(report);
        
        this.add(cash);
        this.add(card);
        this.add(back);
        this.add(remove);
        
        
    }
    
    public static void setTotal(String total){
        report.setText(total);
    }
    
    public static String getTotal(){      
        return report.toString();
    }
    
}
