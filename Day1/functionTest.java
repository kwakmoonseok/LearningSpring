package Day1;

public class functionTest {
	public static int addNum(int num1, int num2) { //입력값과 반환값이 있는 함수
		return num1 + num2;
	}
	
	public static void sayHello(String greeting) { //입력값은 있으나 반환값이 없는 함수
		System.out.println(greeting);
	}
	
	public static int calcSum() { //입력값이 없으나 반환값이 있는 함수
		int sum = 0;
		
		for (int i = 0; i <= 100; i++) {
			sum += i;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = 20;
		
		int total1 = addNum(n1, n2);
		
		sayHello("Hello");
		
		int total2 = calcSum();
		
		System.out.println(total1);
		System.out.println(total2);
	}
}
