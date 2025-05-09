package am;

import java.util.Scanner;

public class Ex2_String {

	public static void main(String[] args) {
		// 키보드로 문자열을 받는다.
		// 그것이 숫자인지? 아닌지?를 판단하는 프로그램을 완성하시오
		Scanner scan = new Scanner(System.in);
		System.out.println("입력하세요 : ");
		
		String str = scan.nextLine();
		// str에서 한 문자씩 얻어내어 그것이 0~9까지의 수들 중 하나인지
		// 아닌지 판단(boolean)하자!
		boolean res = true; // res가 true이면 숫자, 그렇지 않으면 false 문자열 이다
		for(int i=0; i < str.length(); i++) { // str의 문자 길이가 i 보다 작을때 반복한다
			// str로부터 문자 하나를 가져온다. ********중요**********
			char ch = str.charAt(i);
			// i가 0이면 1번째 문자,  i가 1이면 2번째 문자 . . . 반복 증가

			// 얻어낸 문자(ch)가 0~9 범위에 포함 되는지 판단 	
			if(ch < '0' || ch > '9') { // 12a09
				res = false;
				break; // 반복문 탈출
			} // if 문의 끝
		}// for 문의 끝
		
		if(res) { // res의 값이 true 이면 값을 출력합니다
			System.out.println("숫자입니다");
		}else { // res의 값이 flase 이면 값을 출력합니다
			System.out.println("문자열입니다");
		}

		// int 형태로 이 값이 숫자에 속하면 true 
		// 값이 숫자에 속하지 않으면 false
	
	}

}
