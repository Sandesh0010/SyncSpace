import javax.swing.*;
import java.awt.*;
public class Friend extends JPanel{
    
    public Friend(){
        setLayout(new BorderLayout());
   //     setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.white);
        setBorder(BorderFactory.createEmptyBorder(15,15,15,25));

        JLabel author = new JLabel("User Name",20,Color.BLACK,Font.BOLD);
        add(author,BorderLayout.WEST);

       

        JPanel right = new JPanel(new FlowLayout(FlowLayout.LEADING));
        right.setBackground(null);
        JButton addFriend = new JButton("Add", 35, 17);
        addFriend.setPreferredSize(new Dimension(81,37));
        right.add(addFriend);

        JLabel remove = new JLabel("Remove", 17, Color.blue, Font.BOLD);
        remove.setCursor(new Cursor(Cursor.HAND_CURSOR));
        remove.setVisible(false);
        right.add(remove);

        add(right,BorderLayout.EAST);

        Dimension dimension = new Dimension(500,90);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);

    }
}
