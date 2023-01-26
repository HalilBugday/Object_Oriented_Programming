package G13_CENG211_HW1;

public class Book {
	private String id;
	private String title;
	private String author;
	private String publisher;
	private String edition;
	private String genre;
	private String libraryName;
	private int quantity;
	private int numberOfIssue;
	
	// Constructor
	public Book(String[] bookData, String libName) {
		id = bookData[0];
		title = bookData[1];
		author = bookData[2];
		publisher = bookData[3];
		edition = bookData[4];
		genre = bookData[5];
		libraryName = libName;
		quantity = Integer.parseInt(bookData[6]);
	}
	
	// Copy Constructor
	public Book(Book originalObject) {
		if(originalObject == null) {
			System.out.println("Fatal error.");
			System.exit(0);
		}
		id = originalObject.getId();
		title = originalObject.getTitle();
		author = originalObject.getAuthor();
		publisher = originalObject.getPublisher();
		edition = originalObject.getEdition();
		genre = originalObject.getGenre();
		quantity = originalObject.getQuantity();
		libraryName = originalObject.getLibraryName();
		numberOfIssue = originalObject.getNumberOfIssue();
	}
	
	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getNumberOfIssue() {
		return numberOfIssue;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public String getEdition() {
		return edition;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getLibraryName() {
		return libraryName;
	}
	
	public String toString() {
		return title;
	}
	
	public void incrementIssue() {
		numberOfIssue++;
	}
}
