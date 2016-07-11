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
    
    public MainPanel(){
        this.setLayout(new GridLayout(2,2));
        
        this.add(new JLabel("Mainpage"));
        this.add(new JLabel("Status: "));
        
        
    }
}
