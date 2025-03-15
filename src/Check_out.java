import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
public class Check_out extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField tfroom, tfname, tcheck, tfdepo, tpending;
    JButton chexx, updatee, bacxx;

    Check_out() {
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 980, 500);
        setLayout(null);

        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 30);
        add(ccustomer);

        JLabel text = new JLabel("Update Status");
        text.setBounds(90, 20, 200, 30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lbild = new JLabel("Customer ID");
        lbild.setBounds(30, 80, 100, 30);
        lbild.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbild);

        JLabel lbroom = new JLabel("Room number");
        lbroom.setBounds(30, 120, 120, 30);
        lbroom.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbroom);
        tfroom = new JTextField();
        tfroom.setBounds(190, 120, 200, 30);
        tfroom.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(tfroom);


        JLabel lbname = new JLabel("Name");
        lbname.setBounds(30, 160, 100, 30);
        lbname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbname);
        tfname = new JTextField();
        tfname.setBounds(190, 160, 200, 30);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(tfname);

        JLabel check = new JLabel("Check-in time");
        check.setBounds(30, 200, 140, 30);
        check.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(check);
        tcheck = new JTextField();
        tcheck.setBounds(190, 200, 200, 30);
        tcheck.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(tcheck);

        JLabel deposit = new JLabel("Amount paid");
        deposit.setBounds(30, 240, 140, 30);
        deposit.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(deposit);
        tfdepo = new JTextField();
        tfdepo.setBounds(190, 240, 200, 30);
        tfdepo.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(tfdepo);

        JLabel pending = new JLabel("Pending amount");
        pending.setBounds(30, 280, 140, 30);
        pending.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(pending);
        tpending = new JTextField();
        tpending.setBounds(190, 280, 200, 30);
        tpending.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(tpending);
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

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icon/nine.jpg"));
        Image i2 = il.getImage().getScaledInstance(400, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 400);
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
                    tfdepo.setText(rs.getString("Deposited"));
                    tcheck.setText(rs.getString("Check_in"));

                }
                ResultSet rs2 = c.s.executeQuery("select * from rooms where Room_no = '" + tfroom.getText() + "'");
                while (rs2.next()) {
                    String price = rs2.getString("price");
                    String pendingText = tpending.getText().trim();


                    if (pendingText.isEmpty()) {
                        pendingText = "0";
                    }

                    int amountpaid = Integer.parseInt(price) - Integer.parseInt(pendingText);
                    tpending.setText("" + amountpaid);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == updatee) {
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tcheck.getText();
            String deposit = tfdepo.getText();
            String pending = tpending.getText();

            try {
                conn c = new conn();
                c.s.executeUpdate("update customer set rooms = '" + room + "','" + deposit + "','" + checkin + "','" + name + "','" + number + "' where number = '"+number+"' ");
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
        new Check_out();
    }
}