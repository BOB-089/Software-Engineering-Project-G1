import java.util.Scanner;

public class NewsagentCLI {

	public static void run(Scanner scanner) {

		System.out.println("=== Create New Newsagent ===");

		System.out.print("First Name: ");
		String firstName = scanner.nextLine();

		System.out.print("Surname: ");
		String surname = scanner.nextLine();

		System.out.print("Phone Number: ");
		String phoneNumber = scanner.nextLine();

		Newsagent newsagent = new Newsagent();
		newsagent.createNewsagent(firstName, surname, phoneNumber);

		NewsagentDAO newsagentDAO = new NewsagentDAO();

		if (newsagentDAO.addNewsagent(newsagent)) {
			System.out.println("Newsagent saved successfully.");
		} else {
			System.out.println("Failed to save newsagent.");
		}
	}
}
