import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Comments {
    public Comments(){
        JFrame frame = new JFrame();
        frame.setSize(900,625);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        frame.add(new SideBar("xugam"),BorderLayout.EAST);
        frame.add(new JScrollPane(panel),BorderLayout.CENTER);
        frame.requestFocus();
        frame.setVisible(true);

    }
}
