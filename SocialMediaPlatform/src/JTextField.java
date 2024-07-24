import java.awt.*;
public class JTextField extends javax.swing.JTextField{
   
    private Shape shape;
    private String hint;

    public JTextField(String hint){
        super();
        this.hint = hint;
        setFont(new Font("Sergeo UI",Font.BOLD,20));
        setOpaque(false);
        setText(hint);
        setForeground(Color.GRAY);
        
    }
}
