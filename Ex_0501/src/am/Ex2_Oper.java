package am;

public class Ex2_Oper {

	public static void main(String[] args) {
		// 증감연산자 : ++, --
		
		// 정수 8을 기억하는 변수 a 를 만들자
		int a = 8;
		
		int b = ++a + 3; // 전위증감연산자 ++a = a 에 1을 더한다 + 3
		
		System.out.println("a = " + a); // 증감연산자를 지난 a 의 저장값이 9로 변경
		System.out.println("b = " + b); // 9로 변한 a + 3 = 12, 즉 b = 12
		// eclipse 에서 유용한 단축키
		// ctrl + alt + 방향키 ↓ = 현재 줄 복사
		// alt + 방향키 ↑ or ↓ = 현재 줄 이동
		// ctrl + D = 현재 줄 삭제
		
		b = a++ + 3; // 12 a++(후위 증감연산자)는 현재 식을 통과하고 연산을 한다.
		// 			 	즉 식 이후에 출력하면 10
		
		System.out.println("a = " + a); // 10 위 식을 통과하고 1 증가
		System.out.println("b = " + b); // 12 a 의 1을 더하기 전인 9 + 3 = 12
		
		System.out.println(a++); //  10 후위 증감연산자 a++ 이므로 식이 끝나고 1
		System.out.println(a); // 11
	}

}
