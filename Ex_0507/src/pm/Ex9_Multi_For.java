package pm;

public class Ex9_Multi_For {

	public static void main(String[] args) {
		// 화면에 1~5까지 출력하는 반복문 
		/*
		 [결과]
		 1 2 3 4 5
		 1 2 3 4 5
		 1 2 3 4 5
		 */

		for(int i = 1; i <= 5; i++) {
			// System.out.println(i +" ");
			System.out.printf("%-2d", i); // print(f) 형식에 맞춰 출력한다
			// %d(숫자) %s(문자) %c(하나의 글자) %f(소수점) 
			// %(1) %(2), (1) (2))
			// %2d %3d %4d ... %(n)d n에 들어간 숫자 만큼 자리를 차지함
		}
		
		System.out.println("------------다중for문-------------");
		
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 5; j++ ) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		System.out.println("--------------------------------------");
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= 4; j++) {
				System.out.printf('*' + " ");
			}
			System.out.println();
		}
		
		for(int i = 1; i <= 2; i++) {
			for(int j = 1; j <= 4; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
	}

}
