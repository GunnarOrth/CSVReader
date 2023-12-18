package csvhelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import csvhelper.StudentReport.ReportBuilder;

public class CsvApplication implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9148581566649888709L;

	public static void main(String[] args) throws ClassNotFoundException {
		//initialize server client communication objects
		Socket socket = null;
		InputStreamReader inputStreamReader = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
        //starts GUI
		GUI studentGUI = new GUI();
		
		while(!studentGUI.getSubmitted()) {
			//wait
		}
		//System.out.println("while loop passedd");
		
		try {
			socket = new Socket("localhost", 1234);
			//connect objects
			inputStreamReader = new InputStreamReader(socket.getInputStream());
			outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
			
			bufferedReader = new BufferedReader(inputStreamReader);
			bufferedWriter = new BufferedWriter(outputStreamWriter);
			//send file path to server for csvreader	
			String msgToSend = studentGUI.getFile().toString();
			bufferedWriter.write(msgToSend);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			//create an object input stream to capture serialized objects from server
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ArrayList<String[]> arrayOfLines;
			//create arraylist from object(deserialized)
			arrayOfLines = (ArrayList<String[]>) in.readObject();
			System.out.println(arrayOfLines);
			//build report
			ReportBuilder builder = new StudentReport.ReportBuilder();
	        
	        //get information from file
			System.out.println(studentGUI.getFile().toString());
	        
	        //build student report
	        builder.addMin(studentGUI.getPassInt());
	        builder.buildStudent(arrayOfLines);
	        StudentReport studentList = builder.build();
	        
	        //make report writer and write to file
	        ReportWriter report = new ReportWriter("Student Pass/FAIL\n", studentGUI.getFileString() + ".txt");
	        report.writeLine(studentList);
	        report.close();
	        in.close();
			//System.out.println("Server: " + bufferedReader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null)
					socket.close();
				if(inputStreamReader != null)
					inputStreamReader.close();
				if(outputStreamWriter != null)
					outputStreamWriter.close();
				if(bufferedReader != null)
					bufferedReader.close();
				if(bufferedWriter != null)
					bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        
	}
}




