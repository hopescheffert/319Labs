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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	private static String clientName;
	private static ServerSocket serverSocket;
	private static Socket clientSocket = null;

	public Server() {}


	public static void main(String[] args) throws IOException, InterruptedException 
	{
		serverSocket = null;
		// 1. CREATE A NEW SERVERSOCKET
		try 
		{
			serverSocket = new ServerSocket(1222); // provide MYSERVICE at port 4444
		} 
		catch (IOException e) 
		{
			System.out.println("Could not listen on port: 1222");
			System.exit(-1);
		}

		// 2. LOOP FOREVER - SERVER IS ALWAYS WAITING TO PROVIDE SERVICE!
		while (true) 
		{
			try {
				// 2.1 WAIT FOR CLIENT TO TRY TO CONNECT TO SERVER
				clientSocket = serverSocket.accept();

				// 2.2 SPAWN A THREAD TO HANDLE CLIENT
				System.out.println("Server is connected to a client");

				Thread t = new Thread(new ServerHandleClient(clientSocket, Client.username));
				t.start();

			} catch (IOException e) {
				System.out.println("Accept failed: 4444");
				System.exit(-1);
			}

		} // end while loop

	} // end of main method


}//end of Server class

class ServerHandleClient implements Runnable 
{
	private static Socket s; // this is socket on the server side that connects to the CLIENT
	private String username;
	private int choice;

	private Scanner  streamIn  =  null;
	private PrintWriter streamOut = null;

	ServerHandleClient(Socket s, String username) throws IOException, InterruptedException
	{
		this.s = s;
		this.username = username;
	}

	//handle given message
	public synchronized void handle(String input, int choice) throws IOException
	{
		if(choice == 1) //incoming encrypted message
		{
			try 
			{
				//get encrypted message
				String encryptedMessage = decryptMessage(input);
				//send to server
				streamOut.println(encryptedMessage.length()); //write length of the message (an int)
				streamOut.println(encryptedMessage); //write the message
				streamOut.flush(); //forces output
			} 
			catch (UnsupportedEncodingException e) 
			{
				System.out.println("----Problem with encrypting the message");
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}

		}
		else //incoming encrypted image
		{

		}


	}

	/**
	 * Method of Decryption:
	 * For every byte Bn in the received String, Let Bn  = Bn XOR 11110000
	 * e.g. Bn = 01011000, then Bn Xor 11110000 = 10101000
	 * @throws UnsupportedEncodingException 
	 */
	public synchronized String decryptMessage(String message) throws UnsupportedEncodingException
	{
		byte [] encryptedBytes = message.getBytes();
		byte[] decryptedBytes = new byte[encryptedBytes.length];

		//for each of the encrypted bytes XOR and put into decryptedBytes
		for(int i = 0; i < encryptedBytes.length; i ++)
		{
			//do XOR with 11110000
			decryptedBytes[i] = (byte) (encryptedBytes[i] ^ 11110000);

		}
		return new String(decryptedBytes);
	}


	//This is the client handling code
	//This keeps running handling client requests 
	@Override
	public void run() 
	{
		try {
			streamIn = new Scanner(new BufferedInputStream(s.getInputStream()));
			//System.out.println("error");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		while(true)
		{
			//get the choice - if its 1 handle message if its 2 handle image
			choice = streamIn.nextInt();
			try 
			{
				handle(streamIn.nextLine(), choice);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}// end of method run()

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
