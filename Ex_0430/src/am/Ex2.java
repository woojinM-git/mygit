package am;

public class Ex2 {
	public static void main(String[] args) {
		// 프로그램 시작
		
		// 변수 선언
		// 변수는 자료형을 알아야 한다.
		// - 자바에서는 자료형을 크게 2가지로 나눔
		// - 1) 기본자료형
		// - 2) 객체(참조)자료형
		// boolean: true, false
		boolean b1 = true; // 변수 선언 // true = 예약어
		System.out.println(b1); // ln = 라인체인지, 줄바꿈
		System.out.print(b1); // 문장의 끝에는 ;를 붙인다
		System.out.println(b1); // truetrue: 위 문장은 ln이 없어 아래 문장과 같이 출력
		
		// char: 하나의 문자를 기억하는 자료형, 문자는 홑따옴표로 구분(Character)
		char b2 = 'A'; // char라는 calss에 b2라는 이름을 붙이고 A라는 문자를 넣는다
		System.out.println(b2); // b2를 출력 = A
		System.out.println(); // sysout + (ctrl + spacebar) = System.out.println(); 자동완성
		
		b2 = 'B'; // 변수 사용(값 변경)
		// char 자료형이 이미 선언되어 있으면 변수만 작성하고 값을 변경한다
		System.out.println(b2); // b2 값 출력 = B
		
		// 정수형 변수 선언 : byte, short, int, long
		byte b3 = 127; // 범위: -128 ~ 127
		System.out.println(b3);
		
		short b4 = 32767;
		
		int b5 = 123456789;
		System.out.println(b4 + b5); // 32767 + 2100000000의 값
		long b6 = 2100000000000000l; // long 형의 값을 의미할 때는 값 뒤에 l or L 을 기술한다
		System.out.println(b5 + b6);
	}
}
