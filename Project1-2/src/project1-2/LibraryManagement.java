package G13_CENG211_HW1;

public class LibraryManagement {
	private Issue[][] issues;
	private FileIO[] files;
	private Library[] libraries;
	private MemberManagement memberManagement;
	
	// Constructor
	public LibraryManagement(MemberManagement people,
			Library[] libs) {
		libraries = libs;
		memberManagement = people;
		issues = new Issue[Library.getLibraryNumber()][];
		files = new FileIO[Library.getLibraryNumber()];
		files[0] = new FileIO("L1_Issues.csv");
		files[1] = new FileIO("L2_Issues.csv");
		files[2] = new FileIO("L3_Issues.csv");
		for(int index = 0; index < issues.length; index++) {
			issues[index] = getIssueForLib(files[index]);
		}
	}
	
	/**
	 Gets two-dimensional Issue type array.
	 @return The deep copy of the two-dimensional Issue type array
	 */
	public Issue[][] getIssues() {
		Issue[][] temp = new Issue[issues.length][];
		for(int row = 0; row < temp.length; row++) {
			temp[row] = new Issue[issues[row].length];
			for(int col = 0; col < temp[row].length; col++) {
				temp[row][col] = new Issue(issues[row][col]);
			}
		}
		return temp;
	}
	
	/*Implementation details.*/
	
	private final Issue[] getIssueForLib(FileIO libFile) {
		String[][] resultArray = libFile.getResultArray();
		Issue[] result = new Issue[resultArray.length];
		for(int issue = 0; issue < resultArray.length; issue++) {
			String[] temp = resultArray[issue];
			Book book = getBookFromLibs(temp[2]);
			Member member = memberManagement.getMember(Integer.parseInt(temp[1]));
			result[issue] = new Issue(Integer.parseInt(temp[0]), 
					member, book, temp[3], temp[4]);;
			member.incrementIssue();
			book.incrementIssue();
		}
		return result;
	}
	
	private Book getBookFromLibs(String id) {
		Book book = null;
		for(int lib = 0; lib < libraries.length; lib++) {
			if(libraries[lib].getBook(id) != null) {
				book = libraries[lib].getBook(id);
			}
		}
		return book;
	}
	
}
