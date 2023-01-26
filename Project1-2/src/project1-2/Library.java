package G13_CENG211_HW1;

public class Library {
	private Book[] books;
	private String name;
	private static int libraryNumber;
	
	static {
		libraryNumber = 0;
	}
	
	// Constructor
	public Library(String[][] booksData, String libName) {
		name = libName;
		books = new Book[booksData.length];
		for(int row = 0; row < booksData.length; row++) {
			books[row] = new Book(booksData[row], libName);
		}
		libraryNumber++;
	}
	// Copy constructor in order to prevent privacy leaks.
	public Library(Library originalLib) {
		if(originalLib == null) {
			System.out.println("Fatal error.");
			System.exit(0);
		}
		books = originalLib.getBooks();
		name = originalLib.getName();
	}
	
	/**
	 Accessor that gives the deep copy of book[] reference variable
	 @return Book array which includes each book object in this library.
	 */
	public Book[] getBooks() {
		Book[] temp = new Book[books.length];
		for(int index = 0; index < temp.length; index++) {
			temp[index] = new Book(books[index]);
		}
		return temp;
	}
	
	/**
	 Accessor that gives the deep copy of book that has the id given as an argument
	 @return Book object which has the id as a given argument.
	 */
	public Book getBook(String id) {
		if(isEmpty()) {
			System.out.println("Fatal error.");
			System.exit(0);
		}
		Book result = null;
		for(int index = 0; index < books.length; index++) {
			if(id.equals(books[index].getId()))
				result = books[index];
		}
		return result;
	}
	
	/**
	 Getter for library
	 @return The name of the library.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 Accessor that gives the deep copy of book object that has the name given to the argument.
	 @return Book object which has the name given as an argument
	 */
	public Book getBookByTitle(String title) {
		if(isEmpty()) {
			System.out.println("Fatal error.");
			System.exit(0);
		}
		Book result = null;
		for(int index = 0; index < books.length; index++) {
			if(title.equals(books[index].getTitle()))
				result = books[index];
		}
		return result;
	}
	
	/**
	 Inspector that says whether the library empty or not.
	 @return True if library is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return books.length == 0;
	}
	
	public static int getLibraryNumber() {
		return libraryNumber;
	}
}
