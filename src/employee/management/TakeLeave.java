
package employee.management;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TakeLeave extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b1,b2;
    Choice c2,c4;
    
    TakeLeave(){
       
        setLayout(new GridLayout(6,2,10,40));
        c2 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                c2.add(rs.getString("id"));    
            }
      
      
       }catch(Exception e){ }
       
        add(new JLabel("Select Empno"));
        add(c2);
//        l8 = new JLabel("Employee ID");
//        t8 = new JTextField(15);
//        add(l8);
//        add(t8);
        l1 = new JLabel("Name");
        t1=new JTextField();
        add(l1);
        add(t1);
        l2 = new JLabel("Start Date");
        t2=new JTextField();
        add(l2);
        add(t2);
        l3=  new JLabel("End Date");
        t3=new JTextField();
        add(l3);
        add(t3);
        
        l4= new JLabel("Reason");
        c4=new Choice();
        c4.add("Health Issue");
        c4.add("Family Issue");
        c4.add("Function");
        c4.add("Maternal");
        c4.add("Others");
        add(l4);
        add(c4);
        
              
        b1 =new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        add(b1);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
        setSize(500,500);
        setLocation(600,200);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        
       if(ae.getSource()== b2){
            setVisible(false);
            //System.exit(0);
        }
       else if(ae.getSource()== b1){
                
                String id = c2.getSelectedItem();
                String n= t1.getText();
                String s=t2.getText();
                String e=t2.getText();
                String r = c4.getSelectedItem();
                String dt = new java.util.Date().toString();
       
        try{
            conn c1 = new conn();
            String qry = "insert into leav values('"+ id +"','"+n+"','"+s+"','"+e+"','"+r+"')";
            c1.s.executeUpdate(qry);
            JOptionPane.showMessageDialog(null,"Leave confirmed");
            this.setVisible(false);
            
        }catch(Exception ee){
            ee.printStackTrace();
        }
       }
        
    }
    
    public static void main(String s[]){
        new TakeLeave();
    }
}

