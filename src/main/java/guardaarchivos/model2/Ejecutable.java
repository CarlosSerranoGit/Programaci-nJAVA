package guardaarchivos.model2;

public class Ejecutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Repository r=Repository.getInstance();
		/*Book b1=new Book(1,"El Quijote","Cervantes");
		Book b2=new Book(2,"El camino","Miguel Delibes");
		r.addBook(b1); r.addBook(b2);
		System.out.println(r);
		r.saveFile("books.xml");*/
		
		r.loadFile("books.xml");
		System.out.println(r);

	}

}
