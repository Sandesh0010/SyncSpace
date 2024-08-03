import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;


public class CustomView {
    public CustomView(String view,String pic, User user, Database database) throws SQLException{
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
        north.add(new JLabel(view, 20, Color.black, Font.BOLD),BorderLayout.WEST);

        ImageIcon icon = new ImageIcon("C:\\Users\\Home\\Downloads\\home.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(newimg);
        
        javax.swing.JButton home = new javax.swing.JButton(imgIcon);
        home.setPreferredSize(new Dimension(40,40));
        
        home.setCursor(new Cursor(Cursor.HAND_CURSOR));

        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Userpage(user, database);
                frame.dispose();
            }
            
        });

        north.add(home,BorderLayout.EAST);
        header.add(north,BorderLayout.NORTH);

        panel.add(header);
        switch (view) {
            case "Friends":
               
                    ArrayList<User> users = database.getUsers(user);
                for(User u : users){
                    panel.add(Box.createVerticalStrut(7));
                    panel.add(new Friend(user,database,u));
                }
                break;
            
            
            default:
                break;
        }
        // for(int i=0;i<10;i++){
        //     panel.add(Box.createVerticalStrut(7));
        //     panel.add(new Friend());
        //         // if(i%2==0){
        //         //     panel.add(new Post());
        //         // }
        //         // else{
        //         //     panel.add(new Comment());
        //         // }

        // }

        frame.add(new JScrollPane(panel));
        frame.setVisible(true);
        frame.requestFocus();

    }
}
