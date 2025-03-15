import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.ResultSet;
import net.proteanit.sql.*;


public class Department extends JFrame implements ActionListener {
    JTable tabel;
    JButton btn1;
    Department(){
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 515, 400);
        setLayout(null);


        JLabel i1 =new JLabel("Department");
        i1.setBounds(10,10,100,20);
        add(i1);
        JLabel l2 =new JLabel("Budget");
        l2.setBounds(300,10,100,20);
        add(l2);


        btn1 = new JButton("Back");
        btn1.setBounds(170, 300, 100, 25);
        btn1.setBackground(Color.black);
        btn1.setForeground(Color.WHITE);
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btn1.addActionListener(this);
        add(btn1);

        tabel = new JTable();
        tabel.setBounds(0,40,500,400);
        add(tabel);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            tabel.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==btn1){
            setVisible(false);
            new Reception();
        }

    }
    public static void main(String[] args){
        new Department();
    }
}
