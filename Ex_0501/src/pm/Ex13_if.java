package pm;

import java.util.Scanner;

public class Ex13_if {

	/**
	 * 1) 100 초과하고 0 미만의 경우를 걸러낸다 if(score > 100 || score < 0) = System.out.println("점수를 잘못 입력하셨습니다.");
	 * 2) 80 이상 값 입력 시 "우수" 출력 -> 100 초과 값 입력 시 자동 1) 로 처리
	 * 3) 60 이상 값 입력 시 "보통" 출력 -> 80 이상 값 입력 시 자동 2)
	 * 4) 40 이상 값 입력 시 "우려" 출력 -> 60 이상 값 입력 시 자동 3)
	 * 5) 40 미만 값 입력 시 "미달" 출력 -> 40 이상 값 입력 시 자동 4) / 0 미만 값 입력 시 자동 1) 
	 */
	public static void main(String[] args) {
		// 키보드로부터 점수를 하나 받아 score에 저장한다.(0~100)-> score <= 100
		// 그 점수가 80~100이면 "우수"
		// 60~79 "보통"
		// 40~59 "우려"
		// 이하 "미달"
		
		Scanner scan = new Scanner(System.in);
		System.out.println("점수 : ");
		
		int score = scan.nextInt();
		
		String str = "";
		if(score > 100 || score < 0) {
			System.out.println("점수를 잘못 입력하셨습니다.");
			return;
		}else if(score >= 80) {
			str = "우수";
		}else if(score >= 60) {
			str = "보통";
		}else if(score >= 40) {
			str = "우려";
		}else {
			str = "미달";
		}
		System.out.println(str + " 입니다.");
		System.out.println();
		System.out.println("수고하셨습니다.");

		/*
		 * 101 -> 점수 잘못 입력
		 * 80 -> 우수
		 * 60 -> 보통
		 * 40 -> 우려
		 * 39~0 -> 미달
		 */
	}

}
