package Classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static String BDD = "tpjee";
	static String url = "jdbc:mysql://localhost:3306/" + BDD 
	 + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static String user = "root";
	static String passwd = "";
	
    private static Connection conn = null;
    
    public static Connection getConn() throws SQLException{
    	
    	
    	if(conn == null) {
    		
    		conn = DriverManager.getConnection(url, user, passwd);
    	   
    	}
    	 
		return conn;
		
	}
	
	
}
