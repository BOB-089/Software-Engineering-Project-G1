import java.util.Scanner;

public class BillCLI {
	private static final BillDAO billDAO = new BillDAO();
	
	public static void run(Scanner scanner) {
		boolean running = true;
		while (running) {
			System.out.println("\n=== Bill Menu ===");
			System.out.print("What would you like to do:\n" + 
							 "1 Create bill\n" + 
							 "2 Read bill\n" + 
							 "3 Update bill\n" + 
							 "4 Delete bill\n" + 
							 "5 Return\n" + 
							 "Enter 1-5: ");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				createBill(scanner);
				break;
			case "2":
				readBill(scanner);
				break;
			case "3":
				updateBill(scanner);
				break;
			case "4":
				deleteBill(scanner);
				break;
			case "5":
				running = false;
				break;
			default:
				System.out.println("Invalid entry. Please enter 1-5.");
			}
		}
	}
	
	private static void createBill(Scanner scanner) {
	    System.out.println("\n=== Create New Bill ===");
	    Bill bill = new Bill();
	    System.out.print("Customer Id: ");
	    int customerId;
	    try { customerId = Integer.parseInt(scanner.nextLine()); }
	    catch (NumberFormatException e) { System.out.println("Customer Id must be a whole number."); return; }
	    if (!billDAO.customerExists(customerId)) { System.out.println("Customer with Id " + customerId + " could not be found."); return; }
	    bill.setCustomerId(customerId);
	    System.out.print("Month: ");
	    int month;
	    try { month = Integer.parseInt(scanner.nextLine()); }
	    catch (NumberFormatException e) { System.out.println("Month must be a whole number."); return; }
	    if (!bill.setMonth(month)) { System.out.println("Month must be between 1 and 12."); return; }
	    System.out.print("Year: ");
	    int year;
	    try { year = Integer.parseInt(scanner.nextLine()); }
	    catch (NumberFormatException e) { System.out.println("Year must be a whole number."); return; }
	    if (!bill.setYear(year)) { System.out.println("Year must be 1900 or greater."); return; }
	    bill.setTotal(billDAO.calculateBillTotal(bill.getCustomerId(), bill.getMonth(), bill.getYear()));
	    bill.setPaid(false);
	    if (billDAO.addBill(bill)) {
	        System.out.println("Bill saved successfully.");
	    } else {
	        System.out.println("Failed to save bill.");
	    }
	}
	
	private static void readBill(Scanner scanner) {
		System.out.println("\n=== Read Bill ===");
		System.out.print("Bill Id: ");
		int billId;
        try { billId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Bill Id must be a whole number."); return; }
		Bill bill = billDAO.findBillById(billId); 
		if (bill == null) { System.out.println("Bill with Id " + billId + " could not be found."); return; }
		System.out.println("Customer Id: " + bill.getCustomerId() + 
						   "\nMonth: " + bill.getMonth() + 
						   "\nYear: " + bill.getYear() +
						   "\nTotal: €" + String.format("%.2f", bill.getTotal()) + 
						   "\nPaid: " + (bill.isPaid() ? "Yes" : "No"));
	}
	
	private static void updateBill(Scanner scanner) {
		System.out.println("\n=== Update Bill ===");
		System.out.print("Bill Id: ");
		int billId;
        try { billId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Bill Id must be a whole number."); return; }
		Bill bill = billDAO.findBillById(billId);
		if (bill == null) { System.out.println("Bill with Id " + billId + " could not be found."); return; }
		boolean updating = true;
		while (updating) {
			System.out.print("What would you like to update:\n" + 
							 "1 Customer Id\n" + 
							 "2 Month\n" + 
							 "3 Year\n" + 
							 "4 Paid\n" + 
							 "5 Complete\n" + 
							 "Enter 1-5: ");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				System.out.print("Customer Id: ");
			    int customerId;
			    try { customerId = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { System.out.println("Customer Id must be a whole number."); break; }
			    if (!billDAO.customerExists(customerId)) { System.out.println("Customer with Id " + customerId + " could not be found."); break; }
			    bill.setCustomerId(customerId);
			    break;
			case "2":
				System.out.print("Month: ");
				int month;
			    try { month = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { System.out.println("Month must be a whole number."); break; }
			    if (!bill.setMonth(month)) { System.out.println("Month must be between 1 and 12."); }
			    break;
			case "3":
				System.out.print("Year: ");
				int year;
			    try { year = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { System.out.println("Year must be a whole number."); break; }
			    if (!bill.setYear(year)) { System.out.println("Year must be 1900 or greater."); }
			    break;
			case "4":
				System.out.print("Paid (yes/no): ");
				String paidInput = scanner.nextLine().trim();
			    if (paidInput.equalsIgnoreCase("yes")) { bill.setPaid(true); } 
			    else if (paidInput.equalsIgnoreCase("no")) { bill.setPaid(false); } 
			    else { System.out.println("Invalid entry. Please enter yes or no."); }
				break;
			case "5":
				updating = false;
				break;
			default:
				System.out.println("Invalid entry. Please enter 1-5.");
			}
		}
	    bill.setTotal(billDAO.calculateBillTotal(bill.getCustomerId(), bill.getMonth(), bill.getYear()));
		if (billDAO.updateBill(bill)) {
		    System.out.println("Bill updated.");
		} else {
		    System.out.println("Failed to update bill.");
		}
	}
	
	private static void deleteBill(Scanner scanner) {
		System.out.println("\n=== Delete Bill ===");
		System.out.print("Bill Id: ");
		int billId;
        try { billId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Bill Id must be a whole number."); return; }
        Bill bill = billDAO.findBillById(billId);
		if (bill == null) { System.out.println("Bill with Id " + billId + " could not be found."); return; }
        System.out.print("Are you sure you want to delete this bill from the database? (yes/no): ");
        String confirmation = scanner.nextLine().trim();
        if (confirmation.equalsIgnoreCase("yes")) { 
        	if (billDAO.deleteBill(billId)) {
        		System.out.println("Bill deleted successfully.");
        	} else {
        		System.out.println("Failed to delete bill.");
        	}
        } else {
        	System.out.println("Deletion cancelled.");
        }
	}
}