
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
        
        javax.swing.JLabel img = new javax.swing.JLabel(new ImageIcon("pics/"+pic+".png"));
        add(new JLabel(text,20,Color.decode("#0f0f0f"),Font.BOLD));
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    new CustomView(text,user,database);
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
