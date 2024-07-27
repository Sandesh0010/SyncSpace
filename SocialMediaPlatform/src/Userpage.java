import java.awt.*;
import javax.swing.*;

public class Userpage {
    static Database database;
    Userpage(User user){
        database = new Database();
        JFrame frame = new JFrame("Welcome Page");
        frame.setSize(900,625);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());;



        frame.setVisible(true);
        frame.requestFocus();

    }
}
