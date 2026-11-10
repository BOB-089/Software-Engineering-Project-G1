/*
 * INPUT: customer ID, and month + year
 * TODO values from other tables: all order publication names, dates, and prices. 
 * TODO other: Added up prices from the total orders of the selected month
 * 
 * 
 * 
 */

import java.time.DateTimeException;
import java.sql.*;
import java.time.LocalDate;

public class Bill {
    private int customerId;
    private int month;
    private int year;

    private int billId;

    public Bill() {}
    
    public String publicationNameQuery = "SELECT COUNT(*) FROM PublicationTable WHERE publicationName = ?";
    public String customerIdQuery = "SELECT COUNT(*) FROM CustomerTable WHERE customerId = ?";

    public int getCustomerId() { return customerId; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
    public String getDate() { return month + "/" + year; }
    public int getOrderId() { return billId; }

    public boolean setCustomerId(int customerId) { if (verifyCustomerId(customerId)) { this.customerId = customerId; return true; } else return false; }
    public boolean setMonth(int month) { if (verifyMonth(month)) { this.month = month; return true; } else return false; }
    public boolean setYear(int year) { if (verifyYear(year)) { this.year = year; return true; } else return false; }
    public void setBillId(int billId) { this.billId = billId; }

    public boolean verifyCustomerId(int customerId) {
		if (customerId < 1) { return false; }
		else {
			try (Connection conn = DatabaseConnection.getConnection();
		             PreparedStatement stmt = conn.prepareStatement(customerIdQuery)) {
		            stmt.setInt(1, customerId);
		            ResultSet rs = stmt.executeQuery();
		            if (rs.next()) {
		                int count = rs.getInt(1);
		                if (count > 0) {
		                    return true;
		                } else {
		                    return false;
		                }
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        } 
			}
		return false;
    }
    
	public boolean verifyMonth(int month) { return month >= 1 && month <= 12; }
	
	public boolean verifyYear(int year) { return year >= 1900; }
	
	public boolean verifyDate(int day, int month, int year) { // TODO RELATED TESTS
	    try { LocalDate.of(year, month, day); return true; } 
	    catch (DateTimeException e) { return false; }
	}

    public boolean createOrder(String publicationName, int customerId, int day, int month, int year) {
        if (!setCustomerId(customerId)) return false;
        if (!setMonth(month)) return false;
        if (!setYear(year)) return false;
        return true;
    }
}