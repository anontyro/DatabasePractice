/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.gui.mainpage;

import com.walfordroad.gui.BotInfoPanel;
import com.walfordroad.gui.LoginFrame;
import com.walfordroad.gui.LoginPanel;
import com.walfordroad.gui.MenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Alex
 */
public class MainFrame extends QuitableJFrame{
    
    protected String username = "";
    private LoginPanel logPanel;
    
    public MainFrame(LoginPanel logPanel){

        super(logPanel.getUsername() + "'s" +" Home", 1000, 500);
        
        this.logPanel = logPanel;
        
        username = logPanel.getUsername();

        this.setLocationRelativeTo(null);

        //sets the layout for the frame overall this is currently to BorderLayout
        this.getContentPane().setLayout(new BorderLayout());

        MenuBar menu = new MenuBar();
        //
        MainPanel mPanel = new MainPanel();

        TopInfoPanel tiPanel = new TopInfoPanel(this, logPanel);
        BotInfoPanel connectionStatus = new BotInfoPanel();
        //
        this.setupMenubar(menu);
        
        this.getContentPane().add(tiPanel,BorderLayout.NORTH);
        this.getContentPane().add(mPanel,BorderLayout.CENTER);
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

}
