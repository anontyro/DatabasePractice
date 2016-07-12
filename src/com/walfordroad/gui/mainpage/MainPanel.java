/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.gui.mainpage;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Alex
 */
public class MainPanel extends JPanel{
    final static boolean SHOULDFILL = true;
    final static boolean SHOULDWEIGHTX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    public MainPanel(){
        if(RIGHT_TO_LEFT){
            this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if(SHOULDFILL){
            c.fill = GridBagConstraints.HORIZONTAL;
        }
        
        this.add(new JLabel("Mainpage"));
        this.add(new JLabel("Status: "));
        
        
    }
}
