package JavaBasic;

public class StudentTest {
	public static void main(String args[]) {
		Student lee = new Student("�̼���"); //�����ڸ� ���� ���� ����
		lee.studentName = "�̼���"; // �ɹ� ���� �Ҵ�
		lee.address = "����";
		
		lee.showStudentInfo(); // ���
		
		Student kim = new Student(100, "������"); //�ϳ��� Ŭ���� �����ڷ� ���� ���� �ν��Ͻ��� ���� �� ���� 
		kim.studentName = "������";
		kim.address = "����";
		
		kim.showStudentInfo();
		
		System.out.println(lee); //�� ������ �����ϴ� �޸� �ּҰ� ���
		System.out.println(kim);
	}
}
