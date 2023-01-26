package G13_CENG211_HW1;

public class Member {
	private int id;
	private int numberOfIssue;
	private String name;
	private String email;
	
	// Constructor
	public Member(int id, 
			String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
		numberOfIssue = 0;
	}
	
	// Copy Constructor
	public Member(Member original) {
		if(original == null) {
			System.out.println("Fatal error.");
			System.exit(0);
		}
		id = original.getId();
		name = original.getName();
		email = original.getEmail();
		numberOfIssue = original.getIssueNumber();
	}
	
	public boolean equals(Member otherMember) {
		return id == otherMember.getId();
	}
	
	public String toString() {
		return name;
	}
	// Mutator
	public void incrementIssue() {
		numberOfIssue++;
	}
	
	// Getters
	public int getId() {
		return id;
	}
	
	public int getIssueNumber() {
		return numberOfIssue;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
}
