package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter in some of that message");
		String a = sc.nextLine();
		System.out.println("ACCEPTED; Please check BOOM.txt");
		
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/BOOM.txt");
			
			fw.write(a);
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
