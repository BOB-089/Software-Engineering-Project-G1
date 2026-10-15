
public class Newsagent {
	private String firstName;
    private String surname;
    private String phoneNumber;
    private int id;
    private static int nextId = 10000;
    
    public Newsagent() {}

	public String getFirstName() { return firstName; }
	public String getSurname() { return surname; }
	public String getPhoneNumber() { return phoneNumber; }
	public int getId() { return id; }

	public boolean setFirstName(String firstName) { if (verifyFirstName(firstName)) { this.firstName = firstName; return true; } else return false; }
	public boolean setSurname(String surname) { if (verifySurname(surname)) { this.surname = surname; return true; } else return false; }
	public boolean setPhoneNumber(String phoneNumber) { if (verifyPhoneNumber(phoneNumber)) { this.phoneNumber = phoneNumber; return true; } else return false; }
	public void setId() { this.id = nextId++; }
    
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
	
	public boolean createNewsagent(String firstName, String surname, String phoneNumber) {
        if (!setFirstName(firstName)) return false;
        if (!setSurname(surname)) return false;
        if (!setPhoneNumber(phoneNumber)) return false;
        setId();
        return true;
    }
}
