import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Alert;

public class CreateUser {
    private User u;
    private Database database;
    public CreateUser(User u, Database database){
        this.u=u;
        this.database=database;
        
    }
    public void create(){
        String insert= "INSERT into users (FirstName,LastName,Email,password) values ("+u.getFirstName()+","+u.getLastName()+","+u.getEmail()+","+u.getPassword()+");";
                try {
                    database.getStatement().execute(insert);
                } catch (SQLException e) {
                    new  Alert(null, e.getMessage(),null);
                    
                }
    }
    
    public boolean isEmailUsed() {
        String select="SELECT ID FROM users WHERE Email="+u.getEmail()+" ";
        boolean used=false;

        try {
            ResultSet rs=database.getStatement().executeQuery(select);
            rs.next();
            u.setID(rs.getInt("ID"));
        } catch (SQLException e) {
            new Alert(null, e.getMessage(),null);
            
        }
        
        
        return used;
    }
        public User getUser(){
            u.setComments(new ArrayList<>());
            u.setFriends(new ArrayList<>());
            u.setLikes(new ArrayList<>());
            u.setPosts(new ArrayList<>());
            String select="SELECT ID FROM users WHERE Email="+u.getEmail()+" AND Password="+u.getPassword()+" ";

        try {
            ResultSet rs=database.getStatement().executeQuery(select);
            rs.next();
            u.setID(rs.getInt("ID"));
        } catch (SQLException e) {
            new Alert(null, e.getMessage(),null);
            
        }
            
            return u;
        }

        

    }
    

