import java.sql.Connection;
import java.sql.Statement;

public class DeliveryDocketDb {
	public static void main(String[] args) {
        try {
        	Connection conn = DatabaseConnection.getConnection();
            String sql = """
                CREATE TABLE IF NOT EXISTS DeliveryDocketTable (
                    deliveryDocketId INTEGER PRIMARY KEY NOT NULL,
                    areaCode INTEGER NOT NULL,
                    day INTEGER NOT NULL,
                    month INTEGER NOT NULL,
                    year INTEGER NOT NULL
                );""";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Database created successfully.");
            conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
