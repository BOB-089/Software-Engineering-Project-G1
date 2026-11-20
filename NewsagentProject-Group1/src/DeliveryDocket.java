import java.time.DateTimeException;
import java.time.LocalDate;

public class DeliveryDocket {
	private int areaCode;
	private int deliveryDocketId;
    private int day;
    private int month;
    private int year;
	
    public DeliveryDocket() {}
    
    public int getAreaCode() { return areaCode; }
    public int getDeliveryDocketId() { return deliveryDocketId; }
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
    public String getDate() { return day + "/" + month + "/" + year; }

    public void setAreaCode(int areaCode) { this.areaCode = areaCode; }
	public void setDeliveryDocketId(int deliveryDocketId) { this.deliveryDocketId = deliveryDocketId; }
	public boolean setDay(int day) { if (verifyDay(day)) { this.day = day; return true; } else return false; }
	public boolean setMonth(int month) { if (verifyMonth(month)) { this.month = month; return true; } else return false; }
	public boolean setYear(int year) { if (verifyYear(year)) { this.year = year; return true; } else return false; }
	
	public boolean verifyDay(int day) { return day >= 1 && day <= 31; }
	
	public boolean verifyMonth(int month) { return month >= 1 && month <= 12; }
	
	public boolean verifyYear(int year) { return year >= 1900; }
	
	public boolean verifyDate(int day, int month, int year) {
	    try { LocalDate.of(year, month, day); return true; } 
	    catch (DateTimeException e) { return false; }
	}
	
	// Convenience creation method used by tests
	public boolean createDeliveryDocket(int areaCode, int day, int month, int year) {
		setAreaCode(areaCode);
	    if (!setDay(day)) return false;
	    if (!setMonth(month)) return false;
	    if (!setYear(year)) return false;
	    if (!verifyDate(day, month, year)) return false;
	    return true;
    }
}