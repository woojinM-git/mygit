package pm;

import java.util.Scanner;

public class Ex12_local_var {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("값 : ");
		
		int v1 = scan.nextInt();
		
		String str = "";
		if(v1 >= 60) {
			// if 문의 영역
			str = "합격"; // if 문 영역의 지역변수
		}
		else {
			str = "재도전"; // else 영역의 지역변수
				// 이런 지역변수는 해당 지역 벗어나면 소멸된다.
		}
		System.out.println(str + " 입니다.");
		
	}
}
