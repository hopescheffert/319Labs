package cs319;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;


////Server must be running before using this class.
public class DataModel extends AbstractListModel {

	ArrayList<String> list = new ArrayList<String>();
	
	public DataModel() throws UnknownHostException, ClassNotFoundException, IOException {
		read();
	}
	
	public void remove(int index) throws IOException {
		list.remove(index);
		write();
		fireIntervalRemoved(this, list.size()-1, list.size()-1);
	}
	
	public void add(String s) throws IOException {
		list.add(s);
		write();
		fireIntervalAdded(this, list.size()-1, list.size()-1);
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return list.get(index);
	}
	
	//Make a request to the server to send you the data from a file
	public void read() throws UnknownHostException, IOException, ClassNotFoundException{
		ArrayList<String> data = new ArrayList<String>();
		data.add("READ");
		
		Socket socket = new Socket("localhost", 4444);
		ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
		toServer.writeObject(data);
		
		ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());
		
		list.addAll((ArrayList<String>)fromServer.readObject());
		
		socket.close();
	}
	
	//Tell the server to write the data to a file
	public void write() throws IOException{
		Socket socket = new Socket("localhost", 4444);
		ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
		toServer.writeObject(list);
		
		socket.close();
	}
}
