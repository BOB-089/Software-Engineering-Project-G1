import java.util.Scanner;

public class NewsagentCLI {
	private static final NewsagentDAO newsagentDAO = new NewsagentDAO();
	
	public static void run(Scanner scanner) {
		boolean running = true;
		while (running) {
			System.out.print("What would you like to do:\n" + "1 Create newsagent\n" + "2 Read newsagent\n"
					+ "3 Update newsagent\n" + "4 Delete newsagent\n" + "5 Return\n" + "Enter 1-5: ");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				createNewsagent(scanner);
				break;
			case "2":
				readNewsagent(scanner);
				break;
			case "3":
				updateNewsagent(scanner);
				break;
			case "4":
				deleteNewsagent(scanner);
				break;
			case "5":
				running = false;
				break;
			default:
				System.out.println("Entry Invalid. Please enter 1-5.");
			}
		}
	}
	
	private static void createNewsagent(Scanner scanner) {
		System.out.println("=== Create New Newsagent ===");
		System.out.print("First name: ");
		String firstName = scanner.nextLine();
		System.out.print("Surname: ");
		String surname = scanner.nextLine();
		System.out.print("Phone number: ");
		String phoneNumber = scanner.nextLine();
		Newsagent newsagent = new Newsagent();
		if (!newsagent.createNewsagent(firstName, surname, phoneNumber)) { System.out.println("Invalid newsagent details."); return; }
		if (newsagentDAO.addNewsagent(newsagent)) {
			System.out.println("Newsagent saved successfully.");
		} else {
			System.out.println("Failed to save newsagent.");
		}
	}
	
	private static void readNewsagent(Scanner scanner) {
		System.out.println("=== Find Newsagent ===");
		System.out.print("Newsagent Id: ");
		int id;
		try { id = Integer.parseInt(scanner.nextLine()); }
		catch (NumberFormatException e) { System.out.println("Id must be a whole number."); return; }
		Newsagent newsagent = newsagentDAO.findNewsagentByID(id); 
		if (newsagent == null) { System.out.println("Newsagent with Id " + id + " could not be found."); return; }
		System.out.println("First name: " + newsagent.getFirstName() + 
						   "\nSurname: " + newsagent.getSurname() + 
						   "\nPhone number: " + newsagent.getPhoneNumber());
	}
	
	private static void updateNewsagent(Scanner scanner) {
		System.out.println("=== Find Newsagent ===");
		System.out.print("Newsagent Id: ");
		int id;
		try { id = Integer.parseInt(scanner.nextLine()); }
		catch (NumberFormatException e) { System.out.println("Id must be a whole number."); return; }
		Newsagent newsagent = newsagentDAO.findNewsagentByID(id);
		if (newsagent == null) { System.out.println("Newsagent with Id " + id + " could not be found."); return; }
		System.out.println("=== Update Newsagent ===");
		boolean updating = true;
		while (updating) {
			System.out.print("What would you like to update:\n" + "1 First name\n" + "2 Surname\n"
				 + "3 Phone number\n" + "4 Complete\n" + "Enter 1-4: ");
			String choice = scanner.nextLine();
			boolean validEntry = true;
			switch (choice) {
			case "1":
				System.out.print("First name: ");
				validEntry = newsagent.setFirstName(scanner.nextLine());
				break;
			case "2":
				System.out.print("Surname: ");
				validEntry = newsagent.setSurname(scanner.nextLine());
				break;
			case "3":
				System.out.print("Phone number: ");
				validEntry = newsagent.setPhoneNumber(scanner.nextLine());
				break;
			case "4":
				updating = false;
				break;
			default:
				System.out.println("Entry Invalid. Please enter 1-4.");
			}
			if (!validEntry) { System.out.println("Invalid value entered."); }
		}
		if (newsagentDAO.updateNewsagent(newsagent)) {
		    System.out.println("Newsagent updated.");
		} else {
		    System.out.println("Failed to update newsagent.");
		}
	}
	
	private static void deleteNewsagent(Scanner scanner) {
		System.out.println("=== Delete Newsagent ===");
		System.out.print("Newsagent Id: ");
		int id;
		try { id = Integer.parseInt(scanner.nextLine()); }
		catch (NumberFormatException e) { System.out.println("Id must be a whole number."); return; }
		if (newsagentDAO.deleteNewsagent(id)) {
			System.out.println("Newsagent deleted successfully.");
		} else {
			System.out.println("Failed to delete newsagent.");
		}
	}
}