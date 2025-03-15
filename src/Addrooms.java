import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Addrooms extends JFrame implements ActionListener {
    JComboBox cbprice, cbclean, cbbed, cbavail;
    JTextField rooms;
    JButton btn, btn1;

    Addrooms() {
        getContentPane().setBackground(Color.WHITE);
        setBounds(450, 180, 750, 500);
        setLayout(null);


        JLabel addrooms = new JLabel("Room Specifications");
        addrooms.setBounds(90, 10, 170, 30);
        addrooms.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(addrooms);

//        Add room
        JLabel room = new JLabel("Room No.");
        room.setBounds(30, 60, 100, 30);
        room.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(room);
        rooms = new JTextField();
        rooms.setBounds(190, 60, 150, 30);
        rooms.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(rooms);

//        Add available status

        JLabel avail = new JLabel("Availabile Status");
        avail.setBounds(30, 120, 130, 30);
        avail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(avail);
        String str[] = {"Available", "Occupied"};
        cbavail = new JComboBox(str);
        cbavail.setBounds(190, 120, 150, 30);
        cbavail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        cbavail.setBackground(Color.WHITE);
        add(cbavail);
//
////        Add cleaning status
        JLabel clean = new JLabel("Cleaning status");
        clean.setBounds(30, 180, 130, 30);
        clean.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(clean);
        String str1[] = {"Clean", "Not-clean"};
        cbclean = new JComboBox(str1);
        cbclean.setBounds(190, 180, 150, 30);
        cbclean.setFont(new Font("Tahoma", Font.PLAIN, 17));
        cbclean.setBackground(Color.WHITE);
        add(cbclean);
//
//        Add Price
        JLabel price = new JLabel("Pricing");
        price.setBounds(30, 240, 130, 30);
        price.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(price);
        String str2[] = {"2000", "3000"};
        cbprice = new JComboBox(str2);
        cbprice.setBounds(190, 240, 150, 30);
        cbprice.setFont(new Font("Tahoma", Font.PLAIN, 17));
        cbprice.setBackground(Color.WHITE);
        add(cbprice);
//
//        Add bed type
        JLabel bed = new JLabel("Bed type");
        bed.setBounds(30, 300, 150, 30);
        bed.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(bed);
        String str3[] = {"Single-bed", "Double-bed"};
        cbbed = new JComboBox(str3);
        cbbed.setBounds(190, 300, 150, 30);
        cbbed.setFont(new Font("Tahoma", Font.PLAIN, 17));
        cbbed.setBackground(Color.WHITE);
        add(cbbed);
//
        btn = new JButton("SUBMIT");
        btn.setBounds(50, 370, 100, 25);
        btn.setBackground(Color.black);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btn.addActionListener(this);
        add(btn);

        btn1 = new JButton("CANCEL");
        btn1.setBounds(170, 370, 100, 25);
        btn1.setBackground(Color.black);
        btn1.setForeground(Color.WHITE);
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btn1.addActionListener(this);
        add(btn1);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icon/eight.jpg"));
        Image i2 = il.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360, 40, 360, 380);
        add(image);


        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {
        String room = rooms.getText();
        String ava = (String) cbavail.getSelectedItem();
        String cleaning = (String) cbclean.getSelectedItem();
        String pricing = (String) cbprice.getSelectedItem();
        String bed = (String) cbbed.getSelectedItem();
        if (ae.getSource() == btn) {


            try {
                conn con = new conn();
                String query = "insert into rooms values('" + room + "','" + ava + "','" + cleaning + "','" + pricing + "','" + bed + "')";
                System.out.println("Executing query: " + query);
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Room added successfullu");
                con.c.setAutoCommit(true);

                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Addrooms();
    }
}
