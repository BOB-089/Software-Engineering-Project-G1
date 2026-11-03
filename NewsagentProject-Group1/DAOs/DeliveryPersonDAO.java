import java.sql.*;
import java.util.ArrayList;

public class DeliveryPersonDAO {
	private static final String INSERT_DELIVERYPERSON = "INSERT INTO DeliveryPersonTable " + "(firstName, surname, phoneNumber, areaCode) " + "VALUES (?, ?, ?, ?)";

	private static final String SELECT_BY_ID = "SELECT * FROM DeliveryPersonTable WHERE deliveryPersonId = ?";

	private static final String SELECT_ALL = "SELECT * FROM DeliveryPersonTable";

	private static final String UPDATE_DELIVERYPERSON = "UPDATE DeliveryPersonTable " + "SET firstName=?, surname=?, phoneNumber=?, areaCode=? " + "WHERE deliveryPersonId=?";

	private static final String DELETE_DELIVERYPERSON = "DELETE FROM DeliveryPersonTable WHERE deliveryPersonId=?";

//		CREATE DELIVERYPERSON
	public boolean addDeliveryPerson(DeliveryPerson deliveryPerson) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(INSERT_DELIVERYPERSON, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, deliveryPerson.getFirstName());
			stmt.setString(2, deliveryPerson.getSurname());
			stmt.setString(3, deliveryPerson.getPhoneNumber());
			stmt.setInt(4, deliveryPerson.getAreaCode());
			int rowsInserted = stmt.executeUpdate();
			
			// If your database auto-generates the ID, retrieve and set it back on the object
			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					deliveryPerson.setDeliveryPersonId(generatedKeys.getInt(1));
				}
			}
			
			return rowsInserted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}

//		FIND DELIVERYPERSON BY ID
	public DeliveryPerson findDeliveryPersonById(int deliveryPersonId) {
		DeliveryPerson deliveryPerson = null;
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
			stmt.setInt(1, deliveryPersonId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				deliveryPerson = new DeliveryPerson();
				deliveryPerson.setDeliveryPersonId(rs.getInt("deliveryPersonId"));
				deliveryPerson.setFirstName(rs.getString("firstName"));
				deliveryPerson.setSurname(rs.getString("surname"));
				deliveryPerson.setPhoneNumber(rs.getString("phoneNumber"));
				deliveryPerson.setAreaCode(rs.getInt("areaCode"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return deliveryPerson;
	}

//		GET ALL DELIVERYPERSONS
	public ArrayList<DeliveryPerson> getAllDeliveryPersons() {
		ArrayList<DeliveryPerson> deliveryPersons = new ArrayList<>();
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
		ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				DeliveryPerson deliveryPerson = new DeliveryPerson();
				deliveryPerson.setDeliveryPersonId(rs.getInt("deliveryPersonId"));
				deliveryPerson.setFirstName(rs.getString("firstName"));
				deliveryPerson.setSurname(rs.getString("surname"));
				deliveryPerson.setPhoneNumber(rs.getString("phoneNumber"));
				deliveryPerson.setAreaCode(rs.getInt("areaCode"));
				deliveryPersons.add(deliveryPerson);
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return deliveryPersons;
	}

//		UPDATE DELIVERYPERSON
	public boolean updateDeliveryPerson(DeliveryPerson deliveryPerson) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(UPDATE_DELIVERYPERSON)) {
			stmt.setString(1, deliveryPerson.getFirstName());
			stmt.setString(2, deliveryPerson.getSurname());
			stmt.setString(3, deliveryPerson.getPhoneNumber());
			stmt.setInt(4, deliveryPerson.getAreaCode());
			stmt.setInt(5, deliveryPerson.getDeliveryPersonId());
			int rowsUpdated = stmt.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}

//		DELETE DELIVERYPERSON
	public boolean deleteDeliveryPerson(int deliveryPersonId) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(DELETE_DELIVERYPERSON)) {
			stmt.setInt(1, deliveryPersonId);
			int rowsDeleted = stmt.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}
}