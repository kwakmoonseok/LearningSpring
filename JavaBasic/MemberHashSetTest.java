package JavaBasic;

import Collection.Member;

public class MemberHashSetTest {
	public static void main(String[] args) {
		MemberHashSet manager = new MemberHashSet();
		
		Member lee = new Member(100, "lee");
		Member kim = new Member(100, "kim");
		Member park = new Member(100, "park");
		
		manager.addMember(lee);
		manager.addMember(kim);
		manager.addMember(park);
		
		manager.showAllMember();
		
		manager.removeMember(100);
		
		manager.showAllMember();
	}
}
