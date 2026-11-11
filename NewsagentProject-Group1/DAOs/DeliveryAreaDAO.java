import java.sql.*;
import java.util.ArrayList;

public class DeliveryAreaDAO {
	private static final String INSERT_DELIVERYAREA = "INSERT INTO DeliveryAreaTable " + "(areaCode, name) " + "VALUES (?, ?)";

	private static final String SELECT_BY_AREACODE = "SELECT * FROM DeliveryAreaTable WHERE areaCode = ?";

	private static final String SELECT_ALL = "SELECT * FROM DeliveryAreaTable";

	private static final String UPDATE_DELIVERYAREA = "UPDATE DeliveryAreaTable " + "SET name=? " + "WHERE areaCode=?";

	private static final String DELETE_DELIVERYAREA = "DELETE FROM DeliveryAreaTable WHERE areaCode=?";

//  GET CUSTOMERS FOR DELIVERY AREA
	public ArrayList<Customer> getCustomersByAreaCode(int areaCode) {
		ArrayList<Customer> customers = new ArrayList<>();
		String sql = """
				SELECT *
				FROM CustomerTable
				WHERE areaCode = ?
				""";
		try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, areaCode);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Customer customer = new Customer();
					customer.setCustomerId(rs.getInt("customerId"));
					customer.setFirstName(rs.getString("firstName"));
					customer.setSurname(rs.getString("surname"));
					customer.setAddress(rs.getString("address"));
					customer.setPhoneNumber(rs.getString("phoneNumber"));
					customer.setOnHoliday(rs.getBoolean("onHoliday"));
					customer.setPublicationsAvailable(rs.getBoolean("publicationsAvailable"));
					customer.setAreaCode(rs.getInt("areaCode"));
					customers.add(customer);
				}
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return customers;
	}

//		CREATE DELIVERY AREA
	public boolean addDeliveryArea(DeliveryArea deliveryArea) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(INSERT_DELIVERYAREA)) {
			stmt.setInt(1, deliveryArea.getAreaCode());
			stmt.setString(2, deliveryArea.getName());
			int rowsInserted = stmt.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}

//		FIND DELIVERY AREA BY AREA CODE
	public DeliveryArea findDeliveryAreaByAreaCode(int areaCode) {
		DeliveryArea deliveryArea = null;
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_BY_AREACODE)) {
			stmt.setInt(1, areaCode);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				deliveryArea = new DeliveryArea();
				deliveryArea.setAreaCode(rs.getInt("areaCode"));
				deliveryArea.setName(rs.getString("name"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return deliveryArea;
	}

//		GET ALL DELIVERY AREAS
	public ArrayList<DeliveryArea> getAllDeliveryAreas() {
		ArrayList<DeliveryArea> deliveryAreas = new ArrayList<>();
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
		ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				DeliveryArea deliveryArea = new DeliveryArea();
				deliveryArea.setAreaCode(rs.getInt("areaCode"));
				deliveryArea.setName(rs.getString("name"));
				deliveryAreas.add(deliveryArea);
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return deliveryAreas;
	}

//		UPDATE DELIVERY AREA
	public boolean updateDeliveryArea(DeliveryArea deliveryArea) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(UPDATE_DELIVERYAREA)) {
			stmt.setString(1, deliveryArea.getName());
			stmt.setInt(2, deliveryArea.getAreaCode());
			int rowsUpdated = stmt.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}

//		DELETE DELIVERY AREA
	public boolean deleteDeliveryArea(int areaCode) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(DELETE_DELIVERYAREA)) {
			stmt.setInt(1, areaCode);
			int rowsDeleted = stmt.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}
}