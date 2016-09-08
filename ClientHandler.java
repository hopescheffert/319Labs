package messenger;

import java.io.BufferedInputStream;
import java.net.Socket;
import java.util.Scanner;

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

		// 1. USE THE SOCKET TO READ WHAT THE CLIENT IS SENDING
		in = new Scanner(new BufferedInputStream(System.in));
		//display menu to client
		System.out.println("What would you like to do? "
				+ "Please choose 1 or 2 and press enter:");
		System.out.println("1. Send a text message to the server");
		System.out.println("2. Send an image file to the server");
		int choice = in.nextInt();
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