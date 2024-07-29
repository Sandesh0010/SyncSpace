import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
public class JPasswordField extends javax.swing.JPasswordField{
   
    private Shape shape;
    private String hint;

    public JPasswordField(String hint){
        super();
        this.hint = hint;
        setFont(new Font("Sergeo UI",Font.BOLD,20));
        setOpaque(false);
        setText(hint);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createEmptyBorder(TOP,20,BOTTOM,20));
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(getText().equals(hint)){
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(getText().equals("")){
                    setText(hint);
                    setForeground(Color.LIGHT_GRAY);
                }
                
            }
        });
    }

    //for rounded courners
    protected void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillRoundRect(0,0,getWidth(), getHeight(), 45, 45);
        super.paintComponent(g);
    }

    //for rounded border
    protected void paintBorder(Graphics g){
        g.setColor(Color.white);
        g.drawRoundRect(0,0,getWidth(), getHeight(), 45, 45);
    }

    public boolean contains(int x, int y){
        if(shape == null || shape.getBounds().equals(getBounds())){
            shape = new RoundRectangle2D.Float(0,0,getWidth(),getHeight(),45,45);
        }
        return shape.contains(x,y);
    }

}
