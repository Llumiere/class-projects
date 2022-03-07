 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author dave
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class notepad extends JFrame implements ActionListener{
    JMenu menu1, menu2, menu3;
    JMenuBar bar1;
    JTextArea ta, ta1;
    JMenuItem item1, item2, item3, item4, item5, item6, item7, item8, item9;
    JScrollPane jsp, jsp1, jsp2, jsp3;
    JList jl1, jl2, jl3;
    JButton btn1, btn2;
    JPanel panel1;
    JLabel label1, label2;
    JTextField tf1;
    JButton find;
    JFileChooser fchooser;
    Path filepath;
    
    public notepad(){
        setLayout(new BorderLayout());
        
        ta = new JTextArea();
        add(ta, BorderLayout.CENTER);
        
        jsp = new JScrollPane(ta);
        add(jsp);
        
        bar1 = new JMenuBar();
        setJMenuBar(bar1);
        
        menu2 = new JMenu("File");
        bar1.add(menu2);
        menu1 = new JMenu("Edit");
        bar1.add(menu1);
        menu3 = new JMenu("View");
        bar1.add(menu3);
        
        item1 = new JMenuItem("New");
        menu2.add(item1);
        item2 = new JMenuItem("Save");
        item2.addActionListener(this);
        menu2.add(item2);
        item3 = new JMenuItem("Open");
        menu2.add(item3);
        
        item4 = new JMenuItem("Undo");
        menu1.add(item4);
        item5 = new JMenuItem("Redo");
        menu1.add(item5);
        item6 = new JMenuItem("Cut");
        menu1.add(item6);
        item7 = new JMenuItem("Copy");
        menu1.add(item7);
        item8 = new JMenuItem("Paste");
        menu1.add(item8);
        
        item9 = new JMenuItem("Font");
        menu3.add(item9);
        item9.addActionListener(this);
        
        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(panel1,BorderLayout.SOUTH);
        
        tf1 = new JTextField();
        tf1.setPreferredSize(new Dimension(200, 25));
        panel1.add(tf1);
        
        find = new JButton("Find");
        find.addActionListener(this);
        panel1.add(find);
        
        
        
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        setVisible(true);
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void font(){
        JFrame jf = new JFrame();
        
        String[] fonts = {"Calibri", "Times New Roman", "Monospace", "Serif"};
        jl1 = new JList(fonts);
        jsp1 = new JScrollPane(jl1);
        jsp1.setBounds(10, 10, 100, 150);
        jf.add(jsp1);
        
        String[] style = {"Bold", "Plain", "Italic"};
        jl2 = new JList(style);
        jsp2 = new JScrollPane(jl2);
        jsp2.setBounds(150, 10, 100, 150);
        jf.add(jsp2);
        
        String[] size = {"8", "10", "12", "14", "16", "18", "20", "22", "24"};
        jl3 = new JList(size);
        jsp3 = new JScrollPane(jl3);
        jsp3.setBounds(300, 10, 100, 150);
        jf.add(jsp3);
        
        ta1 = new JTextArea("Aa, Bb, Cc, Xx, Yy, Zz");
        ta1.setBounds(10, 200, 400, 100);
        jf.add(ta1);
        
        btn1 = new JButton("Apply");
        btn1.setBounds(200, 320, 100, 30);
        jf.add(btn1);
        
        btn2 = new JButton("Preview");
        btn2.addActionListener(this);
        btn2.setBounds(310, 320, 100, 30);
        jf.add(btn2);
        
        
        jf.setLayout(null);
        jf.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        jf.setVisible(true);
        jf.setSize(450,400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    
    public static void main(String[] args){
        notepad obj = new notepad();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sf, ss;
        int fs;
        if(e.getSource() == find){
            String text = ta.getText();
            String textSplit[] = text.split(" ");
            String textfield = tf1.getText();
            Pattern mypattern = Pattern.compile(".*"+textfield+".*");
        
        for(int i = 0; i < textSplit.length; i++){
            Matcher matcher = mypattern.matcher(textSplit[i]);
            boolean mybool = matcher.matches();
            label1 = new JLabel(" Does "+textfield+" exist in the word "+textSplit[i]+": "+mybool);
            panel1.add(label1);
        }
        }
        
       if(e.getSource() == item2){
           fchooser = new JFileChooser();
           int i = fchooser.showSaveDialog(this);
           if(i == JFileChooser.APPROVE_OPTION){
               File f = fchooser.getSelectedFile();
               filepath = Paths.get(f.getPath());
           }
           try(FileWriter fw = new FileWriter("" + filepath)){
               String source = ta.getText();
               char[] writer = new char[source.length()];
                       fw.write(writer);
       } catch(Exception ex){
               System.out.println(ex);
       }
       }
        
       if(e.getSource()== item9){
           font();
       }
       if(e.getSource() == btn2){
           try{
        sf = jl1.getSelectedValue().toString();
        ss = jl2.getSelectedValue().toString();
        fs = Integer.parseInt(jl3.getSelectedValue().toString());
        
//        if(sf.equals("") || ss.equals("")){
//            fs = 14;
//            ta1.setFont(new Font("serif", Font.PLAIN, 16));
//        }
        
        if(ss.equalsIgnoreCase("Plain")){
            ta1.setFont(new Font(sf, Font.PLAIN, fs));
        }
        else if(ss.equalsIgnoreCase("Bold")){
            ta1.setFont(new Font(sf, Font.BOLD, fs));
        }
        else if(ss.equalsIgnoreCase("Italic")){
            ta1.setFont(new Font(sf, Font.ITALIC, fs));
        }
        
           }
           catch(Exception ex){}
       }
    }
}
