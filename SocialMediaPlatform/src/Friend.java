import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Friend extends JPanel{
    
    public Friend(User mainUser,Database database, User u){ 
        setLayout(new BorderLayout());
   //     setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.white);
        setBorder(BorderFactory.createEmptyBorder(25,15,15,25));

        JLabel author = new JLabel(u.getFirstName()+' '+u.getLastName(),20,Color.BLACK,Font.BOLD);
        add(author,BorderLayout.WEST);

       
        JPanel right = new JPanel(new FlowLayout(FlowLayout.LEADING));
        right.setBackground(null);
        JButton addFriend = new JButton("Follow", 35, 17);
        addFriend.setPreferredSize(new Dimension(81,37));
        addFriend.setVisible(false);
       
        right.add(addFriend);

        JLabel remove = new JLabel("Unfollow", 17, Color.blue, Font.BOLD);
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

        addFriend.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(database.addFriend(mainUser,u))
                {
                    mainUser.addFriend(u);
                    addFriend.setVisible(false);
                    remove.setVisible(true);
                }
                   

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });

        remove.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(database.removeFriend(mainUser,u))
                {
                    mainUser.removeFriend(u);
                    addFriend.setVisible(true);
                    remove.setVisible(false);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });

        add(right,BorderLayout.EAST);

        Dimension dimension = new Dimension(500,90);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);

    }
}
