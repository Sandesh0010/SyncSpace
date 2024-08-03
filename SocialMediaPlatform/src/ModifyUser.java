import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.Border;

public class ModifyUser {
    Database database;
    public ModifyUser(User user){
        JFrame frame = new JFrame("Edit the user:");
        frame.setSize(900,625);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.lightGray);
        database = new Database();

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.white);
        Dimension dimension = new Dimension(200,50);
        header.setPreferredSize(dimension);
        header.setMaximumSize(dimension);
        header.setMinimumSize(dimension);
        header.setBorder(BorderFactory.createEmptyBorder(10,15,10,15));

        JPanel north = new JPanel(new BorderLayout());
        north.setBackground(null);
        north.add(new JLabel(user.getName(), 20, Color.black, Font.BOLD),BorderLayout.WEST);

        ImageIcon icon = new ImageIcon("C:\\Users\\Home\\Downloads\\home.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(newimg);
        
        javax.swing.JButton home = new javax.swing.JButton(imgIcon);
        home.setPreferredSize(new Dimension(40,40));
        
        home.setCursor(new Cursor(Cursor.HAND_CURSOR));

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Userpage(user, database);
                frame.dispose();
            }
        });
        north.add(home,BorderLayout.EAST);
        header.add(north,BorderLayout.NORTH);

        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(53, 84, 76, 84));
        panel.add(new JLabel("Edit your profile:",40, Color.blue, Font.BOLD),BorderLayout.NORTH);
        JPanel center = new JPanel(new GridLayout(5,1,10,10));
        center.setBackground(null);
        center.setBorder(BorderFactory.createEmptyBorder(22,231,17,231));
        JTextField firstName = new JTextField("First Name");
        center.add(firstName);
        JTextField lastName = new JTextField("Last Name");
        center.add(lastName);
        JPasswordField password = new JPasswordField("Password");
        center.add(password);
        JPasswordField confirmPassword = new JPasswordField("Confirm Password");
        center.add(confirmPassword);
        JButton createAccount = new JButton("Modify account", 45, 20);
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
                if(password.getText().equals("")){
                    new Alert("Password field cannot be empty", frame);
                    return;
                }
                if(password.getText().length()<8){
                    new Alert("Password must be at least 8 characters", frame);
                    return;
                }
                if(password.getText().equals(confirmPassword.getText())){
                    try {
                        database.modifyUser(firstName.getText(),lastName.getText(),password.getText(),user);
                        new Alert("Modification Successful. Go to login.", frame);
                        
                    }
                    catch(SQLException e1){}
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

        
        frame.getContentPane().add(header,BorderLayout.NORTH);
        frame.getContentPane().add(panel,BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.requestFocus();
    }
}
