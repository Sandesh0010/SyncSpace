
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Database{
   
        String URL = "jdbc:mysql://localhost:3306/social_media_platform";
        String db_user = "root";
        String db_password = "root";
        private Statement statement;
        

    public Database(){
        try {
            Connection conn=DriverManager.getConnection(URL, db_user, db_password);
            statement=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
       
           e.printStackTrace();
        }
    } 
    
    public Statement getStatement() {
        return statement;
    }
}
