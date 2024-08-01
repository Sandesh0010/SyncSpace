import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Post extends JPanel{
    public Post(User user, PostModel post, Database database){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(Color.white);
        setBorder(BorderFactory.createEmptyBorder(15,15,15,25));

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(null);

        JLabel author = new JLabel(post.getUser().getName(), 20,Color.BLACK,Font.BOLD);
        header.add(author,BorderLayout.WEST);

        JLabel date = new JLabel(post.getDateToString(), 15, Color.lightGray, Font.PLAIN);
        header.add(date,BorderLayout.EAST);
        
        add(header);
        add(Box.createVerticalStrut(7));

        JPanel center = new JPanel(new FlowLayout(FlowLayout.LEADING));
        center.setBackground(null);
        JTextArea content = new JTextArea(post.getContent(),18,Color.BLACK, Font.PLAIN);
        center.add(content);
        add(center);
        add(Box.createVerticalStrut(7));

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(null);

        JPanel likes = new JPanel(new FlowLayout(FlowLayout.LEFT,13,13));
        likes.setBackground(null);
        ImageIcon icon = new ImageIcon("C:\\Users\\Home\\Downloads\\like.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(newimg);

        ImageIcon likedicon = new ImageIcon("C:\\Users\\Home\\Downloads\\liked.png");
        Image img1 = likedicon.getImage();
        Image likedimg = img1.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        ImageIcon likedImgIcon = new ImageIcon(likedimg);

        javax.swing.JLabel like = new javax.swing.JLabel(imgIcon);
        javax.swing.JLabel liked = new javax.swing.JLabel(likedImgIcon);
        like.setPreferredSize(new Dimension(50,50));
        liked.setPreferredSize(new Dimension(50,50));
        like.setVisible(true);
        liked.setVisible(false);
       
        like.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(new LikePost(user, post, database).isLiked(user, post)){
                    like.setVisible(false);
                    liked.setVisible(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
            
            
        });

        liked.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(new LikePost(user, post, database).removeLike(user, post)){
                    like.setVisible(true);
                    liked.setVisible(false);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
            
            
        });
        
        likes.add(like);
        likes.add(liked);

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
