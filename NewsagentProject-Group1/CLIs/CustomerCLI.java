import java.util.Scanner; 

public class CustomerCLI {
	
	public static void run(Scanner scanner) {
		
		System.out.println("=== Create New Customer ===");

		System.out.print("First Name: ");
		String firstName = scanner.nextLine();

		System.out.print("Surname: ");
		String surname = scanner.nextLine();

		System.out.print("Address: ");
		String address = scanner.nextLine();

		System.out.print("Phone Number: ");
		String phoneNumber = scanner.nextLine();
		
		System.out.print("Area Code: ");
		int areaCode = scanner.nextInt();

		Customer customer = new Customer();
		customer.createCustomer(firstName, surname, address, phoneNumber, areaCode);

		CustomerDAO customerDAO = new CustomerDAO();

		if (customerDAO.addCustomer(customer)) {
			System.out.println("Customer saved successfully.");
		} else {
			System.out.println("Failed to save customer.");
		}
	}
}