package JavaBasic;

class boo {
	
}
/* 학생에 대한 정보를 보여주는 클래스*/

// public class는 클래스 파일당 하나
public class Student { //public class 이름과 클래스 파일 이름은 같아야함.
	
	public int studentID;
	//private - 다른 클래스에서 직접 접근 불가능함
	public String studentName;
	public String address;
	
	//디폴트 생성자 - 사용자 지정 생성자가 존재하면 작동하지 않음

	public Student(String name) { //사용자 지정 생성자
		studentName = name;
	}
	
	public Student(int id, String name) { //사용자 지정 생성자
		studentID = id;
		studentName = name;
		address = "주소 없음";
	}
	
	public void showStudentInfo() {
		System.out.println(studentName + ", " + address);
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	
	
}
