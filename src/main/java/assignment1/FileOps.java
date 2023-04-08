package assignment1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;


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
			//File file = new File(FILE_NAME);
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
		try {
			Files.deleteIfExists(Paths.get(FILE_NAME));
			System.out.println("File "+fileName+" is deleted");
		} catch (IOException e) {
			System.out.println("Error while deleting file");
			e.printStackTrace();
		}
		
	}
	
	public void searchForFile(String fileName) {
		boolean fileExists;
		try {
			Path path = Paths.get(fileName);
			fileExists = Files.exists(path);
			if (fileExists) {
				System.out.println("File exists");
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
		
	}

	

	

}
