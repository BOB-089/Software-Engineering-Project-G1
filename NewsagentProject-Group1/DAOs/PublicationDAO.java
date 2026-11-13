import java.sql.*;
import java.util.ArrayList;

public class PublicationDAO {
	private static final String INSERT_PUBLICATION = "INSERT INTO PublicationTable " + "(name, stock, price) " + "VALUES (?, ?, ?)";

	private static final String SELECT_BY_ID = "SELECT * FROM PublicationTable WHERE publicationId = ?";

	private static final String SELECT_ALL = "SELECT * FROM PublicationTable";

	private static final String UPDATE_PUBLICATION = "UPDATE PublicationTable " + "SET name=?, stock=?, price=? " + "WHERE publicationId=?";

	private static final String DELETE_PUBLICATION = "DELETE FROM PublicationTable WHERE publicationId=?";

//		CREATE PUBLICATION
	public boolean addPublication(Publication publication) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(INSERT_PUBLICATION)) {
			stmt.setString(1, publication.getName());
			stmt.setInt(2, publication.getStock());
			stmt.setDouble(3, publication.getPrice());
			int rowsInserted = stmt.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}

//		FIND PUBLICATION BY ID
	public Publication findPublicationById(int publicationId) {
		Publication publication = null;
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
			stmt.setInt(1, publicationId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				publication = new Publication();
				publication.setPublicationId(rs.getInt("publicationId"));
				publication.setName(rs.getString("name"));
				publication.setStock(rs.getInt("stock"));
				publication.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return publication;
	}

//		GET ALL PUBLICATIONS
	public ArrayList<Publication> getAllPublications() {
		ArrayList<Publication> publications = new ArrayList<>();
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
		ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Publication publication = new Publication();
				publication.setPublicationId(rs.getInt("publicationId"));
				publication.setName(rs.getString("name"));
				publication.setStock(rs.getInt("stock"));
				publication.setPrice(rs.getDouble("price"));
				publications.add(publication);
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return publications;
	}

//		UPDATE PUBLICATION
	public boolean updatePublication(Publication publication) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(UPDATE_PUBLICATION)) {
			stmt.setString(1, publication.getName());
			stmt.setInt(2, publication.getStock());
			stmt.setDouble(3, publication.getPrice());
			stmt.setInt(4, publication.getPublicationId());
			int rowsUpdated = stmt.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}

//		DELETE PUBLICATION
	public boolean deletePublication(int publicationId) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(DELETE_PUBLICATION)) {
			stmt.setInt(1, publicationId);
			int rowsDeleted = stmt.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}
}