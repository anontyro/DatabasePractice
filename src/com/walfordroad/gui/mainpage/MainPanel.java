/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.gui.mainpage;

import com.walfordroad.gui.pointofsales.POSFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * The main
 * @author Alex
 */
public class MainPanel extends JPanel{
    private JButton POSButton,ReportButton;

    
    public MainPanel(){
        this.setLayout(new GridLayout(3,2));

        this.add(POSButton = new JButton("POS"));
        POSButton.addActionListener((ActionEvent e) ->{
            POSFrame posFrame = new POSFrame();
        });
        this.add(new JLabel("Mainpage"));
        this.add(new JLabel("Status: "));
        
        
    }
}
