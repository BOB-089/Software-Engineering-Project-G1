// TODO
public class DeliveryDocket {
	private int areaCode;
	private boolean deliverySuccessful;
	private int deliveryDocketID;
    private int orderID;
    private int customerID;
    private int publicationsID;
	
    public DeliveryDocket() {}
    
    
    public int getAreaCode() { return areaCode; }
    public boolean isDeliverySuccessful() { return deliverySuccessful; }
    public int getOrderID() { return orderID; }
    public int getCustomerID() { return customerID; }
    public int getPublicationsID() { return publicationsID; }
    public int getDeliveryDocketID() { return deliveryDocketID; }

    public boolean setAreaCode(int areaCode) { if (verifyAreaCode(areaCode)) { this.areaCode = areaCode; return true; } else return false; }
	public void setDeliverySuccessful(boolean deliverySuccessful) { this.deliverySuccessful = deliverySuccessful; }
	public boolean setOrderID(int orderID) { if (verifyOrderID(orderID)) { this.orderID = orderID; return true; } else return false; }
	public boolean setCustomerID(int customerID) { if (verifyCustomerID(customerID)) { this.customerID = customerID; return true; } else return false; }
	public boolean setPublicationsID(int publicationsID) { if (verifyPublicationsID(publicationsID)) { this.publicationsID = publicationsID; return true; } else return false; }
	public void setDeliveryDocketID(int deliveryDocketID) { this.deliveryDocketID = deliveryDocketID; }

	public boolean verifyAreaCode(int areaCode) {
        return areaCode >= 1 && areaCode <= 24;
    }

	public boolean verifyOrderID(int orderID) {
		if (orderID < 1) { return false; }
		else { return true; }
    }
	
	public boolean verifyCustomerID(int customerID) {
		if (customerID < 1) { return false; }
		else { return true; }
    }

	public boolean verifyPublicationsID(int publicationsID) {
		if (publicationsID < 1) { return false; }
		else { return true; }
    }
	
	public boolean createDeliveryDocket(int areaCode, int orderID, int customerID, int publicationsID) {
		if (!setAreaCode(areaCode)) return false;
		if (!setOrderID(orderID)) return false;
		if (!setCustomerID(customerID)) return false;
		if (!setPublicationsID(publicationsID)) return false;
        return true;
    }

    
}
