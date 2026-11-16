import java.sql.Connection;
import java.sql.Statement;

public class BillDb {
	public static void main(String[] args) {
		try (Connection conn = DatabaseConnection.getConnection();
	             Statement stmt = conn.createStatement()) {
			String sql = """
	                CREATE TABLE IF NOT EXISTS BillTable (
	                    billId INTEGER PRIMARY KEY AUTOINCREMENT,
	                    customerId INTEGER NOT NULL,
	                    month INTEGER NOT NULL,
					   	year INTEGER NOT NULL,
					   	total REAL NOT NULL, 
					   	paid INTEGER NOT NULL
	                );""";
	            stmt.execute(sql);
	            System.out.println("Database created successfully.");
	            conn.close();
		} catch (Exception e) { e.printStackTrace(); }
	}
}
