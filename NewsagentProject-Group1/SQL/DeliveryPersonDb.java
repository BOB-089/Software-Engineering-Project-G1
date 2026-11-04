import java.sql.Connection;
import java.sql.Statement;

public class DeliveryPersonDb {
    public static void main(String[] args) {
        try {
        	Connection conn = DatabaseConnection.getConnection();
            String sql = """
                CREATE TABLE IF NOT EXISTS DeliveryPersonTable (
            		DeliveryPersonId INTEGER PRIMARY KEY AUTOINCREMENT,
                    firstName TEXT NOT NULL,
                    surname TEXT NOT NULL,
                    phoneNumber TEXT NOT NULL,
                    areaCode INTEGER NOT NULL
                );""";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Database created successfully.");
            conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}