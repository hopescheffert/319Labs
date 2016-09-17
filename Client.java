package messenger;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;


public class Client 
{
	private PrintWriter streamOut = null;
	private static Socket serverSocket = null;
	ClientListenForServerMessage listen;
	private static String username;
	private ArrayList<Client> clientList = new ArrayList<Client>();
	private Scanner streamIn;
	File f = new File("chat.txt");




	Client(String username) throws UnknownHostException, IOException
	{
		//CONNECT TO SERVER
		serverSocket = new Socket("localhost", 5000);
		this.username = username;
		//INIT STREAMS
		streamIn = new Scanner(new BufferedInputStream(serverSocket.getInputStream()));
		streamOut = new PrintWriter(new BufferedOutputStream(serverSocket.getOutputStream()));
		//TELL SERVER CLIENT'S USERNAME (defined by starting with !-!)
		streamOut.println("!-!" + username);

		//ADD CLIENT TO CLIENT LIST
		clientList.add(this);

		//TODO SPAWN A LISTENER FOR THE SERVER. THIS WILL KEEP RUNNING
		listen = new ClientListenForServerMessage(this, serverSocket);
		new Thread(listen).start();

		//DISPLAY MENU TO CLIENT
		if(username.equals("admin")) //if they are admin: have special menu
		{
			System.out.println("What would you like to do? Please choose 1, 2, or 3.");
			System.out.println("1. Brodcast message to all clients");
			System.out.println("2. List messages so far");
			System.out.println("3. Delete a specified message (please give a message number)");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			if(choice == 1)
			{
				//TODO broadcast message to all clients in clientList
				//broadcast(scanner.nextLine());
			}
			else if(choice == 2)
			{
				//TODO list messages so far from chat.txt
				getMessagesSoFar();
			}
			else if(choice == 3)
			{
				//TODO delete specified message (get message number from scanner)
				int messageNum = scanner.nextInt();
				deleteMessage(messageNum);

			}
			else System.out.println("Please choose either 1, 2, or 3");
			scanner.close();

		}
		else //regular user
		{
			//DISPLAY MENU FOR USER TO TAKE ACTION
			MenuAndAsk();
		}


	}
	private void deleteMessage(int messageNum) 
	{
		//FileWriter 

	}
	public ArrayList<Client> getClientList()
	{
		return clientList;
	}


	public void MenuAndAsk() throws IOException
	{
		//DISPLAY MENU TO NORMAL CLIENT
		System.out.println("What would you like to do? Please choose 1 or 2 and press enter:");
		System.out.println("1. Send a text message to the server");
		System.out.println("2. Send an image file to the server");
		Scanner s = new Scanner(System.in);
		//HANDLE CHOICE - HELPER METHOD
		//TODO not waiting for the users input
		while(s.hasNext())
		{
			int choice = s.nextInt();
			handleChoice(choice);
		}


	}

	public void handleChoice(int choice) throws IOException
	{

		if(choice == 1) //SEND MESSAGE
		{
			System.out.println("Please type your message and press enter");			
			Scanner scanMsg = new Scanner(System.in);
			String msg = "";
			//while(scanMsg.hasNext()) 
			{
				msg = scanMsg.nextLine();
			}
			sendMsg(msg);
			scanMsg.close();

		}		
		else if(choice == 2) //SEND IMAGE
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
			
			//Users/jacobneyens/Documents/BackgroundImages/iowa.jpg
			File image = new File(imgpath);
			//byte[] imageBytes = Files.readAllBytes(image.toPath());
			//System.out.println("the image bytes are:  " + imageBytes);
			sendImg(image);
			
			//TODO convert image to a string sequence and encrypt that
			//send it to encryption method
			


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
		{
			System.out.println("Error: Please enter either 1 or 2");
		}
	}

	public String getUsername()
	{
		return username;
	}


	/**
	 * Encrypts message and sends to server as well as chat.txt
	 * @param imgpath
	 * @throws IOException
	 */

