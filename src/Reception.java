import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Reception extends JFrame implements ActionListener {
    JButton customerform,rooms,department,employe,custinfo;
    JButton managerinfo,checkout,update,updateroom,pickup,searchroom,logout;
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(450,180,740,530);

        customerform = new JButton("New Customer form");
        customerform.setBackground(Color.BLACK);
        customerform.setBounds(30,25,190,30);
        customerform.setFont(new Font("Tahoma",Font.PLAIN,17));
        customerform.setBorder(new LineBorder(null));
        customerform.setForeground(Color.WHITE);
        customerform.setFocusPainted(false);
        customerform.addActionListener(this);
        add(customerform);

        rooms = new JButton("Room");
        rooms.setBackground(Color.BLACK);
        rooms.setBounds(30,70,190,30);
        rooms.setFont(new Font("Tahoma",Font.PLAIN,17));
        rooms.setBorder(new LineBorder(null));
        rooms.setForeground(Color.WHITE);
        rooms.setFocusPainted(false);
        rooms.addActionListener(this);
        add(rooms);

        department = new JButton("Department");
        department.setBackground(Color.BLACK);
        department.setBounds(30,110,190,30);
        department.setFont(new Font("Tahoma",Font.PLAIN,17));
        department.setBorder(new LineBorder(null));
        department.setForeground(Color.WHITE);
        department.setFocusPainted(false);
        department.addActionListener(this);
        add(department);


        employe = new JButton("All Employee");
        employe.setBackground(Color.BLACK);
        employe.setBounds(30,150,190,30);
        employe.setFont(new Font("Tahoma",Font.PLAIN,17));
        employe.setBorder(new LineBorder(null));
        employe.setForeground(Color.WHITE);
        employe.setFocusPainted(false);
        employe.addActionListener(this);
        add(employe);

        custinfo = new JButton("Customer Information");
        custinfo.setBackground(Color.BLACK);
        custinfo.setBounds(30,190,190,30);
        custinfo.setFont(new Font("Tahoma",Font.PLAIN,17));
        custinfo.setBorder(new LineBorder(null));
        custinfo.setForeground(Color.WHITE);
        custinfo.setFocusPainted(false);
        custinfo.addActionListener(this);
        add(custinfo);

        managerinfo = new JButton("Manager Information");
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setBounds(30,230,190,30);
        managerinfo.setFont(new Font("Tahoma",Font.PLAIN,17));
        managerinfo.setBorder(new LineBorder(null));
        managerinfo.setForeground(Color.WHITE);
        managerinfo.setFocusPainted(false);
        managerinfo.addActionListener(this);
        add(managerinfo);

        checkout = new JButton("Checkout status");
        checkout.setBackground(Color.BLACK);
        checkout.setBounds(30,270,190,30);
        checkout.setFont(new Font("Tahoma",Font.PLAIN,17));
        checkout.setBorder(new LineBorder(null));
        checkout.setForeground(Color.WHITE);
        checkout.setFocusPainted(false);
        checkout.addActionListener(this);
        add(checkout);

        update = new JButton("Update rooms");
        update.setBackground(Color.BLACK);
        update.setBounds(30,310,190,30);
        update.setFont(new Font("Tahoma",Font.PLAIN,17));
        update.setBorder(new LineBorder(null));
        update.setForeground(Color.WHITE);
        update.setFocusPainted(false);
        update.addActionListener(this);
        add(update);

        pickup = new JButton("Pick-up");
        pickup.setBackground(Color.BLACK);
        pickup.setBounds(30,350,190,30);
        pickup.setFont(new Font("Tahoma",Font.PLAIN,17));
        pickup.setBorder(new LineBorder(null));
        pickup.setForeground(Color.WHITE);
        pickup.setFocusPainted(false);
        pickup.addActionListener(this);
        add(pickup);

        searchroom = new JButton("Search rooms");
        searchroom.setBackground(Color.BLACK);
        searchroom.setBounds(30,390,190,30);
        searchroom.setFont(new Font("Tahoma",Font.PLAIN,17));
        searchroom.setBorder(new LineBorder(null));
        searchroom.setForeground(Color.WHITE);
        searchroom.setFocusPainted(false);
        searchroom.addActionListener(this);
        add(searchroom);

        logout = new JButton("Logout");
        logout.setBackground(Color.BLACK);
        logout.setBounds(30,430,190,30);
        logout.setFont(new Font("Tahoma",Font.PLAIN,17));
        logout.setBorder(new LineBorder(null));
        logout.setForeground(Color.WHITE);
        logout.setFocusPainted(false);
        logout.addActionListener(this);
        add(logout);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icon/fourth.jpg"));
        Image i2 = il.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250,25,450,430);
        add(image);




        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==customerform){
            setVisible(false);
                  new Customer();
        }
        if (ae.getSource()==rooms){
            setVisible(false);
            new Bookroom();
        }
        if (ae.getSource()==department){
            setVisible(false);
            new Department();
        }
        if (ae.getSource()==employe){
            setVisible(false);
            new Employee_info();
        }
        if (ae.getSource()==managerinfo){
            setVisible(false);
            new Manager();
        }
        if (ae.getSource()==custinfo){
            setVisible(false);
            new Cust_info();
        }
        if (ae.getSource()==checkout){
            setVisible(false);
            new Check_out();
        }
        if (ae.getSource()==update){
            setVisible(false);
            new Update();
        }
        if (ae.getSource()==pickup){
            setVisible(false);
            new Pick_up();
        }
        if (ae.getSource()==searchroom){
            setVisible(false);
            new Seaarch_room();
        }
        if (ae.getSource()==logout){
            setVisible(false);

        }
    }
    public static void main(String[] args){
                  new Reception();
    }
}
