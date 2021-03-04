package JavaBasic;

class Subject {
    String subjectName;
    int score;

}
/* �л��� ���� ������ �����ִ� Ŭ����*/

// public class�� Ŭ���� ���ϴ� �ϳ�
public class Student { //public class �̸��� Ŭ���� ���� �̸��� ���ƾ���.

    public int studentID;
    //private - �ٸ� Ŭ�������� ���� ���� �Ұ�����
    public String studentName;

    Subject korea;
    Subject math;

    //����Ʈ ������ - ����� ���� �����ڰ� �����ϸ� �۵����� ����

    public Student(int id, String name) { //����� ���� ������
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
        lee.setKoreaSubject("����", 100);
        lee.setMathSubject("����", 95);

        lee.showStudentScore();
    }
}
