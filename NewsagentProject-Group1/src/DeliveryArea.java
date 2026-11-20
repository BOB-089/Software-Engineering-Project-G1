public class DeliveryArea {
	private int areaCode;
	private String name;
	
	public DeliveryArea() {}

    public int getAreaCode() { return areaCode; }
    public String getName() { return name; }

    public boolean setAreaCode(int areaCode) { if (verifyAreaCode(areaCode)) { this.areaCode = areaCode; return true; } else return false; }
    public boolean setName(String name) { if (verifyName(name)) { this.name = name; return true; } else return false; }
    
    public boolean verifyAreaCode(int areaCode) { return areaCode >= 1 && areaCode <= 24; }
    
    public boolean verifyName(String name) {
        if (name == null || name.trim().isEmpty()) { return false; }
        return name.matches("^[A-Za-z'-]+$");
    }

    // Convenience creation method used by tests
    public boolean createDeliveryArea(int areaCode, String name) {
    	if (!setAreaCode(areaCode)) return false;
    	if (!setName(name)) return false;
    	return true;
    }
}