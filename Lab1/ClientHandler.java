package messenger;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

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
		//handle client messages
		//if choose 1...getTextMessage()
		
		
		
		//if choose 2...getImage()
		
		
		
		
	} // end of method run()

	/**
	 * Method of Decryption:
	 * For every byte Bn in the received String, Let Bn  = Bn XOR 11110000
	 * e.g. Bn = 01011000, then Bn Xor 11110000 = 10101000
	 * @throws UnsupportedEncodingException 
	 */
	public static byte[] decryptMessage(byte[] encryptedBytes) throws UnsupportedEncodingException
	{
		System.out.println("gets to decryptMessage()");

		byte[] decryptedBytes = null;

		//for each of the encrypted bytes XOR and put into decryptedBytes
		for(int i = 0; i < encryptedBytes.length; i ++)
		{
			//do XOR with 11110000
			decryptedBytes[i] = (byte) (encryptedBytes[i] ^ 11110000);

		}
		return decryptedBytes;
	}

	/**
	 * Gets the text message from the client
	 * It gets the encrypted byte array from the socket, then it reads the bytes, 
	 * decrypts them, then returns the string representation of the bytes. 
	 * @param decryptedBytes
	 * @return message
	 * @throws IOException
	 */
	public static String getTextMessage() throws IOException
	{
		//TODO NOT WORKING with input stream

		System.out.println("in getTextMessage()");
		String message = "";
		DataInputStream in = new DataInputStream(s.getInputStream());
		//the input stream will get the encrypted message from the client
		//Scanner in = new Scanner(new BufferedInputStream(clientSocket.getInputStream()));

		int length = in.readInt();

		if(length > 0)
		{
			byte[] msg = new byte[length]; //read length of incoming message
			in.readFully(msg, 0, msg.length);
			System.out.println("message in bytes " + msg);
			msg = decryptMessage(msg); //decrypt the message
			message = new String(msg); //convert to string 
			System.out.println("in getTextMessage the message is " + message);
		}
		return message;

	}

	


} // end of class ClientHandler