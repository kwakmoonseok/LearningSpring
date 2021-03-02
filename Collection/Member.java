package Collection;

public class Member {
	private int memberId;
	private String memberName;
	
	public Member() {
		
	}

	public Member(int memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String toString() {
		return memberName + ": " + memberId;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return memberId;
	}

	@Override
	public boolean equals(Object obj) { //set의 중복 기준은 이 함수이기 때문에 필요하면 재정의하여 set의 조건을 맞춰주어야 한다.
		// TODO Auto-generated method stub
		if (obj instanceof Member) {
			Member member = (Member)obj;
			
			return (this.memberId == member.memberId);
		}
		return false;
	}
	
}
