import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.*;

public class LoginPage {
    Database database;
    public LoginPage(){
        JFrame frame = new JFrame("Login Page");
        frame.setSize(900,625);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);

        database = new Database();

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(53, 84, 76, 84));
        panel.add(new JLabel("SyncSpace",40, Color.blue, Font.BOLD),BorderLayout.NORTH);
        JPanel center = new JPanel(new GridLayout(6,1,10,10));
        center.setBackground(null);
        center.setBorder(BorderFactory.createEmptyBorder(22,231,17,231));
        JTextField email = new JTextField("Email");
        center.add(email);
        JPasswordField password = new JPasswordField("Password");
        center.add(password);
        JButton login = new JButton(" Login!", 45, 20);
        center.add(login);

        login.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
                try {
                    if(database.checkloginUser(email.getText(), password.getText())){
                        new Alert("Success", frame);
                        User user = database.getloginUser(email.getText(), password.getText());
                        new Userpage(user,database);
                        frame.dispose();
                    }      
                    else{
                        new Alert("Invalid email or password", frame);
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
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

        panel.add(center,BorderLayout.CENTER);

        JLabel createNewAcc = new JLabel("Don't have an account?Create account.", 20, Color.black, Font.BOLD);
        
        
        createNewAcc.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createNewAcc.setHorizontalAlignment(JLabel.CENTER);

        createNewAcc.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new WelcomePage();
                frame.dispose();
                
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
        
        panel.add(createNewAcc,BorderLayout.SOUTH);

        frame.getContentPane().add(panel);

        frame.setVisible(true);
        frame.requestFocus();
    }
}
