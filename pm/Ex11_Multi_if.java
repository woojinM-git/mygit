package pm;

import java.util.Scanner;

public class Ex11_Multi_if {

	public static void main(String[] args) {
		// JVM
		
		System.out.println("값 : ");
		Scanner scan = new Scanner(System.in);
		int value = scan.nextInt();
		
		// 변수 value의 값이 1 or 2 or 3이 들어간다고 가정하면
		// 1일때, "초급" 출력
		// 2일때, "중급" 출력
		// 3일때, "고급" 출력
		// 그 외는 모두 "잘 못 입력"이라고 출력
		// 위를 해결하기 위해서는 다중 if 문을 구현해야 한다
		// [ 구성 ]
		/*
		 * if(조건식1)
		 * 		조건식1 을 만족하는 수행문;
		 * else if(조건식2)
		 * 		조건식1 에는 맞지 않지만 조건식2 에는 만족하는 수행문;
		 * else if(조건식3)
		 * 		조건식2 에도 맞지 않지만 조건식3 에는 만족하는 수행문;
		 * else 
		 * 		모든 조건식에 만족하지 않는 수행문;
		 */
		
		if(value == 1) {
			System.out.print("초급");
		}
		else if(value == 2) {
			System.out.print("중급");
		}
		else if(value == 3) {
			System.out.print("고급");
		}
		else {
			System.out.print("올바르지 않은 값");
		}
		System.out.println(" 입니다");
		
		String str = "";
		if(value == 1) {
			str = "초급";
		}
		else if(value == 2) {
			str = "중급";
		}
		else if(value == 3) {
			str = "고급";
		}
		else {
			str = "올바르지 않은 값";
		}
		System.out.println(str + " 입니다.");
	}

}
