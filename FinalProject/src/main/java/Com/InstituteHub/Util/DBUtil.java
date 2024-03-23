package Com.InstituteHub.Util;
import java.sql.*;

public class DBUtil {
	private static final String URL = "jdbc:postgresql://localhost:5432/InstituteHub";
	private static final String USERNAME = "postgres";
    private static final String PASSWORD = "viveksutar21";
    
    static {
    		try {
    			 Class.forName("org.postgresql.Driver");

    		}catch(ClassNotFoundException e){
    			e.printStackTrace();
    		}
    	}
    public static Connection getConnection() throws SQLException{
    	System.out.println("Connection Build...");
    	return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}

