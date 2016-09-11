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

	GetMessageFromClient(Socket s)
	{
		this.s = s;
	}
	
	@Override
	public void run() 
	{
		//TODO make this work right with the thread
		String textMessage = "init";
		try 
		{
			textMessage = getTextMessage();
			System.out.println("client text message is: '" + textMessage + "' in GetMessageFromClient line 27");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Server.getClientName() + " said: " + textMessage);
		
	}
	
	/**
	 * Gets the text message from the client
	 * It gets the encrypted byte array from the socket, then it reads the bytes, 
	 * decrypts them, then returns the string representation of the bytes. 
	 * @param decryptedBytes
	 * @return message
	 * @throws IOException
	 */
	public String getTextMessage() throws IOException
	{
		//TODO NOT WORKING with input stream

		//System.out.println("in GetMessageFromClient getTextMessage(47)");
		String message = "";
		//the input stream will get the encrypted message from the client

		//NONE OF THESE ARE WORKING!
		//DataInputStream in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
		//Scanner in = new Scanner(new BufferedInputStream(s.getInputStream()));
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//int length = in.readInt(); //for DataInputStream
		//int length = in.nextInt(); //for scanner
		int length = in.read();	//for BufferedReader
		System.out.println("length is " + length);
		
		if(length > 0)
		{
			//byte[] msg = new byte[length]; //read length of incoming message
			//int i = 0;
			//while(i < length)
			//{
				//msg[i] = in.nextByte(); //for scanner
				//msg = in.readLine().getBytes();	//for BufferedReader
				//i++;
			//}
			//in.readFully(msg, 0, msg.length); //for DataInputStream
			String msg = in.readLine();
			System.out.println("client message in GetMessageFromClient(59) " + msg);
			message = decryptMessage(msg.getBytes()); //decrypt the message
			System.out.println("client message is decrypted as '" + message + "'in GetMessageFromClient (69)");
		}
		else System.out.println("----Error in GetMessageFromClient getTextMessage(): length is 0");
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
		System.out.println("gets to decryptMessage()");

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
