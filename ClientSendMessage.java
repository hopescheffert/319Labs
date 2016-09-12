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
	private String msg;

	public ClientSendMessage(Socket s, String username)//, String msg)
	{
		this.s = s;
		clientName = username;
		//this.msg = msg;

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
		byte[] encryptedBytes = message.getBytes();
		for(int i = 0; i < encryptedBytes.length; i ++)
		{
			//do XOR with 11110000
			encryptedBytes[i] = (byte) (encryptedBytes[i] ^ 11110000);
		}

		return new String(encryptedBytes);
	}


	@Override
	public void run() 
	{
		//get the message from the client
//		ReadText r = new ReadText();
//		Thread th = new Thread(r);
//		th.start();		
//		String message = r.getMsg();
		
		String clientTextMessage;
		System.out.println("Please type your text message and press enter");
		Scanner console = new Scanner(new BufferedInputStream(System.in));
		
		while(console.hasNextLine())
		{
			clientTextMessage = console.nextLine();


			//send message to encryption method using a printwriter and outputstream
			try 
			{
				String encryptedMessage = encryptMessage(clientTextMessage);
				//String encryptedMessage = encryptMessage(message); //get encrypted message
				//String encryptedMessage = encryptMessage(msg);
				//send to server
				PrintWriter out = new PrintWriter(s.getOutputStream()); //new BufferedOutputStream(s.getOutputStream()));
				out.write(encryptedMessage.length()); //write length of the message (an int)
				out.write(encryptedMessage); //write the message
				out.flush(); //forces output

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

class ReadText implements Runnable
{
	private String clientTextMessage;
	
	public String getMsg()
	{
		return clientTextMessage;
	}
	
	@Override
	public void run() 
	{
		System.out.println("Please type your text message and press enter");
		Scanner console = new Scanner(new BufferedInputStream(System.in));
		while(console.hasNextLine())
		{
			clientTextMessage = console.nextLine();
		}
		
	}
	
}



