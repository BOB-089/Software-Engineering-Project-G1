import java.util.Scanner;

public class DeliveryPersonCLI {
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
                System.out.println("Entry Invalid. Please enter 1-5");
            }
        }
    }

    private static void createDeliveryPerson(Scanner scanner) {
        System.out.println("=== Create New Delivery Person ===");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Surname: ");
        String surname = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Area Code: ");
        int areaCode = scanner.nextInt();
        scanner.nextLine();

        DeliveryPerson deliveryPerson = new DeliveryPerson();
        if (deliveryPerson.createDeliveryPerson(firstName, surname, phoneNumber, areaCode)) {
            DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
            if (deliveryPersonDAO.addDeliveryPerson(deliveryPerson)) {
                System.out.println("Delivery person saved successfully.");
            } else {
                System.out.println("Failed to save delivery person.");
            }
        } else {
            System.out.println("Invalid delivery person details entered.");
        }
    }

    private static void readDeliveryPerson(Scanner scanner) {
        System.out.println("=== Find Delivery Person ===");
        System.out.print("Delivery Person Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
        DeliveryPerson deliveryPerson = deliveryPersonDAO.findDeliveryPersonById(id); 
        if (deliveryPerson == null) { 
            System.out.println("Delivery person with id " + id + " could not be found"); 
            return; 
        }
        System.out.println("First Name: " + deliveryPerson.getFirstName() + 
                           "\nSurname: " + deliveryPerson.getSurname() +
                           "\nPhone Number: " + deliveryPerson.getPhoneNumber() + 
                           "\nArea Code: " + deliveryPerson.getAreaCode());
    }

    private static void updateDeliveryPerson(Scanner scanner) {
        System.out.println("=== Find Delivery Person ===");
        System.out.print("Delivery Person Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
        DeliveryPerson deliveryPerson = deliveryPersonDAO.findDeliveryPersonById(id);
        if (deliveryPerson == null) { 
            System.out.println("Delivery person with id " + id + " could not be found"); 
            return; 
        }

        System.out.println("=== Update Delivery Person ===");
        try {
            boolean updating = true;
            while (updating) {
                System.out.print("What would you like to update:\n" + "1 First Name\n" + "2 Surname\n"
                        + "3 Phone Number\n" + "4 Area Code\n" + "5 Complete\n" + "Enter 1-5: ");
                String choice = scanner.nextLine();
                boolean validEntry = true;
                switch (choice) {
                case "1":
                    System.out.print("First Name: ");
                    validEntry = deliveryPerson.setFirstName(scanner.nextLine());
                    break;
                case "2":
                    System.out.print("Surname: ");
                    validEntry = deliveryPerson.setSurname(scanner.nextLine());
                    break;
                case "3":
                    System.out.print("Phone Number: ");
                    validEntry = deliveryPerson.setPhoneNumber(scanner.nextLine());
                    break;
                case "4":
                    System.out.print("Area Code: ");
                    validEntry = deliveryPerson.setAreaCode(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case "5":
                    updating = false;
                    break;
                default:
                    System.out.println("Entry Invalid. Please enter 1-5");
                }
                if (!validEntry) { System.out.println("Invalid value entered."); }
            }
            deliveryPersonDAO.updateDeliveryPerson(deliveryPerson);
            System.out.println("Delivery person updated");
        } catch (Exception e) { 
            System.out.println("Failed to update delivery person"); 
        }
    }

    private static void deleteDeliveryPerson(Scanner scanner) {
        System.out.println("=== Delete Delivery Person ===");
        System.out.print("Delivery Person Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
        DeliveryPerson deliveryPerson = deliveryPersonDAO.findDeliveryPersonById(id);
        if (deliveryPerson == null) {
            System.out.println("Delivery person with id " + id + " could not be found.");
            return;
        }

        System.out.print("Are you sure you want to delete this delivery person from the database? (yes/no): ");
        String confirmation = scanner.nextLine().trim();

        if (confirmation.equalsIgnoreCase("yes")) {
            if (deliveryPersonDAO.deleteDeliveryPerson(id)) {
                System.out.println("Delivery person deleted successfully.");
            } else {
                System.out.println("Failed to delete delivery person.");
            }
        } else {
            System.out.println("Deletion cancelled. Returning to system home page.");
        }
    }
}