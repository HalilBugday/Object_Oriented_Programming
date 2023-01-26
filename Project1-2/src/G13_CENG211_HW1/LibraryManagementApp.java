package G13_CENG211_HW1;

/* Program which has the main method*/
public class LibraryManagementApp {
	
	private LibraryManagement libraryManagement;
	private MemberManagement memberManagement;
	private LibraryQuery libraryQuery;
	private Library centralLibrary;
	private Library foreignLibrary;
	private Library compSciLibrary;
	private FileIO L1BooksFile;
	private FileIO L2BooksFile;
	private FileIO L3BooksFile;
	
	public static void main(String[] args) {
		LibraryManagementApp app = new LibraryManagementApp();
		app.setUp();
	}
	
	public final void setUp() {
		L1BooksFile = new FileIO("L1_Books.csv");
		L2BooksFile = new FileIO("L2_Books.csv");
		L3BooksFile = new FileIO("L3_Books.csv");
		memberManagement = new MemberManagement();
		// Library objects
		centralLibrary = new Library(L1BooksFile.getResultArray(), "cn");
		foreignLibrary = new Library(L2BooksFile.getResultArray(), "fl");
		compSciLibrary = new Library(L3BooksFile.getResultArray(), "cs");
		libraryManagement = new LibraryManagement(memberManagement,
				getLibraries());
		Issue[][] issues = libraryManagement.getIssues();
		libraryQuery = new LibraryQuery(issues, getLibraries(),
				memberManagement);
		showQueries();
	}
	
	private void showQueries() {
		Book issuedBook = libraryQuery.getMostIssuedBook();
		Book copiedBook = libraryQuery.getMostCopiedBook();
		Book fewestIssuedBook = libraryQuery.getFewIssuedBook();
		Member popularMember = libraryQuery.getHighestIssuedMember();
		Member bestPerson = libraryQuery.getBestCSPerson();
		double maxPenalty = libraryQuery.getHighestPenalty();
		
		System.out.println("1) " + issuedBook);
		System.out.println("2) " + popularMember);
		System.out.println("3) " + maxPenalty + " TL");
		System.out.println("4) " + copiedBook);
		System.out.println("5) " + fewestIssuedBook);
		System.out.println("6) " + bestPerson);
	}
	
	private Library[] getLibraries() {
		Library[] libraries = new Library[Library.getLibraryNumber()];
		libraries[0] = centralLibrary;
		libraries[1] = foreignLibrary;
		libraries[2] = compSciLibrary;
		return libraries;
	}
}
