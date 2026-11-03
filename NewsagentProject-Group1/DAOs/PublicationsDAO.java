import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PublicationsDAO {
		private static final String INSERT_PUBLICATION =
			"INSERT INTO PublicationTable " +
			"(publicationName, publicationStock) " +
			"VALUES (?, ?)";
		
		private static final String SELECT_BY_ID = "SELECT * FROM PublicationTable WHERE PublicationId = ?";

		private static final String SELECT_ALL = "SELECT * FROM PublicationTable";
		
		private static final String UPDATE_PUBLICATION = "UPDATE PublicationTable " + 
				"SET publicationName=?, publicationStock=? " + 
				"WHERE publicationId=?";
		
		private static final String DELETE_PUBLICATION = "DELETE FROM PublicationTable WHERE publicationId=?";
		//add publication
		public boolean addPublication(Publications publication) {
			try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERT_PUBLICATION)) {
				stmt.setString(1, publication.getPublicationName());
				stmt.setInt(2, publication.getPublicationStock());
				int rowsInserted = stmt.executeUpdate();
				return rowsInserted > 0;
			} catch (SQLException e) { e.printStackTrace(); return false; }
		}
		//read publication
		public Publications findPublicationById(int orderId) {
			Publications publication = null;
			try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
				stmt.setInt(1, orderId);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					publication = new Publications();
					publication.setPublicationId(rs.getInt("orderId"));
					publication.setPublicationName(rs.getString("publicationName"));
					publication.setPublicationStock(rs.getInt("publicationStock"));
				}
			} catch (SQLException e) { e.printStackTrace(); }
			return publication;
		}
		
		//read all publications
		public ArrayList<Publications> getAllPublications() {
			ArrayList<Publications> publications = new ArrayList<>();
			try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Publications publication = new Publications();
					publication.setPublicationId(rs.getInt("publicationId"));
					publication.setPublicationName(rs.getString("publicationName"));
					publication.setPublicationStock(rs.getInt("publicationStock"));
					publications.add(publication);
				}
			} catch (SQLException e) { e.printStackTrace(); }
			return publications;
		}
		
		//update publication
		public boolean updatePublication(Publications publication) {
			try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(UPDATE_PUBLICATION)) {
				stmt.setString(1, publication.getPublicationName());
				stmt.setInt(2, publication.getPublicationStock());
				stmt.setInt(3, publication.getPublicationId());
				int rowsUpdated = stmt.executeUpdate();
				return rowsUpdated > 0;

			} catch (SQLException e) { e.printStackTrace(); return false; }
		}
		
		//delete publication
		public boolean deletePublication(int publicationId) {
			try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DELETE_PUBLICATION)) {
				stmt.setInt(1, publicationId);
				int rowsDeleted = stmt.executeUpdate();
				return rowsDeleted > 0;
			} catch (SQLException e) { e.printStackTrace(); return false; }
		}
}
