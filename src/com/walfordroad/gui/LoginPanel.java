/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import com.walfordroad.database.*;
import com.walfordroad.gui.mainpage.MainFrame;
import java.sql.SQLException;

/**
 *
 * @author Alex
 */
public class LoginPanel extends JPanel implements ActionListener{
    
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton,helpButton;
    private LoginFrame logFrame;
    private Login login = new Login();
    
    /**
     * Constructor that takes the LoginFrame parameter to allow passing of data
     * between the two, constructs the panel in GridLayout.
     * @param logFrame LoginFrame to change visability and get message boxes
     */
    public LoginPanel(LoginFrame logFrame){
        this.logFrame = logFrame;
        this.setLayout(new GridLayout(3,2));
        
        // creates the label and box to enter the user details into
        this.add(new JLabel("Username: "));
        this.add(username = new JTextField());
        
        this.add(new JLabel ("Password:"));
        this.add(password = new JPasswordField());
        
        //login button created
        this.add(loginButton = new JButton("Login"));
        /*
        login button action using lambda to check that the method returns
        true and then will open a new frame and hide this one then open the MainFrame
        */
        loginButton.addActionListener((ActionEvent e) ->{
            try{
                boolean logSuccess = login.logInto(username.getText(), password.getText());
                if(logSuccess = true){
                    MainFrame theMain = new MainFrame(this);
                    setUsername("");
                    resetPassword();
                    showOrHide(false);
                    //logFrame.setVisible(false);
                    

                }
                //If login is not successful 
                else{
                    logFrame.telUser("Unable to login try again");

                }
            }
            catch(SQLException exception){
                logFrame.warnUser("Error could not connect to database");
            }
        });
        
        this.add(helpButton = new JButton("Help"));
           
    }
    public void setUsername(String username){
        this.username.setText(username);
    }
    public String getUsername(){
        return username.getText();
    }
    
    public void resetPassword(){
        password.setText("");
    }
    public void showOrHide(boolean boo){
        logFrame.setVisible(boo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