	public void sendImg(File f) throws IOException
	{
		//System.out.println(msg);

		//write the message to chat.txt
		String encrypted = encryptImage(f);
		streamOut.println(encrypted);
		streamOut.flush();

	}

	//broadcasts messages to all clients in the clientList
	public synchronized void broadcast(String message) throws IOException
	{
		for(Client c : clientList)
		{
			c.sendMsg(message);
		}
	}


	public static void main(String[] args) throws UnknownHostException, IOException 
	{
		//create scanner for client input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name and press enter");
		username = scanner.next();
		new Client(username);	


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
			messages += file.nextLine() + "\n";
		}
		System.out.print(messages);
		file.close();
	}


	/**
	 * Encrypts image path and sends to server
	 * @param msg
	 * @throws IOException
	 */
	public void sendMsg(String msg) throws IOException
	{
		//write the message to chat.txt
		String encrypted = encryptMessage(msg);
		streamOut.println(encrypted);
		streamOut.flush();

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

		byte[] msg = message.getBytes();
		byte[] encryptedBytes = new byte[msg.length];
		for(int i = 0; i < msg.length; i ++)
		{
			//do XOR with 11110000
			encryptedBytes[i] = (byte) (msg[i] ^ 11110000);
		}
		System.out.println("the encrypted bytes are" + encryptedBytes);
		//give it a pound sign to notify server that it is a message
		return "#" + new String(encryptedBytes);
	}

	/**
	 * IMAGE
	 * Method of Encryption:
	 * Suppose an image is stored by m bytes
	 * 
	 * For every 3 bytes, we have 24 bits
	 * 		Divide 24 into four 6 bit fragments
	 * 		Add two bits of 00 to the right of each 6 bits fragment
	 * 		(then we can get four 8 bit fragments)
	 * 		Convert the 8 bit fragments into characters and combine them to make a string
	 * 
	 * @param path
	 * @return
	 * @throws IOException 
	 */
	public String encryptImage(File f) throws IOException
	{
		byte[] imageBytes = Files.readAllBytes(f.toPath());
		System.out.println("the encrypted bytes are" + imageBytes);
		byte[] encryptedBytes = new byte[imageBytes.length];
		//for every 3 bytes
		
		for(int i = 0; i < encryptedBytes.length % 3; i++)
		{
			encryptedBytes[i] = (byte) (00 + (encryptedBytes[i] ^ 11110000));
			System.out.println("the encrypted bytes are" + encryptedBytes[i]);
		}


		return "*" + new String(imageBytes);

	}

}

class ClientListenForServerMessage implements Runnable 
{
	Client c;
	Scanner in; //blocking call
	Socket s;
	String username;
	private File f = new File("chat.txt");



	ClientListenForServerMessage(Client c, Socket s) throws IOException
	{
		this.c = c;
		username = c.getUsername();
		//scanner for output of the server
		in = new Scanner(new BufferedInputStream(s.getInputStream()));
		this.s = s;
	}


	/**
	 * Sole purpose is to listen for a message from the server at all times
	 */
	@Override
	public void run()
	{
		FileWriter fout = null;
		try {
			fout = new FileWriter(f, true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int msgNum = 1;

		while(true) //run forever
		{
			if(in.hasNext())
			{

				//send to all clients in the clientList
				//for(Client c : c.getClientList())
				{
					String msg = (in.nextLine());
					System.out.println(">>>" + msg);
					try 
					{
						//TODO add message number to chat.txt for admin reasons (counter)
						fout.append(msgNum + " " + msg + "\n");
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
					try 
					{
						fout.flush();
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
			}
			//display menu and ask again what they would like to do 
			try 
			{
				c.MenuAndAsk();
			} 
			catch (IOException e) 
			{
				System.out.println("----Problem with continuing conversation----");
				e.printStackTrace();
			}


		}

	}

}