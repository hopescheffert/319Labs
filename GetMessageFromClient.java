package messenger;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;

public class GetMessageFromClient implements Runnable
{
	private Socket s;
	private String username;

	GetMessageFromClient(Socket s, String username)
	{
		this.s = s;
		this.username = username;
	}
	
	@Override
	public void run() 
	{
		String textMessage = "";
		try 
		{
			textMessage = getTextMessage();
			System.out.println(username + " said: " + textMessage);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Gets the text message from the client
	 * It gets the encrypted byte array from the socket, then it reads the bytes, 
	 * decrypts them, then returns the string representation of the byte's. 
	 * @param decryptedBytes
	 * @return message
	 * @throws IOException
	 */
	public String getTextMessage() throws IOException
	{
		String message = "";
		//the input stream will get the encrypted message from the client

		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	
		int length = in.read();	//for BufferedReader		
		if(length > 0)
		{
			String msg = in.readLine();
			message = decryptMessage(msg.getBytes()); //decrypt the message
		}
		else System.out.println("----Error in GetMessageFromClient getTextMessage(): message length is 0");
		return message;

	}
	
	/**
	 * Method of Decryption:
	 * For every byte Bn in the received String, Let Bn  = Bn XOR 11110000
	 * e.g. Bn = 01011000, then Bn Xor 11110000 = 10101000
	 * @throws UnsupportedEncodingException 
	 */
	public String decryptMessage(byte[] encryptedBytes) throws UnsupportedEncodingException
	{
		byte[] decryptedBytes = new byte[encryptedBytes.length];

		//for each of the encrypted bytes XOR and put into decryptedBytes
		for(int i = 0; i < encryptedBytes.length; i ++)
		{
			//do XOR with 11110000
			decryptedBytes[i] = (byte) (encryptedBytes[i] ^ 11110000);

		}
		return new String(decryptedBytes);
	}

}
