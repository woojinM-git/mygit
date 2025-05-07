package pm;

import java.util.Scanner;

public class Ex7_Oper {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 키보드로 부터 정수를 받기 위해 필요한 객체
		Scanner scan = new Scanner(System.in);
		
		
		// 정수를 받기 전에 문자열 출력으로 표현
		System.out.println("정수 입력:");
		// 키보드와 연결된 스캐너로부터 정수를 하나 받아서
		// 변수 v1에 저장하자
		
		int v1 = scan.nextInt();

		// 입력받은 값이 10대 (10~19)인지? 맞다면 true
		// 그렇지 않다면 false 표현하자
		// 위와 같은 결과는 v1을 두번 비교 해야 한다
		// v1이 10보다 크거나 같고
		// v1이 20보다 작다면 true 이럴 때 논리연산자를 같이 써야 함
		// 논리연산자:
		// - && : AND조건
		// && : 먼저의 조건이 충족되야 뒤의 조건을 수행한다
		//      반대로 먼저의 조건이 충족되지 않으면 뒤의 조건을 수행하지않는다.
		// - || : OR 조건

		boolean res = (v1 >= 10) && (v1 < 20);
		System.out.println("v1의 값이 10대인가? = " + res);

		scan.close();
	}

}
