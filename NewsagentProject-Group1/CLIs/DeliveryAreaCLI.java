import java.util.Scanner;

public class DeliveryAreaCLI {
    public static void run(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.print( "What would you like to do:\n" + "1 Create delivery area\n" + "2 Read delivery area\n" +
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
                System.out.println("Entry Invalid. Please enter 1-5");
            }
        }
    }

    private static void createDeliveryArea(Scanner scanner) {
        System.out.println("=== Create New Delivery Area ===");
        System.out.print("Area Code: ");
        int areaCode = scanner.nextInt();
        scanner.nextLine();
        DeliveryAreaDAO deliveryAreaDAO = new DeliveryAreaDAO();
        if (deliveryAreaDAO.findDeliveryAreaByAreaCode(areaCode) != null) { System.out.println("Area with code " + areaCode + " already exists"); return; }
        System.out.print("Area Name: ");
        String name = scanner.nextLine();
        DeliveryArea deliveryArea = new DeliveryArea();
        deliveryArea.createDeliveryArea(areaCode, name);
        if (deliveryAreaDAO.addDeliveryArea(deliveryArea)) {
            System.out.println("Delivery area saved successfully.");
        } else {
            System.out.println("Failed to save delivery area.");
        }
    }

    private static void readDeliveryArea(Scanner scanner) {
        System.out.println("=== Find Delivery Area ===");
        System.out.print("Area Code: ");
        int areaCode = scanner.nextInt();
        scanner.nextLine();
        DeliveryAreaDAO deliveryAreaDAO = new DeliveryAreaDAO();
        DeliveryArea deliveryArea = deliveryAreaDAO.findDeliveryAreaByAreaCode(areaCode);
        if (deliveryArea == null) { System.out.println("Delivery area with area code " + areaCode + " could not be found"); return; }
        System.out.println("Name: " + deliveryArea.getName() + 
        				   "\nCustomers: " + deliveryArea.getCustomers().size());
    }

    private static void updateDeliveryArea(Scanner scanner) {
        System.out.println("=== Find Delivery Area ===");
        System.out.print("Area Code: ");
        int areaCode = scanner.nextInt();
        scanner.nextLine();
        DeliveryAreaDAO deliveryAreaDAO = new DeliveryAreaDAO();
        DeliveryArea deliveryArea = deliveryAreaDAO.findDeliveryAreaByAreaCode(areaCode);
        if (deliveryArea == null) { System.out.println("Delivery area with area code " + areaCode + " could not be found"); return; }
        System.out.println("=== Update Delivery Area ===");
        try {
            System.out.print("New name: ");
            if (!deliveryArea.setName(scanner.nextLine())) { System.out.println("Invalid value entered."); }
            deliveryAreaDAO.updateDeliveryArea(deliveryArea);
            System.out.println("Delivery area updated");
        } catch (Exception e) { System.out.println("Failed to update delivery area"); }
    }

    private static void deleteDeliveryArea(Scanner scanner) {
        System.out.println("=== Delete Delivery Area ===");
        System.out.print("Area Code: ");
        int areaCode = scanner.nextInt();
        scanner.nextLine();
        DeliveryAreaDAO deliveryAreaDAO = new DeliveryAreaDAO();
        if (deliveryAreaDAO.deleteDeliveryArea(areaCode)) {
            System.out.println("Delivery area deleted successfully.");
        } else {
            System.out.println("Failed to delete delivery area.");
        }
    }
}