import java.awt.*;
import javax.swing.*;
public class SideBar extends JPanel {
    public SideBar(String username){
        JPanel sideBar = new JPanel(new BorderLayout());
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
        profile.add(new JLabel(username,20, Color.BLACK, Font.BOLD));
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
    }
}
