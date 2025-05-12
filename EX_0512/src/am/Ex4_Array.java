package am;

public class Ex4_Array {

	public static void main(String[] args) {
		/*
		 	0 0 0 0		 1 0 0 0  	0,0 0,1 0,2 0,3
		 	0 0 0 0  ==> 0 1 0 0	1,0 1,1 1,2 1,3
		 	0 0 0 0		 0 0 1 0	2,0 2,1 2,2 2,3
		 	0 0 0 0		 0 0 0 1	3,0 3,1 3,2 3,3
		 */
		int[][] ar = new int[4][4];
		
		for(int i = 0; i < ar.length; ++i) {
			for(int j = 0; j < ar[i].length; ++j) {
				if(i == j) {
					System.out.printf("%-2d", 1);
				}else {
					System.out.printf("%-2d", 0);
				}
			}
			System.out.println();
		}
		
		System.out.println("---------- 초기 선생님 방법 ----------");
		
		int[][] ar1 = new int[4][4];
		
		for(int i = 0; i < ar1.length; ++i) {
			for(int j = 0; j < ar[i].length; ++j) {
				// 각 1차원배열을 접근하는 반복문
				System.out.printf("%-2d", ar1[i][j]);
			}
			// 1차원 배열이 하나씩 끝날 때마다 줄바꿈
			System.out.println();
		}
		
		System.out.println("---------- 1값 선생님 방법 ----------");
		
		for(int i = 0; i < ar1.length; ++i) {
			for(int j = 0; j < ar[i].length; ++j) {
				if(i == j)
					ar[i][j] = 1;
				System.out.printf("%-2d", ar1[i][j]);
			}
			// 1차원 배열이 하나씩 끝날 때마다 줄바꿈
			System.out.println();
		}
		
	}

}
