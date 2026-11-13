import java.sql.Connection;
import java.sql.Statement;

public class PublicationDb {
    public static void main(String[] args) {
        try {
        	Connection conn = DatabaseConnection.getConnection();
            String sql = """
                CREATE TABLE IF NOT EXISTS PublicationTable (
                    publicationId INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    stock INTEGER NOT NULL,
                    price DOUBLE NOT NULL
                );""";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Database created successfully.");
            conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}