package login;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static final String DB_URL = "jdbc:mysql://localhost:3306/demo";
    static final String USER = "root";
    static final String PASS = "";
    
    public static Connection connectDB(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database.");
            return conn;
            
        }catch(Exception ex){
            System.out.println("There were errors while connect to db.");
            return null;
        }
    }
}
