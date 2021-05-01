package connectDatabase;
import java.sql.Connection;
import java.sql.DriverManager;

public class koneksi {
	public static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project?useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}