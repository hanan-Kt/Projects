import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
public class PasswordManager extends JFrame {
    void more() {
    Scanner s = new Scanner(System.in);
    JFrame jf= new JFrame();
    
    JLabel label = new JLabel("Password Manager");
    label.setBounds(100,100,100,100);
    
    JButton show =new JButton("Show Passwords");
    show.setBounds(50,50,50,50);
    show.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
           System.out.println("Passwords are saved here");
          }
    });

    JButton back = new JButton("Go Back");
    back.setBounds(50,50,50,50);
    back.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        System.out.println("Cannot go back bob");
      }
    });

    JButton add= new JButton("Add password");
    add.setBounds(50,50,50,50);
    add.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent aeadd) {
            System.out.println("What do you want to add?");
        }
    });

    JButton remove = new JButton("Remove");
    remove.setBounds(50,50,50,50);

    jf.add(label);
    jf.add(show);
    jf.add(add);
    jf.add(remove);
    jf.add(back);
    jf.setSize(500, 500);
    jf.setLayout(null);
    jf.setVisible(true);
    }
}
