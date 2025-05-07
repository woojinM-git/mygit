package am;

public class Ex5_For {

	public static void main(String[] args) {
		// 1~10까지 반복하여 출력하는 for 문
		
		/*
			[for 구성]
			for(초기식; 조건식; 증감식) {
				조건식에 만족할 때 수행하는 문장;
			}
		*/
		for(int i = 0; i < 10; i++) {
			System.out.print(i); // print(ln) ln 이 없음
		}

		System.out.println("------------------------------");
		
		for(int i = 1; i <= 10; i+=2) { // ++(1을 더함), +=n(n을 더함)
			System.out.println(i);
		}
		
		for(double i = 1; i <= 10; i+=0.5) { // 소수점을 증가할 때 사용
			System.out.println(i);
		} // 이렇게 할거면 int 형으로 20보다 작거나 같을 때까지 돌리는 것이
		// 가독성에서는 더 유익하다
		
		for(int i = 0; i < 10; i++) {
			// System.out.println(i); // 0~9 까지 표현됨
			System.out.println(i+1); // 1~10까지 표현됨
		}
		
		System.out.println("---------------무한반복----------------");

		// for(;;) 식이 없으니 조건을 만족하지 못해 반복이 끝나지 않음
			System.out.println("^^");
	}

}