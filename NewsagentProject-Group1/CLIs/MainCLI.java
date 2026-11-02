import java.util.Scanner; 

public class MainCLI {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		while (running) {
			System.out.print("What do you want to run\n"
					+ "1 - NewsagentCLI\n" + "2 - CustomerCLI\n" + "3 - OrderCLI\n" + "4 - Exit\n" + "Enter 1-4: ");
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
				running = false;
				break;
			default:
				System.out.println("Entry Invalid. Please enter 1-4");
			}
		}
		scanner.close();
	}
}