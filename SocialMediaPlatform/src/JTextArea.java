import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;

public class JTextArea extends javax.swing.JTextArea {
    private String hint;
    public JTextArea(String hint, int textSize, int padding){
        super();
        this.hint = hint;
        setFont(new Font("Sergoe UI",Font.BOLD,textSize));
        setBackground(null);
        setText(hint);
        setForeground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createEmptyBorder(padding,padding,padding,padding));

        addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                if(getText().equals("")){
                    setText(hint);
                    setForeground(Color.LIGHT_GRAY);
                }
               }

            @Override
            public void focusGained(FocusEvent e) {
                if(getText().equals(hint)){
                    setText("");
                    setForeground(Color.BLACK);
                }
               }
            
        });
    }
    public JTextArea(String text, int textSize, Color color, int style){
        super();
        setFont(new Font("Sergoe UI",style,textSize));
        setText(text);
        setForeground(color);
        setEditable(false);
        setPreferredSize(new Dimension(1000, (int) getPreferredSize().getHeight()));

    }
    public boolean isEmpty(){
        return getText().equals(hint)||getText().equals("");
    }
}
