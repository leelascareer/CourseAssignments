package assignment1;

public class WelcomeScreen {

	public static void main(String args[]) {
		String fileName;
		boolean exit = false;
		FileOps file = new FileOps();
		WelcomeScreen ws = new WelcomeScreen();
		UserInputs ui = new UserInputs();

		// welcome message
		ws.printWelcomeMessage();

		while (!exit) {
			// get user input
			String userInput = ui.getUserChoice();

			// operation based on user input
			switch (userInput) {

			case "1":
				// Call sort method
				file.sortByName();
				break;

			case "2":
				// add method
				fileName = ui.getFileName();
				file.addFile(fileName);
				break;

			case "3":
				// delete file
				fileName = ui.getFileName();
				file.deleteFile(fileName);
				break;

			case "4":
				// search for file
				fileName = ui.getFileName();
				file.searchForFile(fileName);
				break;

			case "5":
				exit = true;
				// call exit method
				System.out.println("Thank You");
				break;

			default:
				System.out.println("Please check your input");
			}
		}
	}

	private void printWelcomeMessage() {
		System.out.println("     *****     ");
		System.out.println("Company Lockers Application");
		System.out.println("Developed By Leela N");
		System.out.println("     *****     ");

	}

}
