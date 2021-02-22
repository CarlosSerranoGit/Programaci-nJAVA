package guardaarchivos.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Repository implements Serializable{
	private static Repository _instance;
	List<Book> books;
	
	private Repository() {
		books=new ArrayList<Book>();
	}
	
	public static Repository getInstance() {
		if(_instance==null) {
			_instance=new Repository();
		}
		return _instance;
	}
	public void addBook(Book b){
		books.add(b);
	}
	public void saveFile(String url) {
		FileOutputStream f;
		try {
			f = new FileOutputStream(url);
			ObjectOutputStream of=new ObjectOutputStream(f);
			of.writeObject(books);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void loadFile(String url) {
		FileInputStream f;
		try {
			f = new FileInputStream(url);
			ObjectInputStream iof=new ObjectInputStream(f);
			books=(List)iof.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public String toString() {
		return "Repository [books=" + books + "]";
	}
	
	
}
