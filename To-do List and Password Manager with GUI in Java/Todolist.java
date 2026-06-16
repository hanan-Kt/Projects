import java.util.Scanner;
import javax.swing.*;

public class Todolist {
    Scanner s = new Scanner(System.in);
    JFrame f = new JFrame();
    void show() {
        JFrame frame = new JFrame();
        JLabel label = new JLabel("To-Do List");
        JButton add = new JButton("Add task");

        add.setBounds(200, 200, 200, 200);
        label.setBounds(400, 400, 400, 200);

        frame.add(label);
        frame.add(add);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
}
