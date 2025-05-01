package am;

public class Ex1_Oper {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 정수 13을 기억하는 변수 a 만들자
		
		int a = 13;
		
		// 정수 7을 기억하는 변수 b 만들자
		
		int b = 7;

		int c = a & b; // 비트연산자 비트단위로 &(AND) 연산을 한다.
		// a -> 0000 .... 1101 = 13
		// b -> 0000 .... 0111 = 7 
		//    & --------------       = a b 둘다 1이면 카운트 한다 1, 4 자리 = 5
		//      0000 .... 0101 = 5
		
		System.out.println("c = " + c);
		
		int d = 20;
		
		int e = 15;
		
		int f = d | e; // 비트연산자 비트단위로 |(OR) 연산을 한다.
		
		System.out.println(f);
	}

}
