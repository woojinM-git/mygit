package am;

import java.util.Scanner;

public class Ex1_String {

	public static void main(String[] args) {
		// 물류센터에서 각 제품의 제품번호를 읽어온다.
		// 이 상황을 키보드로 입력 받는 것으로 하자
		System.out.println("코드 : ");
		Scanner scan = new Scanner(System.in);
		
		// 제품번호 형식: 제조날짜-카테고리-유형코드
		// 								250509-L-120
		String num = scan.nextLine();
		
		// 입력된 제품번호의 8번째 자리의 문자를 얻어내어
		// 그것이 'L'이면 "생활용품", 'E'면 "가전제품", 'S'면 "스포츠용품"
		// 으로 구분하도록 하자
		int len = num.length();
		
		if(len < 8) { // len 이 8글자보다 적다면 아래 문장을 수행한다
			System.out.println("잘 못 된 코드입니다");
			return;// 제어권 반환:(이 후 수행 안함)
		}
		
		char ch = num.charAt(7); // num의 7번째 자리를 char 형태로 ch에 담는다
		
		switch(ch) {
		case 'L' :
			System.out.println("생활용품");
			break;
		case 'E' :
			System.out.println("가전제품");
			break;
		case 'S' :
			System.out.println("스포츠용품");
			break;
//		default :
//			System.out.println("잘 못 입력하셨습니다");
		} // swirch의 끝
		
	}

}
