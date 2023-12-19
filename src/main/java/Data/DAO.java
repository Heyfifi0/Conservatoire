package Data;
import java.sql.*;
/**
 *
 * @author miste
 */
public class DAO {
    
    private static Connection connection;
    private static Statement statement;
    
    static {

        String url = "jdbc:mysql://localhost:3307/Conservatoire";
        String loginBd = "root";
        String passwd = "";
        
        try {
            connection = DriverManager.getConnection(url,loginBd,passwd);
            statement = connection.createStatement();
        } catch(SQLException e){
            System.out.println("SQL Exception : " + e);
        }
    }
    
    public static Statement getStatement(){
        return statement;
    }
    public static Connection getConnection() {
        return connection;
    }
}
