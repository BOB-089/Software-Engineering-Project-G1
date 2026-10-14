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

    public String getFirstName() { return firstName; }
    public String getSurname() { return surname; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public boolean isOnHoliday() { return onHoliday; }
    public boolean isPublicationsAvailable() { return publicationsAvailable; }
    public String getAreaCode() { return areaCode; }
    public String getId() { return id; }

    public void setFirstName(String firstName) { if (verifyFirstName(firstName)) this.firstName = firstName; }
    public void setSurname(String surname) { if (verifySurname(surname)) this.surname = surname; }
    public void setAddress(String address) { if (verifyAddress(address)) this.address = address; }
    public void setPhoneNumber(String phoneNumber) { if (verifyPhoneNumber(phoneNumber)) this.phoneNumber = phoneNumber; }
    public void setOnHoliday(boolean onHoliday) { this.onHoliday = onHoliday; }
    public void setPublicationsAvailable(boolean publicationsAvailable) { this.publicationsAvailable = publicationsAvailable; }
    
    public void setId() {
    	String id = null; // TODO: create id
        this.id = id;
        throw new RuntimeException("Incomplete code");
    }
    
    public void setAreaCode(String address) {
    	String areaCode = null; // TODO: create area code off address
        this.areaCode = areaCode;
        throw new RuntimeException("Incomplete code");
    }
    
    public boolean verifyFirstName(String firstName) {
        throw new RuntimeException("No Product Written Yet"); // TODO: Implement
    }

    public boolean verifySurname(String surname) {
        throw new RuntimeException("No Product Written Yet"); // TODO: Implement
    }

    public boolean verifyAddress(String address) {
        throw new RuntimeException("No Product Written Yet"); // TODO: Implement
    }

    public boolean verifyPhoneNumber(String phoneNumber) {
        throw new RuntimeException("No Product Written Yet"); // TODO: Implement
    }

    public boolean createCustomer(String firstName, String surname, String address, String phoneNumber) {
        setFirstName(firstName);
        setSurname(surname);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setOnHoliday(false);
        setPublicationsAvailable(true);
        setId();
        setAreaCode(address);

        System.out.println("Product not complete Yet"); // TODO: Implement
        return true;
    }
}
