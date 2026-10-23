import java.util.Scanner; 

public class CustomerCLI {
	
	public static void run(Scanner scanner) {
		
		System.out.println("What would you like to do:\n"
				+ "1 Create customer\n" + "2 Read customer\n" + "3 Update customer\n" + "4 Delete customer\n"  + "Enter 1-4: ");
		String choice = scanner.nextLine();
		switch (choice) {
		case "1": 
			CreateCustomer(scanner);
			break;
		case "2": 
			CustomerCLI.run(scanner);
			break;
		case "3": 
			OrderCLI.run(scanner);
			break;
		case "4": 
			OrderCLI.run(scanner);
			break;
		}
	}
	
	private static void CreateCustomer(Scanner scanner) {
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
	
	private static void ReadCustomer(Scanner scanner) {
		System.out.println("=== Find Customer ===");

		System.out.print("Customer Id: ");
		int id = scanner.nextInt();
		
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.findCustomerById(id);
		//updateCustomer
		customerDAO.updateCustomer(customer);
	}
}