import java.util.Scanner;

public class PublicationsCLI {
	public static void run(Scanner scanner) {
		System.out.print("What would you like to do:\n" + "1 Create publication\n" + "2 Read publication\n"
				+ "3 Update publication\n" + "4 Delete publication\n" + "Enter 1-4: ");
		String choice = scanner.nextLine();
		switch (choice) {
		case "1":
			createPublication(scanner);
			break;
		case "2":
			readPublication(scanner);
			break;
		case "3":
			updatePublication(scanner);
			break;
		case "4":
			deletePublication(scanner);
			break;
		}
	}
	
	private static void createPublication(Scanner scanner) {
		System.out.println("=== Create New Publication ===");
		System.out.print("Publication Name: ");
		String publicationName = scanner.nextLine();
		System.out.print("Publication Stock: ");
		int publicationStock = scanner.nextInt();
		Publications publication = new Publications();
		publication.createPublication(publicationName, publicationStock);
		PublicationsDAO publicationDAO = new PublicationsDAO();
		if (publicationDAO.addPublication(publication)) {
			System.out.println(
			"Publication saved successfully.");
		} else {
			System.out.println(
			"Failed to save publication.");
		}
	}
	
	private static void readPublication(Scanner scanner) {
		System.out.println("=== Find Publication ===");
		System.out.print("Publication Id: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		PublicationsDAO publicationDAO = new PublicationsDAO();
		Publications publication = publicationDAO.findPublicationById(id); 
		if (publication == null) { System.out.println("Publication with id " + id + " could not be found"); return; }
		System.out.println("Publication name: " + publication.getPublicationName() + 
						   "\nPublication stock: " + publication.getPublicationStock());
	}
	
	private static void updatePublication(Scanner scanner) {
		System.out.println("=== Find Publication ===");
		System.out.print("Publication Id: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		PublicationsDAO publicationDAO = new PublicationsDAO();
		Publications publication = publicationDAO.findPublicationById(id);
		if (publication == null) { System.out.println("Publication with id " + id + " could not be found"); return; }
		System.out.println("=== Update Publication ===");
		try {
			boolean updating = true;
			while (updating) {
				System.out.print("What would you like to update:\n" + "1 Publication name\n" + "2 Publicaction stock\n"
						+ "3 Complete\n" + "Enter 1-3: ");
				String choice = scanner.nextLine();
				boolean validEntry = true;
				switch (choice) {
				case "1":
					System.out.print("Publication Name: ");
					validEntry = publication.setPublicationName(scanner.nextLine());
					break;
				case "2":
					System.out.print("Customer ID: ");
					validEntry = publication.setPublicationStock(scanner.nextInt());
					break;
				case "3":
					updating = false;
					break;
				default:
					System.out.println("Entry Invalid. Please enter 1-6");
				}
				if (!validEntry) { System.out.println("Invalid value entered."); }
			}
			publicationDAO.updatePublication(publication);
			System.out.println("Publication updated");
		} catch (Exception e) { System.out.println("Failed to update publication"); }
	}
	
	private static void deletePublication(Scanner scanner) {
		System.out.println("=== Delete Publication ===");
		System.out.print("Publication Id: ");
		int id = scanner.nextInt();
		PublicationsDAO publicationDAO = new PublicationsDAO();
		if (publicationDAO.deletePublication(id)) {
			System.out.println("Publication deleted successfully.");
		} else {
			System.out.println("Failed to delete Publication.");
		}
	}
}