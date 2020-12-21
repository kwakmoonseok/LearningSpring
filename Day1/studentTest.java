package Day1;

public class studentTest {
	public static void main(String args[]) {
		Student lee = new Student(); //생성자를 통한 변수 생성
		lee.studentName = "이순신"; // 맴버 변수 할당
		lee.address = "서울";
		
		lee.showStudentInfo(); // 출력
	}
}
