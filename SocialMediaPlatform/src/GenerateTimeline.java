import java.sql.*;
import java.util.ArrayList;

public class GenerateTimeline {

    private ArrayList<PostModel> posts;
    public GenerateTimeline(User user, Database database){
        posts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(user.getFriendIDs().size()!=0){
            for(int i=0;i<user.getFriendIDs().size();i++){
                sb.append("userID = "+user.getFriendIDs().get(i));
                if(i!=user.getFriendIDs().size()-1){
                    sb.append(" OR ");
                }
                else{
                    sb.append(";");
                }
            }
            String select = "Select * from posts where "+sb.toString();
            //System.out.println(select);
            try {
                PreparedStatement selPreparedStatement = database.conn.prepareStatement(select);
                ResultSet rs = selPreparedStatement.executeQuery();
                ArrayList<Integer> usersIDs = new ArrayList<>();
                while (rs.next()) {
                    PostModel p = new PostModel();
                    p.setID(rs.getInt("ID"));
                    p.setContent(rs.getString("Content"));
                    usersIDs.add(rs.getInt("userID"));
                    p.setDateTimeFromToString(rs.getString("DateTime"));
                    posts.add(p);
                }
                for(int i=0; i<usersIDs.size();i++){
                    posts.get(i).setUser(new ReadUserByID(usersIDs.get(i), database).getUser());
                }

            } catch (SQLException e) {
                new Alert("GenerateTimeline", null);
            }
        }
    }
   public ArrayList<PostModel> getPosts(){
        return posts;
   } 
}
