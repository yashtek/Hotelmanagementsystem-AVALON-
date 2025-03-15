
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.ResultSet;
import net.proteanit.sql.*;


public class Manager extends JFrame implements ActionListener {
    JTable tabel;
    JButton btn1;
    Manager(){
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 1050, 500);
        setLayout(null);

        JLabel i =new JLabel("Manager Information");
        i.setBounds(430,10,190,25);
        i.setFont(new Font("serif",Font.BOLD,20));
        add(i);
        JLabel i1 =new JLabel("Name");
        i1.setBounds(10,60,100,20);
        add(i1);
        JLabel l2 =new JLabel("Age");
        l2.setBounds(130,60,100,20);
        add(l2);
        JLabel l3 =new JLabel("Gender");
        l3.setBounds(260,60,100,20);
        add(l3);
        JLabel i4 =new JLabel("Job");
        i4.setBounds(390,60,100,20);
        add(i4);
        JLabel i5 =new JLabel("Salary");
        i5.setBounds(520,60,100,20);
        add(i5);
        JLabel i6 =new JLabel("Phone_no ");
        i6.setBounds(655,60,100,20);
        add(i6);
        JLabel i7 =new JLabel("Email");
        i7.setBounds(784,60,100,20);
        add(i7);

        JLabel i8 =new JLabel("Aadhar");
        i8.setBounds(920,60,100,20);
        add(i8);
        btn1 = new JButton("Back");
        btn1.setBounds(480, 400, 100, 25);
        btn1.setBackground(Color.black);
        btn1.setForeground(Color.WHITE);
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btn1.addActionListener(this);
        add(btn1);

        tabel = new JTable();
        tabel.setBounds(0,80,1050,400);
        add(tabel);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employees where job = 'Manager'");
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
        new Manager();
    }
}

