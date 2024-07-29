import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.crypto.Data;

public class Comments {
    public Comments(User user, Database database){
        JFrame frame = new JFrame();
        frame.setSize(900,625);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //sidebar
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
        profile.add(new JLabel("ReDflag",20, Color.BLACK, Font.BOLD));
        sideBar.add(profile);

        sideBar.add(Box.createVerticalStrut(5));
        sideBar.add(new SideButton("Home", "post",user,database));
        sideBar.add(Box.createVerticalStrut(5));
        sideBar.add(new SideButton("Post", "post",user,database));
        sideBar.add(Box.createVerticalStrut(5));
        sideBar.add(new SideButton("Like", "like",user,database));
        sideBar.add(Box.createVerticalStrut(5));
        sideBar.add(new SideButton("Comment", "comment",user,database));
        sideBar.add(Box.createVerticalStrut(5));
        sideBar.add(new SideButton("Friends", "friend",user,database));
        sideBar.add(Box.createVerticalStrut(5));

        frame.add(sideBar,BorderLayout.WEST);
        //end
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(null);

        panel.add(new Post());
        panel.add(Box.createVerticalStrut(7));

        JPanel newComment = new JPanel(new BorderLayout());
        newComment.setBackground(Color.white);
        Dimension dimension = new Dimension(500,60);
        newComment.setPreferredSize(dimension);
        newComment.setMaximumSize(dimension);
        newComment.setMinimumSize(dimension);
        newComment.setBorder(BorderFactory.createEmptyBorder(10,10,10,15));
        
        JTextArea commentIn = new JTextArea("Type a Comment",18 ,5 );
        newComment.add(new JScrollPane(commentIn),BorderLayout.CENTER);

        JButton commetBtn = new JButton("Post", 35, 16);
        commetBtn.setPreferredSize(new Dimension(80,37));
        newComment.add(commetBtn,BorderLayout.EAST);

        panel.add(newComment);
        panel.add(Box.createVerticalStrut(7));

        for(int i =0;i<10;i++){
            panel.add(new Comment());
            panel.add(Box.createVerticalStrut(7));
        }
       
        frame.add(new JScrollPane(panel),BorderLayout.CENTER);
        frame.requestFocus();
        frame.setVisible(true);

    }
}
