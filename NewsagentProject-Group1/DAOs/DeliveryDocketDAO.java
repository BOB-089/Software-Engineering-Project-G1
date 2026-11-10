import java.sql.*;
import java.util.ArrayList;

public class DeliveryDocketDAO {
	private static final String INSERT_DELIVERYDOCKET = "INSERT INTO DeliveryDocketTable " + "(areaCode, day, month, year) " + "VALUES (?, ?, ?, ?)";

	private static final String SELECT_BY_ID = "SELECT * FROM DeliveryDocketTable WHERE deliveryDocketId = ?";

	private static final String SELECT_ALL = "SELECT * FROM DeliveryDocketTable";

	private static final String UPDATE_DELIVERYDOCKET = "UPDATE DeliveryDocketTable " + "SET areaCode=?, day=?, month=?, year=? " + "WHERE deliveryDocketId=?";

	private static final String DELETE_DELIVERYDOCKET = "DELETE FROM DeliveryDocketTable WHERE deliveryDocketId=?";

//		CREATE DELIVERY DOCKET
	public boolean addDeliveryDocket(DeliveryDocket deliveryDocket) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(INSERT_DELIVERYDOCKET)) {
			stmt.setInt(1, deliveryDocket.getAreaCode());
			stmt.setInt(2, deliveryDocket.getDay());
			stmt.setInt(3, deliveryDocket.getMonth());
			stmt.setInt(4, deliveryDocket.getYear());
			int rowsInserted = stmt.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}

//		FIND DELIVERY DOCKET BY ID
	public DeliveryDocket findDeliveryDocketById(int deliveryDocketId) {
		DeliveryDocket deliveryDocket = null;
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
			stmt.setInt(1, deliveryDocketId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				deliveryDocket = new DeliveryDocket();
				deliveryDocket.setDeliveryDocketId(rs.getInt("deliveryDocketId"));
				deliveryDocket.setAreaCode(rs.getInt("areaCode"));
				deliveryDocket.setDay(rs.getInt("day"));
				deliveryDocket.setMonth(rs.getInt("month"));
				deliveryDocket.setYear(rs.getInt("year"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return deliveryDocket;
	}

//		GET ALL DELIVERY DOCKETS
	public ArrayList<DeliveryDocket> getAllDeliveryDockets() {
		ArrayList<DeliveryDocket> deliveryDockets = new ArrayList<>();
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
		ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				DeliveryDocket deliveryDocket = new DeliveryDocket();
				deliveryDocket.setDeliveryDocketId(rs.getInt("deliveryDocketId"));
				deliveryDocket.setAreaCode(rs.getInt("areaCode"));
				deliveryDocket.setDay(rs.getInt("day"));
				deliveryDocket.setMonth(rs.getInt("month"));
				deliveryDocket.setYear(rs.getInt("year"));
				deliveryDockets.add(deliveryDocket);
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return deliveryDockets;
	}

//		UPDATE DELIVERY DOCKET
	public boolean updateDeliveryDocket(DeliveryDocket deliveryDocket) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(UPDATE_DELIVERYDOCKET)) {
			stmt.setInt(1, deliveryDocket.getAreaCode());
			stmt.setInt(2, deliveryDocket.getDay());
			stmt.setInt(3, deliveryDocket.getMonth());
			stmt.setInt(4, deliveryDocket.getYear());
			stmt.setInt(5, deliveryDocket.getDeliveryDocketId());
			int rowsUpdated = stmt.executeUpdate();
			return rowsUpdated > 0;

		} catch (SQLException e) { e.printStackTrace(); return false; }
	}

//		DELETE DELIVERY DOCKET
	public boolean deleteDeliveryDocket(int deliveryDocketId) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(DELETE_DELIVERYDOCKET)) {
			stmt.setInt(1, deliveryDocketId);
			int rowsDeleted = stmt.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}
}