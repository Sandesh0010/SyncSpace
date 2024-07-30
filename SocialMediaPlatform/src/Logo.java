import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class Logo extends JPanel{
    int x=200;
    int y=150;
    private Image commentImage;
    Logo(){
        super();
        try{
            commentImage= ImageIO.read(new File("./comment.png"));
                    }
                    catch(IOException e){
                        System.out.println(e);
                    }
                }
                    public void paintComponent (Graphics g){
                        super.paintComponent(g);
                        g.setColor(Color.red);
                        g.drawImage (commentImage,x, y, 90, 90,this);
                       
                    }  
                }
        
    
