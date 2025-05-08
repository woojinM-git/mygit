package am;

import java.util.Scanner;

public class Ex5_Break {

	public static void main(String[] args) {
		// 문자열을 기억하는 변수 str을 선언하자
		String str = ""; // 객체자료형 / 선언할 때 대문자로 시작한다
		
		// 키보드와 연결된 스케너 준비
		Scanner scan = new Scanner(System.in);
		System.out.println("문자열 입력: ");
		// 키보드로 부터 문자열을 받아서 str에 저장하자
		str = scan.nextLine(); // 변수를 받아서 반환값을 문자열로 한다
		
		System.out.println("str : " + str);
		
		// 사용자가 키보드로 입력한(scan) 모든 값들이 하나의 문자열로 만들어져서
		// 변수 str 에 저장된 상태다. 이때
		// str 에 있는 문자열(String)을 한자씩(char) 얻어내어 출력하는 반복문을 만들자
		bk1:for(int i = 0; i < str.length(); ++i) { // str.length << 저장되어있는 문자열의 수를 알려줌
			char ch = str.charAt(i); // 문자 추출
			
			System.out.printf("%-2c", ch); // 출력하여 확인
			
			//만약에 문자가 '0'과 같은 것을 만나면 반복문을 탈출하자
//			if(ch == '0') 
//				break; // 탈출
			
			switch(ch) {
				case '0':
						System.out.println("0이네");
//							break; // 반복문을 탈출하지 못하고 switch 문만 탈출함
								break bk1; // bk1 이라는 반복문을 탈출 (반복문 앞에 bk1: 레이블 붙여줘야됌)
				case 'a':
					System.out.println("a 입니다.");
				
			}
		}
	}

}
