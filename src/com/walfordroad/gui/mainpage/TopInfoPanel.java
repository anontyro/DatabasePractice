/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.gui.mainpage;

import com.walfordroad.gui.LoginFrame;
import com.walfordroad.gui.LoginPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.ZonedDateTime;

/**
 * top menu from the main that contains the basic details for the user
 * from the logout and information that may be useful to the user
 * @author Alex
 */
public class TopInfoPanel extends JPanel implements ActionListener,FocusListener{
    
    private MainFrame mFrame;
    private JLabel userDetails;
    private JButton details,logout;
    
    public TopInfoPanel(MainFrame mFrame, LoginPanel logPanel){
        this.setLayout(new FlowLayout());
        
        this.mFrame = mFrame;
        
        this.add(userDetails = new JLabel("Welcome " + mFrame.username 
                +" Login at: " + ZonedDateTime.now()));
        
        this.add(details = new JButton("Details"));
        this.add(logout = new JButton("Logout"));
        logout.addActionListener(event ->
            {
            mFrame.username = "";
            LoginFrame theFrame = new LoginFrame();
            mFrame.hide();
            });
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusGained(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
