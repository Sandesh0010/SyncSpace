import java.awt.*;
import javax.swing.*;

public class Userpage {
    static Database database;
    Userpage(User user){
        database = new Database();
        JFrame frame = new JFrame("HomePage for User");
        frame.setSize(900,625);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());;

        //sidebar ko lagi
        JPanel sideBar = new JPanel();
        sideBar.setBackground(Color.decode("#2f4f7f"));
        Dimension sideBarDim = new Dimension(200,1000);


        frame.setVisible(true);
        frame.requestFocus();

    }
}
