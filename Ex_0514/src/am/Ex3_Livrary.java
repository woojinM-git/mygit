package am;

public class Ex3_Livrary {
	Ex3_Book[] ar = new Ex3_Book[5];
	
	// 도서들을 만들어서 배열에 저장하는 기능
	public void setAr() {
		ar[0] = new Ex3_Book();
		ar[0].setB_num("P-J-100");
		ar[0].setTitle("이것이 자바다");
		ar[0].setPub("한빛미디어");
		ar[0].setPos("A-13");
		ar[0].setRent(true);
		
		ar[1] = new Ex3_Book();
		ar[1].setB_num("P-T-112");
		ar[1].setTitle("UML");
		ar[1].setPub("한빛미디어");
		ar[1].setPos("B-103");
		ar[1].setRent(true);
		
		ar[2] = new Ex3_Book();
		ar[2].setB_num("P-J-200");
		ar[2].setTitle("자바 바이블");
		ar[2].setPub("한빛아카데미");
		ar[2].setPos("A-20");
		ar[2].setRent(false);
		
		ar[3] = new Ex3_Book();
		ar[3].setB_num("P-O-111");
		ar[3].setTitle("이것이 우분투 리눅스다");
		ar[3].setPub("한빛미디어");
		ar[3].setPos("c-13");
		ar[3].setRent(true);
		
		ar[4] = new Ex3_Book();
		ar[4].setB_num("P-F-111");
		ar[4].setTitle("스프링 활용");
		ar[4].setPub("한빛아카데미");
		ar[4].setPos("S-11");
		ar[4].setRent(true);
	}
	
	// 책이름으로 검색하는 기능
	public String search(String n) {
		// 도서명으로 검색된 책 정보들을 문자열로 저장하기 위해
		// 필요한 객체 준비
		StringBuffer sb = new StringBuffer();
		
		// 모든 책들의 이름을 가져와서 인자로 받은 n이 저장된 값이
		// 포함 되었는지 확인하는 반복문
		for(int i = 0; i < ar.length; ++i) {
			// 배열에 저장된 책 정보를 하나씩 가져온다
			Ex3_Book book = ar[i];
			
			// 얻어낸 책 정보에서 책제목만 얻어낸다.
			String tt = book.getTitle(); // tt안에 "이것이 자바다" 의 주소가 들어가 있음
			
			// tt안에 n이 포함 되었는지? 확인하는 비교
			int idx = tt.indexOf(n); // tt안에 n의 값이 있는 위치값을 변수
										// idx에 저장한다. 만약! n의 값이
										// 없다면 idx에는 -1이 저장된다.
			if (idx != -1) {
				sb.append(book.getB_num()); // 도서번호
				sb.append("|");
				sb.append(book.getTitle()); // 책 제목
				sb.append("|");
				sb.append(book.getPub()); // 출판사
				sb.append("|");
				sb.append(book.getPos()); // 위치
				sb.append("|");
				
				String rent = "대여 중";
				if(book.isRent()) { // true이면 대여가능으로 하자
					rent = "대여가능";
				}
				sb.append(rent); // "대여 중" 아니면 "대여가능"이 들어감
				sb.append("\r\n"); // 줄바
			}
		} // for의 끝
		
		return sb.toString();
	}
}
	


















