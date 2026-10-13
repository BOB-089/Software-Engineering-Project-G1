
public class Order {
    private String publicationName;
    private String customerID;
    private int day;
    private int month;
    private int year;

    private boolean publicationsAvailable;

    public Order(String publicationName, String customerID, int day, int month, int year) {
        this.publicationName = publicationName;
        this.customerID = customerID;
        this.day = day;
        this.month = month;
        this.year = year;

        this.publicationsAvailable = true;
    }

    public String getPublicationName() { return publicationName; }
    public void setPublicationName(String publicationName) { this.publicationName = publicationName; }

    public String getCustomerID() { return customerID; }
    public void setCustomerID(String customerID) { this.customerID = customerID; }

    public int getDay() { return day; }
    public void setDay(int day) { this.day = day; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public boolean isPublicationsAvailable() { return publicationsAvailable; }
    public void setPublicationsAvailable(boolean publicationsAvailable) { this.publicationsAvailable = publicationsAvailable; }

    public boolean verifyPublicationName(String publicationName) { 
    	throw new RuntimeException("No Product Written Yet"); // TODO: Implement
    }

    public boolean verifyCustomerID(String customerID) { 
	throw new RuntimeException("No Product Written Yet"); // TODO: Implement
    }

    public boolean verifyDay(int day) { 
	throw new RuntimeException("No Product Written Yet"); // TODO: Implement
    }
	
    public boolean verifyMonth(int month) { 
	throw new RuntimeException("No Product Written Yet"); // TODO: Implement
    }

    public boolean verifyYear(int year) { 
	throw new RuntimeException("No Product Written Yet"); // TODO: Implement
    }
    public boolean createOrder(
	String publicationName,
	String customerID,
	int day,
	int month,
        int year) {

	throw new RuntimeException("No Product Written Yet");// TODO: Implement
    }
}
