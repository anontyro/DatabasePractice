/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walfordroad.gui.pointofsales;

import com.walfordroad.database.PointOfSales;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Alex
 */
public class POSFrame extends QuitableJFrame {

    static JPanel cards;

    public POSFrame() {
        super("Point Of Sales", 1000, 720);
        PointOfSales pos = new PointOfSales();
        POSRightPanel posRpane = new POSRightPanel();
        POSCentrePanelActionControls posCactions = new POSCentrePanelActionControls(posRpane);
        this.setLocationRelativeTo(null);

        this.getContentPane().setLayout(new BorderLayout());

        //central panel panels to switch between
        POSCentrePanel posCentPane = new POSCentrePanel(posCactions);
        POSSalePanel posSale = new POSSalePanel(posCactions);
        POSCashPanel posCash = new POSCashPanel(posCactions);
        POSCardPanel posCard = new POSCardPanel(posCactions);

        cards = new JPanel(new CardLayout());
        cards.add(posCentPane, "mainDisplayCard");
        cards.add(posSale, "saleCard");
        cards.add(posCash, "cashCard");
        cards.add(posCard, "cardCard");
        System.out.println(cards.toString());

        //this.getContentPane().add(posCentPane, BorderLayout.CENTER);
        this.getContentPane().add(cards, BorderLayout.CENTER);
        this.getContentPane().add(posRpane, BorderLayout.EAST);

        this.pack();

        this.setVisible(true);

    }

    public static void displayMain() {
        CardLayout c1 = (CardLayout) cards.getLayout();
        c1.show(cards, "mainDisplayCard");
    }

    public static void displaySale() {
        CardLayout c1 = (CardLayout) (cards.getLayout());
        c1.show(cards, "saleCard");
    }

    public static void displayCash() {
        CardLayout c1 = (CardLayout) (cards.getLayout());
        c1.show(cards, "cashCard");
    }

    public static void displayCard() {
        CardLayout c1 = (CardLayout) (cards.getLayout());
        c1.show(cards, "cardCard");
    }

    public static void displayNext() {
        CardLayout c1 = (CardLayout) (cards.getLayout());
        c1.next(cards);
    }

    public static void main(String[] args) {
        POSFrame thisFrame = new POSFrame();
    }
}
