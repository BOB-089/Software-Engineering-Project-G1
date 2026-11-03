import java.util.ArrayList;

public class DeliveryArea {
	private int areaCode;
	private String name;
	private CustomerDAO customerDAO = new CustomerDAO();
	
	public DeliveryArea() {}

    public int getAreaCode() { return areaCode; }
    public String getName() { return name; }
    
    public ArrayList<Customer> getCustomers() {
    	ArrayList<Customer> customers = new ArrayList<>();
    	ArrayList<Customer> allCustomers = customerDAO.getAllCustomers();
    	for (Customer customer : allCustomers) {
    		if (customer.getAreaCode() == areaCode) { customers.add(customer); }
    	}
    	return customers;
    }

    public boolean setAreaCode(int areaCode) { if (verifyAreaCode(areaCode)) { this.areaCode = areaCode; return true; } else return false; }
    public boolean setName(String name) { if (verifyName(name)) { this.name = name; return true; } else return false; }
    
    public boolean verifyAreaCode(int areaCode) {
        return areaCode >= 1 && areaCode <= 24;
    }
    
    public boolean verifyName(String name) {
        if (name == null || name.trim().isEmpty()) { return false; }
        return name.matches("^[A-Za-z'-]+$");
    }

    public boolean createDeliveryArea(int areaCode, String name) {
        try {
        	if (!setAreaCode(areaCode)) return false;
        	if (!setName(name)) return false;
        } catch(Exception e) { System.out.println("Failed to create delivery area:"); e.printStackTrace(); }
        return true;
    }
}