package am;

public class Ex2_while {

	public static void main(String[] args) {
		// 1~45 수들 중 난수를 발생시켜 출력하는 프로그램을
		// 구현하자 난수의 수는 총 6개를 출력해야 하며
		// 반드시 while문을 사용
		int i = 0;
		while(i < 6) {
			int su = (int)(Math.random()*45+1);
			System.out.printf("%-3d", su);
			++i;
		}
		
		System.out.println("\n--------------------------------------------");
		
		/*
		 	while 문을 이용하여 다음과 같이 출력하자
		 	[결과]
		 	* * * * 
		 	* * * * 
		 	* * * * 
		 */
		
		i = 0;
		while(i < 3) {
			int k = 0;
			while(k < 4) {
				System.out.printf("%2s", '*');
				++k;
			}
			System.out.println();
			++i;
		}
		
	}

}
