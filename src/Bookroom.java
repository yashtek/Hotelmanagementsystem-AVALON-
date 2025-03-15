import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.ResultSet;
import net.proteanit.sql.*;


public class Bookroom extends JFrame implements ActionListener {
    JTable tabel;
    JButton btn1;
    Bookroom(){
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 1050, 600);
        setLayout(null);
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icon/eight.jpg"));
        Image i2 = il.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);

        JLabel i1 =new JLabel("Room_no");
        i1.setBounds(10,10,100,20);
        add(i1);
        JLabel l2 =new JLabel("Availability");
        l2.setBounds(100,10,100,20);
        add(l2);
        JLabel l3 =new JLabel("Cleaning_status");
        l3.setBounds(200,10,100,20);
        add(l3);
        JLabel i4 =new JLabel("Price");
        i4.setBounds(305,10,100,20);
        add(i4);
        JLabel i5 =new JLabel("Bed_type");
        i5.setBounds(400,10,100,20);
        add(i5);
        btn1 = new JButton("Back");
        btn1.setBounds(170, 520, 100, 25);
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
          ResultSet rs = c.s.executeQuery("select * from rooms");
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
        new Bookroom();
    }
}
