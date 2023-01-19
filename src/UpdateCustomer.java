import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener {
    JLabel labelusername, labelname;
    JTextField tfnumber, tfcountry, tfaddress, tfphone, tfemail, tfid, tfgender;
    JRadioButton rfemale, rmale;
    JButton add, back;
    String user_name;

    UpdateCustomer(String user) {
        setBounds(450, 0, 850, 530);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setResizable(false);
        user_name = user;

        JLabel title = new JLabel("Update Customer Details");
        title.setBounds(50, 0, 300, 25);
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(title);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel(user);
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);

        tfid = new JTextField();
        tfid.setBounds(220, 90, 150, 25);
        add(tfid);

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

        tfgender = new JTextField();
        tfgender.setBounds(220, 210, 150, 25);
        add(tfgender);

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

        add = new JButton("Update");
        add.setBounds(70, 430, 100, 25);
        add.setForeground(new Color(51, 204, 255));
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(220, 430, 100, 25);
        back.setForeground(new Color(51, 204, 255));
        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(
                ClassLoader.getSystemResource("icons/graphic-cartoon-character-system-update-vector-34678927.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel traveller = new JLabel(i6);
        traveller.setBounds(400, 40, 400, 500);
        add(traveller);

        setVisible(true);
        try {
            sql con = new sql();
            ResultSet rs = con.stmt.executeQuery("select *from signup where username='" + user + "'");

            while (rs.next()) {
                labelname.setText(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
        } else if (e.getSource() == add) {
            try {
                String name = labelname.getText();
                String id = tfid.getText();
                String num = tfnumber.getText();
                String email = tfemail.getText();
                String phno = tfphone.getText();
                String gender = tfgender.getText();

                String country = tfcountry.getText();
                String address = tfaddress.getText();
                sql con1 = new sql();
                String query = "update customer set username='" + user_name + "',name='" + name + "',id='" + id
                        + "',num='" + num
                        + "',gender='" + gender + "',country='" + country + "',addr='" + address + "',email='" + email
                        + "',phone='" + phno + "' where username='" + user_name + "'";
                con1.stmt.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "successfully updated details");
                setVisible(false);
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // new UpdateCustomer();
    }
}
