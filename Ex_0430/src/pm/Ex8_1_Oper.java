package pm;

public class Ex8_1_Oper {

	public static void main(String[] args) {
		// 프로그램 시작
		
		int a = 10;
		int b = 7;
				
		boolean res = ((a += 2) > 10) && ((b += 2) > 10);
				
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("res = " + res);
		System.out.println("--------------------------");
				
		res = ((a += 2) > 15) && ((b + 2) > 15);
		System.out.println("a = " + a); // 14
		System.out.println("b = " + b); // ?
		System.out.println("res = " + res); // false
				
		// 논리연산자 &&는 앞의 값이 false 라면 뒤의 조건을 실행하지 않아 연산이 되지않는다

	}

}
