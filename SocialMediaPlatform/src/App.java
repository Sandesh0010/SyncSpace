import java.awt.*;
import javax.swing.*;

public class App {
    public static Color white = Color.CYAN;
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Social Media Platform");
        LoginPage loginPage = new LoginPage();
        frame.setSize(900,625);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(white);
        frame.setVisible(true);
        
    }
}
