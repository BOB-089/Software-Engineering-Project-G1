import java.util.Scanner;

public class CustomerCLI {
	private static final CustomerDAO customerDAO = new CustomerDAO();
	
	public static void run(Scanner scanner) {
		boolean running = true;
		while (running) {
			System.out.print("What would you like to do:\n" + "1 Create customer\n" + "2 Read customer\n"
					+ "3 Update customer\n" + "4 Delete customer\n" + "5 Return\n" + "Enter 1-5: ");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				createCustomer(scanner);
				break;
			case "2":
				readCustomer(scanner);
				break;
			case "3":
				updateCustomer(scanner);
				break;
			case "4":
				deleteCustomer(scanner);
				break;
			case "5":
				running = false;
				break;
			default:
				System.out.println("Entry Invalid. Please enter 1-5.");
			}
		}
	}

	private static void createCustomer(Scanner scanner) {
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
		int areaCode;
        try { areaCode = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Area code must be a whole number."); return; }
		Customer customer = new Customer();
		if (!customer.createCustomer(firstName, surname, address, phoneNumber, areaCode)) { System.out.println("Invalid customer details."); return; }
		if (customerDAO.addCustomer(customer)) {
			System.out.println("Customer saved successfully.");
		} else {
			System.out.println("Failed to save customer.");
		}
	}

	private static void readCustomer(Scanner scanner) {
		System.out.println("=== Find Customer ===");
		System.out.print("Customer Id: ");
		int id;
        try { id = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Id must be a whole number."); return; }
		Customer customer = customerDAO.findCustomerById(id); 
		if (customer == null) { System.out.println("Customer with id " + id + " could not be found."); return; }
		System.out.println("First Name: " + customer.getFirstName() + 
						   "\nSurname: " + customer.getSurname() +
						   "\nAddress: " + customer.getAddress() + 
						   "\nPhone Number: " + customer.getPhoneNumber() + 
						   "\nArea Code: " + customer.getAreaCode());
	}

	private static void updateCustomer(Scanner scanner) {
		System.out.println("=== Find Customer ===");
		System.out.print("Customer Id: ");
		int id;
        try { id = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Id must be a whole number."); return; }
		Customer customer = customerDAO.findCustomerById(id);
		if (customer == null) { System.out.println("Customer with id " + id + " could not be found."); return; }
		System.out.println("=== Update Customer ===");
		boolean updating = true;
		while (updating) {
			System.out.print("What would you like to update:\n" + "1 First Name\n" + "2 Surname\n"
					+ "3 Address\n" + "4 Phone Number\n" + "5 Area Code\n" + "6 Complete\n" + "Enter 1-6: ");
			String choice = scanner.nextLine();
			boolean validEntry = true;
			switch (choice) {
			case "1":
				System.out.print("First Name: ");
				validEntry = customer.setFirstName(scanner.nextLine());
				break;
			case "2":
				System.out.print("Surname: ");
				validEntry = customer.setSurname(scanner.nextLine());
				break;
			case "3":
				System.out.print("Address: ");
				validEntry = customer.setAddress(scanner.nextLine());
				break;
			case "4":
				System.out.print("Phone Number: ");
				validEntry = customer.setPhoneNumber(scanner.nextLine());
				break;
			case "5":
			    System.out.print("Area Code: ");
			    int areaCode;
			    try { areaCode = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { validEntry = false; break; }
			    validEntry = customer.setAreaCode(areaCode);
			    break;
			case "6":
				updating = false;
				break;
			default:
				System.out.println("Entry Invalid. Please enter 1-6.");
			}
			if (!validEntry) { System.out.println("Invalid value entered."); }
		}
		if (customerDAO.updateCustomer(customer)) {
		    System.out.println("Customer updated.");
		} else {
		    System.out.println("Failed to update customer.");
		}
	}

	private static void deleteCustomer(Scanner scanner) {
		System.out.println("=== Delete Customer ===");
		System.out.print("Customer Id: ");
		int id;
        try { id = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Id must be a whole number."); return; }
		if (customerDAO.deleteCustomer(id)) {
			System.out.println("Customer deleted successfully.");
		} else {
			System.out.println("Failed to delete customer.");
		}
	}
}