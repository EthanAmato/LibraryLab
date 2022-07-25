import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
	
	String openingHours;
	String closingHours;
	String address;
	ArrayList<Book> books;
	
	
	public Library(String address) {
		this.address = address;
		this.books = new ArrayList<>();
	}

	public void addBook(Book newBook) {
		this.books.add(newBook);
	}
	
	public void printAddress() {
		System.out.println(this.address);
	}
	
	public void borrowBook(String bookTitle) {
		String msg = "";
		for(Book book: this.books) {
			if (book.title.equals(bookTitle) && book.isBorrowed() == false) {
				msg = "You successfully borrowed %s\n";
				book.borrowed();
				break;
			}
			else if (book.title.equals(bookTitle) && book.isBorrowed() == true){
				msg = "Sorry, %s is already borrowed.\n";
			}
		}
		if (msg.equals("")) {msg = "Sorry, %s is not in our catalog.\n";}
		System.out.printf(msg,bookTitle);
	}
	
	public void returnBook(String bookTitle) {
		String msg = "";
		for(Book book: this.books) {
			if (book.title.equals(bookTitle) && book.isBorrowed() == true) {
				msg = "You successfully returned %s\n";
				book.returned();
				break;
			}
			else if (book.title.equals(bookTitle) && book.isBorrowed() == false){
				msg = "Sorry, it seems like you may have brought your own copy of %s.\n";
			}
		}
		if (msg.equals("")) {msg = "Sorry, %s is not in our catalog.\n";}
		System.out.printf(msg,bookTitle);
	}
	
	public void printAvailableBooks() {
		String msg = "";
		if (this.books.size() == 0) {
			System.out.println("No Books in Catalog");
			return;
		}
		for(Book book: this.books) {
			
			if (book.isBorrowed() == false) {
				msg+=book.title+ ", ";
			}
		}
		System.out.print(msg.substring(0, msg.length()-2));
	}
	
//Static Methods
	public static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}
	
	
	
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();
        
        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}