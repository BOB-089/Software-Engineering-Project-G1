
public class Publications {
	private String publicationName;
	private int publicationStock;
	private int publicationId;
	
	public Publications() {}
	
	public String getPublicationName() { return publicationName; }
    public int getPublicationStock() { return publicationStock; }
    public int getPublicationId() { return publicationId; }
    
    public boolean setPublicationName(String publicationName) { if (verifyPublicationName(publicationName)) { this.publicationName = publicationName; return true; } else return false; }
    public boolean setPublicationStock(int publicationStock) { if (verifyPublicationStock(publicationStock)) { this.publicationStock = publicationStock; return true; } else return false; }
    public void setPublicationId(int publicationId) { this.publicationId = publicationId; }
    
    public boolean verifyPublicationName(String publicationName) {
        if (publicationName == null || publicationName.trim().isEmpty()) { return false; }
        return publicationName.matches("^[A-Za-z'-]+$");
    }
    
    public boolean verifyPublicationStock(int publicationStock) {
		if (publicationStock <= 1) { return false; }
		else { return true; }
    }
    
    public boolean createPublication(String publicationName, int publicationStock) {
        if (!setPublicationName(publicationName)) return false;
        if (!setPublicationStock(publicationStock)) return false;
        return true;
    }
}