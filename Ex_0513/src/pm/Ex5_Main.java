package pm;

import java.util.Scanner;

public class Ex5_Main {

	public static void main(String[] args) {
		// 스캐너 준비
		Scanner scan = new Scanner(System.in);
		System.out.println("단:");
		int dan = scan.nextInt(); // 키보드로 부터 정수 하나 받기
		
		// 구구단의 값을 받기 위해 필요한 객체 생성
		Ex5_Gugudan gu = new Ex5_Gugudan();
		
		// 키보드로 부터 입력받은 단의 값을 Ex5_Gugudan에게 전달
		gu.setDan(dan);
		
		// 해당 구구단의 결과를 문자열로 받는다.
		String str = gu.result();
		System.out.println(str.replace("*", "x")); // 지정한 왼쪽을 오른쪽으로 변형
		
	}

}
