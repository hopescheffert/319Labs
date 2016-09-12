package messenger;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;

import org.omg.CORBA.portable.OutputStream;

class ClientHandler implements Runnable {
	private static Socket s; // this is socket on the server side that connects to the CLIENT
	private String username;

	ClientHandler(Socket s, String username) 
	{
		this.s = s;
		this.username = username;

	}

	// This is the client handling code
	// This keeps running handling client requests 
	// after initially sending some stuff to the client
	@Override
	public void run() 
	{
		Scanner console;
		PrintWriter out;

		try
		{
			// 1. USE THE SOCKET TO READ WHAT THE CLIENT IS SENDING?
			//in = new Scanner(new BufferedInputStream(s.getInputStream())); 
			console = new Scanner(new BufferedInputStream(System.in)); 
			out = new PrintWriter(new BufferedOutputStream(s.getOutputStream()));
			//out = new PrintWriter(s.getOutputStream());
			//display menu to client
			System.out.println("What would you like to do? "
					+ "Please choose 1 or 2 and press enter:");
			//out.flush();
			System.out.println("1. Send a text message to the server");
			//out.flush();
			System.out.println("2. Send an image file to the server");
			//out.flush();

			//keep listening and responding to client requests

			int choice = console.nextInt();

			if(choice == 1) //wants to send a message
			{
				//TODO make sure message goes to chat.txt

				//send to a new thread to deal with client sending message
				//Thread t = new Thread(new ClientListenForMessage(new Client(username), s));
				Thread t = new Thread(new ClientSendMessage(s, username));
				t.start();
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
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

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
					ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
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