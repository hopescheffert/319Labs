package cs319;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ListDataServer {

	public static void main(String [] args) throws IOException {

		ServerSocket serverSocket = null;
		int clientNum = 0; // keeps track of how many clients were created

		// create server socket
		try {
			serverSocket = new ServerSocket(4444);
		} catch (IOException e) {
			System.exit(-1);
		}

		// Server loop
		while (true) {
			Socket clientSocket = null;
			try {

				// wait for client
				System.out.println("Waiting for client " + (clientNum + 1)
						+ " to connect!");
				clientSocket = serverSocket.accept();

				// spawn thread to handle request
				System.out.println("Server got connected to a client"
						+ ++clientNum);
				Thread t = new Thread(new ClientDataHandler(clientSocket, clientNum));
				t.start();

			} catch (IOException e) {
				System.out.println("Accept failed: 4444");
				System.exit(-1);
			}

		} // end while loop

	} // end of main method

} // end of class MyServer

class ClientDataHandler implements Runnable {
	Socket s; 
	int num; 

	ClientDataHandler(Socket s, int n) {
		this.s = s;
		num = n;
	}

	public void run() {
		try{
			ObjectInputStream dataIn = new ObjectInputStream(s.getInputStream());

			ArrayList<String> data = (ArrayList<String>)dataIn.readObject();
			
			if(data.get(0).equalsIgnoreCase("READ")){
				ObjectOutputStream dataOut = new ObjectOutputStream(s.getOutputStream());
				dataOut.writeObject(readFromFile());
			} else {
				writeToFile(data);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	void writeToFile(ArrayList<String> list) throws IOException{
		File file = new File("companies.txt");
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		for(int i = 0; i < list.size(); i++){
			bufferedWriter.write((String) list.get(i) + "\n");
		}
		bufferedWriter.close();
		fileWriter.close();
	}
	
	ArrayList<String> readFromFile() throws FileNotFoundException{
		File file = new File("companies.txt");
		Scanner scanner = new Scanner(file);
		ArrayList<String> data = new ArrayList<String>();
		while(scanner.hasNext()){
			data.add(scanner.next());
		}
		return data;
	}
	
} // end of class ClientDataHandler

