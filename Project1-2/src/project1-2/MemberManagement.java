package G13_CENG211_HW1;

public class MemberManagement {
	private Member[] members;
	private FileIO memberIO;
	
	// Constructor
	public MemberManagement() {
		memberIO = new FileIO("Members.csv");
		String[][] membersInfo = memberIO.getResultArray();
		members = new Member[membersInfo.length - 1];
		setUpMembers(membersInfo);
	}
	
	/**
	 Gets the member with a given id.
	 @return The member object who is the given id.
	 */
	public Member getMember(int id) {
		Member member = null;
		for(int row = 0; row < members.length; row++) {
			if(id == members[row].getId()) {
				member = members[row];
				break;
			}
		}
		return member;
	}

	/**
	 Gets members array which the library has.
	 @return The member reference array type.
	 */
	public Member[] getMembers() {
		Member[] temp = new Member[members.length-1];
		for(int index = 1; index < members.length; index++) {
			temp[index - 1] = new Member(members[index]);
		}
		return temp;
	}
	
	//  Implementation details.
	private final void setUpMembers(String[][] info) {
		for(int member = 0; member < members.length; member++) {
			int id = Integer.parseInt(info[member+1][0]);
			members[member] = new Member(id,
					info[member+1][1], info[member+1][0]);
		}
	}
}
