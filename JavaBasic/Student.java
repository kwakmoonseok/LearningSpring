package JavaBasic;

class boo {
	
}
/* �л��� ���� ������ �����ִ� Ŭ����*/

// public class�� Ŭ���� ���ϴ� �ϳ�
public class Student { //public class �̸��� Ŭ���� ���� �̸��� ���ƾ���.
	
	public int studentID;
	//private - �ٸ� Ŭ�������� ���� ���� �Ұ�����
	public String studentName;
	public String address;
	
	//����Ʈ ������ - ����� ���� �����ڰ� �����ϸ� �۵����� ����

	public Student(String name) { //����� ���� ������
		studentName = name;
	}
	
	public Student(int id, String name) { //����� ���� ������
		studentID = id;
		studentName = name;
		address = "�ּ� ����";
	}
	
	public void showStudentInfo() {
		System.out.println(studentName + ", " + address);
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	
	
}
