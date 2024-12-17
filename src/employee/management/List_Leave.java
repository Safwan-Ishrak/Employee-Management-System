
package employee.management;


import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class List_Leave extends JFrame implements ActionListener{
  
    JTable j1;
    JButton b1;
    String h[]={"Emp id","Name","Start Date","End Date","Reason"};
    String d[][]=new String[20][8];  
    int i=0,j=0;
    
    List_Leave(){
        super("Leave list");
        
        setSize(1000,400);
        setLocation(450,200);

        try{
            String q="select * from leav";
            conn c1=new conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
                // i = 0 j = 0
                d[i][j++]=rs.getString("id");
                d[i][j++]=rs.getString("Name");
                d[i][j++]=rs.getString("Start_date");
                d[i][j++]=rs.getString("End_date");
                d[i][j++]=rs.getString("Reason");
                
                i++;
                j=0;
            }
            j1=new JTable(d,h); 

        }
        catch(Exception e){}
        
        b1=new JButton("Print");
        add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        
        b1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
           j1.print();
        }catch(Exception e){}
    }
     
    public static void main(String s[]){
        new List_Leave().setVisible(true);
    }
}

