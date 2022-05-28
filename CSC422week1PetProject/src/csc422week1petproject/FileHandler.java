package csc422week1petproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
	
	public void getFile() {		
		try {
		      File myObj = new File("petText.txt");
		      System.out.println(myObj.isFile());
		      
		      
		      
		      
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	System.out.println("loop");
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      //e.printStackTrace();
		    }
	}
	
	public void testThis() {
		File f = new File("pet.txt");
		try {
		    System.out.println(f.getCanonicalPath());
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	

}
