package am;

public class Ex4_Array {

	public static void main(String[] args) {
		// 정수 3개짜리 배열을 생성하자!
		int[] ar1 = new int[3]; // 배열을 생성하는 문장
		System.out.printf("%d, %d, %d", ar1[0], ar1[1], ar1[2]);
		
		/*
		 ar1[0] = 10;
		 ar1[1] = 20;
		 ar1[2] = 30;
		 */
		System.out.println();
		for(int i = 0; i < ar1.length; ++i) { // i < ar1.length 지정한 배열의 길이만큼 반복
			ar1[i] = (i+1)*10;
		}
		System.out.printf("%d, %d, %d", ar1[0], ar1[1], ar1[2]);
		
		
	}

}
