/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import java.awt.Dimension;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Bolu Mustapha
 */
public class Attendant {
    JFrame frame2;
    JComboBox cb1, cb2;
    JLabel label1, label2, label3, label4;
    JTextField tf1, tf2;
    JButton btn1;

    public Attendant(){
        frame2 = new JFrame("Store Management System");
        frame2.setLayout(null);
        label1 = new JLabel("Product:");
        label1.setBounds(10, 10, 100, 100);
        frame2.add(label1);
        
        label2 = new JLabel("Quantity:");
        label2.setBounds(10, 60, 100, 100);
        frame2.add(label2);
        
        label3 = new JLabel("Payment Method:");
        label3.setBounds(10, 110, 100, 100);
        frame2.add(label3);
        
        label4 = new JLabel("Price:");
        label4.setBounds(10, 160, 100, 100);
        frame2.add(label4);
        
        btn1 = new JButton("PAY");
        btn1.setBounds(100, 250, 100, 30);
        frame2.add(btn1);
        
        tf1 = new JTextField();
        tf1.setBounds(100, 95, 150, 30);
        frame2.add(tf1);
        
        tf1 = new JTextField();
        tf1.setBounds(100, 195, 150, 30);
        frame2.add(tf1);
        
        String[] products = {"Milk", "Meat", "Egg", "Fish", "Chicken", "Turkey"};
        cb1 = new JComboBox(products);
        cb1.setBounds(100, 45, 100, 30);
        frame2.add(cb1);
        


//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        // the screen height
//        int screenHeight = (int) screenSize.getHeight();
//        // the screen width
//        int screenWidth = (int) screenSize.getWidth();     
        
        frame2.setVisible(true);
        frame2.setSize(800,400);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        Attendant obj1 = new Attendant();
    }
}
