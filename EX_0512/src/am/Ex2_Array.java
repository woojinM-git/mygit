package am;

public class Ex2_Array {

	public static void main(String[] args) {
		// 2차원 배열을 생성하자!
		int[][] ar = new int[2][3]; 
		
		for(int i = 0; i < ar.length; ++i) { // 2차원 배열의 길이를 반복 수행
			for(int j = 0; j < ar[i].length; ++j) {
				// 각 1차원 배열을 반복하는 반복문
				System.out.printf("%-2d", ar[i][j]);
			} // 안쪽 for의 끝
			System.out.println(); // 1차원 배열 하나 끝나면 줄바꿈
		} // 바깥쪽 for의 끝

		// 바깥 for = 행의 반복 / 안 for = 열의 반복
	}

}
