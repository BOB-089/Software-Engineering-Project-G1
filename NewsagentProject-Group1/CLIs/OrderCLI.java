
import java.util.Scanner;

public class OrderCLI {
	public static void run(Scanner scanner) {
		System.out.print("What would you like to do:\n" + "1 Create order\n" + "2 Read order\n"
				+ "3 Update order\n" + "4 Delete order\n" + "Enter 1-4: ");
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
		System.out.println("=== FindOrder ===");
		System.out.print("Order Id: ");
		int id = scanner.nextInt();
		OrderDAO orderDAO = new OrderDAO();
		Order order = orderDAO.findOrderById(id);

		System.out.print(order);
	}

	private static void updateOrder(Scanner scanner) {
		System.out.println("=== Find Order ===");
		System.out.print("Order Id: ");
		int id = scanner.nextInt();
		OrderDAO  OrderDAO = new OrderDAO();
		Order order = OrderDAO.findOrderById(id);
		// updateCustomer
		OrderDAO.updateOrder(order);
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
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    run(scanner);
	    scanner.close();
	}
}