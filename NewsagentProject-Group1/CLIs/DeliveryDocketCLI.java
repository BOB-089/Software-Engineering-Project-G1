import java.util.ArrayList;
import java.util.Scanner;
public class DeliveryDocketCLI {
	private static final DeliveryDocketDAO deliveryDocketDAO = new DeliveryDocketDAO();
	
	public static void run(Scanner scanner) {
		boolean running = true;
		while (running) {
			System.out.print("What would you like to do:\n" + "1 Create docket\n" + "2 Read docket\n"
					+ "3 Update docket\n" + "4 Delete docket\n" + "5 Return\n" + "Enter 1-5: ");
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
				System.out.println("Entry Invalid. Please enter 1-5.");
			}
		}
	}

	private static void createDeliveryDocket(Scanner scanner) {
		System.out.println("=== Create New Delivery Docket ===");
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

		DeliveryDocket docket = new DeliveryDocket();
		if (!docket.createDeliveryDocket(areaCode, day, month, year)) { System.out.println("Invalid Delivery Docket details."); return; }
		if (deliveryDocketDAO.addDeliveryDocket(docket)) {
			System.out.println("Delivery Docket saved successfully.");
		} else {
			System.out.println("Failed to save docket.");
		}
	}
	
	private static void readDeliveryDocket(Scanner scanner) {
		System.out.println("=== Find Delivery Docket ===");
		System.out.print("Delivery Docket Id: ");
		int docketId;
        try { docketId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Docket ID must be a whole number."); return; }
		DeliveryDocket docket = deliveryDocketDAO.findDeliveryDocketById(docketId); 
		if (docket == null) { System.out.println("Delivery Docket with ID " + docketId + " could not be found."); return; }
		System.out.println("Area Code: " + docket.getAreaCode() + 
						   "\nDay: " + docket.getDay() +
						   "\nMonth: " + docket.getMonth() + 
						   "\nYear: " + docket.getYear());
		ArrayList<Order> orders = deliveryDocketDAO.getOrdersForDocket(docket);
		System.out.println("\n=== Orders for Delivery ===");
		if (orders.isEmpty()) {
			System.out.println("No orders found for this docket.");
		} else {
			for (Order order : orders) {
				System.out.println("Order ID: " + order.getOrderId() +
			            "\nCustomer ID: " + order.getCustomerId() +
			            "\nPublication: " + order.getPublicationName() +
			            "\n---------------------------");
			}
		}
	}
	
	private static void updateDeliveryDocket(Scanner scanner) {
		System.out.println("=== Find Delivery Docket ===");
		System.out.print("Delivery Docket Id: ");
		int docketId;
        try { docketId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Docket ID must be a whole number."); return; }
		DeliveryDocket docket = deliveryDocketDAO.findDeliveryDocketById(docketId);
		if (docket == null) { System.out.println("Delivery Docket with ID " + docketId + " could not be found."); return; }
		System.out.println("=== Update Delivery Docket ===");
		boolean updating = true;
		while (updating) {
			System.out.print("What would you like to update:\n" + "1 Area Code\n" + "2 Day\n"
					+ "3 Month\n" + "4 Year\n" + "5 Complete\n" + "Enter 1-5: ");
			String choice = scanner.nextLine();
			boolean validEntry = true;
			switch (choice) {
			case "1":
				System.out.print("Area code: ");
			    int areaCode;
			    try { areaCode = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { validEntry = false; break; }
			    validEntry = docket.setAreaCode(areaCode);
			    break;
			case "2":
				System.out.print("Day: ");
				int day;
			    try { day = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { validEntry = false; break; }
			    validEntry = docket.setDay(day);
			    break;
			case "3":
				System.out.print("Month: ");
				int month;
			    try { month = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { validEntry = false; break; }
			    validEntry = docket.setMonth(month);
			    break;
			case "4":
				System.out.print("Year: ");
				int year;
			    try { year = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { validEntry = false; break; }
			    validEntry = docket.setYear(year);
			    break;
			case "5":
				updating = false;
				break;
			default:
				System.out.println("Entry Invalid. Please enter 1-5.");
			}
			if (!validEntry) { System.out.println("Invalid value entered."); }
		}
		if (deliveryDocketDAO.updateDeliveryDocket(docket)) {
		    System.out.println("Delivery Docket updated.");
		} else {
		    System.out.println("Failed to update docket.");
		}
	}
	
	private static void deleteDeliveryDocket(Scanner scanner) {
		System.out.println("=== Delete Delivery Docket ===");
		System.out.print("Delivery Docket Id: ");
		int docketId;
        try { docketId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Docket ID must be a whole number."); return; }
        DeliveryDocket docket = deliveryDocketDAO.findDeliveryDocketById(docketId);
		if (docket == null) { System.out.println("Delivery Docket with ID " + docketId + " could not be found."); return; }
        System.out.print("Are you sure you want to delete this docket from the database? (yes/no): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();
        if (confirmation.equalsIgnoreCase("yes")) { 
        	if (deliveryDocketDAO.deleteDeliveryDocket(docketId)) {
        		System.out.println("Delivery Docket deleted successfully.");
        	} else {
        		System.out.println("Failed to delete docket.");
        	}
        } else {
        	System.out.println("Deletion cancelled.");
        }
	}
}