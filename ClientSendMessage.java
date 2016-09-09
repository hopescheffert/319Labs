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
	 * e.g. Bn = 10101000, then Bn Xor 11110000 = 01011000
	 * @throws UnsupportedEncodingException 
	 */
	public byte[] encryptMessage(String message) throws UnsupportedEncodingException
	{
		//charSet name?
		byte[] encryptedBytes = message.getBytes();
		for(int i = 0; i < encryptedBytes.length; i ++)
		{
			//do XOR with 11110000
			encryptedBytes[i] = (byte) (encryptedBytes[i] ^ 11110000);
		}
		return encryptedBytes;
	}
	
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		String clientTextMessage = "";
		System.out.println("Please type your text message and press enter");
		Scanner in = new Scanner(new BufferedInputStream(System.in));

		while(clientTextMessage.isEmpty())
		{
			clientTextMessage = in.nextLine();
		}


		//send to encryption method
		try 
		{
			PrintWriter out;
			byte[] encryptedMessage = encryptMessage(clientTextMessage); //get encrypted message
			
			//DataOutputStream out = new DataOutputStream(s.getOutputStream()); //send it to server through the socket
			out = new PrintWriter(new BufferedOutputStream(s.getOutputStream()));
			//PrintWriter out = new PrintWriter(new BufferedOutputStream(s.getOutputStream())); //send it to server through the socket
			out.println(encryptedMessage.length); //write length of the message
			out.println(encryptedMessage); //write the message
			out.flush();
			
			
			
			//TODO NOT WORKING! get the text message from the client
			Server server = new Server();
			String textMessage = "";
			try 
			{
				textMessage = server.getTextMessage();
				System.out.println("client text message is: " + textMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(server.getUsername() + " said :" + textMessage);

			
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
