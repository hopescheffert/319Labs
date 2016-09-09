package messenger;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;

class ClientHandler implements Runnable {
	private static Socket s; // this is socket on the server side that connects to the CLIENT

	ClientHandler(Socket s) 
	{
		this.s = s;

	}
//	public Socket getClientSocket()
//	{
//		return s;
//	}
	// This is the client handling code
	@Override
	public void run() 
	{
		Scanner in;

		// 1. USE THE SOCKET TO READ WHAT THE CLIENT IS SENDING?
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
			//TODO make sure message goes to chat.txt
			
			//send to a new thread
			Thread t = new Thread(new ClientSendMessage(s));
			t.start();
		}
		else if(choice == 2)
		{
			//TODO send an image file to the server using java's obj out stream
			try {
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			
				//Object ob = new Object();
				//oos.writeObject(ob);
				
				//oos.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("Please enter your image file name and press enter");
			Scanner img = new Scanner(System.in);
			String imgpath = img.nextLine();
			img.close();

			//byte[] encryptedImage = encryptImage(imgpath);

			
			//get image file from client
			try 
			{
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				//Object ob1 = ois.readObject();
				
				
				
				//ois.close();

			
			} catch (IOException e) {
				e.printStackTrace();
			}
			

		}
		else
		{ System.out.println("Please enter either 1 or 2");}
		// This handling code dies after doing all the printing
	} // end of method run()


	
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
	
	
	
	

} // end of class ClientHandler