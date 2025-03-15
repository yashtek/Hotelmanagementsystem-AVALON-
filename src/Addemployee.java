import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Addemployee extends JFrame implements ActionListener {
    JButton btn;
    JTextField addname, addage, addsalary, addPh, addemail, addadhar;
    JComboBox addjob;
    JRadioButton rbmale, rbfemale;

    Addemployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(450, 180, 740, 650);

        JLabel emp = new JLabel("Add Employee");
        emp.setBounds(90, 5, 170, 30);
        emp.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(emp);
//        Adding name
        JLabel name = new JLabel("Name");
        name.setBounds(40, 60, 100, 30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(name);
        addname = new JTextField();
        addname.setBounds(150, 60, 150, 30);
        addname.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(addname);

//        Adding Age
        JLabel age = new JLabel("Age");
        age.setBounds(40, 120, 100, 30);
        age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(age);
        addage = new JTextField();
        addage.setBounds(150, 120, 150, 30);
        addage.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(addage);

//       Adding Gender
        JLabel gender = new JLabel("Gender");
        gender.setBounds(40, 180, 100, 30);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(gender);
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(150, 180, 75, 30);
        rbmale.setBackground(Color.WHITE);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(rbmale);
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(230, 180, 80, 30);
        rbfemale.setBackground(Color.WHITE);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(rbfemale);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
//        Adding Job
        JLabel job = new JLabel("Job");
        job.setBounds(40, 240, 100, 30);
        job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(job);
        String cb[] = {"Front-Desk clerks", "Kitchen Staff", "Porters", "Housekeepers", "Chef", "Manager", "Room Service"};
        addjob = new JComboBox(cb);
        addjob.setBounds(150, 240, 150, 30);
        addjob.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addjob.setBackground(Color.WHITE);
        add(addjob);


//       Adding salary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(40, 300, 100, 30);
        salary.setFont(new Font("serif", Font.PLAIN, 17));
        add(salary);
        addsalary = new JTextField();
        addsalary.setBounds(150, 300, 150, 30);
        addsalary.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(addsalary);

//      Adding phone number
        JLabel Phno = new JLabel("Phone no.");
        Phno.setBounds(40, 360, 100, 30);
        Phno.setFont(new Font("serif", Font.PLAIN, 17));
        add(Phno);
        addPh = new JTextField();
        addPh.setBounds(150, 360, 150, 30);
        addPh.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(addPh);

//         Adding email
        JLabel email = new JLabel("E-mail");
        email.setBounds(40, 420, 100, 30);
        email.setFont(new Font("serif", Font.PLAIN, 17));
        add(email);
        addemail = new JTextField();
        addemail.setBounds(150, 420, 150, 30);
        addemail.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(addemail);

//       Add adhar
        JLabel adhar = new JLabel("AAdhar no.");
        adhar.setBounds(40, 480, 100, 30);
        adhar.setFont(new Font("serif", Font.PLAIN, 17));
        add(adhar);
        addadhar = new JTextField();
        addadhar.setBounds(150, 480, 150, 30);
        addadhar.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(addadhar);

//        Add button
        btn = new JButton("SUBMIT");
        btn.setBounds(100, 540, 110, 25);
        btn.setBackground(Color.black);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btn.addActionListener(this);
        add(btn);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icon/tenth.jpg"));
        Image i2 = il.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 60, 360, 380);
        add(image);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String name = addname.getText();
        String age = addage.getText();
        String salary = addsalary.getText();
        String phone = addPh.getText();
        String email = addemail.getText();
        String aadhar = addadhar.getText();

        String gender = null;



        if(aadhar.length()<13){
            JOptionPane.showMessageDialog(null,"AAdhar should not be less then 12 digits");
            return;
        }

        if(name.isEmpty()){
            JOptionPane.showMessageDialog(null,"Name should not be empty");
            return;
        }
        if (rbmale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        String job = (String) addjob.getSelectedItem();
        try {
            conn con = new conn();
            String query = "insert into employees values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + aadhar + "')";
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee added successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Addemployee();
    }
}
