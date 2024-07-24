import java.util.ArrayList;
public class User {
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private ArrayList<Post> posts;
    private ArrayList<Comment> comments;
    private ArrayList<Post> likes;
    private ArrayList<User> friends;
    
    public User(){

    }

    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }
    
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }


}
