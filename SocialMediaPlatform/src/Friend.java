import javax.swing.*;
import java.awt.*;
public class Friend extends JPanel{
    
    public Friend(User mainUser, User u){
        setLayout(new BorderLayout());
   //     setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.white);
        setBorder(BorderFactory.createEmptyBorder(25,15,15,25));

        JLabel author = new JLabel(u.getFirstName()+' '+u.getLastName(),20,Color.BLACK,Font.BOLD);
        add(author,BorderLayout.WEST);

       

        JPanel right = new JPanel(new FlowLayout(FlowLayout.LEADING));
        right.setBackground(null);
        JButton addFriend = new JButton("Add", 35, 17);
        addFriend.setPreferredSize(new Dimension(81,37));
        addFriend.setVisible(false);
        right.add(addFriend);

        JLabel remove = new JLabel("Remove", 17, Color.blue, Font.BOLD);
        remove.setCursor(new Cursor(Cursor.HAND_CURSOR));
        remove.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        remove.setVisible(false);
        right.add(remove);

        if(mainUser.isFriend(u)){
            addFriend.setVisible(false);
            remove.setVisible(true);

        }else{
            remove.setVisible(false);
            addFriend.setVisible(true);

        }


        add(right,BorderLayout.EAST);

        Dimension dimension = new Dimension(500,90);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);

    }
}
