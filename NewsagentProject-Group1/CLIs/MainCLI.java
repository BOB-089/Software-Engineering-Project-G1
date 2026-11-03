import java.util.Scanner; 

public class MainCLI {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		while (running) {
			System.out.print("What do you want to run\n" + 
							 "1 - NewsagentCLI\n" + 
							 "2 - CustomerCLI\n" + 
							 "3 - OrderCLI\n" + 
							 "4 - PublicationsCLI\n" +
							 "5 - DeliveryAreaCLI\n" +
							 "6 - DeliveryDocketCLI\n" +
							 "7 - DeliveryPersonCLI\n" +
							 "8 - BillCLI\n" +
							 "9 - Exit\n" + 
							 "Enter 1-9: ");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1": 
				NewsagentCLI.run(scanner);
				break;
			case "2": 
				CustomerCLI.run(scanner);
				break;
			case "3": 
				OrderCLI.run(scanner);
				break;
			case "4": 
				PublicationsCLI.run(scanner);
				break;
			case "5": 
				DeliveryAreaCLI.run(scanner);
				break;
			case "6": 
				System.out.println("Incomplete");
				//DeliveryDocketCLI.run(scanner);
				break;
			case "7": 
				DeliveryPersonCLI.run(scanner);
				break;
			case "8": 
				System.out.println("Incomplete");
				//BillCLI.run(scanner);
				break;
			case "9": 
				running = false;
				break;
			default:
				System.out.println("Entry Invalid. Please enter 1-9");
			}
		}
		scanner.close();
	}
}