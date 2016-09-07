package messenger;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;



public class Client {

	private DataOutputStream streamOut = null;
	private Socket clientSocket = null;

	private String username;

	public Client(String username) throws UnknownHostException, IOException
	{
		this.username = username;
	}
//	public void connect() throws UnknownHostException, IOException
//	{
//		Socket socket = new Socket("localhost", 4444);
//		while(true)
//		{
//			//keeps client running forever
//		}
//		
//	}
	


	public static void main(String[] args) throws UnknownHostException,
	IOException {

		Socket socket = new Socket("localhost", 4444);
		while(true)
		{
			//keeps client running forever
		}

	}


}
