import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Userpage {
    static Database database;
    Userpage(User user){
        database = new Database();
        JFrame frame = new JFrame("HomePage for User");
        frame.setSize(900,625);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        //sidebar ko lagi
        JPanel sideBar = new JPanel();
        sideBar.setBackground(Color.RED);
        sideBar.setBackground(Color.decode("#2f4f7f"));
        Dimension sideBarDim = new Dimension(200,1000);
        sideBar.setPreferredSize(sideBarDim);
        sideBar.setMaximumSize(sideBarDim);
        sideBar.setMinimumSize(sideBarDim);
        sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));

        JPanel profile = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        profile.setBackground(Color.CYAN);
        profile.setMaximumSize(new Dimension(180,50));
        profile.setBackground(Color.white);
        sideBar.add(Box.createVerticalStrut(5));
        profile.add(new JLabel(user.getName(),20, Color.BLACK, Font.BOLD));
        sideBar.add(profile);

        sideBar.add(Box.createVerticalStrut(5));
        sideBar.add(new SideButton("Home", "post"));
        sideBar.add(Box.createVerticalStrut(5));
        sideBar.add(new SideButton("Post", "post"));
        sideBar.add(Box.createVerticalStrut(5));
        sideBar.add(new SideButton("Like", "like"));
        sideBar.add(Box.createVerticalStrut(5));
        sideBar.add(new SideButton("Comment", "comment"));
        sideBar.add(Box.createVerticalStrut(5));
        sideBar.add(new SideButton("Friends", "friend"));
        sideBar.add(Box.createVerticalStrut(5));

        frame.add(sideBar,BorderLayout.WEST);
      
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(null);

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.white);
        Dimension dimension = new Dimension(500,160);
        header.setPreferredSize(dimension);
        header.setMinimumSize(dimension);
        header.setMaximumSize(dimension);
        header.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JPanel north = new JPanel(new BorderLayout());
        north.setBackground(null);
        north.add(new JLabel("Home", 20, Color.black, Font.BOLD));
        header.add(north,BorderLayout.NORTH);

        JTextArea postIn = new JTextArea("Write Something on your Post?:....", 18, 20);
        header.add(new JScrollPane(postIn),BorderLayout.CENTER);

        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        south.setBackground(null);

        JButton postButton = new JButton("Post",35,20 );
        postButton.setPreferredSize(new Dimension(80,40));
        

        frame.setVisible(true);
        frame.requestFocus();

        

    }
}
