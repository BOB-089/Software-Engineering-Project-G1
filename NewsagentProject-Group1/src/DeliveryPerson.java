
public class DeliveryPerson {
    private String firstName;
    private String surname;
    private String phoneNumber;
    private int areaCode;
    private int deliveryPersonId;

    public DeliveryPerson() {}

    public String getFirstName() { return firstName; }
    public String getSurname() { return surname; }
    public String getPhoneNumber() { return phoneNumber; }
    public int getAreaCode() { return areaCode; }
    public int getDeliveryPersonId() { return deliveryPersonId; }

    public boolean setFirstName(String firstName) { if (verifyFirstName(firstName)) { this.firstName = firstName; return true; } else return false; }
    public boolean setSurname(String surname) { if (verifySurname(surname)) { this.surname = surname; return true; } else return false; }
    public boolean setPhoneNumber(String phoneNumber) { if (verifyPhoneNumber(phoneNumber)) { this.phoneNumber = phoneNumber; return true; } else return false; }
    public boolean setAreaCode(int areaCode) { if (verifyAreaCode(areaCode)) { this.areaCode = areaCode; return true; } else return false; }
    public void setDeliveryPersonId(int deliveryPersonId) { this.deliveryPersonId = deliveryPersonId; }

    public boolean verifyFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) { return false; }
        return firstName.matches("^[A-Za-z'-]+$");
    }

    public boolean verifySurname(String surname) {
        if (surname == null || surname.trim().isEmpty()) { return false; }
        return surname.matches("^[A-Za-z'-]+$");
    }

    public boolean verifyPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) { return false; }
        return phoneNumber.matches("^[0-9]{10}$");
    }

    public boolean verifyAreaCode(int areaCode) { return areaCode >= 1 && areaCode <= 24; }

    public boolean createDeliveryPerson(String firstName, String surname, String phoneNumber, int areaCode) {
    	if (!setFirstName(firstName)) return false;
        if (!setSurname(surname)) return false;
        if (!setPhoneNumber(phoneNumber)) return false;
        if (!setAreaCode(areaCode)) return false;
        return true;
    }
}