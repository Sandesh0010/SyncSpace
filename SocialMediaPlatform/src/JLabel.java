import java.awt.Color;
import java.awt.Font;
public class JLabel extends javax.swing.JLabel {
    public JLabel(String text, int textSize, Color color, int style){
        setFont(new Font("Sergoe UI", style, textSize));
        setText(text);
        setForeground(color);
    }
}
