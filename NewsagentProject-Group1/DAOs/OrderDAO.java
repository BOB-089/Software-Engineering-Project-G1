import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAO 
{
	private static final String INSERT_ORDER =
		"INSERT INTO OrderTable " +
		"(publicationName, customerId, day, month, year) " +
		"VALUES (?, ?, ?, ?, ?)";
		
	public boolean addOrder(Order order) 
	{
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(INSERT_ORDER)) 
		{
//			stmt.setString(1, customer.getPublicationName());
//			stmt.setString(2, customer.getCustomerId());
//			stmt.setString(3, customer.getDay());
//			stmt.setString(4, customer.getMonth());
//			stmt.setString(5, customer.getYear());
//			int rowsInserted = stmt.executeUpdate();
//			return rowsInserted > 0;
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
