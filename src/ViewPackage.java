import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener {
    JButton back;
    JLabel labelprice, labelphone, labelnumber, labelid, labelperson, labelpackage, labelusername;

    ViewPackage(String user) {
        setBounds(450, 0, 900, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);

        JLabel text = new JLabel("Your Booked Package");
        text.setForeground(new Color(51, 204, 255));
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(30, 0, 300, 30);
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(30, 90, 150, 25);
        add(lblpackage);

        labelpackage = new JLabel();
        labelpackage.setBounds(220, 90, 150, 25);
        add(labelpackage);

        JLabel lblperson = new JLabel("No of Person");
        lblperson.setBounds(30, 130, 150, 25);
        add(lblperson);

        labelperson = new JLabel();
        labelperson.setBounds(220, 130, 150, 25);
        add(labelperson);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 170, 150, 25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(220, 170, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("ID-Number");
        lblnumber.setBounds(30, 210, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(220, 210, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone No");
        lblphone.setBounds(30, 260, 150, 25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(220, 260, 150, 25);
        add(labelphone);

        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30, 300, 150, 25);
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(220, 300, 150, 25);
        add(labelprice);

        back = new JButton("Back");
        back.setForeground(new Color(51, 204, 255));
        back.setBounds(135, 350, 100, 50);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/traveling-cartoon-set-vector-22948478.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(390, 360, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(400, -40, 500, 450);
        add(icon);

        try {
            sql con = new sql();
            String query = "select *from booking where username='" + user + "'";
            String query1 = "select *from customer where username='" + user + "'";
            ResultSet rs = con.stmt.executeQuery(query);

            while (rs.next()) {
                labelpackage.setText(rs.getString("package"));
                labelperson.setText(rs.getString("person"));
                labelprice.setText(rs.getString("price"));
                labelusername.setText(rs.getString("username"));
            }
            ResultSet rs1 = con.stmt.executeQuery(query1);
            while (rs1.next()) {
                labelid.setText(rs1.getString("id"));
                labelnumber.setText(rs1.getString("num"));
                labelphone.setText(rs1.getString("phone"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        // new ViewPackage();
    }

}
