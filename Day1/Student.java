package Day1;

class boo {
	
}
/* 학생에 대한 정보를 보여주는 클래스*/

// public class는 클래스 파일당 하나
public class Student { //public class 이름과 클래스 파일 이름은 같아야함.
	
	public int studentID;
	public String studentName;
	public String address;
	
	public void showStudentInfo() {
		System.out.println(studentName + ", " + address);
	}
	
}
