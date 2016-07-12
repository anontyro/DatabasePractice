/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.gui;

import com.walfordroad.database.Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Alex
 */
public class LoginFrame extends QuitableJFrame{
    
    
    public LoginFrame(){
        super("Login", 1000, 500);
        
        this.setLocationRelativeTo(null);
        
        //sets the layout for the frame overall this is currently to BorderLayout
        this.getContentPane().setLayout(new BorderLayout());
        
        MenuBar menu = new MenuBar();
        //
        LoginPanel loginControls = new LoginPanel(this);
        loginControls.setBorder(new EmptyBorder(10,10,10,10));
        
        BotInfoPanel connectionStatus = new BotInfoPanel();
        //
        this.setupMenubar(menu);
        
        this.getContentPane().add(loginControls,BorderLayout.CENTER);
        this.getContentPane().add(connectionStatus, BorderLayout.SOUTH);
        //
        this.pack();
        
        //
        this.setVisible(true);
    }
    
    
    private void setupMenubar(MenuBar menu){
        
        //new menubar
        JMenuBar thBar = new JMenuBar();
        //craetes a new menu under "File"
        JMenu fileMenu = new JMenu("File");
        //content of "file" menu
        
        JMenuItem quitItem = new JMenuItem("Quit");
    }
    
    
    public static void main(String[] args){
        LoginFrame theFrame = new LoginFrame();
        
    }
    
}
