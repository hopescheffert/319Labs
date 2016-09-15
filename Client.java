package messenger;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;


public class Client 
{
	private PrintWriter streamOut = null;
	private static Socket serverSocket = null;
	ClientListenForServerMessage listen;
	ClientSendMessageToServer sendmsg;
	static String username;
	private ArrayList<Client> clientList = new ArrayList<Client>();
	private int choice;
	private Scanner streamIn;


	Client(String username) throws UnknownHostException, IOException
	{
		//CONNECT TO SERVER
		serverSocket = new Socket("localhost", 1222);
		this.username = username;
		clientList.add(this);

		//SPAWN A LISTENER FOR THE SERVER. THIS WILL KEEP RUNNING
		listen = new ClientListenForServerMessage(this, serverSocket);
//		new Thread(listen).start();
		
		//DISPLAY MENU TO CLIENT
		System.out.println("What would you like to do? "
				+ "Please choose 1 or 2 and press enter:");
		System.out.println("1. Send a text message to the server");
		System.out.println("2. Send an image file to the server");
		Scanner in = new Scanner(System.in);
		streamOut = new PrintWriter(new BufferedOutputStream(serverSocket.getOutputStream()));
		
		choice = in.nextInt();
		handleChoice(choice);
		//tell the server your choice
		streamOut.println(choice);
		streamOut.flush();
	}
	
	public void handleChoice(int choice) throws IOException
	{
		streamIn = new Scanner(new BufferedInputStream(serverSocket.getInputStream()));

		if(choice == 1) //wants to send a message
		{
			streamOut.println("Please type your message");
			streamOut.flush();
			

			//TODO make sure message goes to chat.txt
			handle(streamIn.nextLine());
		}




		//****IMAGE*****			

		else if(choice == 2) //wants to send an image
		{
			//TODO send an image file to the server using java's object output stream
			try {
				ObjectOutputStream oos = new ObjectOutputStream(serverSocket.getOutputStream());

				//Object ob = new Object();
				//oos.writeObject(ob);

				//stuff here

				//oos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

			//ask client to enter the file name of the image
			System.out.println("Please enter your image file name and press enter");
			Scanner img = new Scanner(System.in);
			String imgpath = img.nextLine();
			img.close();
			//TODO convert image to a string sequence and encrypt that
			//send it to encryption method
			//byte[] encryptedImage = encryptImage(imgpath);


			//get image from the client
			try 
			{
				ObjectInputStream ois = new ObjectInputStream(serverSocket.getInputStream());
				//Object ob1 = ois.readObject();

				//stuff here

				//ois.close();


			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		else
		{ System.out.println("Error: Please enter either 1 or 2");}
	}

	public static String getUsername()
	{
		return username;
	}

	public void handle(String msg) throws IOException
	{
		//System.out.println(msg);

		//write the message to chat.txt
		String encrypted = encryptMessage(msg);
		streamOut.println(encrypted);
		streamOut.flush();
		File f = new File("chat.txt");
		FileWriter fout = new FileWriter(f);
		fout.write(username + ": " + encrypted + "\n");
		fout.flush();
		//fout.close();
	}
	
	//broadcasts messages to all clients in the clientList
	public synchronized void broadcast(String message) throws IOException
	{
		for(Client c : clientList)
		{
			c.handle(message);
		}
	}


	public static void main(String[] args) throws UnknownHostException, IOException 
	{
		//create scanner for client input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name and press enter");
		username = scanner.next();
		new Client(username);	
		//check if they are admin: have special menu
		if(username.equals("admin"))
		{
			System.out.println("What would you like to do? Please choose 1, 2, or 3.");
			System.out.println("1. Brodcast message to all clients");
			System.out.println("2. List messages so far");
			System.out.println("3. Delete a specified message (please give a message number)");

			int choice = scanner.nextInt();
			if(choice == 1)
			{
				//TODO broadcast message to all clients in clientList
				//broadcast(scanner.nextLine());
			}
			else if(choice == 2)
			{
				//TODO list messages so far from chat.txt
				//getMessagesSoFar();
			}
			else if(choice == 3)
			{
				//TODO delete specified message (get message number from scanner)
				//int messageNum = scanner.nextInt();
			}
			else System.out.println("Please choose either 1, 2, or 3");
		}
		//scanner.close();

		while(true)
		{
			//keeps client running forever

		}

	}
	
	//get messages from chat.txt
	public synchronized void getMessagesSoFar() throws FileNotFoundException
	{
		File f = new File("chat.txt");
		Scanner file = new Scanner(f);
		String messages = "";
		while(file.hasNext())
		{
			messages += file.nextLine();
		}
		streamOut.print(messages);
		
	}

	
	/**
	 * MESSAGE
	 * Gets the client's text message and outputs an encrypted byte array 
	 * Method of Encryption:
	 * For every byte Bn in a String, encrypted Byte = Bn XOR 11110000
	 * e.g. Bn = 10101000, then Bn Xor 11110000 = 01011000
	 * @throws UnsupportedEncodingException 
	 */
	public String encryptMessage(String message) throws UnsupportedEncodingException
	{
		byte[] encryptedBytes = message.getBytes();
		//TODO change to ascii values then encrypt
		//int ascii = (int) character
		for(int i = 0; i < encryptedBytes.length; i ++)
		{
			//do XOR with 11110000
			encryptedBytes[i] = (byte) (encryptedBytes[i] ^ 11110000);
		}

		return new String(encryptedBytes);
	}

}

class ClientListenForServerMessage implements Runnable 
{
	Client c;
	Scanner in; //blocking call
	Socket s;


	ClientListenForServerMessage(Client c, Socket s) throws IOException
	{
		this.c = c;
		//scanner for output of the server
//		in = new Scanner(new BufferedInputStream(s.getInputStream()));
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
			try 
			{
				c.handle(in.nextLine());
			} 
			catch (UnsupportedEncodingException | FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}

}