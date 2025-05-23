package am;

public class Ex2_Outer {
	
	private String msg = "쌍용교육센터"; // private: 외부에서 접근 불가
									// 외부에서 접근하기위해 get, set 필요
	
	// 멤버 내부클래스: 멤버와 같은 격이다(멤버필드)
	
	class Inner { // 내부클래스: 장점은 바깥쪽 클래스의 멤버를 
					// 자신의 것처럼 사용이 가능하다
		
		int value = 100; // 변수 선언 가능
		
		public void print() { // 함수 생성 가능
			System.out.println(msg + value);
		}
	}
	
}
