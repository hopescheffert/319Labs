package cs319;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.AbstractListModel;

public class DataModel extends AbstractListModel {

	ArrayList<String> list = new ArrayList<String>();
	
	public DataModel() throws FileNotFoundException {
		File file = new File("companies.txt");
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()){
			list.add(scanner.next());
		}
	}
	
	public void remove(int index) throws IOException {
		list.remove(index);
		File file = new File("companies.txt");
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		for(int i = 0; i < list.size(); i++){
			bufferedWriter.write((String) list.get(i) + "\n");
		}
		bufferedWriter.close();
		fileWriter.close();
		fireIntervalRemoved(this, list.size()-1, list.size()-1);
	}
	
	public void add(String s) throws IOException {
		list.add(s);
		File file = new File("companies.txt");
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		for(int i = 0; i < list.size(); i++){
			bufferedWriter.write((String) list.get(i) + "\n");
		}
		bufferedWriter.close();
		fileWriter.close();
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
}
