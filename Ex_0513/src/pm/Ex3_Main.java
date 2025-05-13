package pm;

import java.util.Scanner;

public class Ex3_Main {

	public static void main(String[] args) {
		Ex3_Gugudan gu = new Ex3_Gugudan();
				
		Scanner scan = new Scanner(System.in);
		System.out.println("단 : ");
		int dan = scan.nextInt(); // 키보드로 부터 정수 하나 받기
		
		gu.setDan(dan); // 키보드로부터 받은 값을 구구단을 멤버변수에 저장
		
		// 해당 단을 출력하는 기능을 호출하자!
		gu.print();

	}

}
