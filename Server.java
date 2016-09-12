package messenger;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	private static String clientName;
	private static ServerSocket serverSocket;
	private static Socket clientSocket = null;

	
	public Server() {}


	public static void main(String[] args) throws IOException 
	{
		serverSocket = null;
		// 1. CREATE A NEW SERVERSOCKET
		try 
		{
			serverSocket = new ServerSocket(4444); // provide MYSERVICE at port 4444
		} catch (IOException e) {
			System.out.println("Could not listen on port: 4444");
			System.exit(-1);
		}


		// 2. LOOP FOREVER - SERVER IS ALWAYS WAITING TO PROVIDE SERVICE!

		while (true) {

			try {
				// 2.1 WAIT FOR CLIENT TO TRY TO CONNECT TO SERVER
				clientSocket = serverSocket.accept();

				// 2.2 SPAWN A THREAD TO HANDLE CLIENT
				//System.out.println("Server is connected to " + clientName);
				//Thread t = new Thread(new ClientHandler(clientSocket, clientName));
				Thread t = new Thread(new ServerListenForClientMessage(new Client(Client.getUsername()), clientSocket));
				t.start();
			} catch (IOException e) {
				System.out.println("Accept failed: 4444");
				System.exit(-1);
			}

		} // end while loop

	} // end of main method


	




}//end of Server class



