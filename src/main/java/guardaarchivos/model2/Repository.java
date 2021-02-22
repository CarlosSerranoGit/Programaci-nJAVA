package guardaarchivos.model2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "repository")
@XmlAccessorType (XmlAccessType.FIELD)
public class Repository {
	private static Repository _instance;
	@XmlElement(name = "employee")
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
		//marshaling
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Repository.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			 
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		     
		    //Marshal the list in console
		    //jaxbMarshaller.marshal(_instance, System.out);
		     
		    //Marshal the employees list in file
		    jaxbMarshaller.marshal(_instance, new File(url));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void loadFile(String url) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Repository.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		     
		    //We had written this file in marshalling example
		    Repository newR = (Repository) jaxbUnmarshaller.unmarshal( new File(url) );
		    books=newR.books;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Repository [books=" + books + "]";
	}
	
	
}
