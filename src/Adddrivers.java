import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class Adddrivers extends JFrame implements ActionListener {
    JTextField tfdrive, cbprice;
    JComboBox<String> cbcar, cbno, cbavail;
    JButton btn;

    Adddrivers() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(450, 180, 740, 600);

        JLabel driver = new JLabel("Driver Specifications");
        driver.setBounds(90, 10, 250, 30);
        driver.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(driver);

        JLabel drive = new JLabel("Driver Name:");
        drive.setBounds(30, 60, 130, 30);
        drive.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(drive);

        tfdrive = new JTextField();
        tfdrive.setBounds(190, 60, 150, 30);
        tfdrive.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(tfdrive);

        JLabel car = new JLabel("Car Type:");
        car.setBounds(30, 120, 130, 30);
        car.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(car);

        String carTypes[] = {"Mini", "Sedan", "XUV"};
        cbcar = new JComboBox<>(carTypes);
        cbcar.setBounds(190, 120, 150, 30);
        cbcar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(cbcar);

        JLabel cno = new JLabel("Car Number:");
        cno.setBounds(30, 180, 150, 30);
        cno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(cno);

        String carNumbers[] = {"001", "002", "111", "222", "112", "221"};
        cbno = new JComboBox<>(carNumbers);
        cbno.setBounds(190, 180, 150, 30);
        cbno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(cbno);

        JLabel available = new JLabel("Availability:");
        available.setBounds(30, 240, 150, 30);
        available.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(available);

        String availability[] = {"Available", "Not-Available"};
        cbavail = new JComboBox<>(availability);
        cbavail.setBounds(190, 240, 150, 30);
        cbavail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(cbavail);

        JLabel price = new JLabel("Price:");
        price.setBounds(30, 300, 170, 30);
        price.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(price);

        cbprice = new JTextField();
        cbprice.setBounds(190, 300, 150, 30);
        cbprice.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(cbprice);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icon/eleven.jpg"));
        Image i2 = il.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360, 20, 360, 380);
        add(image);

        btn = new JButton("SUBMIT");
        btn.setBounds(100, 400, 150, 35);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btn.addActionListener(this);
        add(btn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = tfdrive.getText();
        String cart = (String) cbcar.getSelectedItem();
        String carN = (String) cbno.getSelectedItem();
        String avail = (String) cbavail.getSelectedItem();
        String price = cbprice.getText();



        try {
            conn con = new conn();  // Ensure conn.java exists and is properly configured
            String query = "insert into driver values ('" + name + "','" + cart + "','" + carN + "','" + avail + "','" + price + "')";
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Driver added successfully!");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding driver.");
        }
    }

    public static void main(String[] args) {
        new Adddrivers();
    }
}
