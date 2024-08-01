
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.*;

//import javax.swing.JLabel;
import javax.swing.*;

public class SideButton extends JPanel {
    public SideButton(String text, String pic, User user, Database database, JFrame f){
        super(new FlowLayout(FlowLayout.LEFT,10,10));
        setMaximumSize(new Dimension(180,50));
        setBackground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ImageIcon icon = new ImageIcon("C:\\Users\\Home\\Downloads\\"+pic+".png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(newimg);

        javax.swing.JLabel home = new javax.swing.JLabel(imgIcon);
        home.setPreferredSize(new Dimension(40,40));

        add(home, BorderLayout.WEST);
        add(new JLabel(text,20,Color.decode("#0f0f0f"),Font.BOLD),BorderLayout.EAST);
       
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    new CustomView(text,pic,user,database);
                    f.dispose();
                } catch (SQLException e1) {
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.lightGray);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.white);
            }
            
        });
    }
}
