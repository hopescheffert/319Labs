package messenger;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Waits whole time for the client to send it a message
 * "Client Listener"
 * @author hopees
 *
 */
public class ServerListenForClientMessage implements Runnable 
{
	Scanner in; //blocking call
	Socket s;
	Client c;
	
	ServerListenForClientMessage(Client c, Socket s) throws IOException
	{
		//scanner from output of the server
		in = new Scanner(new BufferedInputStream(s.getInputStream()));
		this.s = s;
		this.c = c;
	}
	
	
	@Override
	public void run() 
	{
		while(true) //run forever
		{
			//Server is waiting for message from client
//			String msg = in.nextLine();
//			handleMessage(msg);

			
		}
		
		
	}
	
	public void handleMessage()//(String msg)
	{
		Thread t = new Thread(new GetMessageFromClient(s, c.username));
		t.start();
	}

}
