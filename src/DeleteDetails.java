import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class DeleteDetails extends JFrame implements ActionListener {
    JButton delete, back, deleteacc;
    String username;

    DeleteDetails(String user) {
        setBounds(450, 0, 600, 300);
        getContentPane().setBackground(Color.white);
        setResizable(false);
        setLayout(null);
        username = user;

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel(user);
        labelusername.setBounds(250, 50, 150, 25);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 13));
        add(labelusername);

        delete = new JButton("Exit");
        delete.setBounds(20, 200, 150, 50);
        delete.setForeground(new Color(51, 204, 255));
        delete.setFont(new Font("Tahoma", Font.PLAIN, 15));
        delete.addActionListener(this);
        add(delete);

        deleteacc = new JButton("Delete Account");
        deleteacc.setBounds(180, 200, 200, 50);
        deleteacc.setForeground(new Color(51, 204, 255));
        deleteacc.setFont(new Font("Tahoma", Font.PLAIN, 15));
        deleteacc.addActionListener(this);
        add(deleteacc);

        back = new JButton("Back");
        back.setBounds(400, 200, 100, 50);
        back.setForeground(new Color(51, 204, 255));
        back.setFont(new Font("Tahoma", Font.PLAIN, 15));
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deleteacc) {
            int i = JOptionPane.showConfirmDialog(null, "Are you sure to delete this account?", "Confirm",
                    JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                try {
                    sql con = new sql();
                    String query = "delete from customer where username='" + username + "'";
                    con.stmt.executeQuery(query);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Account deleted successfully!!");
                setVisible(false);
                new login();
            }

        } else if (ae.getSource() == delete) {
            int i = JOptionPane.showConfirmDialog(null, "are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                setVisible(false);
                new login();
            }
        } else {
            setVisible(false);
            new Dashboard(username);
        }
    }

    public static void main(String[] args) {
        // new DeleteDetails();
    }
}
