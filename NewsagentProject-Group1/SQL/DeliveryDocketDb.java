import java.sql.Connection;
import java.sql.Statement;

public class DeliveryDocketDb {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            String sql = """
                CREATE TABLE IF NOT EXISTS DeliveryDocketTable (
                    deliveryDocketId INTEGER PRIMARY KEY AUTOINCREMENT,
                    areaCode INTEGER NOT NULL,
                    day INTEGER NOT NULL,
                    month INTEGER NOT NULL,
                    year INTEGER NOT NULL
                );""";
            stmt.execute(sql);
            String orderSql = """
                CREATE TABLE IF NOT EXISTS DeliveryDocketOrderTable (
                    deliveryDocketId INTEGER NOT NULL,
                    orderId INTEGER NOT NULL,
                    PRIMARY KEY (deliveryDocketId, orderId),
                    FOREIGN KEY (deliveryDocketId)
                        REFERENCES DeliveryDocketTable(deliveryDocketId)
                        ON DELETE CASCADE,
                    FOREIGN KEY (orderId)
                        REFERENCES OrderTable(orderId)
                );""";
            stmt.execute(orderSql);
            System.out.println("Database created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}