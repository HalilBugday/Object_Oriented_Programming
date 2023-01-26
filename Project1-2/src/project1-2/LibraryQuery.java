package G13_CENG211_HW1;

public class LibraryQuery {
	
	private Issue[][] issues;
	private Library[] libraries;
	private int issueMax;
	private MemberManagement members;
	public static final double PENALTY_CONSTANT = 0.5;
	
	// Constructor
	public LibraryQuery(Issue[][] issues, 
			Library[] libraries, MemberManagement members) {
		this.libraries = libraries;
		this.issues = issues;
		this.members = members;
		issueMax = 0;
	}
	
	/**
	 It gets the most issued book in the libraries.
	 @return The most issued book among the three libraries.
	 */
	public Book getMostIssuedBook() {
		Book mostIssuedBook = null;
		int maxIssue = 0;
		for(int row = 0; row < issues.length; row++) {
			for(int col = 0; col < issues[row].length; col++) {
				if(maxIssue < issues[row][col].getBook().getNumberOfIssue()) {
					maxIssue = issues[row][col].getBook().getNumberOfIssue();
					mostIssuedBook = issues[row][col].getBook();
				}
			}
		}
		return mostIssuedBook;
	}
	
	/**
	 It gets the member who issues the most books (for all three libraries and all years)
	 @return Name of the member who issues the most books.
	 */
	public Member getHighestIssuedMember() {
		Member[] membersArray = members.getMembers();
		Member member = null;
		for(int index = 0; index < membersArray.length; index++) {
			if(issueMax < membersArray[index].getIssueNumber()) {
				issueMax = membersArray[index].getIssueNumber();
				member = membersArray[index];
			}
		}
		return member;
	}
	
	/**
	 Returns the highest penalty according to the day goes after the latest returning day
	 @return The maximum penalty
	 */
	public double getHighestPenalty() {
		int maxDay = 0;
		double penalty = 0.0;
		for(int row = 0; row < issues.length; row++) {
			for(int col = 0; col < issues[row].length; col++) {
				if(maxDay < issues[row][col].getIssuedDayNumber()) {
					maxDay = issues[row][col].getIssuedDayNumber();
				}
			}
		}
		if(maxDay > 14) {
			penalty = PENALTY_CONSTANT*(maxDay - 14);
		}
		return penalty;
	}
	/**
	 Gets the most copied book in terms of their quantity attributes.
	 @return The book object which has the maximum number of copy.
	 */
	public Book getMostCopiedBook() {
		Book copiedBook = null;
		int maxCopy = 0;
		for(int lib = 0; lib < libraries.length; lib++) {
			Book[] libBook = libraries[lib].getBooks();
			for(int book = 0; book < libBook.length; book++) {
				if(maxCopy < libBook[book].getQuantity()) {
					maxCopy = libBook[book].getQuantity();
					copiedBook = libBook[book];
				}
			}
		}
		return copiedBook;
	}
	
	/**
	 Gets the book with the fewest copies of previously issued books.
	 @return The book with the fewest copies of previously issued book.
	 */
	public Book getFewIssuedBook() {
		Book book = issues[0][0].getBook();
		int quantity = issues[0][0].getBook().getNumberOfIssue();
		for(int row = 0; row < issues.length; row++) {
			for(int col = 1; col < issues[row].length; col++) {
				if(quantity >= issues[row][col].getBook().getQuantity()) {
					quantity = issues[row][col].getBook().getQuantity();
					book = issues[row][col].getBook();
				}
			}
		}
		return book;
	}
	
	/**
	 Gets the fewest issued person in CS
	 @return The member who issues the least number of books from the Computer Science Library.
	 */
	public Member getBestCSPerson() {
		Member[] membersArray = members.getMembers(); 
		int[] issueNumbers = new int[membersArray.length];
		for(int row = 0; row < issues.length; row++) {
			for(int col = 0; col < issues[row].length; col++) {
				Issue issue = issues[row][col];
				if(issue.getBook().getLibraryName().equals("cs")) {
					int index = getMemberIndex(membersArray, 
							issue.getMember());
					issueNumbers[index]++;
				}
			}
		}
		int bestIndex = getMinIndex(issueNumbers);
		assert bestIndex < membersArray.length;
		return membersArray[bestIndex];
	}
	
	/* Implementation details */
	
	private int getMemberIndex(Member[] members, Member member) {
		int index = 0;
		int result = -1;
		boolean isFound = false;
		while((!isFound)&&(index < members.length)) {
			if(member.getId() == members[index].getId()) {
				result = index;
				isFound = true;
			}
			index++;
		}
		return result;
	}
	
	private int getMinIndex(int[] array) {
		if(array == null)
			throw new NullPointerException();
		else {
			int min = array[0];
			int minIndex = 0;
			int index = 1;
			while(index < array.length) {
				if(array[index] < min) {
					min = array[index];
					minIndex = index;
				}
				index++;
			}
			return minIndex;
		}
	}
}
