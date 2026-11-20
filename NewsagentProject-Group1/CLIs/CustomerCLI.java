import java.util.Scanner;

public class CustomerCLI {
	private static final CustomerDAO customerDAO = new CustomerDAO();
	
	public static void run(Scanner scanner) {
		boolean running = true;
		while (running) {
			System.out.println("\n=== Customer Menu ===");
			System.out.print("What would you like to do:\n" + 
							 "1 Create customer\n" + 
							 "2 Read customer\n" + 
							 "3 Update customer\n" + 
							 "4 Delete customer\n" + 
							 "5 Return\n" + 
							 "Enter 1-5: ");
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
				System.out.println("Invalid entry. Please enter 1-5.");
			}
		}
	}
	
	private static void createCustomer(Scanner scanner) {
	    System.out.println("\n=== Create New Customer ===");
	    Customer customer = new Customer();
	    System.out.print("First name: ");
	    String firstName = scanner.nextLine();
	    if (!customer.setFirstName(firstName)) { System.out.println("Invalid first name."); return; }
	    System.out.print("Surname: ");
	    String surname = scanner.nextLine();
	    if (!customer.setSurname(surname)) { System.out.println("Invalid surname."); return; }
	    System.out.print("Address: ");
	    String address = scanner.nextLine();
	    if (!customer.setAddress(address)) { System.out.println("Invalid address."); return; }
	    System.out.print("Phone number: ");
	    String phoneNumber = scanner.nextLine();
	    if (!customer.setPhoneNumber(phoneNumber)) { System.out.println("Invalid phone number."); return; }
	    System.out.print("Area code: ");
	    int areaCode;
	    try { areaCode = Integer.parseInt(scanner.nextLine()); }
	    catch (NumberFormatException e) { System.out.println("Area code must be a whole number."); return; }
	    if (!customerDAO.deliveryAreaExists(areaCode)) { System.out.println("Area with code " + areaCode + " could not be found."); return; }
	    customer.setAreaCode(areaCode);
	    customer.setOnHoliday(false);
	    customer.setPublicationsAvailable(true);
	    if (customerDAO.addCustomer(customer)) {
	        System.out.println("Customer saved successfully.");
	    } else {
	        System.out.println("Failed to save customer.");
	    }
	}

	private static void readCustomer(Scanner scanner) {
		System.out.println("\n=== Read Customer ===");
		System.out.print("Customer Id: ");
		int customerId;
        try { customerId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Customer Id must be a whole number."); return; }
		Customer customer = customerDAO.findCustomerById(customerId); 
		if (customer == null) { System.out.println("Customer with Id " + customerId + " could not be found."); return; }
		System.out.println("First name: " + customer.getFirstName() + 
						   "\nSurname: " + customer.getSurname() +
						   "\nAddress: " + customer.getAddress() + 
						   "\nPhone number: " + customer.getPhoneNumber() + 
						   "\nArea code: " + customer.getAreaCode() +
						   "\nOn holiday: " + (customer.isOnHoliday() ? "Yes" : "No") +
						   "\nPublications available: " + (customer.isPublicationsAvailable() ? "Yes" : "No"));
	}

	private static void updateCustomer(Scanner scanner) {
		System.out.println("\n=== Update Customer ===");
		System.out.print("Customer Id: ");
		int customerId;
        try { customerId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Customer Id must be a whole number."); return; }
		Customer customer = customerDAO.findCustomerById(customerId);
		if (customer == null) { System.out.println("Customer with Id " + customerId + " could not be found."); return; }
		boolean updating = true;
		while (updating) {
			System.out.print("What would you like to update:\n" + 
							 "1 First name\n" + 
							 "2 Surname\n" + 
							 "3 Address\n" + 
							 "4 Phone number\n" + 
							 "5 Area code\n" + 
							 "6 On holiday\n"  + 
							 "7 Complete\n" + 
							 "Enter 1-7: ");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				System.out.print("First name: ");
				if (!customer.setFirstName(scanner.nextLine())) { System.out.println("Invalid first name."); }
				break;
			case "2":
				System.out.print("Surname: ");
				if (!customer.setSurname(scanner.nextLine())) { System.out.println("Invalid surname."); }
				break;
			case "3":
				System.out.print("Address: ");
				if (!customer.setAddress(scanner.nextLine())) { System.out.println("Invalid address."); }
				break;
			case "4":
				System.out.print("Phone number: ");
				if (!customer.setPhoneNumber(scanner.nextLine())) { System.out.println("Invalid phone number."); }
				break;
			case "5":
			    System.out.print("Area code: ");
			    int areaCode;
			    try { areaCode = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { System.out.println("Area code must be a whole number."); break; }
			    if (!customerDAO.deliveryAreaExists(areaCode)) { System.out.println("Area with code " + areaCode + " could not be found."); break; } 
                customer.setAreaCode(areaCode);
			    break;
			case "6":
				System.out.print("On holiday (yes/no): ");
				String holidayInput = scanner.nextLine().trim();
			    if (holidayInput.equalsIgnoreCase("yes")) { customer.setOnHoliday(true); } 
			    else if (holidayInput.equalsIgnoreCase("no")) { customer.setOnHoliday(false); } 
			    else { System.out.println("Invalid entry. Please enter yes or no."); }
				break;
			case "7":
				updating = false;
				break;
			default:
				System.out.println("Invalid entry. Please enter 1-7.");
			}
		}
		if (customerDAO.updateCustomer(customer)) {
		    System.out.println("Customer updated.");
		} else {
		    System.out.println("Failed to update customer.");
		}
	}

	private static void deleteCustomer(Scanner scanner) {
		System.out.println("\n=== Delete Customer ===");
		System.out.print("Customer Id: ");
		int customerId;
        try { customerId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Customer Id must be a whole number."); return; }
        Customer customer = customerDAO.findCustomerById(customerId);
        if (customer == null) { System.out.println("Customer with Id " + customerId + " could not be found."); return; }
        System.out.print("Are you sure you want to delete this customer from the database? (yes/no): ");
        String confirmation = scanner.nextLine().trim();
        if (confirmation.equalsIgnoreCase("yes")) { 
        	if (customerDAO.deleteCustomer(customerId)) {
        		System.out.println("Customer deleted successfully.");
        	} else {
        		System.out.println("Failed to delete customer.");
        	}
        } else {
        	System.out.println("Deletion cancelled.");
        }
	}
}