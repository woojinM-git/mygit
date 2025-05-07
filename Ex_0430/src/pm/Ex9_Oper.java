package pm;

import java.util.Scanner;

public class Ex9_Oper {

	public static void main(String[] args) {
		// 키보드로 부터 정수를 하나 받아 변수 v1에 저장한다.
		// v1의 값이 20대 라면 true 
		// 20대가 아니라면 false
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수");
		
		int v1 = scan.nextInt();
		
		boolean res = ((v1 >= 20) && (v1 < 30));
		
		System.out.println(res);
		// 키보드로 입력한 값이
		// 19 = false
		// 23 = true
		// 30 = false
		
		scan.close();
	}

}
