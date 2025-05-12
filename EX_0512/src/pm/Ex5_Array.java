package pm;

public class Ex5_Array {

	public static void main(String[] args) {
		// 1차원 배열들 준비
		int[] ar1 = {10, 20, 30, 40};
		
		int[] ar2 = new int[3]; // 길이가 3인 ar2이름을 가진 배열, 값은 0이 들어있음
		int[] ar3 = new int[5]; // 길이가 5인 ar3이름을 가진 배열, 값은 0이 들어있음
		
		// 위 3개의 1차원배열들을 하나로 묶는 2차원배열을 만들자!
		
		int[][] ar = new int[3][];
		ar[0] = ar1;
		ar[1] = ar2;
		ar[2] = ar3;
		
		for(int i = 0; i < ar.length; ++i) {
			for(int j = 0; j < ar[i].length; ++j) {
				System.out.printf("%-3d", ar[i][j]);
			} // inner for
			System.out.println(); // 줄바꿈
		} // outer for
		
	}

}
