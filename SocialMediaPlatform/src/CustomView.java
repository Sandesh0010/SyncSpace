import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustomView {
    public CustomView(){
        JFrame frame = new JFrame();
        frame.setSize(900,625);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(null);

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.white);
        Dimension dimension = new Dimension(500,50);
        header.setPreferredSize(dimension);
        header.setMaximumSize(dimension);
        header.setMinimumSize(dimension);
        header.setBorder(BorderFactory.createEmptyBorder(10,15,10,15));

        JPanel north = new JPanel(new BorderLayout());
        north.setBackground(null);
        north.add(new JLabel("My comments", 20, Color.black, Font.BOLD),BorderLayout.WEST);
        javax.swing.JLabel home = new javax.swing.JLabel(new ImageIcon("pics/home.png"));
        home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        north.add(home,BorderLayout.EAST);
        header.add(north,BorderLayout.NORTH);

        panel.add(header);
        for(int i=0;i<10;i++){
            panel.add(Box.createVerticalStrut(7));
                if(i%2==0){
                    panel.add(new Post());
                }
                else{
                    panel.add(new Comment());
                }
        }

        frame.add(new JScrollPane(panel));
        frame.setVisible(true);
        frame.requestFocus();

    }
}
