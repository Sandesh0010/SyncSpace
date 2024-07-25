import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Alert {
    public Alert(String content, JFrame parent){
        JFrame frame = new JFrame();
        frame.setSize(430,170);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel(new BorderLayout(5,5));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(Color.WHITE);

        JLabel title = new JLabel("Alert",24, Color.blue, Font.BOLD);
        title.setHorizontalAlignment(JLabel.CENTER);
        panel.add(title, BorderLayout.NORTH);

        JLabel msg = new JLabel(content, 15, Color.black, Font.BOLD);
        msg.setHorizontalAlignment(JLabel.CENTER);
        panel.add(msg,BorderLayout.CENTER);

       frame.getContentPane().add(panel);
       frame.setLocationRelativeTo(parent);
       frame.setVisible(true);

    }
}
