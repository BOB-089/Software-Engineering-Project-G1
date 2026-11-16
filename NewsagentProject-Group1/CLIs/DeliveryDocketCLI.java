import java.util.ArrayList;
import java.util.Scanner;

public class DeliveryDocketCLI {
	private static final DeliveryDocketDAO deliveryDocketDAO = new DeliveryDocketDAO();
	
	public static void run(Scanner scanner) {
		boolean running = true;
		while (running) {
			System.out.println("\n=== Delivery Docket Menu ===");
			System.out.print("What would you like to do:\n" + 
							 "1 Create delivery docket\n" + 
							 "2 Read delivery docket\n" + 
							 "3 Update delivery docket\n" + 
							 "4 Delete delivery docket\n" + 
							 "5 Return\n" + 
							 "Enter 1-5: ");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				createDeliveryDocket(scanner);
				break;
			case "2":
				readDeliveryDocket(scanner);
				break;
			case "3":
				updateDeliveryDocket(scanner);
				break;
			case "4":
				deleteDeliveryDocket(scanner);
				break;
			case "5":
				running = false;
				break;
			default:
				System.out.println("Invalid entry. Please enter 1-5.");
			}
		}
	}

	private static void createDeliveryDocket(Scanner scanner) {
		System.out.println("\n=== Create New Delivery Docket ===");
		System.out.print("Area code: ");
		int areaCode;
        try { areaCode = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Area code must be a whole number."); return; }
        System.out.print("Day: ");
		int day;
        try { day = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Day must be a whole number."); return; }
        System.out.print("Month: ");
		int month;
        try { month = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Month must be a whole number."); return; }
        System.out.print("Year: ");
		int year;
        try { year = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Year must be a whole number."); return; }
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		if (!deliveryDocket.createDeliveryDocket(areaCode, day, month, year)) { System.out.println("Invalid delivery docket details."); return; }
		if (deliveryDocketDAO.addDeliveryDocket(deliveryDocket)) {
			System.out.println("Delivery docket saved successfully.");
		} else {
			System.out.println("Failed to save delivery docket.");
		}
	}
	
	private static void readDeliveryDocket(Scanner scanner) {
		System.out.println("\n=== Read Delivery Docket ===");
		System.out.print("Delivery docket Id: ");
		int deliveryDocketId;
        try { deliveryDocketId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Delivery docket Id must be a whole number."); return; }
		DeliveryDocket deliveryDocket = deliveryDocketDAO.findDeliveryDocketById(deliveryDocketId); 
		if (deliveryDocket == null) { System.out.println("Delivery docket with Id " + deliveryDocketId + " could not be found."); return; }
		System.out.println("Area code: " + deliveryDocket.getAreaCode() + 
						   "\nDay: " + deliveryDocket.getDay() +
						   "\nMonth: " + deliveryDocket.getMonth() + 
						   "\nYear: " + deliveryDocket.getYear());
		ArrayList<Order> orders = deliveryDocketDAO.getOrdersForDocket(deliveryDocket);
		System.out.println("\n=== Orders For Delivery ===");
		if (orders.isEmpty()) {
			System.out.println("No orders found for this delivery docket.");
		} else {
			for (Order order : orders) {
				System.out.println("Order Id: " + order.getOrderId() +
			            		   "\nCustomer Id: " + order.getCustomerId() +
			            		   "\nPublication: " + order.getPublicationName() +
			            		   "\n---------------------------");
			}
		}
	}
	
	private static void updateDeliveryDocket(Scanner scanner) {
		System.out.println("\n=== Update Delivery Docket ===");
		System.out.print("Delivery docket Id: ");
		int deliveryDocketId;
        try { deliveryDocketId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Delivery docket Id must be a whole number."); return; }
		DeliveryDocket deliveryDocket = deliveryDocketDAO.findDeliveryDocketById(deliveryDocketId);
		if (deliveryDocket == null) { System.out.println("Delivery docket with Id " + deliveryDocketId + " could not be found."); return; }
		boolean updating = true;
		while (updating) {
			System.out.print("What would you like to update:\n" + 
							 "1 Area code\n" + 
							 "2 Day\n" + 
							 "3 Month\n" + 
							 "4 Year\n" + 
							 "5 Complete\n" + 
							 "Enter 1-5: ");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				System.out.print("Area code: ");
			    int areaCode;
			    try { areaCode = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { System.out.println("Area code must be a whole number."); break; }
			    if (!deliveryDocket.setAreaCode(areaCode)) { System.out.println("Area code must be between 1 and 24."); }
			    break;
			case "2":
				System.out.print("Day: ");
				int day;
				try { day = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { System.out.println("Day must be a whole number."); break; }
			    if (!deliveryDocket.setDay(day)) { System.out.println("Day must be between 1 and 31."); }
			    break;
			case "3":
				System.out.print("Month: ");
				int month;
				try { month = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { System.out.println("Month must be a whole number."); break; }
			    if (!deliveryDocket.setMonth(month)) { System.out.println("Month must be between 1 and 12."); }
			    break;
			case "4":
				System.out.print("Year: ");
				int year;
				try { year = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { System.out.println("Year must be a whole number."); break; }
			    if (!deliveryDocket.setYear(year)) { System.out.println("Year must be 1900 or greater."); }
			    break;
			case "5":
				updating = false;
				break;
			default:
				System.out.println("Invalid entry. Please enter 1-5.");
			}
		}
		if (!deliveryDocket.verifyDate(deliveryDocket.getDay(), deliveryDocket.getMonth(), deliveryDocket.getYear())) 
		{ 
			System.out.println("Invalid date. \nFailed to update delivery docket."); 
			return;
		}
		if (deliveryDocketDAO.updateDeliveryDocket(deliveryDocket)) {
		    System.out.println("Delivery docket updated.");
		} else {
		    System.out.println("Failed to update delivery docket.");
		}
	}
	
	private static void deleteDeliveryDocket(Scanner scanner) {
		System.out.println("\n=== Delete Delivery Docket ===");
		System.out.print("Delivery docket Id: ");
		int deliveryDocketId;
        try { deliveryDocketId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Delivery docket Id must be a whole number."); return; }
        DeliveryDocket deliveryDocket = deliveryDocketDAO.findDeliveryDocketById(deliveryDocketId);
		if (deliveryDocket == null) { System.out.println("Delivery docket with Id " + deliveryDocketId + " could not be found."); return; }
        System.out.print("Are you sure you want to delete this delivery docket from the database? (yes/no): ");
        String confirmation = scanner.nextLine().trim();
        if (confirmation.equalsIgnoreCase("yes")) { 
        	if (deliveryDocketDAO.deleteDeliveryDocket(deliveryDocketId)) {
        		System.out.println("Delivery docket deleted successfully.");
        	} else {
        		System.out.println("Failed to delete delivery docket.");
        	}
        } else {
        	System.out.println("Deletion cancelled.");
        }
	}
}