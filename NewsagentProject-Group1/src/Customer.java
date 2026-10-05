
public class Customer {
	private String name;
	private String address;
	private String phoneNumber;
	private int areaCode;
	private int id;
	private boolean onHoliday;
	private boolean publicationsAvailable;

	Customer(int id, String name, String address, String phoneNumber, int areaCode) {
		this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.areaCode = areaCode;
        this.onHoliday = false;
        this.publicationsAvailable = true;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }

	public String getPhoneNumber() { return phoneNumber; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

	public int getAreaCode() { return areaCode; }
	public void setAreaCode(int areaCode) { this.areaCode = areaCode; }

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public boolean isOnHoliday() { return onHoliday; }
	public void setOnHoliday(boolean onHoliday) { this.onHoliday = onHoliday; }

	public boolean isPublicationsAvailable() { return publicationsAvailable; }
	public void setPublicationsAvailable(boolean publicationsAvailable) { this.publicationsAvailable = publicationsAvailable; }

	
	public void createCustomer() { 
		// TODO
	}

	public void deleteCustomer() { 
		// TODO
	}

	public void updateCustomer() { 
		// TODO
	}

	public void readCustomer() { 
		// TODO
	}
}