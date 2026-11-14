public class Bill {
	private int customerId;
    private int month;
    private int year;
    private double total;
    private boolean paid;
    private int billId;

    public Bill() {}

    public int getCustomerId() { return customerId; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
    public double getTotal() { return total; }
    public boolean isPaid() { return paid; }
    public int getBillId() { return billId; }

    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public boolean setMonth(int month) { if (verifyMonth(month)) { this.month = month; return true; } else return false; }
    public boolean setYear(int year) { if (verifyYear(year)) { this.year = year; return true; } else return false; }
    public void setTotal(double total) { this.total = total; }
    public void setPaid(boolean paid) { this.paid = paid; }
    public void setBillId(int billId) { this.billId = billId; }
    
	public boolean verifyMonth(int month) { return month >= 1 && month <= 12; }
	public boolean verifyYear(int year) { return year >= 1900; }

    public boolean createBill(int customerId, int month, int year, double total, boolean paid) {
    	setCustomerId(customerId);
        if (!setMonth(month)) return false;
        if (!setYear(year)) return false;
        setTotal(total);
        setPaid(false);
        return true;
    }
}