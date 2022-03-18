package Store;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Login implements ActionListener {

    JFrame frame1;
    JLabel Uname, Pword;
    JTextField Username;
    JPasswordField Password;
    JButton submit;
    String username, password, roles, password1;

    public Login() {
        frame1 = new JFrame();
        frame1.setLayout(null);

        Uname = new JLabel("UserName:");
        Uname.setBounds(10, 50, 80, 30);
        frame1.add(Uname);

        Username = new JTextField();
        Username.setBounds(80, 50, 200, 30);
        frame1.add(Username);

        Pword = new JLabel("Password:");
        Pword.setBounds(10, 100, 100, 30);
        frame1.add(Pword);

        Password = new JPasswordField();
        Password.setBounds(80, 100, 200, 30);
        frame1.add(Password);

        submit = new JButton("Submit");
        submit.setBounds(220, 170, 100, 30);
//        submit.setBackground(Color.green);
        submit.addActionListener(this);
        frame1.add(submit);

        frame1.setVisible(true);
        frame1.setSize(400, 300);
        frame1.setResizable(false);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Login obj = new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            username = Username.getText();
            password = Password.getText();
            try (Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Acersupermart;user=sa;password=123456")) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                System.out.println("Connected");

//                String str ="Select * from personnel";
//                Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery(str);
//                while(rs.next()){
//                    String fname = rs.getString("firstname");
//                    String lname = rs.getString("lastname");
//                    
//                    String email = rs.getString("email");
//                    String uname = rs.getString("Username");
//                    String pass = rs.getString("password");
//                    
//                    System.out.println("FirstName:"+fname+" LastName:"+lname+" Email:"+email+" Username:"+uname+" Password:"+pass);
//
//                }
                String str1 = "select Roles,password from personnel where Username=" + "\u0027" + username + "\u0027";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(str1);
                while (rs.next()) {
                    roles = rs.getString("Roles");
                    password1 = rs.getString("password");
//                    System.out.println("Roles:" + roles);
//                    System.out.println("Password:" + password1);
                }
                if (password.equals(password1)) {
//                    System.out.println("working");
                    if (roles.equals("Admin")) {
                        frame1.dispose();
                        Admin admin = new Admin();
                    }
                    else{
                        frame1.dispose();
                        Attendant attendant = new Attendant();
                    }
                }else{
                    JOptionPane.showMessageDialog(frame1," Wrong Credentials \n Please Provide Correct Details", "Login Error", JOptionPane.QUESTION_MESSAGE);
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}
