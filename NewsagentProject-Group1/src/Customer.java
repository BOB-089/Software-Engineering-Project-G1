
public class Customer {
    private String firstName;
    private String surname;
    private String address;
    private String phoneNumber;
    private int areaCode;
    private int id;
    private boolean onHoliday;
    private boolean publicationsAvailable;

    public Customer(int id, String firstName, String surname, String address, String phoneNumber, int areaCode) {
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

    public int getAreaCode() { return areaCode; }
    public void setAreaCode(int areaCode) { this.areaCode = areaCode; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public boolean isOnHoliday() { return onHoliday; }
    public void setOnHoliday(boolean onHoliday) { this.onHoliday = onHoliday; }

    public boolean isPublicationsAvailable() { return publicationsAvailable; }
    public void setPublicationsAvailable(boolean publicationsAvailable) { this.publicationsAvailable = publicationsAvailable; }

    public void verifyFirstName() { 
		// TODO: Implement
	}

	public void verifysurname() { 
		// TODO: Implement
	}

	public void verifyAddress() { 
		// TODO: Implement
	}
	
	public void verifyPhoneNumber() { 
		// TODO: Implement
	}
}