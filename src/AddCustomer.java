import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

import javax.swing.JComboBox;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel labelusername, labelname;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfphone, tfemail;
    JRadioButton rfemale, rmale;
    JButton add, back;
    String user_name;

    AddCustomer(String user) {
        setBounds(450, 0, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setResizable(false);
        user_name = user;

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel(user);
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);

        comboid = new JComboBox<>(new String[] { "Passport", "Aadhar Card", "Ration Card" });
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 70, 25);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 100, 25);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 290, 150, 25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 330, 150, 25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        JLabel lblemail = new JLabel("E-mail Id");
        lblemail.setBounds(30, 370, 150, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);

        add = new JButton("Add");
        add.setBounds(70, 430, 100, 25);
        add.setForeground(new Color(51, 204, 255));
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(220, 430, 100, 25);
        back.setForeground(new Color(51, 204, 255));
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource(
                "icons/addcustomer.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel traveller = new JLabel(i6);
        traveller.setBounds(400, 40, 400, 500);
        add(traveller);

        try {
            sql con = new sql();
            ResultSet rs = con.stmt.executeQuery("select *from signup where username='" + user + "'");

            while (rs.next()) {
                labelname.setText(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
        } else if (e.getSource() == add) {
            try {
                String name = labelname.getText();
                String id = (String) comboid.getSelectedItem();
                String num = tfnumber.getText();
                String email = tfemail.getText();
                String phno = tfphone.getText();
                String gender = null;
                if (rmale.isSelected()) {
                    gender = "male";
                } else {
                    gender = "female";
                }

                String country = tfcountry.getText();
                String address = tfaddress.getText();
                sql con1 = new sql();
                String query = "insert into customer values('" + user_name + "','" + name + "','" + id + "','" + num
                        + "','" + gender + "','" + country + "','" + address + "','" + email + "','" + phno + "')";
                con1.stmt.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "successfully added details");
                setVisible(false);
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // new AddCustomer();
    }
}
