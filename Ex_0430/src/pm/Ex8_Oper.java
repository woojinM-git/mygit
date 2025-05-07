package pm;

public class Ex8_Oper {

	public static void main(String[] args) {
		// 프로그램 시작
		
		int a = 13;
		int b = 7;
		
		boolean res = ((a += 2) > 10) || ((b += 2) > 10);
		
		System.out.println("a = " + a); // true 15
		System.out.println("b = " + b); // 먼저 조건이 true = 무시
		System.out.println("res = " + res);
		System.out.println("--------------------------");
		
		res = ((a += 2) > 15) || ((b + 2) > 15);
		System.out.println("a = " + a); // true 17
		System.out.println("b = " + b); // 먼저 조건이 true = 무시
		System.out.println("res = " + res); // true
		
		// 논리연산자 &&는 앞의 값이 false 라면 뒤의 조건을 실행하지 않아 연산이 되지않는다
	}

}
