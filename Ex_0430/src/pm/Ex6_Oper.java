package pm;

import java.util.Scanner;

public class Ex6_Oper {

	public static void main(String[] args) {
		// 프로그램 시작
		// 비교연산자
		//  > : 크다
		//  < : 작다
		//  >=: 크거나 같다
		//  <=: 작거나 같다
		//  !=: 같지 않다
		//  ==: 같다
		
		// 키보드와 연결된 스캐너객체를 만들자
		int a = 10; // int a = 정수
		Scanner scan = new Scanner(System.in); // Scanner scan = 스캐너(new Scanner(System.in));
		System.out.println("값1:");
		a = scan.nextInt(); // 키보드로부터 정수 하나를 받기위해 대기함
		
		System.out.println("값2");
		int b = scan.nextInt(); //키보드로 부터 두번째 정수 받기
		
		System.out.println(a != b); // a와 b가 같지 않다면 true 지만 !(부정연산자)로 인해 false 나옴
		
		System.out.println(a == b); // a와 b가 같은가?

		scan.close();
	}

}
