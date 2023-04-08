package assignment1;

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
	
	
}
