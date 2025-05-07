package pm;

public class Ex4_Oper {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 정수 10을 기억하는 v1이라는 변수를 만들자
		int v1 = 10;
		System.out.println(v1);
		// 정수 7을 기억하는 v2라는 변수를 만들자
		int v2 = 7;
		System.out.println(v2);
		// 정수 10을 기억하는 v1과 정수 7을 기억하는 v2를 더하자
		int res = v1 + v2;
		System.out.println("v1 + v2 = " + res); // v1 + v2 = 17
		// + 연산자는 피연산자들 중 하나라도 문자열이 있다면
		// 다른 피연산자 또한 문자열로 변한다
		
		// 실수형 : float, double
		float f1 = 3.14f; // 자바에서는 소수점을가지는 값들은 기본적으로 double로 인식함
						  // float으로 인식시키기 위해 값 뒤에 f를 붙인다.
		
		double d1 = 2.1;
		
		// 나머지 값 구하기 : %
		double d2 = f1 % d1;
		System.out.println("f1 % d1 = " + d2); // f1의 3.14를 d1의 값 2.1로
										// 나누고 나머지 값을 변수 d2에 저장한 것을 출력한다.
	}

}
