import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadUserByID {
    private User user;
    public ReadUserByID(int ID, Database database) throws SQLException{
        PreparedStatement statement = database.conn.prepareStatement("Select * from users where ID = "+ID+";");
        ResultSet rs = statement.executeQuery();
        user = new User();
        rs.next();
        user.setID(ID);
        user.setFirstName(rs.getString("FirstName"));
        user.setLastName(rs.getString("LastName"));
        user.setEmail("Email");

    }
    
    public User getUser(){
        return user;
    }
}

