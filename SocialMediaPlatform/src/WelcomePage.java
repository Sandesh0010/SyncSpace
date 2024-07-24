import java.awt.*;

import javax.swing.*;

public class WelcomePage {
    public WelcomePage(){
        App frame = new App();
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(53, 84, 76, 84));
        panel.add(new JLabel("Welcome",40, Color.RED, Font.BOLD),BorderLayout.NORTH);
        JPanel center = new JPanel(new GridLayout(6,1,10,10));
        center.setBackground(null);
        center.setBorder(BorderFactory.createEmptyBorder(22,231,17,231));
    }
}
