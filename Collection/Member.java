package Collection;

import java.util.Comparator;

public class Member implements Comparator<Member> {
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
    public boolean equals(Object obj) { //set�� �ߺ� ������ �� �Լ��̱� ������ �ʿ��ϸ� �������Ͽ� set�� ������ �����־�� �Ѵ�.
        // TODO Auto-generated method stub
        if (obj instanceof Member) {
            Member member = (Member) obj;

            return (this.memberId == member.memberId);
        }
        return false;
    }

    @Override
    public int compare(Member o1, Member o2) {
        // TODO Auto-generated method stub
        return (o1.memberId - o2.memberId);
    }


}
