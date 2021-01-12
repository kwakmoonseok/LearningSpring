package JavaBasic;

class Subject {
	String subjectName;
	int score;
	
}
/* 학생에 대한 정보를 보여주는 클래스*/

// public class는 클래스 파일당 하나
public class Student { //public class 이름과 클래스 파일 이름은 같아야함.
	
	public int studentID;
	//private - 다른 클래스에서 직접 접근 불가능함
	public String studentName;
	
	Subject korea;
	Subject math;
	
	//디폴트 생성자 - 사용자 지정 생성자가 존재하면 작동하지 않음

	public Student(int id, String name) { //사용자 지정 생성자
		studentID = id;
		studentName = name;
		korea = new Subject();
		math = new Subject();
	}
	
	public void setKoreaSubject(String name, int score) {
		korea.subjectName = name;
		korea.score = score;
	}
	public void setMathSubject(String name, int score) {
		math.subjectName = name;
		math.score = score;
	}
	public void showStudentScore() {
		int total = korea.score + math.score;
		System.out.println(studentName + ": " + total);
	}
	
	public static void main(String[] args) {
		Student lee = new Student(100, "lee");
		lee.setKoreaSubject("국어", 100);
		lee.setMathSubject("수학", 95);
		
		lee.showStudentScore();
	}
}
