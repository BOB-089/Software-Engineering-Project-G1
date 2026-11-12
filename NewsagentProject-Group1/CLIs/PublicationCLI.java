import java.util.Scanner;

public class PublicationCLI {
	private static final PublicationDAO publicationDAO = new PublicationDAO();
	
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
		System.out.print("Name: ");
		String publicationName = scanner.nextLine();
		System.out.print("Current stock: ");
		int stock;
		try { stock = Integer.parseInt(scanner.nextLine()); }
		catch (NumberFormatException e) { System.out.println("Stock must be a whole number."); return; }
		System.out.print("Price: ");
		double price;
		try { price = Double.parseDouble(scanner.nextLine()); }
		catch (NumberFormatException e) { System.out.println("Price must be a whole number."); return; }
		Publication publication = new Publication();
		if (!publication.createPublication(publicationName, stock, price)) { System.out.println("Invalid publication details."); return; }
		if (publicationDAO.addPublication(publication)) {
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
		Publication publication = publicationDAO.findPublicationById(publicationId); 
		if (publication == null) { System.out.println("Publication with Id " + publicationId + " could not be found."); return; }
		System.out.println("Name: " + publication.getName() + 
						   "\nStock: " + publication.getStock() +
						   "\nPrice: €" + publication.getPrice());
	}
	
	private static void updatePublication(Scanner scanner) {
		System.out.println("=== Find Publication ===");
		System.out.print("Publication Id: ");
		int publicationId;
		try { publicationId = Integer.parseInt(scanner.nextLine()); }
		catch (NumberFormatException e) { System.out.println("Publication Id must be a whole number."); return; }
		Publication publication = publicationDAO.findPublicationById(publicationId);
		if (publication == null) { System.out.println("Publication with Id " + publicationId + " could not be found."); return; }
		System.out.println("=== Update Publication ===");
		boolean updating = true;
		while (updating) {
			System.out.print("What would you like to update:\n" + "1 Name\n" + "2 Stock\n" + "3 Price\n" + "4 Complete\n" + "Enter 1-4: ");
			String choice = scanner.nextLine();
			boolean validEntry = true;
			switch (choice) {
			case "1":
				System.out.print("Name: ");
				validEntry = publication.setName(scanner.nextLine());
				break;
			case "2":
				System.out.print("Stock: ");
				int stock;
			    try { stock = Integer.parseInt(scanner.nextLine()); }
			    catch (NumberFormatException e) { validEntry = false; break; }
			    validEntry = publication.setStock(stock);
				break;
			case "3":
				System.out.print("Price: ");
				double price;
			    try { price = Double.parseDouble(scanner.nextLine()); }
			    catch (NumberFormatException e) { validEntry = false; break; }
			    validEntry = publication.setPrice(price);
				break;
			case "4":
				updating = false;
				break;
			default:
				System.out.println("Entry Invalid. Please enter 1-4.");
			}
			if (!validEntry) { System.out.println("Invalid value entered."); }
		}
		if (publicationDAO.updatePublication(publication)) {
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
		Publication publication = publicationDAO.findPublicationById(publicationId);
		if (publication == null) { System.out.println("Publication with Id " + publicationId + " could not be found."); return; }
		System.out.print("Are you sure you want to delete this publication from the database? (yes/no): ");
		String confirmation = scanner.nextLine().trim();
		if (confirmation.equalsIgnoreCase("yes")) {
			if (publicationDAO.deletePublication(publicationId)) {
				System.out.println("Publication deleted successfully.");
			} else {
				System.out.println("Failed to delete publication.");
			}
		} else {
			System.out.println("Deletion cancelled. Returning to system home page.");
		}
	}
}