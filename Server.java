package messenger;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
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
		int i = 1;

		// 2. LOOP FOREVER - SERVER IS ALWAYS WAITING TO PROVIDE SERVICE!
		while (true) 
		{
			try {
				// 2.1 WAIT FOR CLIENT TO TRY TO CONNECT TO SERVER
				clientSocket = serverSocket.accept();
				System.out.println("Server is connected to client" + (i++));

				// 2.2 SPAWN A THREAD TO HANDLE CLIENT
				Thread t = new Thread(new ServerHandleClient(clientSocket));
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

	private Scanner  streamIn  =  null;
	private PrintWriter streamOut = null;


	ServerHandleClient(Socket s) throws IOException, InterruptedException
	{
		this.s = s;
		streamOut = new PrintWriter(new BufferedOutputStream(s.getOutputStream()));

	}

	//handle given message	
	public synchronized void handle(String input) throws IOException
	{
		
		if(input.startsWith("!-!")) //incoming is client's name
		{
			username = input.substring(3);
		}
		else if(input.startsWith("#")) //incoming encrypted message
		{
			input = input.substring(1); //take off # so can decrypt
			try 
			{
				//get encrypted message
				String decryptedMessage = decryptMessage(input);
				//send to server
				streamOut.println(username + ": " + decryptedMessage); //write the message
				streamOut.flush(); //forces output
				
			} 
			catch (UnsupportedEncodingException e) 
			{
				System.out.println("----Problem with encrypting the message----");
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}

		}
		else if(input.startsWith("*"))//incoming encrypted image
		{
			input = input.substring(1); //take off *

			//String encryptedImage = decryptImage(input);
			//send to server
			//streamOut.println(encryptedImage); //write the message
			//streamOut.flush(); //forces output
			//writes to file
			//fout.write(username + ": " + decryptedMessage + "\n");
			//fout.flush();

		}
		else System.out.println("----ERROR handling encrypted message----");
		
	}

	/**
	 * Method of Decryption:
	 * For every byte Bn in the received String, Let Bn  = Bn XOR 11110000
	 * e.g. Bn = 01011000, then Bn Xor 11110000 = 10101000
	 * @throws UnsupportedEncodingException 
	 */
	public String decryptMessage(String message) throws UnsupportedEncodingException
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
		try 
		{
			streamIn = new Scanner(new BufferedInputStream(s.getInputStream()));
			
		} catch (IOException e1) 
		{
			e1.printStackTrace();
		}

		while(true)
		{
			try 
			{
				if(streamIn.hasNext()) 
				{
					handle(streamIn.nextLine());
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

	}// end of method run()
} // end of class ClientHandler
