
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.ResultSet;
import net.proteanit.sql.*;


public class Pick_up extends JFrame implements ActionListener {
    JTable tabel;
    JButton btn1;
    Pick_up(){
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 600, 400);
        setLayout(null);

        JLabel lbroom = new JLabel("Pick up service");
        lbroom.setBounds(150, 10, 150, 30);
        lbroom.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lbroom);
        JLabel i1 =new JLabel("Name");
        i1.setBounds(10,70,100,20);
        add(i1);

        JLabel l3 =new JLabel("Car_type");
        l3.setBounds(120,70,100,20);
        add(l3);
        JLabel i4 =new JLabel("Car_no");
        i4.setBounds(240,70,100,20);
        add(i4);
        JLabel i5 =new JLabel("Available");
        i5.setBounds(360,70,100,20);
        add(i5);
        JLabel i6 =new JLabel("Price ");
        i6.setBounds(480,70,100,20);
        add(i6);



        btn1 = new JButton("Back");
        btn1.setBounds(250, 300, 100, 25);
        btn1.setBackground(Color.black);
        btn1.setForeground(Color.WHITE);
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btn1.addActionListener(this);
        add(btn1);

        tabel = new JTable();
        tabel.setBounds(0,90,600,400);
        add(tabel);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
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
        new Pick_up();
    }
}

