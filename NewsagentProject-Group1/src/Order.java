public class Order {
    private String publicationName;
    private String customerID;
    private int day;
    private int month;
    private int year;
    private boolean publicationsAvailable;
    private int OrderID;
    private static int nextOrderID = 10000;

    public Order() {}

    public String getPublicationName() { return publicationName; }
    public String getCustomerID() { return customerID; }
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
    public boolean isPublicationsAvailable() { return publicationsAvailable; }
    public int getOrderID() { return OrderID; }

    public void setPublicationName(String publicationName) { if (verifyPublicationName(publicationName)) { this.publicationName = publicationName; return true; } else return false; }
    public void setCustomerID(String customerID) { if (verifyCustomerID(customerID)) { this.customerID = customerID; return true; } else return false; }
    public void setDay(int day) { if (verifyDay(day)) { this.day = day; return true; } else return false; }
    public void setMonth(int month) { if (verifyMonth(month)) { this.month = month; return true; } else return false; }
    public void setYear(int year) { if (verifyYear(year)) { this.year = year; return true; } else return false; }
    public void setPublicationsAvailable(boolean publicationsAvailable) { this.publicationsAvailable = publicationsAvailable; }
    public void setOrderID() { this.OrderID = nextOrderID++; }

    public boolean verifyPublicationName(String publicationName) {
        if (publicationName == null || publicationName.trim().isEmpty()) { return false; }
        return publicationName.matches("^[A-Za-z'-]+$");
    }

    public boolean verifyCustomerID(String customerID) {
	//todo
    }

    public boolean verifyDay(int day) {
        if (day = null || day < 1 || day > 31) { return false; }
        else {return true }
    }

    public boolean verifyMonth(int month) {
        if (month = null || month < 1 || month > 12) { return false; }
        else {return true }
    }
    public boolean verifyYear(int Year) {
        if (year = null || year < 1980) { return false; }
        else {return true }
    }

    public boolean createOrder(String publicationName, String customerID, int day, int month, int year) {
        if (!setPublicationName(publicationName)) return false;
        if (!setcustomerID(customerID)) return false;
        if (!setDay(day)) return false;
        if (!setMonth(month)) return false;
        if (!setYear(year)) return false;
        setPublicationsAvailable(true);
        setOrderID();
        return true;
    }
}
