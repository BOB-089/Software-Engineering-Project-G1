
import java.util.Scanner;

public class OrderCLI {
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
				System.out.println("Entry Invalid. Please enter 1-5");
			}
		}
	}

	private static void createOrder(Scanner scanner) {
		System.out.println("=== Create New Order ===");
		System.out.print("Publication Name: ");
		String publicationName = scanner.nextLine();
		System.out.print("Customer Id: ");
		int customerId = scanner.nextInt();
		System.out.print("Day: ");
		int day = scanner.nextInt();
		System.out.print("Month: ");
		int month = scanner.nextInt();
		System.out.print("Year: ");
		int year = scanner.nextInt();
		Order order = new Order();
		order.createOrder(publicationName, customerId, day, month, year);
		OrderDAO orderDAO = new OrderDAO();
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
		int id = scanner.nextInt();
		scanner.nextLine();
		OrderDAO orderDAO = new OrderDAO();
		Order order = orderDAO.findOrderById(id); 
		if (order == null) { System.out.println("Order with id " + id + " could not be found"); return; }
		System.out.println("Publication name: " + order.getPublicationName() + 
						   "\nCustomer ID: " + order.getCustomerId() +
						   "\nDay: " + order.getDay() + 
						   "\nMonth: " + order.getMonth() + 
						   "\nYear: " + order.getYear());
	}

	private static void updateOrder(Scanner scanner) {
		System.out.println("=== Find Order ===");
		System.out.print("Order Id: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		OrderDAO orderDAO = new OrderDAO();
		Order order = orderDAO.findOrderById(id);
		if (order == null) { System.out.println("Order with id " + id + " could not be found"); return; }
		System.out.println("=== Update Order ===");
		try {
			boolean updating = true;
			while (updating) {
				System.out.print("What would you like to update:\n" + "1 Publication name\n" + "2 Customer ID\n"
						+ "3 Day\n" + "4 Month\n" + "5 Year\n" + "6 Complete\n" + "Enter 1-6: ");
				String choice = scanner.nextLine();
				boolean validEntry = true;
				switch (choice) {
				case "1":
					System.out.print("Publication Name: ");
					validEntry = order.setPublicationName(scanner.nextLine());
					break;
				case "2":
					System.out.print("Customer ID: ");
					validEntry = order.setCustomerId(scanner.nextInt());
					break;
				case "3":
					System.out.print("Day: ");
					validEntry = order.setDay(scanner.nextInt());
					break;
				case "4":
					System.out.print("Month: ");
					validEntry = order.setMonth(scanner.nextInt());
					break;
				case "5":
					System.out.print("Year: ");
					validEntry = order.setYear(scanner.nextInt());
					scanner.nextLine();
					break;
				case "6":
					updating = false;
					break;
				default:
					System.out.println("Entry Invalid. Please enter 1-6");
				}
				if (!validEntry) { System.out.println("Invalid value entered."); }
			}
			orderDAO.updateOrder(order);
			System.out.println("Order updated");
		} catch (Exception e) { System.out.println("Failed to update order"); }
	}

	private static void deleteOrder(Scanner scanner) {
		System.out.println("=== Delete Order ===");
		System.out.print("Order Id: ");
		int id = scanner.nextInt();
		OrderDAO OrderDAO = new OrderDAO();
		if (OrderDAO.deleteOrder(id)) {
			System.out.println("Order deleted successfully.");
		} else {
			System.out.println("Failed to delete Order.");
		}
	}
}