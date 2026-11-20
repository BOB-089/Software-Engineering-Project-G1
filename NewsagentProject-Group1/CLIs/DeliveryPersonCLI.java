import java.util.ArrayList;
import java.util.Scanner;

public class DeliveryPersonCLI {
	private static final DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
	
	private static final DeliveryDocketDAO deliveryDocketDAO = new DeliveryDocketDAO();
	
    public static void run(Scanner scanner) {
        boolean running = true;
        while (running) {
        	System.out.println("\n=== Delivery Person Menu ===");
            System.out.print("What would you like to do:\n" + 
            				 "1 Create delivery person\n" + 
            				 "2 Read delivery person\n" + 
            				 "3 Update delivery person\n" + 
            				 "4 Delete delivery person\n" + 
            				 "5 Return\n" + 
            				 "Enter 1-5: ");
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
                System.out.println("Invalid entry. Please enter 1-5.");
            }
        }
    }
    
    private static void createDeliveryPerson(Scanner scanner) {
        System.out.println("\n=== Create New Delivery Person ===");
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        if (!deliveryPerson.setFirstName(firstName)) { System.out.println("Invalid first name."); return; }
        System.out.print("Surname: ");
        String surname = scanner.nextLine();
        if (!deliveryPerson.setSurname(surname)) { System.out.println("Invalid surname."); return; }
        System.out.print("Phone number: ");
        String phoneNumber = scanner.nextLine();
        if (!deliveryPerson.setPhoneNumber(phoneNumber)) { System.out.println("Invalid phone number."); return; }
        System.out.print("Area code: ");
        int areaCode;
        try { areaCode = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Area code must be a whole number."); return; }
        if (!deliveryPersonDAO.deliveryAreaExists(areaCode)) { System.out.println("Area with code " + areaCode + " could not be found."); return; }
        deliveryPerson.setAreaCode(areaCode);
        if (deliveryPersonDAO.addDeliveryPerson(deliveryPerson)) {
            System.out.println("Delivery person saved successfully.");
        } else {
            System.out.println("Failed to save delivery person.");
        }
    }

    private static void readDeliveryPerson(Scanner scanner) {
        System.out.println("\n=== Read Delivery Person ===");
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
        DeliveryDocket todaysDeliveryDocket = deliveryPersonDAO.getTodaysDeliveryDocket(deliveryPerson.getAreaCode());
        if (todaysDeliveryDocket != null) {
            System.out.println("\n=== Today's Delivery Docket ===");
            System.out.println("Docket Id: " + todaysDeliveryDocket.getDeliveryDocketId());
            System.out.println("Date: " + todaysDeliveryDocket.getDate());
			ArrayList<Order> orders = deliveryDocketDAO.getOrdersForDocket(todaysDeliveryDocket);
            System.out.println("\n=== Orders For Today's Delivery ===");
            if (orders.isEmpty()) {
                System.out.println("No orders found.");
            } else {
                for (Order order : orders) {
                    System.out.println("Order Id: " + order.getOrderId() +
                    				   "\nCustomer Id: " + order.getCustomerId() +
                    				   "\nPublication: " + order.getPublicationName() +
                    				   "\n---------------------------");
                }
            }
        }
        else {
            System.out.println("\nNo delivery docket found for today.");
        }
    }

    private static void updateDeliveryPerson(Scanner scanner) {
    	System.out.println("\n=== Update Delivery Person ===");
        System.out.print("Delivery person Id: ");
        int deliveryPersonId;
        try { deliveryPersonId = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Delivery person Id must be a whole number."); return; }
        DeliveryPerson deliveryPerson = deliveryPersonDAO.findDeliveryPersonById(deliveryPersonId);
        if (deliveryPerson == null) { System.out.println("Delivery person with Id " + deliveryPersonId + " could not be found."); return; }
        boolean updating = true;
        while (updating) {
            System.out.print("What would you like to update:\n" + 
            				 "1 First name\n" + 
            				 "2 Surname\n" + 
            				 "3 Phone number\n" + 
            				 "4 Area code\n" + 
            				 "5 Complete\n" + 
            				 "Enter 1-5: ");
            String choice = scanner.nextLine();
            switch (choice) {
            case "1":
            	System.out.print("First name: ");
                if (!deliveryPerson.setFirstName(scanner.nextLine())) { System.out.println("Invalid first name."); }
                break;
            case "2":
            	System.out.print("Surname: ");
                if (!deliveryPerson.setSurname(scanner.nextLine())) { System.out.println("Invalid surname."); }
                break;
            case "3":
                System.out.print("Phone number: ");
                if (!deliveryPerson.setPhoneNumber(scanner.nextLine())) { System.out.println("Invalid phone number."); }
                break;
            case "4":
                System.out.print("Area code: ");
                int areaCode;
                try { areaCode = Integer.parseInt(scanner.nextLine()); }
                catch (NumberFormatException e) { System.out.println("Area code must be a whole number."); break; }
                if (!deliveryPersonDAO.deliveryAreaExists(areaCode)) { System.out.println("Area with code " + areaCode + " could not be found."); break; } 
                deliveryPerson.setAreaCode(areaCode);
                break;
            case "5":
                updating = false;
                break;
            default:
                System.out.println("Invalid entry. Please enter 1-5.");
            }
        }
        if (deliveryPersonDAO.updateDeliveryPerson(deliveryPerson)) {
            System.out.println("Delivery person updated.");
        } else {
            System.out.println("Failed to update delivery person.");
        }
    }

    private static void deleteDeliveryPerson(Scanner scanner) {
        System.out.println("\n=== Delete Delivery Person ===");
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