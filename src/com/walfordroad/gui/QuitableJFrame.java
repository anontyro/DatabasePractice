/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.gui;

import java.awt.event.*;
import static java.lang.System.in;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Alex
 */
public class QuitableJFrame  extends JFrame implements WindowListener{
    
    public QuitableJFrame(String title, int xpixels, int ypixels){
        super(title);
        this.addWindowListener(this);
        if(xpixels > 0 && ypixels > 0){
            this.setSize(xpixels, ypixels);
        }
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    /**
     *
     * @param title
     */
    public QuitableJFrame(String title){
        this(title,0,0);
    }
    
    public int getValueFromUser(String message, int defaultValue){
        String valueString = JOptionPane.showInputDialog(this, message, "input value ",
                JOptionPane.QUESTION_MESSAGE);
        
        if(valueString == null) return defaultValue;
        else
            try{
                int value = Integer.parseInt(valueString);
                return value;
            }
            catch(NumberFormatException e){
                return defaultValue;
            }
    }
    
    public void quitOrCancel(){
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want"
                + "to exit " + this.getTitle() +"?", "Exit program",
                JOptionPane.YES_NO_CANCEL_OPTION);
        if(result == JOptionPane.YES_OPTION){
            System.exit(1);
        }
    }
    
    public void telUser(String message){
        JOptionPane.showMessageDialog(this, message, "Information",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void warnUser(String warning){
        JOptionPane.showMessageDialog(this,warning, "Warning",
                JOptionPane.WARNING_MESSAGE);
    }
    
    public void setLookAndFeel(String lookAndFeel){
        try{
            UIManager.setLookAndFeel(lookAndFeel);
            
            SwingUtilities.updateComponentTreeUI(this);
            
            this.validate();
            
            this.repaint();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.quitOrCancel();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
}
