package csvhelper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener{
	
	private JLabel label;
	private JTextField passText;
	private JLabel outputLabel;
	private JTextField fileText;
	private JButton enterButton;
	private JLabel createdLabel;
	private JLabel loadedLabel;
	private int passInt;
	private String fileString;
	private File file;
	private JButton fileButton;
	private boolean submitted;
	
	public GUI() {
		//submitted = false;
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		
		panel.setLayout(null);
		
		//creat pass fail text
		label = new JLabel("Pass/Fail:");
		label.setBounds(20,20,200,25);
		panel.add(label);
		passText = new JTextField();
		passText.setBounds(110, 20, 200, 25);
		panel.add(passText);
		
		//create report name text
		outputLabel = new JLabel("Report Name:");
		outputLabel.setBounds(20,50,200,25);
		panel.add(outputLabel);
		fileText = new JTextField();
		fileText.setBounds(110, 50, 200, 25);
		panel.add(fileText);
		
		//button to create report
		enterButton = new JButton("Load Report");
		enterButton.setBounds(10, 110, 100, 25);
		enterButton.addActionListener(this);
		panel.add(enterButton);
		
		//creates label that once file is loaded will say file is loaded
		loadedLabel = new JLabel("");
		loadedLabel.setBounds(115, 80, 200, 25);
		panel.add(loadedLabel);
		
		//creates label once a file has been created with student report info will say success
		createdLabel = new JLabel("");
		createdLabel.setBounds(115, 110, 200, 25);
		panel.add(createdLabel);
		
		//create a button that, when pressed will load a file that's been chosen, no compatable file filter yet
		fileButton = new JButton("Choose CSV");
		fileButton.setBounds(10,80,100,25);
		fileButton.addActionListener(this);
		panel.add(fileButton);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/**
		 * if enter button is chosen and a file has been chosen it will attempt to create a report,
		 * else it will load the file chosen from JFileChooser
		 */
		if(e.getSource() == enterButton && (file != null)) {
			String temp = passText.getText();
			passInt = Integer.valueOf(temp);
			fileString = fileText.getText();
			System.out.println(passInt + "\n" + fileString);
			submitted = true;
			System.out.println(submitted);
			createdLabel.setText("File Created");
		}
		else {
			JFileChooser fileChooser = new JFileChooser();
			int response = fileChooser.showOpenDialog(null); //select file to open
			
			if(response == JFileChooser.APPROVE_OPTION) {
				file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(file);
				loadedLabel.setText("File Loaded");
			}
		}
	}

	public int getPassInt() {
		return passInt;
	}

	public String getFileString() {
		return fileString;
	}

	public boolean getSubmitted() {
		System.out.println(submitted);
		// TODO Auto-generated method stub
		
		return submitted;
	}
	
	public File getFile() {
		return file;
	}
}
