
import java.util.Scanner;

public class OrderCLI {
	private static final OrderDAO orderDAO = new OrderDAO();
	
	public static void run(Scanner scanner) {
		boolean running = true;
		while (running) {
			System.out.print("What would you like to do:\n" + "1 Create order\n" + "2 Read order\n"
					+ "3 Update order\n" + "4 Delete order\n" + "5 Return\n" + "Enter 1-5: ");
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
				System.out.println("Entry Invalid. Please enter 1-5.");
			}
		}
	}

	private static void createOrder(Scanner scanner) {
		System.out.println("=== Create New Order ===");
		System.out.print("Publication name: ");
		String publicationName = scanner.nextLine();
		System.out.print("Customer Id: ");
		int customerId;
		try { customerId = Integer.parseInt(scanner.nextLine()); }
		catch (NumberFormatException e) { System.out.println("Customer Id must be a whole number."); return; }
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
		Order order = new Order();
		if (!order.createOrder(publicationName, customerId, day, month, year)) { System.out.println("Invalid order details."); return; }
		if (orderDAO.addOrder(order)) {
			System.out.println(
			"Order saved successfully.");
		} else {
			System.out.println(
			"Failed to save order.");
		}
	}

	private static void readOrder(Scanner scanner) {
		System.out.println("=== Find Order ===");
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
		System.out.println("=== Find Order ===");
		System.out.print("Order Id: ");
		int orderId;
		try { orderId = Integer.parseInt(scanner.nextLine()); }
		catch (NumberFormatException e) { System.out.println("Order Id must be a whole number."); return; }
		Order order = orderDAO.findOrderById(orderId);
		if (order == null) { System.out.println("Order with Id " + orderId + " could not be found."); return; }
		System.out.println("=== Update Order ===");
		boolean updating = true;
		while (updating) {
			System.out.print("What would you like to update:\n" + "1 Publication name\n" + "2 Customer Id\n"
					+ "3 Day\n" + "4 Month\n" + "5 Year\n" + "6 Complete\n" + "Enter 1-6: ");
			String choice = scanner.nextLine();
			boolean validEntry = true;
			switch (choice) {
			case "1":
				System.out.print("Publication name: ");
				validEntry = order.setPublicationName(scanner.nextLine());
				break;
			case "2":
				System.out.print("Customer Id: ");
				int customerId;
			    try { customerId = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { validEntry = false; break; }
			    validEntry = order.setCustomerId(customerId);
				break;
			case "3":
				System.out.print("Day: ");
				int day;
			    try { day = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { validEntry = false; break; }
			    validEntry = order.setDay(day);
				break;
			case "4":
				System.out.print("Month: ");
				int month;
			    try { month = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { validEntry = false; break; }
			    validEntry = order.setMonth(month);
				break;
			case "5":
				System.out.print("Year: ");
				int year;
			    try { year = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { validEntry = false; break; }
			    validEntry = order.setYear(year);
				break;
			case "6":
				updating = false;
				break;
			default:
				System.out.println("Entry Invalid. Please enter 1-6.");
			}
			if (!validEntry) { System.out.println("Invalid value entered."); }
		}
		if (orderDAO.updateOrder(order)) {
			System.out.println("Order updated.");
		} else {
			System.out.println("Failed to update order.");
		}
	}

	private static void deleteOrder(Scanner scanner) {
		System.out.println("=== Delete Order ===");
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
			System.out.println("Deletion cancelled. Returning to system home page.");
		}
	}
}