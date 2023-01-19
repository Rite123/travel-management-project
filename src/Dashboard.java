import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    JButton addPersonalDetails, updatePersonalDetails, viewPersonalDetails, logout, checkPackages,
            bookPackages, viewPackages, toPay;
    String username;

    Dashboard(String user) {
        setBounds(0, 0, 450, 795);
        setLayout(null);
        username = user;

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 450, 65);
        p1.setBackground(new Color(51, 204, 255));
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/travel222.png"));
        Image i2 = i1.getImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(10, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("      Dashboard");
        heading.setBounds(95, 13, 300, 40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(51, 204, 255));
        p2.setBounds(0, 65, 450, 900);
        add(p2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(75, 20, 300, 50);
        addPersonalDetails.setForeground(new Color(51, 204, 255));
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(75, 90, 300, 50);
        updatePersonalDetails.setForeground(new Color(51, 204, 255));
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(75, 160, 300, 50);
        viewPersonalDetails.setForeground(new Color(51, 204, 255));
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        checkPackages = new JButton("Check Packages");
        checkPackages.setBounds(75, 230, 300, 50);
        checkPackages.setForeground(new Color(51, 204, 255));
        checkPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        bookPackages = new JButton("Book Packages");
        bookPackages.setBounds(75, 300, 300, 50);
        bookPackages.setForeground(new Color(51, 204, 255));
        bookPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookPackages.addActionListener(this);
        p2.add(bookPackages);

        viewPackages = new JButton("View Packages");
        viewPackages.setBounds(75, 370, 300, 50);
        viewPackages.setForeground(new Color(51, 204, 255));
        viewPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPackages.addActionListener(this);
        p2.add(viewPackages);

        // JButton viewHotels=new JButton("View Hotels");
        // viewHotels.setBounds(0,350,300,50);
        // viewHotels.setForeground(new Color(51, 204, 255));
        // viewHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        // p2.add(viewHotels);

        // JButton bookHotel=new JButton("Book Hotel");
        // bookHotel.setBounds(0,400,300,50);
        // bookHotel.setForeground(new Color(51, 204, 255));
        // bookHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        // p2.add(bookHotel);

        // JButton viewBookedHotel=new JButton("View Booked Hotel");
        // viewBookedHotel.setBounds(0,450,300,50);
        // viewBookedHotel.setForeground(new Color(51, 204, 255));
        // viewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        // p2.add(viewBookedHotel);

        toPay = new JButton("How to pay ?");
        toPay.setBounds(75, 440, 300, 50);
        toPay.setForeground(new Color(51, 204, 255));
        toPay.setFont(new Font("Tahoma", Font.PLAIN, 20));
        toPay.addActionListener(this);
        p2.add(toPay);

        logout = new JButton("Logout");
        logout.setBounds(75, 510, 300, 50);
        logout.setForeground(new Color(51, 204, 255));
        logout.setFont(new Font("Tahoma", Font.PLAIN, 20));
        logout.addActionListener(this);
        p2.add(logout);

        JLabel end = new JLabel("               contact@tavelsafe.com");
        end.setBounds(35, 600, 300, 40);
        end.setForeground(Color.BLUE);
        end.setFont(new Font("Tahoma", Font.PLAIN, 18));
        p2.add(end);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/istockphoto-1311219809-170667a.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(1300, 900, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel home = new JLabel(i6);
        home.setBounds(0, 0, 1600, 1000);
        add(home);

        JLabel name = new JLabel("TravelSafe\n  Services");
        name.setBounds(350, 100, 700, 40);
        name.setForeground(new Color(51, 204, 255));
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        home.add(name);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonalDetails) {
            new AddCustomer(username);
        } else if (ae.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);
        } else if (ae.getSource() == viewPersonalDetails) {
            new viewDetails(username);
        } else if (ae.getSource() == logout) {
            new DeleteDetails(username);
            setVisible(false);
            // new login();
        } else if (ae.getSource() == checkPackages) {
            new CheckPackage();
        } else if (ae.getSource() == bookPackages) {
            new BookPackage(username);
        } else if (ae.getSource() == viewPackages) {
            new ViewPackage(username);
        } else {
            new Pay();
        }
    }

    public static void main(String[] args) {
        // new Dashboard(user);
    }

}
