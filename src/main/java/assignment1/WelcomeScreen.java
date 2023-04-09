package assignment1;

public class WelcomeScreen {

	public static void main(String args[]) {	
		WelcomeScreen ws = new WelcomeScreen();
		// welcome message
		ws.printWelcomeMessage();
		ws.askUserChoice(false);
		
			
	}

	private void printWelcomeMessage() {
		System.out.println("     *****     ");
		System.out.println("Company Lockers Application");
		System.out.println("Developed By Leela N");
		System.out.println("     *****     ");

	}
	
	private void accessFile(String fileName,String choice, FileOps file, UserInputs ui) {
		switch (choice) {
		case "R":
			file.readFromFile(fileName);
			break;
			
		case "M":
			boolean isNewLine = ui.isNewLine();
			if(isNewLine) {
				file.appendToFile(fileName,true);
				break;
			} 
			if(!isNewLine){
				file.appendToFile(fileName,false);
			break;
			}

		 default: System.out.println("Please check your input");
			break;
		}
	}
	
	public void askUserChoice(boolean value) {
		boolean exit=value;
		String fileName;
		FileOps file = new FileOps();
		
		UserInputs ui = new UserInputs();

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
				boolean filePresent = file.searchForFile(fileName);
				
				if (filePresent) {
				String choice = ui.getAccessChoice();
				if (choice.equals("R")||choice.equals("M")) {
					WelcomeScreen ws = new WelcomeScreen();
					ws.accessFile(fileName,choice, file, ui);
				}
				}
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
}
