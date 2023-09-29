package _03_To_Do_List;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ToDoList{
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	
	List<String> memory = new ArrayList<String>();
	
	public static void main(String[] args) {
		new ToDoList().showButtons();
		
		
	}
	
	public void showButtons() {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton add = new JButton("Add Task");
		JButton view = new JButton("View Tasks");
		JButton remove = new JButton("Remove Task");
		JButton save = new JButton("Save list");
		JButton load = new JButton("Load List");
		
		frame.add(add);
		frame.add(view);
		frame.add(remove);
		frame.add(save);
		frame.add(load);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		frame.pack();

		
		
		add.addActionListener((e) -> {
			String input = JOptionPane.showInputDialog("Enter a task you want to add");
			memory.add(input);
		});
		
		view.addActionListener((e) -> {
			String nova = "";
			for(String s : memory) {
				nova += "\n";
				nova += s;
			}
			JOptionPane.showMessageDialog(null, nova);
		});
		
		remove.addActionListener((e) -> {
			String input = JOptionPane.showInputDialog("Enter a task you want to remove");
			
			if(memory.contains(input)) {
				memory.remove(input);
			}
			else {
				JOptionPane.showMessageDialog(null, "That is not in your schedule!");
			}
		});
		
		save.addActionListener((d) -> {
			
			String nova = "";
			for(String s : memory) {
				nova += "\n";
				nova += s;
			}
				
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			String fileName="";
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				fileName= jfc.getSelectedFile().getAbsolutePath();
				System.out.println(fileName);
			}
			
			try {
				FileWriter fw = new FileWriter(fileName);
				
				fw.write(nova);
					
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		});
		
		load.addActionListener((d) -> {
			load();
		});
	}

	public void load() {
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		String fileName="";
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileName= jfc.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			String line = br.readLine();
			while(line != null){
				memory.add(line);
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
