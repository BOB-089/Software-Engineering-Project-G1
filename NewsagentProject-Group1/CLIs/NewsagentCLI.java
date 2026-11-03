import java.util.Scanner;

public class NewsagentCLI {

	public static void run(Scanner scanner) {
		boolean running = true;
		while (running) {
			System.out.print("What would you like to do:\n" + "1 Create Newsagent\n" + "2 Read Newsagent\n"
					+ "3 Update Newsagent\n" + "4 Delete Newsagent\n" + "5 Return\n" + "Enter 1-5: ");
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
				System.out.println("Entry Invalid. Please enter 1-5");
			}
		}
	}
	
	private static void createNewsagent(Scanner scanner) {
		System.out.println("=== Create New Newsagent ===");
		System.out.print("First Name: ");
		String firstName = scanner.nextLine();
		System.out.print("Surname: ");
		String surname = scanner.nextLine();
		System.out.print("Phone Number: ");
		String phoneNumber = scanner.nextLine();
		Newsagent newsagent = new Newsagent();
		newsagent.createNewsagent(firstName, surname, phoneNumber);
		NewsagentDAO newsagentDAO = new NewsagentDAO();
		if (newsagentDAO.addNewsagent(newsagent)) {
			System.out.println("Newsagent saved successfully.");
		} else {
			System.out.println("Failed to save newsagent.");
		}
	}
	
	private static void readNewsagent(Scanner scanner) {
		System.out.println("=== Find Newsagent ===");
		System.out.print("Newsagent Id: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		NewsagentDAO newsagentDAO = new NewsagentDAO();
		Newsagent newsagent = newsagentDAO.findNewsagentByID(id); 
		if (newsagent == null) { System.out.println("Newsagent with id " + id + " could not be found"); return; }
		System.out.println("First Name: " + newsagent.getFirstName() + 
						   "\nSurname: " + newsagent.getSurname() + 
						   "\nPhone Number: " + newsagent.getPhoneNumber());
	}
	
	private static void updateNewsagent(Scanner scanner) {
		System.out.println("=== Find Newsagent ===");
		System.out.print("Newsagent Id: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		NewsagentDAO newsagentDAO = new NewsagentDAO();
		Newsagent newsagent = newsagentDAO.findNewsagentByID(id);
		if (newsagent == null) { System.out.println("Newsagent with id " + id + " could not be found"); return; }
		System.out.println("=== Update Newsagent ===");
		try {
			boolean updating = true;
			while (updating) {
				System.out.print("What would you like to update:\n" + "1 First Name\n" + "2 Surname\n"
					 + "3 Phone Number\n" + "4 Complete\n" + "Enter 1-4: ");
				String choice = scanner.nextLine();
				boolean validEntry = true;
				switch (choice) {
				case "1":
					System.out.print("First Name: ");
					validEntry = newsagent.setFirstName(scanner.nextLine());
					break;
				case "2":
					System.out.print("Surname: ");
					validEntry = newsagent.setSurname(scanner.nextLine());
					break;
				case "3":
					System.out.print("Phone Number: ");
					validEntry = newsagent.setPhoneNumber(scanner.nextLine());
					break;
				case "4":
					updating = false;
					break;
				default:
					System.out.println("Entry Invalid. Please enter 1-4");
				}
				if (!validEntry) { System.out.println("Invalid value entered."); }
			}
			newsagentDAO.updateNewsagent(newsagent);
			System.out.println("Newsagent updated");
		} catch (Exception e) { System.out.println("Failed to update newsagent"); }
	}
	
	private static void deleteNewsagent(Scanner scanner) {
		System.out.println("=== Delete Newsagent ===");
		System.out.print("Newsagent Id: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		NewsagentDAO newsagentDAO = new NewsagentDAO();
		if (newsagentDAO.deleteNewsagent(id)) {
			System.out.println("Newsagent deleted successfully.");
		} else {
			System.out.println("Failed to delete newsagent.");
		}
	}
}