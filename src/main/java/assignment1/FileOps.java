package assignment1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class FileOps {
	private static String FILE_NAME;
	
	private static void setFileName (String fileName) {
		FILE_NAME = fileName;
	}
		
	public void sortByName() {
		//Creating a File object for directory
	      File directoryPath = new File("./src/main/resources/");
	      //List of all files and directories
	      File fileArr[] = directoryPath.listFiles();
	      
	      for(File file:fileArr) {
	    	  System.out.println(file.getName());
	    	  System.out.println();
	      }
	      
	      //redundant logic since previous file.listFile() returns sorted array
			/*
			 * List<File> fileList = Arrays.asList(fileArr);
			 * Collections.sort(fileList); System.out.
			 * println("Sorting by filename in ascending order"
			 * ); for(File filel:fileList){
			 * System.out.println(filel); }
			 */	}

	
	public void addFile(String fileName) {
		FileOps.setFileName(fileName);
		try {

			File file = new File("./src/main/resources/"+FILE_NAME); 
			if(file.createNewFile()) {
				System.out.println("File created");
			} else {
				System.out.println("File already exists");
			}
		} catch(IOException e) {
			System.out.println("Error while creating file");
			e.printStackTrace();
		}
	}


	public void deleteFile(String fileName) {
		FileOps.setFileName(fileName);
		try {
			boolean deleted = Files.deleteIfExists(Paths.get("./src/main/resources/"+FILE_NAME));
			if (deleted) {
				System.out.println("File "+fileName+" is deleted");
			} else {
				System.out.println("File "+fileName+" not present");
			}
		} catch (IOException e) {
			System.out.println("Error while deleting file");
			e.printStackTrace();
		}
		
	}
	
	public boolean searchForFile(String fileName) {
		FileOps.setFileName(fileName);
		boolean filePresent=false;
		try {
			Path path = Paths.get("./src/main/resources/"+FILE_NAME);
			boolean fileExists = Files.exists(path);
			if (fileExists) {
				System.out.println("File exists");
				filePresent =true;
			} else {
				System.out.println("File does not exist");
			}
		} catch (SecurityException e) {
			System.out.println("Error while trying to look up file");
			e.printStackTrace();
		}
		catch (InvalidPathException e) {
			System.out.println("Error while trying to look up file");
			e.printStackTrace();
		}
		return filePresent;
	}
	
	public void appendToFile(String fileName,boolean newLine) {
		FileOps.setFileName(fileName);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("./src/main/resources/"+FILE_NAME,true))) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the text you want to append to the file ");
			String content =  scanner.nextLine();
			if(newLine) {
			writer.write("\n");
			}
			writer.write(content);
			System.out.println("Successfully updated to  the file");
		} catch (IOException e) {
			System.out.println("Error: An error accured while writing to  the file");
			e.printStackTrace();
		}
		
	}

	public void readFromFile(String fileName) {
		FileOps.setFileName(fileName);
		try (BufferedReader reader = new BufferedReader(new FileReader("./src/main/resources/"+FILE_NAME))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: An error occured while reading the file.");
			e.printStackTrace();
		}

	}

}
