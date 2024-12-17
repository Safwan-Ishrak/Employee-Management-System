package employee.management;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class New_Employee extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c1;
    JPanel p1;
    
    New_Employee(){
        
        super("New Employee");
        
        setSize(500,650);
        setLocation(500,100);
        getContentPane().setBackground(Color.WHITE);
        
        p1= new JPanel();
        p1.setBackground(Color.WHITE);
      
        p1.setLayout(new GridLayout(8,2,10,40));
        l1 = new JLabel("Name");
        t1 = new JTextField(15);
        p1.add(l1);
        p1.add(t1);
       
        c1 = new Choice();
        c1.add("Male");
        c1.add("Female");
       
        l2 = new JLabel("Gender");
        p1.add(l2);
        p1.add(c1);
        l3 = new JLabel("Date of Birth");
        t3 = new JTextField(15);
        p1.add(l3);
        p1.add(t3);
        l4 = new JLabel("Email");
        t4 = new JTextField(15);
        p1.add(l4);
        p1.add(t4); 
        l5 = new JLabel("Phone");
        t5 = new JTextField(15);
        p1.add(l5);
        p1.add(t5);
        l6 = new JLabel("Position");
        t6 = new JTextField(15);
        p1.add(l6);
        p1.add(t6);
        l7 = new JLabel("Address");
        t7= new JTextField(15);
        p1.add(l7);
        p1.add(t7);
        b1 =new JButton("Submit");
        b2 = new JButton("Cancel");
        p1.add(b1);
        p1.add(b2);
       
        setLayout(new BorderLayout());
        //add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/new_employee.png"))),"West");
        add(p1,"Center");
       
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== b2){
            setVisible(false);
            //System.exit(0);
        }
        
        else if(ae.getSource()== b1){
            
        Random random = new Random();
        String id = "" + Math.abs((random.nextLong() % 9000L)+1000L);
        String n = t1.getText();
        String g = c1.getSelectedItem();
        String a = t3.getText();
        String s = t4.getText();
        String c = t5.getText();
        String e = t6.getText();
        String p = t7.getText();
        
       
        try{
            
            conn c1 = new conn();
            String qry = "insert into employee values('"+id+"','"+n+"','"+g+"','"+a+"','"+s+"','"+c+"','"+e+"','"+p+"')";
            c1.s.executeUpdate(qry);
            JOptionPane.showMessageDialog(null,"Employee Created");
            this.setVisible(false);  
        }catch(Exception ee){
            ee.printStackTrace();
        }
        }
         
    }
    public static void main(String s[]){
        new New_Employee().setVisible(true);
    }
}
