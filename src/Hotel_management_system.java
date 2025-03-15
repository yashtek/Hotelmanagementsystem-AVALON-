import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Hotel_management_system extends JFrame implements ActionListener {
    Hotel_management_system(){
        setSize(1366,565);
        setLocation(100,100);


        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icon/first.jpg  "));
        JLabel image = new JLabel(il);
        add(image);

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(10,450,900,90);
        text.setForeground(Color.YELLOW);
        text.setFont(new Font("serif",Font.PLAIN,50));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1240,470,100,40);
        next.setBackground(Color.BLACK);
        next.setBorder(null);
        next.setFocusPainted(false);
        next.setBorder(new LineBorder(Color.RED,3));
        next.setForeground(Color.orange);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,20));
        image.add(next);
        setVisible(true);

        while(true){
            text.setVisible(false);
            try{
            Thread.sleep(500);}
            catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);}
            catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    public  void actionPerformed(ActionEvent ae){
        setVisible(false);
        new login();

    }
    public static void main(String[] args) {
        new Hotel_management_system();
    }
}