import java.util.ArrayList;

public class DeliveryArea {
	private int areaCode;
	private String name;
	private CustomerDAO customerDAO = new CustomerDAO();
	private DeliveryAreaDAO deliveryAreaDAO = new DeliveryAreaDAO();
	
	public DeliveryArea() {}

    public int getAreaCode() { return areaCode; }
    public String getName() { return name; }
    
    public ArrayList<Customer> getCustomers() { // Consider moving to a DAO
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
        //return deliveryAreaDAO.findDeliveryAreaByAreaCode(areaCode) == null; // move to CLI
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