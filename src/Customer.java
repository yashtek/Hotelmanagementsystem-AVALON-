import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer extends JFrame implements ActionListener {
    JButton jsubmit,jcancel;
    JComboBox jid;
    JTextField tname,jcountry,jdeposit,jroomallocate,jnumber;
    JRadioButton jmale,jfemale;
    JLabel dateTimeLabel;
    Customer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(450,180,740,650);


        JLabel heading = new JLabel("WELCOME :-)");
        heading.setBounds(90,10,150,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,22));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(30,60,130,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(name);
        tname = new JTextField();
        tname.setBounds(190, 60, 150, 30);
        tname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(tname);
//
        JLabel Number =new JLabel("Number");
        Number.setBounds(30,120,130,30);
        Number.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(Number);
        jnumber = new JTextField();
        jnumber.setFont(new Font("Tahoma",Font.PLAIN,17));
        jnumber.setBounds(190,120,150,30);
        add(jnumber);
//
         JLabel id = new JLabel("ID");
         id.setBounds(30,180,150,30);
         id.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(id);
         String str[] = {"AAdhar  card","Pancard","Driving licence","Pass  port"};
         jid = new JComboBox(str);
         jid.setBounds(190,180,150,30);
         jid.setBackground(Color.white);
         jid.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(jid);
//
        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,240,150,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(gender);
        jmale = new JRadioButton("Male");
        jmale.setBounds(190, 240, 75, 30);
        jmale.setBackground(Color.WHITE);
        jmale.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(jmale);
        jfemale = new JRadioButton("Female");
        jfemale.setBounds(270, 240, 80, 30);
        jfemale.setBackground(Color.WHITE);
        jfemale.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(jfemale);
        ButtonGroup genderroup = new ButtonGroup();
        genderroup.add(jfemale);
        genderroup.add(jmale);
//
        JLabel country = new JLabel("Country");
        country.setFont(new Font("Tahoma",Font.PLAIN,17));
        country.setBounds(30,300,130,30);
        add(country);
        jcountry = new JTextField();
        jcountry.setBounds(190,300,150,30);
        jcountry.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(jcountry);
//
        JLabel alloc = new JLabel("Allocate Room");
        alloc.setBounds(30,360,130,30);
        alloc.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(alloc);
        jroomallocate = new JTextField();
        jroomallocate.setBounds(190,360,150,30);
        jroomallocate.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(jroomallocate);

        JLabel check = new JLabel("Check-in Time");
        check.setFont(new Font("Tahoma", Font.PLAIN, 17));
        check.setBounds(30, 420, 130, 30);
        add(check);
        dateTimeLabel = new JLabel();
        dateTimeLabel.setBounds(190, 420, 200, 30);
        dateTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(dateTimeLabel);
        Timer timer = new Timer(1000,e ->{
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            dateTimeLabel.setText(formatter.format(new Date()));
        });
        timer.start();


//
        JLabel Ddeposit = new JLabel("Deposited");
        Ddeposit.setFont(new Font("Tahoma",Font.PLAIN,17));
        Ddeposit.setBounds(30,480,130,30);
        add(Ddeposit);
        jdeposit = new JTextField();
        jdeposit.setFont(new Font("Tahoma",Font.PLAIN,17));
        jdeposit.setBounds(190,480,150,30);
        add(jdeposit);

        jsubmit = new JButton("Submit");
        jsubmit.setFont(new Font("Tahoma",Font.PLAIN,17));
        jsubmit.setBounds(80,540,100,30);
        jsubmit.setForeground(Color.WHITE);
        jsubmit.setBackground(Color.black);
        jsubmit.setBorder(new LineBorder(null));
        jsubmit.addActionListener(this);
        add(jsubmit);
        jcancel = new JButton("Cancel");
        jcancel.setFont(new Font("Tahoma",Font.PLAIN,17));
        jcancel.setBounds(200,540,100,30);
        jcancel.setForeground(Color.WHITE);
        jcancel.setBackground(Color.black);
        jcancel.setBorder(new LineBorder(null));
        jcancel.addActionListener(this);
        add(jcancel);
        ImageIcon il = new ImageIcon((ClassLoader.getSystemResource("icon/fifth.jpg")));
        Image i2 = il.getImage().getScaledInstance(450,590,Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 30, 360, 520);
        add(image);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String id = (String)jid.getSelectedItem();
        String country = jcountry.getText();
        String deposit = jdeposit.getText();
        String allocate = jroomallocate.getText();
        String number = jnumber.getText();
        String gender = null;
        String name = tname.getText();
        String date = dateTimeLabel.getText();

        if(jmale.isSelected())
            gender = "male";
        else if (jfemale.isSelected()) {
            gender = "female";


        }

        if(name.isEmpty()){
            JOptionPane.showMessageDialog(this,"Name cannot be empty");
            return;

        }
        if(number.length() < 10){
         JOptionPane.showMessageDialog(this,"Number cannot be less then ten digit");
         return;
        }
        if(ae.getSource() == jsubmit){
            try{
                conn con = new conn();
                String query = "INSERT INTO newCustomer VALUES ('"
                        + name + "', '" + number + "', '" + id + "', '" + gender + "', '" + country + "', '" + allocate + "', '" + date + "', '" + deposit + "')";

                System.out.println("Excuting queery: "+query);
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"New Customer added successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(ae.getSource()==jcancel){
            setVisible(false);
        }

    }
    public static void main(String[] args){
        new Customer();
    }
}
