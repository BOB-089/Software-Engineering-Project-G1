import java.sql.Connection;
import java.sql.Statement;

public class NewsagentDb {
	public static void main(String[] args)
    {
        try
        {
        	Connection conn = DatabaseConnection.getConnection();

            String sql = """
                CREATE TABLE IF NOT EXISTS NewsagentTable (
                    newsagentID INTEGER PRIMARY KEY AUTOINCREMENT,
                    firstName TEXT NOT NULL,
                    surname TEXT NOT NULL,
                    phoneNumber TEXT NOT NULL
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
