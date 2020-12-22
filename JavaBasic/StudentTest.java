package JavaBasic;

public class StudentTest {
	public static void main(String args[]) {
		Student lee = new Student("이순신"); //생성자를 통한 변수 생성
		lee.studentName = "이순신"; // 맴버 변수 할당
		lee.address = "서울";
		
		lee.showStudentInfo(); // 출력
		
		Student kim = new Student(100, "김유신"); //하나의 클래스 생성자로 여러 개의 인스턴스를 만들 수 있음 
		kim.studentName = "김유신";
		kim.address = "경주";
		
		kim.showStudentInfo();
		
		System.out.println(lee); //각 변수가 참조하는 메모리 주소가 출력
		System.out.println(kim);
	}
}
