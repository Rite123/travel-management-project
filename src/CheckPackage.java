import javax.swing.*;
import java.awt.*;
public class CheckPackage extends JFrame {


    CheckPackage()
    {
        setBounds(450,0,800,650);
        setLayout(null);


        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
        Image i5=i4.getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel traveller=new JLabel(i6);
        traveller.setBounds(50,0,200,300);
        add(traveller);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        Image i2=i1.getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel home2=new JLabel(i3);
        home2.setBounds(300,0,200,300);
        add(home2);

        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i8=i7.getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel home3=new JLabel(i9);
        home3.setBounds(550,0,200,300);
        add(home3);

        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icons/4.png"));
        Image i11=i10.getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT);
        ImageIcon i12=new ImageIcon(i11);
        JLabel home4=new JLabel(i12);
        home4.setBounds(50,320,200,300);
        add(home4);

        ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("icons/5.png"));
        Image i14=i13.getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT);
        ImageIcon i15=new ImageIcon(i14);
        JLabel home5=new JLabel(i15);
        home5.setBounds(300,320,200,300);
        add(home5);

        ImageIcon i16=new ImageIcon(ClassLoader.getSystemResource("icons/6.png"));
        Image i17=i16.getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT);
        ImageIcon i18=new ImageIcon(i17);
        JLabel home6=new JLabel(i18);
        home6.setBounds(550,320,200,300);
        add(home6);

        setVisible(true);
    }


    public static void main(String[] args) {
        new CheckPackage();
    }
}
