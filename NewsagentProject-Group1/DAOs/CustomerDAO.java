import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {
	private static final String INSERT_CUSTOMER = "INSERT INTO CustomerTable " +
		    "(firstName, surname, address, phoneNumber, onHoliday, publicationsAvailable, areaCode) " +
		    "VALUES (?, ?, ?, ?, ?, ?, ?)";

	private static final String SELECT_BY_ID = "SELECT * FROM CustomerTable WHERE customerId = ?";

	private static final String SELECT_ALL = "SELECT * FROM CustomerTable";

	private static final String UPDATE_CUSTOMER = "UPDATE CustomerTable " + 
			"SET firstName=?, surname=?, address=?, phoneNumber=?, onHoliday=?, publicationsAvailable=?, areaCode=? " + 
			"WHERE customerId=?";

	private static final String DELETE_CUSTOMER = "DELETE FROM CustomerTable WHERE customerId=?";

//		CREATE CUSTOMER
	public boolean addCustomer(Customer customer) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(INSERT_CUSTOMER)) {
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getSurname());
			stmt.setString(3, customer.getAddress());
			stmt.setString(4, customer.getPhoneNumber());
			stmt.setBoolean(5, customer.isOnHoliday());
			stmt.setBoolean(6, customer.isPublicationsAvailable());
			stmt.setInt(7, customer.getAreaCode());
			int rowsInserted = stmt.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}

//		FIND CUSTOMER BY ID
	public Customer findCustomerById(int customerId) {
		Customer customer = null;
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
			stmt.setInt(1, customerId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt("customerId"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setSurname(rs.getString("surname"));
				customer.setAddress(rs.getString("address"));
				customer.setPhoneNumber(rs.getString("phoneNumber"));
				customer.setOnHoliday(rs.getBoolean("onHoliday"));
				customer.setPublicationsAvailable(rs.getBoolean("publicationsAvailable"));
				customer.setAreaCode(rs.getInt("areaCode"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return customer;
	}

//		GET ALL CUSTOMERS
	public ArrayList<Customer> getAllCustomers() {
		ArrayList<Customer> customers = new ArrayList<>();
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
		ResultSet rs = stmt.executeQuery()) {
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
		} catch (SQLException e) { e.printStackTrace(); }
		return customers;
	}

//		UPDATE CUSTOMER
	public boolean updateCustomer(Customer customer) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(UPDATE_CUSTOMER)) {
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getSurname());
			stmt.setString(3, customer.getAddress());
			stmt.setString(4, customer.getPhoneNumber());
			stmt.setBoolean(5, customer.isOnHoliday());
			stmt.setBoolean(6, customer.isPublicationsAvailable());
			stmt.setInt(7, customer.getAreaCode());
			stmt.setInt(8, customer.getCustomerId());
			int rowsUpdated = stmt.executeUpdate();
			return rowsUpdated > 0;

		} catch (SQLException e) { e.printStackTrace(); return false; }
	}

//		DELETE CUSTOMER
	public boolean deleteCustomer(int customerId) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(DELETE_CUSTOMER)) {
			stmt.setInt(1, customerId);
			int rowsDeleted = stmt.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}
}