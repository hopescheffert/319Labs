package messenger;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSendMessage implements Runnable 
{
	private Socket s;
	private String clientName;

	public ClientSendMessage(Socket s)
	{
		this.s = s;

	}

	/**
	 * Gets the client's text message and outputs an encrypted byte array 
	 * Method of Encryption:
	 * For every byte Bn in a String, encrypted Byte = Bn XOR 11110000
	 * e.g. Bn = 10101000, then Bn Xor 11110000 = 01011000
	 * @throws UnsupportedEncodingException 
	 */
	public String encryptMessage(String message) throws UnsupportedEncodingException
	{
		System.out.println("makes it to encrypt message");
		//charSet name?
		byte[] encryptedBytes = message.getBytes();
		for(int i = 0; i < encryptedBytes.length; i ++)
		{
			//do XOR with 11110000
			encryptedBytes[i] = (byte) (encryptedBytes[i] ^ 11110000);
		}
		System.out.println("message is :" + message);

		return new String(encryptedBytes);
	}


	@Override
	public void run() 
	{
		String clientTextMessage;
		System.out.println("Please type your text message and press enter");
		Scanner console = new Scanner(new BufferedInputStream(System.in));

		//get the message from the client
		while(console.hasNext())
		{
			clientTextMessage = console.nextLine();

			//send message to encryption method using a printwriter and outputstream
			try 
			{

				String encryptedMessage = encryptMessage(clientTextMessage); //get encrypted message
				//DataOutputStream out = new DataOutputStream(s.getOutputStream()); //send it to server through the socket


				PrintWriter out = new PrintWriter(s.getOutputStream()); //new BufferedOutputStream(s.getOutputStream()));
				out.write(encryptedMessage.length()); //write length of the message (an int)
				out.write(encryptedMessage); //write the message
				out.flush(); //forces output

				//TODO NOT WORKING! get the text message from the client
				//spawn new thread to deal with server handling the message from the client
				//Thread t = new Thread(new GetMessageFromClient(s));
				//t.start();

			} catch (UnsupportedEncodingException e) 
			{
				System.out.println("----Problem with encrypting the message");
				e.printStackTrace();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}



