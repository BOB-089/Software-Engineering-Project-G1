public class Customer {
    private String firstName;
    private String surname;
    private String address;
    private String phoneNumber;
    private boolean onHoliday;
    private boolean publicationsAvailable;
    private int areaCode;
    private int id;
    private static int nextId = 10000;

    public Customer() {}

    public String getFirstName() { return firstName; }
    public String getSurname() { return surname; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public boolean isOnHoliday() { return onHoliday; }
    public boolean isPublicationsAvailable() { return publicationsAvailable; }
    public int getAreaCode() { return areaCode; }
    public int getId() { return id; }

    public boolean setFirstName(String firstName) { if (verifyFirstName(firstName)) { this.firstName = firstName; return true; } else return false; }
    public boolean setSurname(String surname) { if (verifySurname(surname)) { this.surname = surname; return true; } else return false; }
    public boolean setAddress(String address) { if (verifyAddress(address)) { this.address = address; return true; } else return false; }
    public boolean setPhoneNumber(String phoneNumber) { if (verifyPhoneNumber(phoneNumber)) { this.phoneNumber = phoneNumber; return true; } else return false; }
    public boolean setAreaCode(int areaCode) { if (verifyAreaCode(areaCode)) { this.areaCode = areaCode; return true; } else return false; }
    public void setOnHoliday(boolean onHoliday) { this.onHoliday = onHoliday; }
    public void setPublicationsAvailable(boolean publicationsAvailable) { this.publicationsAvailable = publicationsAvailable; }
    public void setId() { this.id = nextId++; }

    public boolean verifyFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) { return false; }
        return firstName.matches("^[A-Za-z'-]+$");
    }

    public boolean verifySurname(String surname) {
        if (surname == null || surname.trim().isEmpty()) { return false; }
        return surname.matches("^[A-Za-z'-]+$");
    }

    public boolean verifyAddress(String address) {
        if (address == null || address.trim().isEmpty()) { return false; }
        return address.matches("^[A-Za-z0-9'\\- ]+$");
    }

    public boolean verifyPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) { return false; }
        return phoneNumber.matches("^[0-9]{10}$");
    }

    public boolean verifyAreaCode(int areaCode) {
        return areaCode >= 1 && areaCode <= 24;
    }

    public boolean createCustomer(String firstName, String surname, String address, String phoneNumber, int areaCode) {
        if (!setFirstName(firstName)) return false;
        if (!setSurname(surname)) return false;
        if (!setAddress(address)) return false;
        if (!setPhoneNumber(phoneNumber)) return false;
        if (!setAreaCode(areaCode)) return false;
        setOnHoliday(false);
        setPublicationsAvailable(true);
        setId();
        return true;
    }
}