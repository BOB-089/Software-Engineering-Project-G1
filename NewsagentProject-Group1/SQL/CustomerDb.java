import java.sql.Connection;
import java.sql.Statement;

public class CustomerDb
{
    public static void main(String[] args)
    {
        try
        {
        	Connection conn = SQLiteConnection.getConnection();

            String sql = """
                CREATE TABLE IF NOT EXISTS CustomerTable (
                    customerId INTEGER PRIMARY KEY AUTOINCREMENT,
                    firstName TEXT NOT NULL,
                    surname TEXT NOT NULL,
                    address TEXT NOT NULL,
                    phoneNumber TEXT NOT NULL,
                    onHoliday INTEGER NOT NULL,
                    publicationsAvailable INTEGER NOT NULL,
                    areaCode INTEGER NOT NULL
                );""";

            Statement stmt = conn.createStatement();
            stmt.execute(sql);

            System.out.println("Database created successfully.");
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}