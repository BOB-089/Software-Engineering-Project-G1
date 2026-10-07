
public class Customer {
    private String firstName;
    private String surname;
    private String address;
    private String phoneNumber;
    private String areaCode;
    private String id;
    private boolean onHoliday;
    private boolean publicationsAvailable;
    
    public Customer() {}

    public Customer(String id, String firstName, String surname, String address, String phoneNumber, String areaCode) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.areaCode = areaCode;
        this.onHoliday = false;
        this.publicationsAvailable = true;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAreaCode() { return areaCode; }
    public void setAreaCode(String areaCode) { this.areaCode = areaCode; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public boolean isOnHoliday() { return onHoliday; }
    public void setOnHoliday(boolean onHoliday) { this.onHoliday = onHoliday; }

    public boolean isPublicationsAvailable() { return publicationsAvailable; }
    public void setPublicationsAvailable(boolean publicationsAvailable) { this.publicationsAvailable = publicationsAvailable; }

    public boolean verifyFirstName(String firstName) { 
    	throw new RuntimeException("No Product Written Yet"); // TODO: Implement
	}

	public boolean verifysurname(String surname) { 
		throw new RuntimeException("No Product Written Yet"); // TODO: Implement
	}

	public boolean verifyAddress(String address) { 
		throw new RuntimeException("No Product Written Yet"); // TODO: Implement
	}
	
	public boolean verifyPhoneNumber(String phoneNumber) { 
		throw new RuntimeException("No Product Written Yet"); // TODO: Implement
	}
}