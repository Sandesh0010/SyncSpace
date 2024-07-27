
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Database{
   
        String URL = "jdbc:mysql://localhost:3306/social_media_platform";
        String db_user = "root";
        String db_password = "root";
        private Statement statement;
        Connection conn;
        

    public Database(){
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
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

    public User loginUser(String email, String password) throws SQLException{
        User user = new User();
        PreparedStatement viewStatement = conn.prepareStatement("SELECT * from users");
        ResultSet rs = viewStatement.executeQuery();
        while (rs.next()) {
            if((email.equals(rs.getString("Email")))&&password.equals(rs.getString("Password"))){
                user.setID(rs.getInt("ID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                new Userpage(user);
            }
           
           
        }

        return user;
    }


    public Statement getStatement() {
        return statement;
    }
}
