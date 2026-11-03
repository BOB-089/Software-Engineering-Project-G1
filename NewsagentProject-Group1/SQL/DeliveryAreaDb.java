import java.sql.Connection;
import java.sql.Statement;

public class DeliveryAreaDb {
    public static void main(String[] args) {
        try {
        	Connection conn = DatabaseConnection.getConnection();
            String sql = """
                CREATE TABLE IF NOT EXISTS DeliveryAreaTable (
                    areaCode INTEGER PRIMARY KEY NOT NULL,
                    name TEXT NOT NULL
                );""";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Database created successfully.");
            conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}