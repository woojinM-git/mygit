package am;

public class Ex3_Array {

	public static void main(String[] args) {
		// 정수형 2차원 배열 생성
		int[][] ar = new int[3][4];
		// 길이가 4개짜리인 1차원 배열을 총 3개 저장하는 2차원 배열
		/*
		 	11 12 13 14
		 	15 16 17 18
		 	19 20 21 22
		
		ar[0][0] = 11;
		ar[0][1] = 12;
		ar[0][2] = 13;
		ar[0][3] = 14;
		
		ar[1][0] = 15;
		ar[1][1] = 16;
		ar[1][2] = 17;
		ar[1][3] = 18;
		
		ar[2][0] = 19;
		ar[2][1] = 20;
		ar[2][2] = 21;
		ar[2][3] = 22;
		
		위와 같은 초기화를 반복문을 이용하여 처리하자
		ar[i:바깥쪽 for문][j:안쪽 for문]
		*/
	
//		int j = 0;
//		int k = 0;
//		
//		
//		for(int i = 0; i < ar.length; ++i) {
//			for(j = 0; j < ar[i].length; ++j) {
//			}
//			for(k = 11; k < 23; ++k) {
//				
//			}
//			System.out.println("ar[" + i + "][" + j + "] = " + k);
//		}
		
		int value = 11;
		for(int i = 0; i < ar.length; ++i) { // ar.length : 2차원 배열에 대한 길이
			
			// 각 1차원 배열의 길이를 반복하는 반복문
			for(int j = 0; j < ar[i].length; ++j) { // ar[i].length : 1차원배열에 대한 길이
				ar[i][j] = value;
				value++;
				System.out.printf("%-3d", ar[i][j]); // 현재 진행중인 i행, j열 의 값 출력 
			} // 안쪽 for 문
			
			// 1차원 배열이 하나씩 반복처리가 끝날 때마다 줄바꿈
			System.out.println(); // 줄바꿈
		} // 바깥쪽 for 문
		
		
		

	}

}
