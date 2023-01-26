package G13_CENG211_HW1;

public class Issue {
	private int id;
	private Member member;
	private Book book;
	private String issueDate;
	private String returningDate;
	private GivenDate date;
	private static int issueNumber;
	
	static {
		issueNumber = 0;
	}
	
	// Constructor
	public Issue(int id, Member member,
			Book book, String issueDate, 
			String returningDate) {
		this.id = id;
		this.member = member;
		this.book = book;
		this.issueDate = issueDate;
		this.returningDate = returningDate;
		this.member.incrementIssue();
		this.book.incrementIssue();
		date = new GivenDate(this.issueDate, this.returningDate);
		issueNumber++;
	}
	
	// Copy Constructor
	public Issue(Issue original) {
		if(original == null) {
			System.out.println("Fatal error.");
			System.exit(0);
		}
		id = original.getIdIssue();
		member = new Member(original.getMember());
		book = new Book(original.getBook());
		issueDate = original.getIssueDate();
		returningDate = original.getReturningDate();
		date = new GivenDate(original.getDate());
	}

	public String toString() {
		return String.format("ID: %s\tMember: %s\tBook: %s", 
				this.id, this.member, this.book);
	}
	
	// Getters
	public int getIdIssue() {
		return id;
	}
	
	public String getIssueDate() {
		return issueDate;
	}
	
	public String getReturningDate() {
		return returningDate;
	}
	
	public GivenDate getDate() {
		return date;
	}
	
	public int getIssuedDayNumber() {
		return date.getDifference();
	}
	
	public Member getMember() {
		return new Member(member);
	}
	
	public Book getBook() {
		return new Book(book);
	}
	
	public static int getIssueNumber() {
		return issueNumber;
	}
}
