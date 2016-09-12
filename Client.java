package messenger;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;


public class Client 
{
	
	
	private ObjectOutputStream streamOut = null;
	private static Socket serverSocket = null;
	ClientListenForServerMessage listen;
	ClientSendMessage sendmsg;
	static String username;
	private ArrayList<Client> clientList = new ArrayList<Client>();

	Client(String username) throws UnknownHostException, IOException
	{
		serverSocket = new Socket("localhost", 4444);
		this.username = username;
		clientList.add(this);
		
		//SPAWN A LISTENER FOR THE SERVER. THIS WILL KEEP RUNNING
		listen = new ClientListenForServerMessage(this, serverSocket);
		new Thread(listen).start();
		
	}

	public static String getUsername()
	{
		return username;
	}
	
	public void handleMessage(String msg)
	{
		//now spawn a thread to deal with client send message
		//***don't know if this should go here or in client handler???***
		//PrintWriter out;
		//out = new PrintWriter(new BufferedOutputStream(serverSocket.getOutputStream()));
		ClientSendMessage csm = new ClientSendMessage(serverSocket, username);
		csm.go();
	}


	public static void main(String[] args) throws UnknownHostException, IOException 
	{
		
		//create scanner for client input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name and press enter");
		username = scanner.next();
		
		Client c = new Client(username);
		
		Scanner console;
		PrintWriter out;

		try
		{
			// 1. USE THE SOCKET TO READ WHAT THE CLIENT IS SENDING?
			//in = new Scanner(new BufferedInputStream(s.getInputStream())); 
			console = new Scanner(new BufferedInputStream(System.in)); 
			out = new PrintWriter(new BufferedOutputStream(serverSocket.getOutputStream()));
			//out = new PrintWriter(s.getOutputStream());
			//display menu to client
			System.out.println("What would you like to do? "
					+ "Please choose 1 or 2 and press enter:");
			System.out.println("1. Send a text message to the server");
			System.out.println("2. Send an image file to the server");

			//keep listening and responding to client requests

			int choice = console.nextInt();

			if(choice == 1) //wants to send a message
			{
				//TODO make sure message goes to chat.txt

				//send to a new thread to deal with client sending message
				ClientSendMessage csm = new ClientSendMessage(serverSocket, username);
				csm.go();
			}
			
			
			//****IMAGE*****			
			
			else if(choice == 2) //wants to send an image
			{
				//TODO will look something like this:
				//Thread t = new Thread(new ClientSendImage(s));
				//t.start();
				//TODO put this in new class called ClientSendImage implements Runnable
				//TODO send an image file to the server using java's object output stream
				try {
					ObjectOutputStream oos = new ObjectOutputStream(serverSocket.getOutputStream());

					//Object ob = new Object();
					//oos.writeObject(ob);

					//stuff here

					//oos.close();

				} catch (IOException e) {
					e.printStackTrace();
				}

				//ask client to enter the file name of the image
				System.out.println("Please enter your image file name and press enter");
				Scanner img = new Scanner(System.in);
				String imgpath = img.nextLine();
				img.close();
				//TODO convert image to a string sequence and encrypt that
				//send it to encryption method
				//byte[] encryptedImage = encryptImage(imgpath);


				//get image from the client
				try 
				{
					ObjectInputStream ois = new ObjectInputStream(serverSocket.getInputStream());
					//Object ob1 = ois.readObject();

					//stuff here

					//ois.close();


				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			else
			{ System.out.println("Please enter either 1 or 2");}

		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// This handling code dies after doing all the printing
		
		
		
		//spawn new thread to deal with server handling the message from the client
		Thread t2 = new Thread(new GetMessageFromClient(serverSocket, c.username));
		t2.start();
		
		while(true)
		{
			//keeps client running forever
		}


	}
	
	/**
	 * IMAGE
	 * Method of Encryption:
	 * Suppose an image is stored by m bytes
	 * 
	 * For every 3 bytes, we have 24 bits
	 * 		Divide 24 into four 6 bit fragments
	 * 		Add two bits of 00 to the right of each 6 bits fragment
	 * 		(then we can get four 8 bit fragments)
	 * 		Convert the 8 bit fragments into characters and combine them to make a string
	 * 
	 * @param path
	 * @return
	 */
	public byte[] encryptImage(String path)
	{
		byte[] encryptedBytes = path.getBytes();
		int len = encryptedBytes.length;
		//for every 3 bytes

		for(int i = 0; i < len % 3; i++)
		{
			//TODO encrypt!

		}

		return encryptedBytes;

	}
}