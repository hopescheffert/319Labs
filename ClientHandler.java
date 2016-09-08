package messenger;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;

class ClientHandler implements Runnable {
	Socket s; // this is socket on the server side that connects to the CLIENT

	ClientHandler(Socket s) 
	{
		this.s = s;

	}
	// This is the client handling code
	@Override
	public void run() 
	{
		Scanner in;

		// 1. USE THE SOCKET TO READ WHAT THE CLIENT IS SENDING?
		in = new Scanner(new BufferedInputStream(System.in));
		//display menu to client
		System.out.println("What would you like to do? "
				+ "Please choose 1 or 2 and press enter:");
		System.out.println("1. Send a text message to the server");
		System.out.println("2. Send an image file to the server");
		int choice = in.nextInt();
		
		if(choice == 1)
		{
			//TODO send text message to server
			//TODO make sure chat goes to chat.txt
			
			
			String clientTextMessage = "";
			System.out.println("Please type your text message and press enter");
			while(in.hasNextLine())
			{
				clientTextMessage = in.nextLine();
			}
			//send to encryption method
			byte[] encryptedMessage;
			try 
			{
				//get encrypted message
				encryptedMessage = encryptMessage(clientTextMessage);
				//send it to server through the socket
				DataOutputStream out = new DataOutputStream(s.getOutputStream());
				out.writeInt(encryptedMessage.length); //write length of the message
				out.write(encryptedMessage); //write the message
				
			} catch (UnsupportedEncodingException e) {
				System.out.println("----Problem with encrypting the message");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		else if(choice == 2)
		{
			//TODO send an image file to the server
			System.out.println("Please enter your image file name and press enter");

		}
		else
		{
			System.out.println("Please enter either 1 or 2");
		}

		in.close(); //close scanner

		
		// This handling code dies after doing all the printing
	} // end of method run()

	
	/**
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
	
	
	
	
	
	
	
	
	
	
	

} // end of class ClientHandler