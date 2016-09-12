package messenger;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;


public class Client {



	private ObjectOutputStream streamOut = null;
	private static Socket serverSocket = null;
	ClientListenForMessage listen;
	ClientSendMessage sendmsg;
	static String username;
	private ArrayList<Client> clientList = new ArrayList<Client>();

	Client(String username) throws UnknownHostException, IOException
	{
		serverSocket = new Socket("localhost", 4444);
		this.username = username;
		clientList.add(this);
		//SPAWN A LISTENER FOR THE SERVER. THIS WILL KEEP RUNNING
		listen = new ClientListenForMessage(this, serverSocket);
		new Thread(listen).start();
		
	}

	public void handleMessage(String msg)
	{
		//now spawn a thread to deal with client send message
		//***don't know if this should go here or in client handler???***
		//PrintWriter out;
		//out = new PrintWriter(new BufferedOutputStream(serverSocket.getOutputStream()));
		sendmsg = new ClientSendMessage(serverSocket, username);//, msg); //okay
		new Thread(sendmsg).start();
	}



	public static void main(String[] args) throws UnknownHostException, IOException 
	{
		
		//create scanner for client input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name and press enter");
		username = scanner.next();
		
		Client c = new Client(username);
		//spawn new thread to deal with server handling the message from the client
		Thread t2 = new Thread(new GetMessageFromClient(serverSocket, c.username));
		t2.start();
		
		while(true)
		{
			//keeps client running forever
		}


	}
}