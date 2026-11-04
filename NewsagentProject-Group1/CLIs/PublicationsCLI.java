import java.util.Scanner;

public class PublicationsCLI {
	private static final PublicationsDAO publicationsDAO = new PublicationsDAO();
	
	public static void run(Scanner scanner) {
		boolean running = true;
		while (running) {
			System.out.print("What would you like to do:\n" + "1 Create publication\n" + "2 Read publication\n"
					+ "3 Update publication\n" + "4 Delete publication\n" + "5 Return\n" + "Enter 1-5: ");
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
			case "5":
				running = false;
				break;
			default:
				System.out.println("Entry Invalid. Please enter 1-5.");
			}
		}
	}
	
	private static void createPublication(Scanner scanner) {
		System.out.println("=== Create New Publication ===");
		System.out.print("Publication name: ");
		String publicationName = scanner.nextLine();
		System.out.print("Publication stock: ");
		int publicationStock;
		try { publicationStock = Integer.parseInt(scanner.nextLine()); }
		catch (NumberFormatException e) { System.out.println("Publication stock must be a whole number."); return; }
		Publications publication = new Publications();
		if (!publication.createPublication(publicationName, publicationStock)) { System.out.println("Invalid publication details."); return; }
		if (publicationsDAO.addPublication(publication)) {
			System.out.println("Publication saved successfully.");
		} else {
			System.out.println("Failed to save publication.");
		}
	}
	
	private static void readPublication(Scanner scanner) {
		System.out.println("=== Find Publication ===");
		System.out.print("Publication Id: ");
		int publicationId;
		try { publicationId = Integer.parseInt(scanner.nextLine()); }
		catch (NumberFormatException e) { System.out.println("Publication Id must be a whole number."); return; }
		Publications publication = publicationsDAO.findPublicationById(publicationId); 
		if (publication == null) { System.out.println("Publication with Id " + publicationId + " could not be found."); return; }
		System.out.println("Publication name: " + publication.getPublicationName() + 
						   "\nPublication stock: " + publication.getPublicationStock());
	}
	
	private static void updatePublication(Scanner scanner) {
		System.out.println("=== Find Publication ===");
		System.out.print("Publication Id: ");
		int publicationId;
		try { publicationId = Integer.parseInt(scanner.nextLine()); }
		catch (NumberFormatException e) { System.out.println("Publication Id must be a whole number."); return; }
		Publications publication = publicationsDAO.findPublicationById(publicationId);
		if (publication == null) { System.out.println("Publication with Id " + publicationId + " could not be found."); return; }
		System.out.println("=== Update Publication ===");
		boolean updating = true;
		while (updating) {
			System.out.print("What would you like to update:\n" + "1 Publication name\n" + "2 Publication stock\n" + "3 Complete\n" + "Enter 1-3: ");
			String choice = scanner.nextLine();
			boolean validEntry = true;
			switch (choice) {
			case "1":
				System.out.print("Publication name: ");
				validEntry = publication.setPublicationName(scanner.nextLine());
				break;
			case "2":
				System.out.print("Publication stock: ");
				int publicationStock;
			    try { publicationStock = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { validEntry = false; break; }
			    validEntry = publication.setPublicationStock(publicationStock);
				break;
			case "3":
				updating = false;
				break;
			default:
				System.out.println("Entry Invalid. Please enter 1-3.");
			}
			if (!validEntry) { System.out.println("Invalid value entered."); }
		}
		if (publicationsDAO.updatePublication(publication)) {
		    System.out.println("Publication updated.");
		} else {
		    System.out.println("Failed to update publication.");
		}
	}
	
	private static void deletePublication(Scanner scanner) {
		System.out.println("=== Delete Publication ===");
		System.out.print("Publication Id: ");
		int publicationId;
		try { publicationId = Integer.parseInt(scanner.nextLine()); }
		catch (NumberFormatException e) { System.out.println("Publication Id must be a whole number."); return; }
		if (publicationsDAO.deletePublication(publicationId)) {
			System.out.println("Publication deleted successfully.");
		} else {
			System.out.println("Failed to delete publication.");
		}
	}
}