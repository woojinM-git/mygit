package am;

import java.util.Scanner;

public class Ex9_if {

	public static void main(String[] args) {
		// 키보드로 부터 점수(0~100)를 받아
		// 60점 이상이면 "합격"을 출력하고 그렇지 않으면
		// "다시 도전" 을 출력
		// 점수기 60 이상이면 "합격"
		// 점수가 100을 넘어가면 "범위 초과"
		// 그 외에는 "불합격"
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("점수 : ");
		
		int score = scan.nextInt();
		
		// 먼저 score의 값이 100을 넘었는지 확인하는 비교문
		
		
		System.out.println("----------------------------------------------------");
		
//		if (score >= 60 && score <= 100) {
//			System.out.println("합격");
//		}
//		else if (score > 100) {
//			System.out.println("범위를 초과하였습니다.");
//		}
//		else {
//			System.out.println("불합격");
//		}
		
		System.out.println("----------------------------------------------------");
		
//		if(score <= 100) {
//			// 제어가 이 안에 들어오면 즉 score의 최대 값은 100이다.
//			if(score >= 60) {
//				System.out.println("합격");
//			}
//			else {
//				System.out.println("불합격"); 
//			}
//		}
//		else {
//			System.out.println("범위를 초과하였습니다.");
//		}
		
		System.out.println("----------------------------------------------------");
		
		// 먼저 100을 넘은 경우를 걸러낸다
		if(score > 100 || score < 0) { 
			System.out.println("잘 못 입력하셨습니다.");
			return; // 제어권 반환(호출한 곳으로 돌아간다.)
		} // score의 값이 100이하인 경우만 수행
		if(score >= 60) {
			System.out.println("합격");
		}
		else {
			System.out.println("재도전");
		}
		
		scan.close();
	}

}
