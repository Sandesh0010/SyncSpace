
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CommentModel{
    private int ID;
    private String content;
    private int userID;
    private String userName;
    private int postID;
    private LocalDateTime dateTime;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    //private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy");
    public CommentModel(){

    }
    public CommentModel(String content, User user){
        this.userID = user.getID();
        this.content = content;
        this.userName = user.getName();
        dateTime = LocalDateTime.now();
    }

    public String getuserName(){
        return userName;
    }
    public void setuserName(String userName){
        this.userName = userName;
    }

    public CommentModel(PostModel post, User user){ 
        this.userID = user.getID();
        this.postID = post.getID();
    }

    public int getpostID(){
        return postID;
    }
    public void setpostID(int postID){
        this.postID = postID;
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

    public int getUser(){
        return userID;
    }

    public void setUser(int userID){
        this.userID = userID;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }
    public String getDateTimeToString(){
        return dateTimeFormatter.format(dateTime);
    }
    public void setDateTimeFromToString(String dateTime){
        this.dateTime = LocalDateTime.parse(dateTime, dateTimeFormatter);
    }
    
}
