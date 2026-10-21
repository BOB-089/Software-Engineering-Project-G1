import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO 
{
	private static final String INSERT_ORDER =
		"INSERT INTO OrderTable " +
		"(publicationName, customerId, day, month, year, publicationsAvailable) " +
		"VALUES (?, ?, ?, ?, ?, ?)";
	
	private static final String SELECT_BY_ID = "SELECT * FROM OrderTable WHERE orderId = ?";

	private static final String SELECT_ALL = "SELECT * FROM OrderTable";
	
	private static final String UPDATE_ORDER = "UPDATE OrderTable " + 
			"SET publicationName=?, customerId=?, day=?, month=?, year=?, publicationsAvailable=? " + 
			"WHERE orderId=?";
	
	private static final String DELETE_ORDER = "DELETE FROM OrderTable WHERE orderId=?";
		
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
	
//	FIND CUSTOMER BY ID
	public Order findOrderById(int orderId) {
		Order order = null;
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
			stmt.setInt(1, orderId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				order = new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setPublicationName(rs.getString("publicationName"));
				order.setCustomerId(rs.getInt("customerId"));
				order.setDay(rs.getInt("day"));
				order.setMonth(rs.getInt("month"));
				order.setYear(rs.getInt("year"));
				order.setPublicationsAvailable(rs.getBoolean("publicationsAvailable"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return order;
	}
	
//	GET ALL ORDERS
	public ArrayList<Order> getAllOrderss() {
		ArrayList<Order> orders = new ArrayList<>();
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
		ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Order order = new Order();
				order.setCustomerId(rs.getInt("customerId"));
				order.setPublicationName(rs.getString("publicationName"));
				order.setCustomerId(rs.getInt("customerId"));
				order.setDay(rs.getInt("day"));
				order.setMonth(rs.getInt("month"));
				order.setYear(rs.getInt("year"));
				order.setPublicationsAvailable(rs.getBoolean("publicationsAvailable"));
				orders.add(order);
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return orders;
	}
	
	
// UPDATE ORDER
	public boolean updateOrder(Order order) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(UPDATE_ORDER)) {
			stmt.setString(1, order.getPublicationName());
			stmt.setInt(2, order.getCustomerId());
			stmt.setInt(3, order.getDay());
			stmt.setInt(4, order.getMonth());
			stmt.setInt(5, order.getYear());
			stmt.setBoolean(6, order.isPublicationsAvailable());
			int rowsUpdated = stmt.executeUpdate();
			return rowsUpdated > 0;

		} catch (SQLException e) { e.printStackTrace(); return false; }
	}
	
//	DELETE CUSTOMER
	public boolean deleteOrder(int orderId) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(DELETE_ORDER)) {
			stmt.setInt(1, orderId);
			int rowsDeleted = stmt.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}
}