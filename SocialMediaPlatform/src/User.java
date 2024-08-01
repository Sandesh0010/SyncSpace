import java.util.ArrayList;
public class User {
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private ArrayList<PostModel> posts;
    private ArrayList<Comment> comments;
    private ArrayList<PostModel> likes;
    private ArrayList<User> friends;
    private ArrayList<Integer> friendID;
    private ArrayList<Integer> likesIDs;

    
    public User(){
        posts = new ArrayList<>();
        comments = new ArrayList<>();
        likes = new ArrayList<>();
        friends = new ArrayList<>();
        friendID = new ArrayList<>();
        likesIDs = new ArrayList<>();

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

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getName(){
        return firstName + " " + lastName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public ArrayList<Integer> getLikesIDs(){
        return likesIDs;
    }
    public void se

    public ArrayList<PostModel> getPosts(){
        return posts;
    }

    public void setPosts(ArrayList<PostModel> posts){
        this.posts = posts;
    }

    public ArrayList<Comment> getComments(){
        return comments;
    }

    public void setComments(ArrayList<Comment> comments){
        this.comments = comments;
    }

    public ArrayList<PostModel> getLikes(){
        return likes;
    }

    public void setLikes(ArrayList<PostModel> likes){
        this.likes = likes;
    }

    public ArrayList<User> getFriends(){
        return friends;
    }

    public void setFriends(ArrayList<User> friends){
        this.friends = friends;
        friendID = new ArrayList<>();
        for(User u : friends){
            friendID.add(u.getID());
        }
    }

    public void setFriendsIDs(ArrayList<Integer> friendsIDs){
        this.friendID = friendsIDs;
    }
    
    public ArrayList<Integer> getFriendIDs(){
        return friendID;
    }

    public boolean isFriend(User u){
        return friendID.contains(u.getID());
    }

    public void addFriend(User f){
        friends.add(f);
        friendID.add(f.getID());
    }
    public void removeFriend(User f){
        friends.remove(f);
        friendID.remove((Integer)f.getID());
    }

}
