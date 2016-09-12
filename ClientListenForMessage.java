package messenger;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientListenForMessage implements Runnable 
{
	Client c;
	Scanner in;
	Socket s;


	ClientListenForMessage(Client c, Socket s) throws IOException
	{
		this.c = c;
		in = new Scanner(new BufferedInputStream(s.getInputStream()));
		this.s = s;
	}
	
	/**
	 * Sole purpose is to listen for a message from the server at all times
	 */
	@Override
	public void run() 
	{
		while(true) //run forever
		{
//			Client is waiting for a message from server
			//String msg = in.nextLine();
			//c.handleMessage(msg);
			
			//Thread t = new Thread(new ClientSendMessage(s, c.username));
			//t.start();
			
			
		}
		
	}

}
