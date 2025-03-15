import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
public class Update extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField tfroom, tfname, tcheck, tfdepo, tpending;
    JButton chexx, updatee, bacxx;

    Update() {
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 980, 500);
        setLayout(null);

        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 40);
        add(ccustomer);

        JLabel text = new JLabel("Update Room Status");
        text.setBounds(90, 20, 250, 30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lbild = new JLabel("Customer ID");
        lbild.setBounds(30, 80, 100, 30);
        lbild.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbild);

        JLabel lbroom = new JLabel("Room number");
        lbroom.setBounds(30, 130, 120, 30);
        lbroom.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbroom);
        tfroom = new JTextField();
        tfroom.setBounds(190, 130, 200, 30);
        tfroom.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(tfroom);


        JLabel lbname = new JLabel("Availability");
        lbname.setBounds(30, 180, 100, 30);
        lbname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbname);
        tfname = new JTextField();
        tfname.setBounds(190, 180, 200, 30);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(tfname);

        JLabel check = new JLabel("Cleaning_status");
        check.setBounds(30, 230, 140, 30);
        check.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(check);
        tcheck = new JTextField();
        tcheck.setBounds(190, 230, 200, 30);
        tcheck.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(tcheck);



        chexx = new JButton("SUBMIT");
        chexx.setBounds(30, 340, 100, 30);
        chexx.setBackground(Color.BLACK);
        chexx.setForeground(Color.WHITE);
        chexx.setFont(new Font("Tahoma", Font.PLAIN, 17));
        chexx.addActionListener(this);
        add(chexx);
        bacxx = new JButton("Cancel");
        bacxx.setBounds(270, 340, 100, 30);
        bacxx.setBackground(Color.BLACK);
        bacxx.setForeground(Color.WHITE);
        bacxx.setFont(new Font("Tahoma", Font.PLAIN, 17));
        bacxx.addActionListener(this);
        add(bacxx);
        updatee = new JButton("Update");
        updatee.setBounds(150, 340, 100, 30);
        updatee.setBackground(Color.BLACK);
        updatee.setForeground(Color.WHITE);
        updatee.setFont(new Font("Tahoma", Font.PLAIN, 17));
        updatee.addActionListener(this);
        add(updatee);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icon/seventh.jpg"));
        Image i2 = il.getImage().getScaledInstance(450, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 370);
        add(image);


        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from newCustomer");
            while (rs.next()) {
                ccustomer.add(rs.getNString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == chexx) {
            String id = ccustomer.getSelectedItem();
            String query = "select  * from newCustomer where number = '" + id + "'";
            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfname.setText(rs.getString("Name"));
                    tfroom.setText(rs.getString("Room_alloc"));
                    tcheck.setText(rs.getString("Check_in"));

                }
                ResultSet rs2 = c.s.executeQuery("select * from rooms where Room_no = '" + tfroom.getText() + "'");
                while (rs2.next()) {
                    tfname.setText(rs2.getString("Available"));
                    tcheck.setText(rs2.getString("Cleaning_status"));


                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == updatee) {
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tcheck.getText();


            try {
                conn c = new conn();
                c.s.executeUpdate("update rooms set Available = '" + name + "',Available = '" + checkin + "' where Room_no = '"+room+"'" );
                JOptionPane.showMessageDialog(null, "Data updated successfully");
                setVisible(false);
                new Reception();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (ae.getSource() == bacxx) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Update();
    }
}