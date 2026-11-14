import java.sql.*;
import java.util.ArrayList;

public class BillDAO {
	private static final String INSERT_BILL = "INSERT INTO BillTable " + "(customerId, month, year, total, paid) " + "VALUES (?, ?, ?, ?, ?)";
	
	private static final String SELECT_BY_ID = "SELECT * FROM BillTable WHERE billId = ?";

	private static final String SELECT_ALL = "SELECT * FROM BillTable";

	private static final String UPDATE_BILL = "UPDATE BillTable " + "SET customerId=?, month=?, year=?, total=?, paid=? " + "WHERE billId=?";

	private static final String DELETE_BILL = "DELETE FROM BillTable WHERE billId=?";
	
	private static final String CHECK_CUSTOMER_EXISTS = "SELECT COUNT(*) FROM CustomerTable WHERE customerId = ?";
	
	private static final String CALCULATE_BILL_TOTAL = "SELECT SUM(p.price) FROM OrderTable o JOIN PublicationTable p ON o.publicationName = p.name " + 
													   "WHERE o.customerId = ? AND o.month = ? AND o.year = ?";

//		CREATE BILL
	public boolean addBill(Bill bill) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(INSERT_BILL)) {
			stmt.setInt(1, bill.getCustomerId());
			stmt.setInt(2, bill.getMonth());
			stmt.setInt(3, bill.getYear());
			stmt.setDouble(4, bill.getTotal());
			stmt.setBoolean(5, bill.isPaid());
			int rowsInserted = stmt.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}

//		FIND BILL BY ID
	public Bill findBillById(int billId) {
		Bill bill = null;
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
			stmt.setInt(1, billId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				bill = new Bill();
				bill.setBillId(rs.getInt("billId"));
				bill.setCustomerId(rs.getInt("customerId"));
				bill.setMonth(rs.getInt("month"));
				bill.setYear(rs.getInt("year"));
				bill.setTotal(rs.getDouble("total"));
				bill.setPaid(rs.getBoolean("paid"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return bill;
	}

//		GET ALL BILLS
	public ArrayList<Bill> getAllBills() {
		ArrayList<Bill> bills = new ArrayList<>();
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
		ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Bill bill = new Bill();
				bill.setBillId(rs.getInt("billId"));
				bill.setCustomerId(rs.getInt("customerId"));
				bill.setMonth(rs.getInt("month"));
				bill.setYear(rs.getInt("year"));
				bill.setTotal(rs.getDouble("total"));
				bill.setPaid(rs.getBoolean("paid"));
				bills.add(bill);
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return bills;
	}

//		UPDATE BILL
	public boolean updateBill(Bill bill) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(UPDATE_BILL)) {
			stmt.setInt(1, bill.getCustomerId());
			stmt.setInt(2, bill.getMonth());
			stmt.setInt(3, bill.getYear());
			stmt.setDouble(4, bill.getTotal());
			stmt.setBoolean(5, bill.isPaid());
			stmt.setInt(6, bill.getBillId());
			int rowsUpdated = stmt.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}

//		DELETE BILL
	public boolean deleteBill(int billId) {
		try (Connection conn = DatabaseConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(DELETE_BILL)) {
			stmt.setInt(1, billId);
			int rowsDeleted = stmt.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) { e.printStackTrace(); return false; }
	}
	
//		CHECK CUSTOMER EXISTS
	public boolean customerExists(int customerId) {
		try (Connection conn = DatabaseConnection.getConnection();
		     PreparedStatement stmt = conn.prepareStatement(CHECK_CUSTOMER_EXISTS)) {
		     	stmt.setInt(1, customerId);
		        ResultSet rs = stmt.executeQuery();
		        if (rs.next()) { return rs.getInt(1) > 0; }
		} catch (Exception e) { e.printStackTrace(); }
		return false;
	}
	
//		CALCULATE BILL TOTAL
	public double calculateBillTotal(int customerId, int month, int year) {
		try (Connection conn = DatabaseConnection.getConnection();
		     PreparedStatement stmt = conn.prepareStatement(CALCULATE_BILL_TOTAL)) {
		        stmt.setInt(1, customerId);
		        stmt.setInt(2, month);
		        stmt.setInt(3, year);
		        ResultSet rs = stmt.executeQuery();
		        if (rs.next()) { return rs.getDouble(1); }
		} catch (SQLException e) { e.printStackTrace(); }
		return 0;
	}
}