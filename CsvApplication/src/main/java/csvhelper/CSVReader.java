package csvhelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class CSVReader implements Serializable{
	
	/**
	 * serialized class so that data can be transmitted as a serialized object from client to server
	 */
	private static final long serialVersionUID = 3099049541696717455L;
	protected String file;
	protected BufferedReader reader;
	protected String line;
	protected ArrayList<String[]> arrayOfLines = new ArrayList<String[]>();
	/**
	 * takes in file to read, initializes reader and line, takes in minimum value to pass
	 * @param CSVfile
	 * @param x
	 * @throws IOException 
	 */
	public CSVReader(String CSVfile)
	{
		file = CSVfile;
        reader = null;
        line = "";
        
        try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Read()
	{
         try {
         	
         	//System.out.println(line);
				while((line = reader.readLine()) != null){
					
				    //add student to arraylist
					getNextEntry();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void getNextEntry()
	{
		System.out.println(line);
		String[] row = line.split(",");
		arrayOfLines.add(row);
		//System.out.println(arrayOfLines.size());
	}
	
	public ArrayList<String[]> getArr() {
		// TODO Auto-generated method stub
		return arrayOfLines;
	}
}
