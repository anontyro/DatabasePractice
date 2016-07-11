/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.gui;

import com.walfordroad.database.Login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author Alex
 */
public class BotInfoPanel extends JPanel implements ActionListener{
    
    private JTextField databaseStatus;
    private JButton databaseConnect;
    protected Login login = new Login();
    
    public BotInfoPanel(){
        this.setLayout(new GridLayout(1,2));
        
        this.add(databaseStatus = new JTextField("Server status: "));
        databaseStatus.setEditable(false);
        
        this.add(databaseConnect = new JButton("Connect"));
        databaseConnect.addActionListener(event -> {
                try{
                String test = login.testMyConnection();
                setDatabaseStatus(test);
                setDatabaseConnect("Refresh");
                }
                catch(SQLException e){
                    setDatabaseStatus("Something went wrong try again!");
                    setDatabaseConnect("Refresh");
                }
        });
    }
    
    public void setDatabaseConnect(String msg){
        databaseConnect.setText(msg);
    }
    public void setDatabaseStatus(String msg){
        databaseStatus.setText(msg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
