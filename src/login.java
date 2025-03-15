import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField Password;
    JButton login, cancel;
    login(){
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(500,300,600,300);
        JLabel user = new JLabel("Username");
        user.setBounds(40,20,100,30);
        user.setFont(new Font("serif",Font.PLAIN,20));
        add(user);
         username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);

        JLabel password = new JLabel("Password");
        password.setBounds(40,80,100,30);
        add(password);
         Password = new JPasswordField();
        Password.setBounds(150,80,150,30);
        password.setFont(new Font("serif",Font.PLAIN,20));
        add(Password);


        login = new JButton("Login");
        login.setBounds(40,150,120,40);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(240,150,120,40);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,10,150,150);

        add(image);
        setVisible(true);



    }
    public  void actionPerformed(ActionEvent ae){
            if(ae.getSource() == login){
            String user = username.getText();
            String pass = Password.getText();
            try{
                conn c =new conn ();
                String query = "select * from login where username = '"+user+"' and password ='"+pass+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                     setVisible(false);
                     new Dashboard();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            } else if (ae.getSource() == cancel) {
                setVisible(false);
            }


    }
    public static void main(String[]args){
        new login();
    }
}
