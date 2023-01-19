import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;

public class BookPackage extends JFrame implements ActionListener {
    JComboBox cpackage;
    int num, price;
    String username;
    JTextField tfperson;
    JButton checkprice, bookpackage, back;
    JLabel labelusername, labelname, labelprice, labelperson;

    BookPackage(String user) {
        setBounds(450, 0, 990, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        username = user;

        JLabel book1 = new JLabel("Book Package");
        book1.setFont(new Font("Tohima", Font.PLAIN, 20));
        book1.setForeground(new Color(51, 204, 255));
        book1.setBounds(40, 10, 150, 30);
        add(book1);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tohima", Font.PLAIN, 16));
        lblusername.setBounds(40, 50, 100, 25);
        add(lblusername);

        labelusername = new JLabel(user);
        labelusername.setFont(new Font("Tohima", Font.PLAIN, 16));
        labelusername.setBounds(250, 50, 100, 25);
        add(labelusername);

        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setFont(new Font("Tohima", Font.PLAIN, 16));
        lblpackage.setBounds(40, 110, 150, 20);
        add(lblpackage);

        cpackage = new JComboBox<>(
                new String[] { "EGYPT", "BALI & SINGAPORE", "DUBAI", "KATHMANDU", "MALDIVES", "SINGAPORE" });
        // cpackage.add("EGYPT");
        // cpackage.add("BALI & SINGAPORE");
        // cpackage.add("DUBAI");
        // cpackage.add("KATHMANDU");
        // cpackage.add("MALDIVES");
        // cpackage.add("SINGAPORE");
        cpackage.setBounds(250, 110, 100, 20);
        add(cpackage);

        labelperson = new JLabel("No of Person");
        labelperson.setFont(new Font("Tohima", Font.PLAIN, 16));
        labelperson.setBounds(40, 160, 150, 25);
        add(labelperson);

        tfperson = new JTextField("1");
        tfperson.setBounds(250, 160, 200, 25);
        add(tfperson);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tohima", Font.PLAIN, 16));
        lblname.setBounds(40, 210, 150, 25);
        add(lblname);

        labelname = new JLabel();
        labelname.setFont(new Font("Tohima", Font.PLAIN, 16));
        labelname.setBounds(250, 210, 150, 25);
        add(labelname);

        JLabel lblprice = new JLabel("Total Price");
        lblprice.setFont(new Font("Tohima", Font.PLAIN, 16));
        lblprice.setBounds(40, 260, 150, 25);
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setFont(new Font("Tohima", Font.PLAIN, 16));
        labelprice.setBounds(250, 260, 150, 25);
        add(labelprice);

        checkprice = new JButton("Check Price");
        checkprice.setBounds(20, 320, 150, 50);
        checkprice.setForeground(new Color(51, 204, 255));
        checkprice.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(190, 320, 170, 50);
        bookpackage.setForeground(new Color(51, 204, 255));
        bookpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("back");
        back.setBounds(380, 320, 100, 50);
        back.setForeground(new Color(51, 204, 255));
        back.setFont(new Font("Tahoma", Font.PLAIN, 20));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(
                "icons/traveling-family-vacation-happy-family-luggage-cartoon-vector-eps-illustration-isolated-white-background-traveling-122148571.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(490, 0, 450, 450);
        add(icon);

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

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            num = Integer.parseInt(tfperson.getText());
            if (cpackage.getSelectedItem() == "EGYPT") {
                price = num * 83245;
                labelprice.setText(Integer.toString(price));
            } else if (cpackage.getSelectedItem() == "BALI & SINGAPORE") {
                price = num * 134346;
                labelprice.setText(Integer.toString(price));
            } else if (cpackage.getSelectedItem() == "DUBAI") {
                price = num * 46684;
                labelprice.setText(Integer.toString(price));
            } else if (cpackage.getSelectedItem() == "KATHMANDU") {
                price = num * 18184;
                labelprice.setText(Integer.toString(price));
            } else if (cpackage.getSelectedItem() == "MALDIVES") {
                price = num * 54051;
                labelprice.setText(Integer.toString(price));
            } else {
                price = num * 57369;
                labelprice.setText(Integer.toString(price));
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        } else {
            String name = labelname.getText();
            String person = tfperson.getText();
            String pack = (String) cpackage.getSelectedItem();
            String amount = labelprice.getText();
            try {
                sql con1 = new sql();
                String query = "insert into booking values('" + username + "','" + name + "','" + person + "','"
                        + pack + "','" + amount + "')";
                con1.stmt.executeQuery(query);

                JOptionPane.showMessageDialog(null, "successfully Booked package");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        // new BookPackage();
    }
}
