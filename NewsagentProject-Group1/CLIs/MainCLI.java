import java.util.Scanner; 

public class MainCLI {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("What do you want to run\n"
				+ "1 - NewsagentCLI\n" + "2 - CustomerCLI\n" + "3 - OrderCLI\n" + "Enter 1-3: ");
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
		}
		scanner.close();
	}
}