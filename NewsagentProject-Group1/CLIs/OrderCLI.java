import java.util.Scanner;

public class OrderCLI {
	private static final OrderDAO orderDAO = new OrderDAO();
	
	public static void run(Scanner scanner) {
		boolean running = true;
		while (running) {
			System.out.println("\n=== Order Menu ===");
			System.out.print("What would you like to do:\n" + 
							 "1 Create order\n" + 
							 "2 Read order\n" + 
							 "3 Update order\n" + 
							 "4 Delete order\n" + 
							 "5 Return\n" + 
							 "Enter 1-5: ");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				createOrder(scanner);
				break;
			case "2":
				readOrder(scanner);
				break;
			case "3":
				updateOrder(scanner);
				break;
			case "4":
				deleteOrder(scanner);
				break;
			case "5":
				running = false;
				break;
			default:
				System.out.println("Invalid entry. Please enter 1-5.");
			}
		}
	}
	
	private static void createOrder(Scanner scanner) {
	    System.out.println("\n=== Create New Order ===");
	    Order order = new Order();
	    System.out.print("Publication name: ");
	    String publicationName = scanner.nextLine();
	    if (!orderDAO.publicationExists(publicationName)) { System.out.println("Publication with name " + publicationName + " could not be found."); return; }
	    order.setPublicationName(publicationName);
	    System.out.print("Customer Id: ");
	    int customerId;
	    try { customerId = Integer.parseInt(scanner.nextLine()); }
	    catch (NumberFormatException e) { System.out.println("Customer Id must be a whole number."); return; }
	    if (!orderDAO.customerExists(customerId)) { System.out.println("Customer with Id " + customerId + " could not be found."); return; }
	    order.setCustomerId(customerId);
	    System.out.print("Day: ");
	    int day;
	    try { day = Integer.parseInt(scanner.nextLine()); }
	    catch (NumberFormatException e) { System.out.println("Day must be a whole number."); return; }
	    if (!order.setDay(day)) { System.out.println("Day must be between 1 and 31."); return; }
	    System.out.print("Month: ");
	    int month;
	    try { month = Integer.parseInt(scanner.nextLine()); }
	    catch (NumberFormatException e) { System.out.println("Month must be a whole number."); return; }
	    if (!order.setMonth(month)) { System.out.println("Month must be between 1 and 12."); return; }
	    System.out.print("Year: ");
	    int year;
	    try { year = Integer.parseInt(scanner.nextLine()); }
	    catch (NumberFormatException e) { System.out.println("Year must be a whole number."); return; }
	    if (!order.setYear(year)) { System.out.println("Year must be 1900 or greater."); return; }
	    if (!order.verifyDate(order.getDay(), order.getMonth(), order.getYear())) { System.out.println("Invalid date."); return; }
	    order.setPublicationsAvailable(true);
	    if (orderDAO.addOrder(order)) {
	        System.out.println("Order saved successfully.");
	    } else {
	        System.out.println("Failed to save order.");
	    }
	}

	private static void readOrder(Scanner scanner) {
		System.out.println("\n=== Read Order ===");
		System.out.print("Order Id: ");
		int orderId;
		try { orderId = Integer.parseInt(scanner.nextLine()); }
		catch (NumberFormatException e) { System.out.println("Order Id must be a whole number."); return; }
		Order order = orderDAO.findOrderById(orderId); 
		if (order == null) { System.out.println("Order with Id " + orderId + " could not be found."); return; }
		System.out.println("Publication name: " + order.getPublicationName() + 
						   "\nCustomer Id: " + order.getCustomerId() +
						   "\nDay: " + order.getDay() + 
						   "\nMonth: " + order.getMonth() + 
						   "\nYear: " + order.getYear());
	}

	private static void updateOrder(Scanner scanner) {
		System.out.println("\n=== Update Order ===");
		System.out.print("Order Id: ");
		int orderId;
		try { orderId = Integer.parseInt(scanner.nextLine()); }
		catch (NumberFormatException e) { System.out.println("Order Id must be a whole number."); return; }
		Order order = orderDAO.findOrderById(orderId);
		if (order == null) { System.out.println("Order with Id " + orderId + " could not be found."); return; }
		boolean updating = true;
		while (updating) {
			System.out.print("What would you like to update:\n" + 
							 "1 Publication name\n" + 
							 "2 Customer Id\n" + 
							 "3 Day\n" + 
							 "4 Month\n" + 
							 "5 Year\n" + 
							 "6 Complete\n" + 
							 "Enter 1-6: ");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				System.out.print("Publication name: ");
				String publicationName = scanner.nextLine();
				if (!orderDAO.publicationExists(publicationName)) { System.out.println("Publication with name " + publicationName + " could not be found."); break; }
				order.setPublicationName(publicationName);
				break;
			case "2":
				System.out.print("Customer Id: ");
				int customerId;
				try { customerId = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { System.out.println("Customer Id must be a whole number."); break; }
			    if (!orderDAO.customerExists(customerId)) { System.out.println("Customer with Id " + customerId + " could not be found."); break; }
			    order.setCustomerId(customerId);
				break;
			case "3":
				System.out.print("Day: ");
			    int day;
			    try { day = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { System.out.println("Day must be a whole number."); break; }
			    if (!order.setDay(day)) { System.out.println("Day must be between 1 and 31."); }
			    break;
			case "4":
				System.out.print("Month: ");
			    int month;
			    try { month = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { System.out.println("Month must be a whole number."); break; }
			    if (!order.setMonth(month)) { System.out.println("Month must be between 1 and 12."); }
			    break;
			case "5":
				System.out.print("Year: ");
			    int year;
			    try { year = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { System.out.println("Year must be a whole number."); break; }
			    if (!order.setYear(year)) { System.out.println("Year must be 1900 or greater."); }
			    break;
			case "6":
				updating = false;
				break;
			default:
				System.out.println("Invalid entry. Please enter 1-6.");
			}
		}
		if (!order.verifyDate(order.getDay(), order.getMonth(), order.getYear())) 
		{ 
			System.out.println("Invalid date. \nFailed to update order."); 
			return;
		}
		if (orderDAO.updateOrder(order)) {
			System.out.println("Order updated.");
		} else {
			System.out.println("Failed to update order.");
		}
	}

	private static void deleteOrder(Scanner scanner) {
		System.out.println("\n=== Delete Order ===");
		System.out.print("Order Id: ");
		int orderId;
		try { orderId = Integer.parseInt(scanner.nextLine()); }
		catch (NumberFormatException e) { System.out.println("Order Id must be a whole number."); return; }
		Order order = orderDAO.findOrderById(orderId);
		if (order == null) { System.out.println("Order with Id " + orderId + " could not be found."); return; }
		System.out.print("Are you sure you want to delete this order from the database? (yes/no): ");
		String confirmation = scanner.nextLine().trim();
		if (confirmation.equalsIgnoreCase("yes")) {
			if (orderDAO.deleteOrder(orderId)) {
				System.out.println("Order deleted successfully.");
			} else {
				System.out.println("Failed to delete order.");
			}
		} else {
			System.out.println("Deletion cancelled.");
		}
	}
}