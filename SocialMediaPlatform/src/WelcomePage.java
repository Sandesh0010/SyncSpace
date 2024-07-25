import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class WelcomePage {
    public WelcomePage(){
        JFrame frame = new JFrame("Welcome Page");
        frame.setSize(900,625);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(53, 84, 76, 84));
        panel.add(new JLabel("SyncSpace",40, Color.blue, Font.BOLD),BorderLayout.NORTH);
        JPanel center = new JPanel(new GridLayout(6,1,10,10));
        center.setBackground(null);
        center.setBorder(BorderFactory.createEmptyBorder(22,231,17,231));
        JTextField firstName = new JTextField("First Name");
        center.add(firstName);
        JTextField lastName = new JTextField("Last Name");
        center.add(lastName);
        JTextField email = new JTextField("Email");
        center.add(email);
        JTextField password = new JTextField("Password");
        center.add(password);
        JTextField confirmPassword = new JTextField("Confirm Password");
        center.add(confirmPassword);
        JButton createAccount = new JButton("Create account", 45, 20);
        center.add(createAccount);

        createAccount.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(firstName.getText().equals("")){
                    new Alert("First Name cannot be empty", frame);
                    return;
                }
                if(lastName.getText().equals("")){
                    new Alert("Last Name cannot be empty", frame);
                    return;
                }
                if(email.getText().equals("")){
                    new Alert("Email field cannot be empty", frame);
                    return;
                }
                if(password.getText().equals("")){
                    new Alert("Password field cannot be empty", frame);
                    return;
                }
                if(password.getText().length()<8){
                    new Alert("Password must be at least 8 characters", frame);
                }
                if(password.getText()!=confirmPassword.getText()){
                    new Alert("Password and Confirm Password must match", frame);
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

        JLabel login = new JLabel("Already have an account? Login!", 20, Color.black, Font.BOLD);
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.setHorizontalAlignment(JLabel.CENTER);

        login.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginPage();
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
        
        panel.add(login,BorderLayout.SOUTH);

        frame.getContentPane().add(panel);

        frame.setVisible(true);
        frame.requestFocus();
    }
}
