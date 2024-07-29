import javax.swing.*;
import java.awt.*;

public class Post extends JPanel{
    public Post(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(Color.white);
        setBorder(BorderFactory.createEmptyBorder(15,15,15,25));

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(null);

        JLabel author = new JLabel("User Name", 20,Color.BLACK,Font.BOLD);
        header.add(author,BorderLayout.WEST);

        JLabel date = new JLabel("Thu, 0 Jan 2024", 15, Color.lightGray, Font.PLAIN);
        header.add(date,BorderLayout.EAST);
        
        add(header);
        add(Box.createVerticalStrut(7));

        JPanel center = new JPanel(new FlowLayout(FlowLayout.LEADING));
        center.setBackground(null);
        JTextArea content = new JTextArea("sdsadjsdkldadsjdkddksladkjdksadkasdksdakldldadklsadkdsakddkjsadkakaskdklasd",18,Color.BLACK, Font.PLAIN);
        center.add(content);
        add(center);
        add(Box.createVerticalStrut(7));

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(null);

        JPanel likes = new JPanel(new FlowLayout(FlowLayout.LEFT,13,13));
        likes.setBackground(null);
        likes.add(new javax.swing.JLabel(new ImageIcon("pics/like.png")));
        likes.add(new JLabel("0 likes", 15, Color.lightGray, Font.BOLD));
        bottom.add(likes,BorderLayout.WEST);
        JLabel comments = new JLabel("0 comments", 15, Color.lightGray,Font.BOLD);
        bottom.add(comments,BorderLayout.EAST);
        add(bottom);

        int height = (int) (115+content.getPreferredSize().getHeight());

        Dimension dimension = new Dimension(500,height);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);


    }
}
