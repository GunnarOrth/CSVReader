package csvhelper;

import java.io.*;

public class ReportWriter {
	
	private File myObj;
	private FileWriter myWriter;
	
	/**
	 * constructor used to initialize the header of the report and filename
	 * I thought it would be better to be able to pass something in for later iterations
	 * @param header
	 * @param filename
	 */
	public ReportWriter(String header, String filename)
	{
		try {
            myObj = new File(filename);
            
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try{
            myWriter = new FileWriter(filename);
            myWriter.write(header);
        }
        catch(Exception e){
            e.printStackTrace();
        }
	}
	
	//function that takes in a StudentReport and writes it to the report
	public void writeLine(StudentReport x)
	{
		try {
			myWriter.write(x.toString());
			//System.out.println(x.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
