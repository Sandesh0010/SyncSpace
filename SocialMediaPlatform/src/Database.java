
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;
public class Database{
   
        String URL = "jdbc:mysql://localhost:3306/social_media_platform";
        String db_user = "root";
        String db_password = "root";
        private Statement statement;
        User user;
        Connection conn;
        

    public Database(){
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
            }
             conn=DriverManager.getConnection(URL, db_user, db_password);
            
        } catch (SQLException e) {
       
           e.printStackTrace();
        }
    } 
    
    public void createUser(String firstName, String lastName, String email, String password) throws SQLException{
        //String insert= "INSERT into users (FirstName,LastName,Email,password) values ("+u.getFirstName()+","+u.getLastName()+","+u.getEmail()+","+u.getPassword()+");";
        PreparedStatement insertStatement= conn.prepareStatement("INSERT into users (FirstName,LastName,Email,Password) values (?,?,?,?)");
        insertStatement.setString(1, firstName);
        insertStatement.setString(2, lastName);
        insertStatement.setString(3, email);
        insertStatement.setString(4, password);
        insertStatement.executeUpdate();

    }

    public boolean checkloginUser(String email, String password) throws SQLException{
        PreparedStatement viewStatement = conn.prepareStatement("SELECT * from users");
        ResultSet rs = viewStatement.executeQuery();
        while (rs.next()) {
            if((email.equals(rs.getString("Email")))&&password.equals(rs.getString("Password"))){
                 user = new User();
                user.setID(rs.getInt("ID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                return true;
            }
        }
        return false; 
    }

    public boolean checkemail(String email) throws SQLException{
        PreparedStatement viewStatement = conn.prepareStatement("SELECT * from users");
        ResultSet rs = viewStatement.executeQuery();
        while (rs.next()) {
            if(email.equals(rs.getString("Email"))){
                return false;
            }
        }
        return true; 
    }

    public User getloginUser(String email, String password) throws SQLException{
        PreparedStatement viewStatement = conn.prepareStatement("SELECT * from users");
        ResultSet rs = viewStatement.executeQuery();
        user = new User();
        while (rs.next()) {
            if((email.equals(rs.getString("Email")))&&password.equals(rs.getString("Password"))){   
                user.setID(rs.getInt("ID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
            }
        }
        return user;
    }

    public void createPost(String post, User user,String time) throws SQLException{

            PreparedStatement postinsertStatement= conn.prepareStatement("INSERT into posts (Content,userID,DateTime) values (?,?,?)");
            postinsertStatement.setString(1, post);
            postinsertStatement.setInt(2, user.getID());
            postinsertStatement.setString(3, time);
            
            postinsertStatement.executeUpdate();
       
       
    }

    public ArrayList<User> getUsers() throws SQLException{
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement viewStatement = conn.prepareStatement("SELECT * from users");
        ResultSet rs = viewStatement.executeQuery();
        while (rs.next()) {
                User u = new User();
                u.setID(rs.getInt("ID"));
                u.setFirstName(rs.getString("FirstName"));
                u.setLastName(rs.getString("LastName"));
                u.setEmail(rs.getString("Email"));
                if(u.getID()!=user.getID())
                    users.add(u);
            }
        return users;
    }
    
    public Statement getStatement() {
        return statement;
    }
}
