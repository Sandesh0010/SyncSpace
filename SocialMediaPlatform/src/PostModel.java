
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PostModel{
    private int ID;
    private String content;
    private User user;
    private LocalDateTime dateTime;
    private ArrayList<Comment> comments;
    private ArrayList<User> likes;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
    
    public PostModel(){}

    public PostModel(String content, User user){
        this.content = content;
        this.user = user;
        dateTime = LocalDateTime.now();
        setDateTime(dateTime);
    }
    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }

    public ArrayList<Comment> getComments(){
        return comments;
    }

    public void setComments(ArrayList<Comment> comments){
        this.comments = comments;
    }

    public ArrayList<User> getLikes(){
        return likes;
    }

    public void setLikes(ArrayList<User> likes){
        this.likes = likes;
    }

    public String getDateTimeToString(){
        return dateTimeFormatter.format(dateTime);
    }
    public void setDateTimeFromToString(String dateTime){
        this.dateTime = LocalDateTime.parse(dateTime, dateTimeFormatter);

    }
}