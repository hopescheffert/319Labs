package messenger;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	private static String clientName;

	public static String getUsername()
	{
		return clientName;
	}

	public static void main(String[] args) throws IOException 
	{

		//create scanner for client input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name and press enter");
		clientName = scanner.next();
//		Client c = new Client(clientName);
//		c.connect();
		
		

		ServerSocket serverSocket = null;
		// 1. CREATE A NEW SERVERSOCKET
		try 
		{
			serverSocket = new ServerSocket(4444); // provide MYSERVICE at port 4444
		} catch (IOException e) {
			System.out.println("Could not listen on port: 4444");
			System.exit(-1);
		}


		// 2. LOOP FOREVER - SERVER IS ALWAYS WAITING TO PROVIDE SERVICE!
		//Client.main(args);
		while (true) {
			Socket clientSocket = null;

			try {
				// 2.1 WAIT FOR CLIENT TO TRY TO CONNECT TO SERVER
				clientSocket = serverSocket.accept();

				// 2.2 SPAWN A THREAD TO HANDLE CLIENT REQUEST
				System.out.println("Server is connected to " + clientName);
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();

			} catch (IOException e) {
				System.out.println("Accept failed: 4444");
				System.exit(-1);
			}

			// 2.3 GO BACK TO WAITING FOR OTHER CLIENTS
			// (While the thread that was created handles the connected client's
			// request)

		} // end while loop


	} // end of main method
}//end of Server class


class ClientHandler implements Runnable {
	Socket s; // this is socket on the server side that connects to the CLIENT

	ClientHandler(Socket s) 
	{
		this.s = s;

	}
	// This is the client handling code
	@Override
	public void run() 
	{
		Scanner in;

		try {
			// 1. USE THE SOCKET TO READ WHAT THE CLIENT IS SENDING
			in = new Scanner(new BufferedInputStream(s.getInputStream()));
			//display menu to client
			System.out.println("What would you like to do? "
					+ "Please choose 1 or 2 and press enter:");
			System.out.println("1. Send a text message to the server");
			System.out.println("2. Send an image file to the server");
			int choice = in.nextInt();
			System.out.println("here");
			if(choice == 1)
			{
				//TODO send text message to server
				System.out.println("Please type your text message and press enter");
				while(in.hasNextLine())
				{
					String clientTextMessage = in.nextLine();
				}

			}
			else if(choice == 2)
			{
				//TODO send an image file to the server
				System.out.println("Please enter your image file name and press enter");

			}
			else
			{
				System.out.println("Please enter either 1 or 2");
			}

			in.close(); //close scanner

		} catch (IOException e) {
			e.printStackTrace();
		}

		
		// This handling code dies after doing all the printing
	} // end of method run()

	void printSocketInfo(Socket s) {
		System.out.print("Socket on Server " + Thread.currentThread() + " ");
		System.out.print("Server socket Local Address: " + s.getLocalAddress()
		+ ":" + s.getLocalPort());
		System.out.println("  Server socket Remote Address: "
				+ s.getRemoteSocketAddress());
	} // end of printSocketInfo


} // end of class ClientHandler
