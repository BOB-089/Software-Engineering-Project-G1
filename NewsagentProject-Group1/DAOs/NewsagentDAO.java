import java.sql.*;
import java.util.ArrayList;

public class NewsagentDAO {
	private static final String INSERT_NEWSAGENT = "INSERT INTO NewsagentTable " +
		    "(firstName, surname, phoneNumber) " + "VALUES (?, ?, ?)";
	
	private static final String SELECT_BY_ID = "SELECT * FROM NewsagentTable WHERE newsagentID = ?";
	
	private static final String SELECT_ALL = "SELECT * FROM NewsagentTable";
	
	private static final String UPDATE_NEWSAGENT = "UPDATE NewsagentTable " + 
			"SET firstName=?, surname=?, phoneNumber=? " + "WHERE newsagentID=?";
	
	private static final String DELETE_NEWSAGENT = "DELETE FROM NewsagentTable WHERE newsagentID=?";
	
	
//	CREATE NEWSAGENT
	public boolean addNewsagent(Newsagent newsagent) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(INSERT_NEWSAGENT)) {
			stmt.setString(1, newsagent.getFirstName());
			stmt.setString(2, newsagent.getSurname());
			stmt.setString(3, newsagent.getPhoneNumber());
			int rowsInserted = stmt.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}
	
//	FIND NEWSAGENT BY ID
	public Newsagent findNewsagentByID(int newsagentID) {
		Newsagent newsagent = null;
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
			stmt.setInt(1, newsagentID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				newsagent = new Newsagent();
				newsagent.setId(rs.getInt("newsagentID"));
				newsagent.setFirstName(rs.getString("firstName"));
				newsagent.setSurname(rs.getString("surname"));
				newsagent.setPhoneNumber(rs.getString("phoneNumber"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return newsagent;
	}
	
	//	GET ALL NEWSAGENTS
	public ArrayList<Newsagent> getAllNewsagents() {
		ArrayList<Newsagent> newsagents = new ArrayList<>();
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
		ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Newsagent newsagent = new Newsagent();
				newsagent.setId(rs.getInt("newsagentID"));
				newsagent.setFirstName(rs.getString("firstName"));
				newsagent.setSurname(rs.getString("surname"));
				newsagent.setPhoneNumber(rs.getString("phoneNumber"));
				newsagents.add(newsagent);
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return newsagents;
	}	
	
	//	UPDATE NEWSAGENT
	public boolean updateNewsagent(Newsagent newsagent) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(UPDATE_NEWSAGENT)) {
			stmt.setString(1, newsagent.getFirstName());
			stmt.setString(2, newsagent.getSurname());
			stmt.setString(3, newsagent.getPhoneNumber());
			stmt.setInt(4, newsagent.getId());
			int rowsUpdated = stmt.executeUpdate();
			return rowsUpdated > 0;
	
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}
	
	//	DELETE NEWSAGENT
	public boolean deleteNewsagent(int newsagentID) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(DELETE_NEWSAGENT)) {
			stmt.setInt(1, newsagentID);
			int rowsDeleted = stmt.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}
}
