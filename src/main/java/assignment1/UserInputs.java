package assignment1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputs {

	Scanner in = new Scanner(System.in);
	
	public String getUserChoice() {	
		System.out.println("Select an option to proceed");
		System.out.println("Enter 1 to see file names");
		System.out.println("Enter 2 to add a file");
		System.out.println("Enter 3 to delete a file");
		System.out.println("Enter 4 search for a file");
		System.out.println("Enter 5 to exit");		
		return in.next();
	}
	
	public String getFileName() {
		System.out.println("Enter file name");		
		return in.next();
	}
	
	public String getAccessChoice() {
		System.out.println("Do you want to open the file - Y/N? ");
		String accessChoice=in.next();
		if (accessChoice.equalsIgnoreCase("y")) {
			System.out.println("Enter R to read the file");
			System.out.println("Enter M to modify the file");
			accessChoice = in.next();
		} 
		return accessChoice;
	}
	
	public boolean isNewLine() {
		boolean isNewLine= false;
		System.out.println("Do you want to add the content as a new line - true/false? ");
		boolean choice = false;
		try {
			choice =in.nextBoolean();
		}
		catch (InputMismatchException e) {
			System.out.println("Please check your input");
			WelcomeScreen ws = new WelcomeScreen();
			ws.askUserChoice(false);
		}
		if (choice) {
			isNewLine = true;
		} 
		return isNewLine;
	}
	
}
