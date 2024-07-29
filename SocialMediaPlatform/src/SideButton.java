import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;

public class SideButton extends JPanel {
    public SideButton(String text, String pic){
        super(new FlowLayout(FlowLayout.LEFT,10,10));
        setMaximumSize(new Dimension(180,50));
        setBackground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        add(new JLabel(text,20,Color.decode("#0f0f0f"),Font.BOLD));
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
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
