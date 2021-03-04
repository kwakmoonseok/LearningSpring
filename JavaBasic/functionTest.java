package JavaBasic;

public class functionTest {
    public static int addNum(int num1, int num2) { //�Է°��� ��ȯ���� �ִ� �Լ�
        return num1 + num2;
    }

    public static void sayHello(String greeting) { //�Է°��� ������ ��ȯ���� ���� �Լ�
        System.out.println(greeting);
    }

    public static int calcSum() { //�Է°��� ������ ��ȯ���� �ִ� �Լ�
        int sum = 0;

        for (int i = 0; i <= 100; i++) {
            sum += i;
        }

        return sum;
    }

    public static void onceAponATime() { //�Է°��� ��ȯ���� ��� ���� �Լ�
        System.out.println("There was a Divine Dragon....");
    }

    public static void main(String[] args) { //�� Ȯ��
        int n1 = 10;
        int n2 = 20;

        int total1 = addNum(n1, n2);

        sayHello("Hello");

        int total2 = calcSum();

        System.out.println(total1);
        System.out.println(total2);

        onceAponATime();
    }
}
