import java.util.Scanner;

public class OrderCLI {

	public static voId main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== Create New Order ===");
		
		System.out.print("Publication Name: ");
		String publicationName = scanner.nextLine();
		
		System.out.print("Customer Id: ");
		String customerID= scanner.nextLine();
		
		System.out.print("Day: ");
		int day = scanner.nextLine();
		
		System.out.print("Month: ");
		int month = scanner.nextLine();
		
		System.out.print("Year: ");
		intyear = scanner.nextLine();
		
		
		Order order =
		new Order(
		publicationName,
		customerId,
		day,
		month,
		year);
		
		OrderDAO orderDAO = new OrderDAO();
		
		if (orderDAO.addOrder(order)) {
			System.out.println(
			"Order saved successfully.");
		} else {
			System.out.println(
			"Failed to save order.");
		}
		
		scanner.close();
	}
}
