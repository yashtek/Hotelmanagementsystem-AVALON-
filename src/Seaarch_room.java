import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Seaarch_room extends JFrame implements ActionListener {
    JTable tabel;
    JButton btn1,btn2;
    JComboBox cbbed;
    JCheckBox bed;

    Seaarch_room() {
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 200, 500, 500);
        setLayout(null);

        JLabel sea = new JLabel("Search for a room");
        sea.setBounds(120, 10, 200, 30);
        sea.setFont(new Font("Tahoma", Font.BOLD, 20));
         add(sea);

        String str3[] = {"Single-bed", "Double-bed"};
        cbbed = new JComboBox(str3);
        cbbed.setBounds(60, 40, 120, 25);
        cbbed.setFont(new Font("Tahoma", Font.PLAIN, 17));
        cbbed.setBackground(Color.WHITE);
        add(cbbed);

       bed = new JCheckBox("Only Available");
        bed.setBounds(250, 40, 150, 20);
        bed.setFont(new Font("Tahoma", Font.PLAIN, 17));
        bed.setBackground(Color.WHITE);
        add(bed);

        JLabel i1 = new JLabel("Room No");
        i1.setBounds(10, 80, 100, 20);
        add(i1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(100, 80, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Cleaning Status");
        l3.setBounds(200, 80, 100, 20);
        add(l3);

        JLabel i4 = new JLabel("Price");
        i4.setBounds(305, 80, 100, 20);
        add(i4);

        JLabel i5 = new JLabel("Bed Type");
        i5.setBounds(400, 80, 100, 20);
        add(i5);

        btn1 = new JButton("Back");
        btn1.setBounds(200, 300, 100, 25);
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btn1.addActionListener(this);
        add(btn1);
        btn2 = new JButton("Submit");
        btn2.setBounds(80, 300, 100, 25);
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        btn2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btn2.addActionListener(this);
        add(btn2);






        tabel = new JTable();
        tabel.setBounds(0, 100, 500, 400);
        add(tabel);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM rooms");
            tabel.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            setVisible(false);
            new Reception();
        }
        if(ae.getSource()==btn2){
            try{
                String query1 = "select * from rooms where Bed_type = '"+cbbed.getSelectedItem()+"'";
                String query2 = "select * from rooms where Available = 'Available' AND Bed_type =  '"+cbbed.getSelectedItem()+"'";
            conn c =new conn();
            ResultSet rs;
            if(bed.isSelected()){
               rs = c.s.executeQuery(query2);
            }else{
                  rs = c.s.executeQuery(query1);
            }
            tabel.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Seaarch_room();
    }
}
