
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
        String db_password = "sugam@123";
        //String db_password = "root";
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

    public void modifyUser(String firstName, String lastName, String password, User user) throws SQLException{
        //String insert= "INSERT into users (FirstName,LastName,Email,password) values ("+u.getFirstName()+","+u.getLastName()+","+u.getEmail()+","+u.getPassword()+");";
        PreparedStatement insertStatement= conn.prepareStatement("Update users set FirstName = ?,LastName = ?,Password = ? where ID = "+user.getID()+";");
        insertStatement.setString(1, firstName);
        insertStatement.setString(2, lastName);
        insertStatement.setString(3, password);
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
                user.setPassword(rs.getString("Password"));

                PreparedStatement arrayStatement = conn.prepareStatement("SELECT * from friends where user ="+ user.getID());
                ResultSet rs2 = arrayStatement.executeQuery();
                ArrayList<Integer> friendsID = new ArrayList<>();
                while (rs2.next()) {
                    friendsID.add(rs2.getInt("Friend"));
                }
                user.setFriendsIDs(friendsID);
                
                PreparedStatement likepostStatement = conn.prepareStatement("Select * from likes where userID = "+user.getID()+";");
                ResultSet rs3 = likepostStatement.executeQuery();
                ArrayList<Integer> likedPostsIDs = new ArrayList<>();
                while (rs3.next()) {
                    likedPostsIDs.add(rs3.getInt("postID"));
                }
                user.setLikesIDs(likedPostsIDs);

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

    public ArrayList<User> getUsers(User user) throws SQLException{
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

    public boolean addFriend(User user, User f){
         try {
         PreparedStatement addFriendStatement= conn.prepareStatement("INSERT into friends (User,Friend) values (?,?)");
            addFriendStatement.setInt(1, user.getID());
            addFriendStatement.setInt(2, f.getID());
            addFriendStatement.executeUpdate();
            return true;
        } catch (SQLException e) { return false;}
    }

    public boolean removeFriend(User user, User f){
        try {
        PreparedStatement removeFriendStatement= conn.prepareStatement("Delete from friends where User = ? AND Friend = ?;");
           removeFriendStatement.setInt(1, user.getID());
           removeFriendStatement.setInt(2, f.getID());
           removeFriendStatement.executeUpdate();
           return true;
       } catch (SQLException e) { return false;}
   }
    
    public boolean likePost(User user, PostModel post){
        boolean liked = false;
        try {
            PreparedStatement likePostStatement = conn.prepareStatement("INSERT into likes (userID,postID) values(?,?)");
            likePostStatement.setInt(1, user.getID());
            likePostStatement.setInt(2, post.getID());
            likePostStatement.executeUpdate();
            liked = true;

        } catch (SQLException e) {
            liked = false;
            e.printStackTrace();
        }
        return liked;
        
    } 

    public boolean removelikePost(User user,PostModel post){
        boolean liked = false;
        try {
            PreparedStatement likePostStatement = conn.prepareStatement("Delete from likes where userID = ? AND postID = ?;");
            likePostStatement.setInt(1, user.getID());
            likePostStatement.setInt(2, post.getID());

            likePostStatement.executeUpdate();
            liked = true;
        } catch (SQLException e) {
            liked = false;
            e.printStackTrace();
        }
        return liked;
    }

    public int likeCount(PostModel post){
        int likeCount = 0;
        try {
            PreparedStatement likeCountStatement = conn.prepareStatement("Select Count(userID) as count from likes where postID = "+post.getID());
            ResultSet rs = likeCountStatement.executeQuery();
            while (rs.next()) {
                likeCount = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likeCount;
    }

    public void createComment(User user, PostModel post, String content,String dateTime ) throws SQLException{
        PreparedStatement createComStatement = conn.prepareStatement("Insert into comments(Content,postID,userID,DateTime,userName) values(?,?,?,?,?)");
        createComStatement.setString(1, content);
        createComStatement.setInt(2, post.getID());
        createComStatement.setInt(3, user.getID());
        createComStatement.setString(4, dateTime);
        createComStatement.setString(5, user.getName());

        createComStatement.executeUpdate();
    }
    public ArrayList<CommentModel> readPostComments(PostModel p) throws SQLException{
        ArrayList<CommentModel> cmt = new ArrayList<>();
        PreparedStatement getComStatement = conn.prepareStatement("Select * from comments where postID ="+p.getID());
        ResultSet rs = getComStatement.executeQuery();
        while (rs.next()) {
            CommentModel commentModel = new CommentModel();
            commentModel.setID(rs.getInt("ID"));
            commentModel.setContent(rs.getString("Content"));
            commentModel.setDateTimeFromToString(rs.getString("DateTime"));
            commentModel.setUser(rs.getInt("userID"));
            commentModel.setpostID(rs.getInt("postID"));
            commentModel.setuserName(rs.getString("userName"));
            cmt.add(commentModel);
        }
        return cmt;
        
    }

    public int getCommentCount(PostModel p){
        int comments = 0;
        try {
            PreparedStatement getComStatement = conn.prepareStatement("Select count(ID) as count from comments where postID = "+p.getID());
        ResultSet rs = getComStatement.executeQuery();
        while (rs.next()) {
            comments = rs.getInt("count");
        }
        } catch (Exception e) { }
        
        return comments;
    }
    public Statement getStatement() {
        return statement;
    }
}
