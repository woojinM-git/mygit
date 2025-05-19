package am;

public class Ex05_Varargs { 

	// Varargs개념 (variable arguments의 준말
	public void test(int ...n) {

		System.out.println("Varargs개념의 지역변수(n)는 배열개념이 된다.");
		System.out.println(n.length); // .length 를 사용할 수 있음
		
		for(int i = 0; i < n.length; ++i) {
			System.out.println(n[i]);
		}
	}
	
}
