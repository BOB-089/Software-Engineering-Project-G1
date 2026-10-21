import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAO 
{
	private static final String INSERT_ORDER =
		"INSERT INTO OrderTable " +
		"(publicationName, customerId, day, month, year, publicationsAvailable) " +
		"VALUES (?, ?, ?, ?, ?, ?)";
	
	private static final String SELECT_BY_ID = "SELECT * FROM OrderTable WHERE orderId = ?";

	private static final String SELECT_ALL = "SELECT * FROM OrderTable";
		
//	CREATE ORDER
	public boolean addOrder(Order order) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(INSERT_ORDER)) {
			stmt.setString(1, order.getPublicationName());
			stmt.setInt(2, order.getCustomerId());
			stmt.setInt(3, order.getDay());
			stmt.setInt(4, order.getMonth());
			stmt.setInt(5, order.getYear());
			stmt.setBoolean(6, order.isPublicationsAvailable());
			int rowsInserted = stmt.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}
}
