import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DeliveryDocket {
	private int areaCode;
	private int deliveryDocketId;
    private int day;
    private int month;
    private int year;
    private final OrderDAO orderDAO = new OrderDAO();
    private final CustomerDAO customerDAO = new CustomerDAO();
	
    public DeliveryDocket() {}
    
    public int getAreaCode() { return areaCode; }
    public int getDeliveryDocketId() { return deliveryDocketId; }
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
    public String getDate() { return day + "/" + month + "/" + year; }
    
    public ArrayList<Order> getOrders() { // Consider moving to DAO layer
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<Order> allOrders = orderDAO.getAllOrders();
        for (Order order : allOrders) {
        	Customer orderCustomer = customerDAO.findCustomerById(order.getCustomerId());
            if (order.getDate().equals(getDate()) && orderCustomer.getAreaCode() == areaCode) { orders.add(order); }
        }
        return orders;
    }

    public boolean setAreaCode(int areaCode) { if (verifyAreaCode(areaCode)) { this.areaCode = areaCode; return true; } else return false; }
	public void setDeliveryDocketId(int deliveryDocketId) { this.deliveryDocketId = deliveryDocketId; }
	public boolean setDay(int day) { if (verifyDay(day)) { this.day = day; return true; } else return false; }
	public boolean setMonth(int month) { if (verifyMonth(month)) { this.month = month; return true; } else return false; }
	public boolean setYear(int year) { if (verifyYear(year)) { this.year = year; return true; } else return false; }

	public boolean verifyAreaCode(int areaCode) { return areaCode >= 1 && areaCode <= 24; }
	
	public boolean verifyDay(int day) { return day >= 1 && day <= 31; }
	
	public boolean verifyMonth(int month) { return month >= 1 && month <= 12; }
	
	public boolean verifyYear(int year) { return year >= 1900; }
	
	public boolean verifyDate(int day, int month, int year) {
	    try { LocalDate.of(year, month, day); return true; } 
	    catch (DateTimeException e) { return false; }
	}
	
	public boolean createDeliveryDocket(int areaCode, int day, int month, int year) {
		if (!setAreaCode(areaCode)) return false;
	    if (!setDay(day)) return false;
	    if (!setMonth(month)) return false;
	    if (!setYear(year)) return false;
	    if (!verifyDate(day, month, year)) return false;
	    return true;
    }
}