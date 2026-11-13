import java.util.Scanner;

public class DeliveryPersonCLI {
	private static final DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
	
    public static void run(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.print("What would you like to do:\n" + "1 Create delivery person\n" + "2 Read delivery person\n"
                    + "3 Update delivery person\n" + "4 Delete delivery person\n" + "5 Return\n" + "Enter 1-5: ");
            String choice = scanner.nextLine();
            switch (choice) {
            case "1":
                createDeliveryPerson(scanner);
                break;
            case "2":
                readDeliveryPerson(scanner);
                break;
            case "3":
                updateDeliveryPerson(scanner);
                break;
            case "4":
                deleteDeliveryPerson(scanner);
                break;
            case "5":
                running = false;
                break;
            default:
                System.out.println("Entry Invalid. Please enter 1-5.");
            }
        }
    }

    private static void createDeliveryPerson(Scanner scanner) {
        System.out.println("=== Create New Delivery Person ===");
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Surname: ");
        String surname = scanner.nextLine();
        System.out.print("Phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Area code: ");
        int areaCode;
        try { areaCode = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Area code must be a whole number."); return; }
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        if (!deliveryPerson.createDeliveryPerson(firstName, surname, phoneNumber, areaCode)) { System.out.println("Invalid delivery person details."); return; }
        if (deliveryPersonDAO.addDeliveryPerson(deliveryPerson)) {
            System.out.println("Delivery person saved successfully.");
        } else {
            System.out.println("Failed to save delivery person.");
        }
    }

    private static void readDeliveryPerson(Scanner scanner) {
        System.out.println("=== Find Delivery Person ===");
        System.out.print("Delivery person Id: ");
        int deliveryPersonId;
        try { deliveryPersonId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Delivery person Id must be a whole number."); return; }
        DeliveryPerson deliveryPerson = deliveryPersonDAO.findDeliveryPersonById(deliveryPersonId); 
        if (deliveryPerson == null) { System.out.println("Delivery person with Id " + deliveryPersonId + " could not be found."); return; }
        System.out.println("First name: " + deliveryPerson.getFirstName() + 
                           "\nSurname: " + deliveryPerson.getSurname() +
                           "\nPhone number: " + deliveryPerson.getPhoneNumber() + 
                           "\nArea code: " + deliveryPerson.getAreaCode());
    }

    private static void updateDeliveryPerson(Scanner scanner) {
        System.out.println("=== Find Delivery Person ===");
        System.out.print("Delivery person Id: ");
        int deliveryPersonId;
        try { deliveryPersonId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Delivery person Id must be a whole number."); return; }
        DeliveryPerson deliveryPerson = deliveryPersonDAO.findDeliveryPersonById(deliveryPersonId);
        if (deliveryPerson == null) { System.out.println("Delivery person with Id " + deliveryPersonId + " could not be found."); return; }
        System.out.println("=== Update Delivery Person ===");
        boolean updating = true;
        while (updating) {
            System.out.print("What would you like to update:\n" + "1 First name\n" + "2 Surname\n"
                    + "3 Phone number\n" + "4 Area code\n" + "5 Complete\n" + "Enter 1-5: ");
            String choice = scanner.nextLine();
            boolean validEntry = true;
            switch (choice) {
            case "1":
                System.out.print("First name: ");
                validEntry = deliveryPerson.setFirstName(scanner.nextLine());
                break;
            case "2":
                System.out.print("Surname: ");
                validEntry = deliveryPerson.setSurname(scanner.nextLine());
                break;
            case "3":
                System.out.print("Phone number: ");
                validEntry = deliveryPerson.setPhoneNumber(scanner.nextLine());
                break;
            case "4":
                System.out.print("Area code: ");
                int areaCode;
                try { areaCode = Integer.parseInt(scanner.nextLine()); }
                catch (NumberFormatException e) { validEntry = false; break; }
                validEntry = deliveryPerson.setAreaCode(areaCode);
                break;
            case "5":
                updating = false;
                break;
            default:
                System.out.println("Entry Invalid. Please enter 1-5.");
            }
            if (!validEntry) { System.out.println("Invalid value entered."); }
        }
        if (deliveryPersonDAO.updateDeliveryPerson(deliveryPerson)) {
            System.out.println("Delivery person updated.");
        } else {
            System.out.println("Failed to update delivery person.");
        }
    }

    private static void deleteDeliveryPerson(Scanner scanner) {
        System.out.println("=== Delete Delivery Person ===");
        System.out.print("Delivery person Id: ");
        int deliveryPersonId;
        try { deliveryPersonId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Delivery person Id must be a whole number."); return; }
        DeliveryPerson deliveryPerson = deliveryPersonDAO.findDeliveryPersonById(deliveryPersonId);
        if (deliveryPerson == null) { System.out.println("Delivery person with Id " + deliveryPersonId + " could not be found."); return; }
        System.out.print("Are you sure you want to delete this delivery person from the database? (yes/no): ");
        String confirmation = scanner.nextLine().trim();
        if (confirmation.equalsIgnoreCase("yes")) {
            if (deliveryPersonDAO.deleteDeliveryPerson(deliveryPersonId)) {
                System.out.println("Delivery person deleted successfully.");
            } else {
                System.out.println("Failed to delete delivery person.");
            }
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
}