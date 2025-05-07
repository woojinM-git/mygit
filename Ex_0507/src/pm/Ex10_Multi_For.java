package pm;

public class Ex10_Multi_For {

	public static void main(String[] args) {
		// 1 2 3 4
		// 5 6 7 8
		
		int num = 0; // num 변수 만들고 0을 넣어둠
		
		for(int i = 1; i <= 2; i++) {
			for(int j = 1; j <=4; j++) {
				System.out.printf("%-2d", ++num); // num이 증가하면서 나열됌 1~8
				// j로 1234 1234 채우던 자리를 1씩 증가하는 num이 대신함
			}
			System.out.println();
		}
		
		System.out.println("----------------------------------------");
		
		/*
		 [결과1]
		 * * * *
		 * * * *
		 * * * *
		 * * * *
		
		 */

		/*
		 [결과2]
		 0 * * *
		 * 0 * *
		 * * 0 *
		 * * * 0
		
		 */
	 
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.printf("%-2c", '*'); // c 하나의 문자, // () 안에 "" '' 같은 홑따옴표 중복 불가능
			}
			System.out.println();
		}
		
		System.out.println("----------------------------------");
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(i == j) { // 0의 위치가 행, 열의 둘이 수가 같은 곳
					System.out.printf("%-2d", '0'); // 일치한다면 0을 
				}else {
					System.out.printf("%-2c", '*'); // 그렇지 않다면 *을 채움
				}
			}
			System.out.println();
		}

	}

}
