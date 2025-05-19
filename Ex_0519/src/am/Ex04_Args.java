package am;

public class Ex04_Args {
	
	public void test(int n) { // 오버로딩(중복정의)
		++n;
		System.out.println(n);
	}
	public void test(int n1, int n2) {
		++n1;
		System.out.println(n1);
	}
	public void test(int n1, int n2, int n3) {
		++n1;
		System.out.println(n1);
	}
}
