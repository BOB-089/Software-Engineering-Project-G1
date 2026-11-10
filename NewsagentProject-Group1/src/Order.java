import java.time.DateTimeException;
import java.time.LocalDate;

public class Order {
    private String publicationName;
    private int customerId;
    private int day;
    private int month;
    private int year;
    private boolean publicationsAvailable;
    private int orderId;

    public Order() {}

    public String getPublicationName() { return publicationName; }
    public int getCustomerId() { return customerId; }
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
    public String getDate() { return day + "/" + month + "/" + year; }
    public boolean isPublicationsAvailable() { return publicationsAvailable; }
    public int getOrderId() { return orderId; }

    public boolean setPublicationName(String publicationName) { if (verifyPublicationName(publicationName)) { this.publicationName = publicationName; return true; } else return false; }
    public boolean setCustomerId(int customerId) { if (verifyCustomerId(customerId)) { this.customerId = customerId; return true; } else return false; }
    public boolean setDay(int day) { if (verifyDay(day)) { this.day = day; return true; } else return false; }
    public boolean setMonth(int month) { if (verifyMonth(month)) { this.month = month; return true; } else return false; }
    public boolean setYear(int year) { if (verifyYear(year)) { this.year = year; return true; } else return false; }
    public void setPublicationsAvailable(boolean publicationsAvailable) { this.publicationsAvailable = publicationsAvailable; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public boolean verifyPublicationName(String publicationName) {
        if (publicationName == null || publicationName.trim().isEmpty()) { return false; }
        return publicationName.matches("^[A-Za-z'-]+$");
    }

    public boolean verifyCustomerId(int customerId) {
		if (customerId < 1) { return false; }
		else { return true; }
    }

    public boolean verifyDay(int day) { return day >= 1 && day <= 31; }
    
	public boolean verifyMonth(int month) { return month >= 1 && month <= 12; }
	
	public boolean verifyYear(int year) { return year >= 1900; }
	
	public boolean verifyDate(int day, int month, int year) { // TODO RELATED TESTS
	    try { LocalDate.of(year, month, day); return true; } 
	    catch (DateTimeException e) { return false; }
	}

    public boolean createOrder(String publicationName, int customerId, int day, int month, int year) {
        if (!setPublicationName(publicationName)) return false;
        if (!setCustomerId(customerId)) return false;
        if (!setDay(day)) return false;
        if (!setMonth(month)) return false;
        if (!setYear(year)) return false;
        setPublicationsAvailable(true);
        return true;
    }
}