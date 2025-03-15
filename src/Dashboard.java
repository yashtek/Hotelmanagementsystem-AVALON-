import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    JMenuItem admin,adrooms,addrivers,reception;
    Dashboard() {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
        Image i2 = il.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400, 50, 1000, 50);
        text.setFont(new Font("Tahoma", Font.ITALIC, 50));
        text.setForeground(Color.orange);
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);

        JMenu hotel = new JMenu("Hotel Management");
        hotel.setForeground(Color.DARK_GRAY);
        mb.add(hotel);

         reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu main = new JMenu("Admin");
        main.setForeground(Color.BLUE);
        mb.add(main);

         admin = new JMenuItem("Add Employee");
         admin.addActionListener(this);
        main.add(admin);
         adrooms = new JMenuItem("Add Rooms");
         adrooms.addActionListener(this);
        main.add(adrooms);
        addrivers = new JMenuItem("Add Drivers");
        addrivers.addActionListener(this);
        main.add(addrivers);


           setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == admin) {
            new Addemployee();
        } else if (ae.getSource() == adrooms) {
            new Addrooms();
        } else if (ae.getSource() == addrivers) {
            new Adddrivers();
        } else if (ae.getSource() == reception) {
            new Reception();
        }
    }


    public static void main(String[] args){
        new Dashboard();
    }
}

