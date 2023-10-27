package textEditor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextEditor {
	
	public static void main(String[] args) {
		new TextEditor().start();
		
	}
	
	public void start() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JTextArea ta = new JTextArea(30,60);
		JButton save = new JButton();
		JButton load = new JButton();
		save.setText("save");
		save.addActionListener((e) -> {
			String s = ta.getText();
			save(s);
		});
		load.setText("load");
		load.addActionListener((e) -> {
			ta.setText(load(ta));
			System.out.println("boo");
		});
		panel.add(ta);
		panel.add(save);
		panel.add(load);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void save(String s) {
		
		try {
			FileWriter fw = new FileWriter("src/textEditor/TextEditor_SAVE.txt");
			fw.write("\n");
			
			fw.write(s);
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String load(JTextArea ta) {
		
		
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String fileName = jfc.getSelectedFile().getAbsolutePath();
			
			System.out.println(fileName);
			try {
				
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				
				String line = br.readLine();
				System.out.println(line);
				String loadedText = "";
				
				while(line != null) {
					line = br.readLine();
					
					if(line == null) {
						continue;
					}

					System.out.println("Line: "+line);
					loadedText += line+"\n";
					System.out.println("LoadedText: "+loadedText);
				}
				br.close();
				return loadedText;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			
		}
		return null;
	}
}
