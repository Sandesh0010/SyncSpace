import javax.swing.*;
import java.awt.*;
public class Comment extends JPanel{
    
    public Comment(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.white);
        setBorder(BorderFactory.createEmptyBorder(15,15,15,25));

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(null);

        JLabel author = new JLabel("User Name",20,Color.BLACK,Font.BOLD);
        header.add(author,BorderLayout.WEST);
        add(header);

        JPanel center = new JPanel(new FlowLayout(FlowLayout.LEADING));
        center.setBackground(null);
        JTextArea content = new JTextArea("Comment something lekhdiyee", 18, Color.BLACK,Font.PLAIN);
        center.add(content);
        add(center);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(null);
        bottom.add(new JLabel("Thu, 0 Jan 2024", 15, Color.lightGray, Font.PLAIN));
        add(bottom);

        int height = (int) (90 + content.getPreferredSize().getHeight());

        Dimension dimension = new Dimension(500,height);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);

    }
    

}
