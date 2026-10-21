import java.util.Scanner;

public class OrderCLI {

	public static void run(Scanner scanner) {
		
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
}
