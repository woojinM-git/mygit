package pm;

public class Ex12_Test {

	public static void main(String[] args) {
		/*
		  [문제1] 다음의 결과와 같은 모양을 추렬갛는 반복문을 구현하시오
		  [결과]
		  * * * * 첫줄 	1 2 3 4		1
		  * * * 					2
		  * * 						3
		  * 						4
		 */
		
		for(int i = 0; i < 4; i++) {
			for(int j = 4; j > i; j--) {
				System.out.printf("%-2c", '*');
			}
			System.out.println();
		}
		System.out.println("-------------------------------");
		/*
		  [문제2] 다음의 결과와 같은 모양을 추렬갛는 반복문을 구현하시오
		  [결과]
		  * * * *		1 2 3 4		1
		  	* * * 		 			2
		  	  * * 					3
		  		* 			 		4
		 */
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < i; j++) {
				System.out.printf("%-2c", ' ');
			}
			for(int k = 4; k > i; k--) {
				System.out.printf("%-2c", '*');
			}
			System.out.println();
		}
		System.out.println("-------------------------------");
		/*
		  [문제3] 구구단을 다음과 같이 출력하는 반복문을 구현하시오
		  [결과]
		  2 * 1 = 2		3 * 1 = 3		. . .		9 * 1 = 9
		  2 * 2 = 4		3 * 2 = 6		. . .		9 * 2 = 18
		  . . .			. . .			. . .		. . .
		  2 * 9 = 18	3 * 9 = 27		. . .		9 * 9 = 81
		 */
		int i = 0;
		int j = 0;
		
		for(i = 2; i < 10; i++) {
			for(j = 1; j < 10; j++) {
				System.out.println(i + " * " + j + " = " + i * j );
			}
			System.out.println();
		}
	}

}
