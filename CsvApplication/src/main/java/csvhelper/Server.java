package csvhelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// initialize server client communication objects
		ServerSocket serverSocket = null;
		
		serverSocket = new ServerSocket(1234);
		
		try {
			
			while (true) {
	    		new TestClientHandler(serverSocket.accept()).start();
	    	}
			//connect objects to server and client data streams	
				
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
	private static class TestClientHandler extends Thread {
        private Socket socket;
        private ObjectOutputStream out;
        private BufferedReader bufferedReader;
        
        /**
         * Create an instance of the TestClientHandler class
         * @param socket - Socket
         */
        public TestClientHandler(Socket socket) {
        	this.socket = socket;
        }
        
        /**
         * Perform actions that the client needs to get a sorted collection of data
         */
        public void run() {
        	try {
        		bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        		String msgFromClient = bufferedReader.readLine();
        		
        		StudentCsvReader studentReader = new StudentCsvReader(msgFromClient);
    			//check if file is a student report csv 
    			if(studentReader.checkCSV()) {
    			        	//System.out.println("student reader if statement");
    			     studentReader.Read();
    			}
    					
    			System.out.println("Client: " + msgFromClient);
    					
    			//bufferedWriter.write(studentReader.getArr());
    			//bufferedWriter.newLine();
    			//bufferedWriter.flush();
    			
    			//send out arraylist of arrays as a serialized object
    			out = new ObjectOutputStream(socket.getOutputStream());
    			out.writeObject(studentReader.getArr());
    			System.out.println(studentReader.getArr());
    			
    			socket.close();
    			out.close();
    			bufferedReader.close();
    			
    		} catch (IOException e) {
    			System.out.println("ERROR: Issue encountered during client communication, system exiting");
    			System.exit(1);
    		}
        }
    }
}

