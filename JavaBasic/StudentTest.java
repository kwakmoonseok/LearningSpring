package JavaBasic;

import java.util.ArrayList;

class SubjectArray {
	private String name;
	private int score;
	
	public SubjectArray(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
class StudentArray {
	int studentID;
	String studentName;
	ArrayList<SubjectArray> subjectList;
	
	public StudentArray(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
		
		subjectList = new ArrayList<SubjectArray>();
	}
	public void addSubject(String name, int score) {
		SubjectArray subject = new SubjectArray(name, score);	
		subjectList.add(subject);
	}
	public void showStudentInfo() {
		int total = 0;
		
		for (SubjectArray o : subjectList) {
			total += o.getScore();
			System.out.println(studentName + " - " + o.getName() + ": " + o.getScore());
		}
		System.out.println(studentName + " : " + total);
	}
}
public class StudentTest {
	public static void main(String[] args) {
		StudentArray lee = new StudentArray(1001, "lee");
		StudentArray kim = new StudentArray(1002, "kim");
		
		lee.addSubject("국어", 100);
		lee.addSubject("수학", 90);
		
		kim.addSubject("국어", 80);
		kim.addSubject("수학", 98);
		
		kim.showStudentInfo();
		lee.showStudentInfo();
	}
	
}	

