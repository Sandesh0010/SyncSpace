import java.util.ArrayList;

public class GenerateTimeline {

    private ArrayList<Post> posts;
    public GenerateTimeline(User user, Database database){
        posts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(user.getFriendIDs().size()!=0){
            for(int i=0;i<user.getFriendIDs().size();i++){
                sb.append("User"+user.getFriendIDs().get(i));
                if(i!=user.getFriendIDs().size()-1){
                    sb.append("OR");
                }
                else{
                    sb.append(";");
                }
            }
        }
    }
   public ArrayList<Post> getPosts(){
        return posts;
   } 
}
