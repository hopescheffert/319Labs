package messenger;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientListenForMessage implements Runnable 
{
	Client c;
	Scanner in;
	

	ClientListenForMessage(Client c, Socket s) throws IOException
	{
		this.c = c;
		in = new Scanner(new BufferedInputStream(s.getInputStream()));
	}
	
	/**
	 * Sole purpose is to listen for a message from the server
	 */
	@Override
	public void run() 
	{
		while(true) //run forever
		{
//			System.out.println("Client is waiting for a message from server");
//			String msg = in.nextLine();
//			c.handleMessage();
		}
		
	}

}
