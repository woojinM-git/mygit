package am;

public class Ex2_Main {

	public static void main(String[] args) {
		// 멤버 생성
		Ex2_Member[] ar = new Ex2_Member[3];
		// 객체를 새로 만드는 키워드는 new
		// 현재 ar 을 가리키는 길이가 3인 배열이 준비되어있고 안에 null이 있다.
		
		ar[0] = new Ex2_Member();
		ar[1] = new Ex2_Member();
		ar[2] = new Ex2_Member();
		
		ar[0].setName("마루치");
		ar[0].setPhon_num("010-1234-5678");

		ar[1].setName("아라치");
		ar[1].setPhon_num("010-0123-5678");
		
		ar[2].setName("파란해골");
		ar[2].setPhon_num("010-0123-1212");
	}

}
