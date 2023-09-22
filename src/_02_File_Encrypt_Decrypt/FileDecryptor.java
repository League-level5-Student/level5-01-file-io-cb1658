package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
		FileDecryptor d = new FileDecryptor();
		
		d.decrypt(7);
	}
	void decrypt(int key) {
		
		ArrayList<Character> arr = new ArrayList<Character>();
		
		try {
			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/encrypted.txt");
			int c = fr.read();
			while(c != -1){
				
				arr.add((char)c);
				
				c = fr.read();
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		StringBuilder bob = new StringBuilder();
		
		for(char c : arr) {
			c -= key%26;
			bob.append(c);
		}
		String nova_res = bob.toString();
		nova_res.toLowerCase();
		
		JOptionPane.showMessageDialog(null, nova_res);
	}
		
}
