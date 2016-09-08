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
	private static Socket clientSocket;

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
		//Client.main(args);
		while (true) {
			clientSocket = null;

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
	
	/**
	 * Method of Decryption:
	 * For every byte Bn in the received String, Let Bn  = Bn XOR 11110000
	 * e.g. Bn = 01011000, then Bn Xor 11110000 = 10101000
	 * @throws UnsupportedEncodingException 
	 */
	public byte[] decryptMessage(byte[] encryptedBytes) throws UnsupportedEncodingException
	{
		byte[] decryptedBytes = null;
		
		//for each of the encrypted bytes XOR and put into decryptedBytes
		for(int i = 0; i < encryptedBytes.length; i ++)
		{
			//do XOR with 11110000
			decryptedBytes[i] = (byte) (encryptedBytes[i] ^ 11110000);
		
		}
		return decryptedBytes;
	}
	
	public String getTextMessage(byte [] decryptedBytes) throws IOException
	{
		String message = "";
		DataInputStream in = new DataInputStream(clientSocket.getInputStream());
		//the input stream will get the encrypted message from the client
		
		int length = in.readInt();
		
		if(length > 0)
		{
			byte[] msg = new byte[length]; //read length of incoming message
			in.readFully(msg, 0, msg.length); //read the message
			msg = decryptMessage(msg); //decrypt the message
			//TODO see if this actually gets the original text message as a string
			message = msg.toString();
		}
		return message;
	}
	
}//end of Server class



