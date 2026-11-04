import java.util.Scanner;

public class DeliveryAreaCLI {
	private static final DeliveryAreaDAO deliveryAreaDAO = new DeliveryAreaDAO();
	
    public static void run(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.print("What would you like to do:\n" + "1 Create delivery area\n" + "2 Read delivery area\n" +
                    "3 Update delivery area\n" + "4 Delete delivery area\n" + "5 Return\n" + "Enter 1-5: ");
            String choice = scanner.nextLine();
            switch (choice) {
            case "1":
                createDeliveryArea(scanner);
                break;
            case "2":
                readDeliveryArea(scanner);
                break;
            case "3":
                updateDeliveryArea(scanner);
                break;
            case "4":
                deleteDeliveryArea(scanner);
                break;
            case "5":
                running = false;
                break;
            default:
                System.out.println("Entry Invalid. Please enter 1-5.");
            }
        }
    }

    private static void createDeliveryArea(Scanner scanner) {
        System.out.println("=== Create New Delivery Area ===");
        System.out.print("Area code: ");
        int areaCode;
        try { areaCode = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Area code must be a whole number."); return; }
        if (deliveryAreaDAO.findDeliveryAreaByAreaCode(areaCode) != null) { System.out.println("Area with code " + areaCode + " already exists."); return; }
        System.out.print("Area name: ");
        String name = scanner.nextLine();
        DeliveryArea deliveryArea = new DeliveryArea();
        if (!deliveryArea.createDeliveryArea(areaCode, name)) { System.out.println("Invalid delivery area details."); return; }
        if (deliveryAreaDAO.addDeliveryArea(deliveryArea)) {
            System.out.println("Delivery area saved successfully.");
        } else {
            System.out.println("Failed to save delivery area.");
        }
    }

    private static void readDeliveryArea(Scanner scanner) {
        System.out.println("=== Find Delivery Area ===");
        System.out.print("Area code: ");
        int areaCode;
        try { areaCode = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Area code must be a whole number."); return; }
        DeliveryArea deliveryArea = deliveryAreaDAO.findDeliveryAreaByAreaCode(areaCode);
        if (deliveryArea == null) { System.out.println("Delivery area with area code " + areaCode + " could not be found."); return; }
        System.out.println("Name: " + deliveryArea.getName() + "\nCustomers: " + deliveryArea.getCustomers().size());
    }

    private static void updateDeliveryArea(Scanner scanner) {
        System.out.println("=== Find Delivery Area ===");
        System.out.print("Area code: ");
        int areaCode;
        try { areaCode = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Area code must be a whole number."); return; }
        DeliveryArea deliveryArea = deliveryAreaDAO.findDeliveryAreaByAreaCode(areaCode);
        if (deliveryArea == null) { System.out.println("Delivery area with area code " + areaCode + " could not be found."); return; }
        System.out.println("=== Update Delivery Area ===");
        System.out.print("New name: ");
        if (!deliveryArea.setName(scanner.nextLine())) { System.out.println("Invalid value entered."); return; }
        if (deliveryAreaDAO.updateDeliveryArea(deliveryArea)) {
            System.out.println("Delivery area updated.");
        } else {
            System.out.println("Failed to update delivery area.");
        }
    }

    private static void deleteDeliveryArea(Scanner scanner) {
        System.out.println("=== Delete Delivery Area ===");
        System.out.print("Area code: ");
        int areaCode;
        try { areaCode = Integer.parseInt(scanner.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Area code must be a whole number."); return; }
        DeliveryArea deliveryArea = deliveryAreaDAO.findDeliveryAreaByAreaCode(areaCode);
        if (deliveryArea == null) { System.out.println("Delivery area with area code " + areaCode + " could not be found."); return; }
        System.out.print("Are you sure you want to delete this delivery area from the database? (yes/no): ");
        String confirmation = scanner.nextLine().trim();
        if (confirmation.equalsIgnoreCase("yes")) {
        	if (deliveryAreaDAO.deleteDeliveryArea(areaCode)) {
        		System.out.println("Delivery area deleted successfully.");
        	} else {
        		System.out.println("Failed to delete delivery area.");
        	}
        } else {
        	System.out.println("Deletion cancelled. Returning to system home page.");
        }
    }
}