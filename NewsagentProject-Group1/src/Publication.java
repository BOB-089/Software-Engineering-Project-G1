
public class Publication {
	private String name;
	private int stock;
	private double price;
	private int publicationId;
	
	public Publication() {}
	
	public String getName() { return name; }
    public int getStock() { return stock; }
    public double getPrice() { return price; }
    public int getPublicationId() { return publicationId; }
    
    public boolean setName(String name) { if (verifyName(name)) { this.name = name; return true; } else return false; }
    public boolean setStock(int stock) { if (verifyStock(stock)) { this.stock = stock; return true; } else return false; }
    public boolean setPrice(double price) { if (verifyPrice(price)) { this.price = price; return true; } else return false; }
    public void setPublicationId(int publicationId) { this.publicationId = publicationId; }
    
    public boolean verifyName(String name) {
        if (name == null || name.trim().isEmpty()) { return false; }
        return name.matches("^[A-Za-z0-9' -]+$");
    }
    
    public boolean verifyStock(int stock) { return stock > 0; }
    
    public boolean verifyPrice(double price) { return price > 0 && Math.round(price * 100) == price * 100; }
    
    public boolean createPublication(String name, int stock, double price) {
        if (!setName(name)) return false;
        if (!setStock(stock)) return false;
        if (!setPrice(price)) return false;
        return true;
    }
}