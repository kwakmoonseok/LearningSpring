package JavaBasic;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("김유신");
		set.add("이순신");
		set.add("강감찬");
		set.add("이순신");
		
		System.out.println(set); //중복된 데이터 값이 나오지 않음
		
		Iterator<String> ir = set.iterator(); //순회시 iterator 자료형 사용
		
		while(ir.hasNext()) {
			String str = ir.next();
			System.out.println(str);
		}
	}
}
