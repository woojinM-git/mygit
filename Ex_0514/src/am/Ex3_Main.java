package am;

import java.util.Scanner;

public class Ex3_Main {

	public static void main(String[] args) {
		// 도서관 객체 생성
		Ex3_Livrary liv = new Ex3_Livrary();
		liv.setAr(); // 배열에 책 5권이 생성되어 채워진다.
		
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 도서명: ");
		String input = scan.nextLine(); // 사용자가 입력한 책 이름
		System.out.println("--------------------");
		
		String msg = liv.search(input); // 도서관에 있는 검색기능을 호출(input을 인자로 전달)
		// 	이때 검색된 결과는 별도로 문자열로 받는다
		// if(msg == "")
		if(msg.trim().length() < 1)
			System.out.println("검색된 정보가 없습니다."); // 검
		else 
			System.out.println(msg); // 검색된 정보가 없다면 null이 출력
	}

}
