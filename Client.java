package messenger;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;



public class Client {
	
	

	private ObjectOutputStream streamOut = null;
	private Socket serverSocket = null;
	ClientListenForMessage listen;
	ClientSendMessage sendmsg;

	private String username;
	
	Client() throws UnknownHostException, IOException
	{
		serverSocket = new Socket("localhost", 4444);
		
		//SPAWN A LISTENER FOR THE SERVER. THIS WILL KEEP RUNNING
		listen = new ClientListenForMessage(this, serverSocket);
		new Thread(listen).start();
	}
	
	public void handleMessage()
	{
		//now spawn a thread to deal with client send message
		//***don't know if this should go here or in client handler???***
//				PrintWriter out;
//				out = new PrintWriter(new BufferedOutputStream(serverSocket.getOutputStream()));
				sendmsg = new ClientSendMessage(serverSocket);
				new Thread(sendmsg).start();
	}

	public Client(String username) throws UnknownHostException, IOException
	{
		this.username = username;
	}
	

	public static void main(String[] args) throws UnknownHostException,
	IOException {
		
		//serverSocket = new Socket("localhost", 4444);
		Client c = new Client();
		while(true)
		{
			//keeps client running forever
		}

	}


}