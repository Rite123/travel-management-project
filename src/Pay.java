import javax.swing.*;
import java.awt.*;

public class Pay extends JFrame {
    Pay()
    {
        setBounds(450,0,850,400);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);

        JLabel text=new JLabel("Payment Methods");
        text.setForeground(new Color(51, 204, 255));
        text.setFont(new Font("Tahoma",Font.PLAIN,25));
        text.setBounds(30,0,300,30);
        add(text);



        JLabel lblusername=new JLabel("1)Using UPI ID: ");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        JButton addPersonalDetails=new JButton("Pay");
        addPersonalDetails.setBounds(150,100,200,50);
        addPersonalDetails.setForeground(new Color(51, 204, 255));
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(addPersonalDetails);

        JLabel d=new JLabel("1)Using Online Banking(NEFT): ");
        d.setFont(new Font("Tahoma",Font.PLAIN,20));
        d.setBounds(30,200,300,25);
        add(d);

        JButton p=new JButton("Pay");
        p.setBounds(150,250,200,50);
        p.setForeground(new Color(51, 204, 255));
        p.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(p);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/online-payment-cartoon-flat-vector-25767706.jpeg"));
        Image i2=i1.getImage().getScaledInstance(430, 380, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel home2=new JLabel(i3);
        home2.setBounds(400,-10,400,400);
        add(home2);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Pay();
    }
}
