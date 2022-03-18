/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import java.awt.Dimension;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Bolu Mustapha
 */
public class Admin implements ActionListener {

    JFrame frame3;
    JPanel panel1, panel2, panel3;
    JButton btn1, btn2, btn3, btn4, logout;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;
    JTextField CategoryId, ProductId, ProductName, Quantity, Price, FirstName, LastName, UserName, Password, Gender;

    public Admin() {
        frame3 = new JFrame("Store Management System");
        frame3.setLayout(null);

        panel1 = new JPanel();
        panel1.setBounds(10, 20, 170, 600);
        panel1.setLayout(null);
//        panel1.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
//        panel1.setBorder(BorderFactory.createEmptyBorder(200, 0, 0, 0));

        btn1 = new JButton("New Product");
        btn1.addActionListener(this);
        btn1.setBounds(10, 15, 150, 30);

        btn2 = new JButton("Add Attendants");
        btn2.addActionListener(this);
        btn2.setBounds(10, 60, 150, 30);

        logout = new JButton("LOGOUT");
        logout.addActionListener(this);
        logout.setBounds(10, 300, 100, 20);

        panel1.add(btn1);
        panel1.add(btn2);
        panel1.add(logout);

        frame3.add(panel1);

        //new panel
        panel2 = new JPanel();
        panel2.setBounds(200, 20, 400, 300);
        panel2.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        panel2.setLayout(null);

        //label for pane12
        label1 = new JLabel("Category ID:");
        label1.setBounds(40, 30, 100, 30);
        panel2.add(label1);

        label2 = new JLabel("Product ID:");
        label2.setBounds(45, 70, 100, 30);
        panel2.add(label2);

        label3 = new JLabel("Product Name:");
        label3.setBounds(25, 110, 100, 30);
        panel2.add(label3);

        label4 = new JLabel("Quantity:");
        label4.setBounds(60, 150, 100, 30);
        panel2.add(label4);

        label5 = new JLabel("Price:");
        label5.setBounds(75, 190, 100, 30);
        panel2.add(label5);

        //textfields for panel2
        CategoryId = new JTextField();
        CategoryId.setBounds(120, 30, 150, 30);
        panel2.add(CategoryId);

        ProductId = new JTextField();
        ProductId.setBounds(120, 70, 150, 30);
        panel2.add(ProductId);

        ProductName = new JTextField();
        ProductName.setBounds(120, 110, 150, 30);
        panel2.add(ProductName);

        Quantity = new JTextField();
        Quantity.setBounds(120, 150, 150, 30);
        panel2.add(Quantity);

        Price = new JTextField();
        Price.setBounds(120, 190, 150, 30);
        panel2.add(Price);

        btn3 = new JButton("Add");
        btn3.setBounds(250, 250, 100, 30);
        btn3.addActionListener(this);
        panel2.add(btn3);
        panel2.setVisible(false);
        frame3.add(panel2);

        //panel3
        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(200, 20, 400, 300);
        panel3.setBorder(BorderFactory.createLineBorder(Color.white, 2));

        label6 = new JLabel("FirstName:");
        label6.setBounds(50, 30, 100, 30);
        panel3.add(label6);

        label7 = new JLabel("LastName:");
        label7.setBounds(50, 70, 100, 30);
        panel3.add(label7);

        label8 = new JLabel("UserName:");
        label8.setBounds(50, 110, 100, 30);
        panel3.add(label8);

        label9 = new JLabel("Password:");
        label9.setBounds(50, 150, 100, 30);
        panel3.add(label9);

        label10 = new JLabel("Gender:");
        label10.setBounds(70, 190, 100, 30);
        panel3.add(label10);

        //panel3 textfield 
        FirstName = new JTextField();
        FirstName.setBounds(120, 30, 150, 30);
        panel3.add(FirstName);

        LastName = new JTextField();
        LastName.setBounds(120, 70, 150, 30);
        panel3.add(LastName);

        UserName = new JTextField();
        UserName.setBounds(120, 110, 150, 30);
        panel3.add(UserName);

        Password = new JTextField();
        Password.setBounds(120, 150, 150, 30);
        panel3.add(Password);

        Gender = new JTextField();
        Gender.setBounds(120, 190, 150, 30);
        panel3.add(Gender);

        btn4 = new JButton("Add");
        btn4.setBounds(250, 250, 100, 30);
        btn4.addActionListener(this);
        panel3.add(btn4);
        panel3.setVisible(false);

        frame3.add(panel3);

        //Dynamic fullscreen size
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        // the screen height
//        int screenHeight = (int) screenSize.getHeight();
//        // the screen width
//        int screenWidth = (int) screenSize.getWidth();
        frame3.setVisible(true);
        frame3.setSize(650, 400);
        frame3.setResizable(false);
        frame3.setLocationRelativeTo(null);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Admin obj3 = new Admin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            panel2.setVisible(true);
        }
        if (e.getSource() == btn2) {
            panel2.setVisible(false);
            panel3.setVisible(true);
        }
        if(e.getSource() == logout){
            frame3.dispose();
            Login login = new Login();
        }
        if(e.getSource() == btn3){
            
        }
        if(e.getSource() == btn4){
            
        }
    }
}
