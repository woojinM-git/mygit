package pm;

import java.util.Arrays;
import java.util.Collections;

public class Ex6_Array {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 정수 5개를 저장하는 배열을 만들자!
		int[] ar = new int[5]; // ar 안에 길이가 5 인 배열을 새로 만든다
		
		// 외부로부터 배열의 값을 받았다고 가정하자
		ar[0] = 27;
		ar[1] = 9;
		ar[2] = 46;
		ar[3] = 17;
		ar[4] = 33;
		
		// 정렬을 시키기 위해 java.util.Arrays객체가 필요함
		// 기본자료형 -> 자바에서 제공해준 자료
		// Arrays.sort(ar); // 오름차순 - 1만건 이하면 이게 나쁘지 않다.
		Arrays.parallelSort(ar); // 배열이 크고(10만 이상 또는 천만 이상)
			// 그 안에 있는 값들이 뒤죽박죽인 경우 parallelSort가 빠르고
			// 배열의 크기가 작고 정렬이 된 경우는 sort가 빠르다.
		
		// *****************내림차순은 알아오기***************
		
		for(int i=0; i<ar.length; ++i) {
			System.out.printf("%-3d", ar[i]);
		}
		System.out.println("\n------------------------------------");
		// 내림차순을 정렬 시키기 위해서는 java.util.Collections객체가 필요함
		// Collections는 기본자료형 배열로 하지 말고 객체자료형 배열로
		// 해야 한다. int[] --> Integer[]
		Integer[] ar1 = new Integer[5]; // 객체자료형
			ar1[0] = 27;
			ar1[1] = 9;
			ar1[2] = 46;
			ar1[3] = 17;
			ar1[4] = 33;
		
		Arrays.parallelSort(ar1, Collections.reverseOrder());
		
		for(int i = 0; i < ar1.length; ++i) {
			System.out.printf("%3d", ar1[i]);
		}
			
		// 실수형(float, double) 5개를 저장하는 배열
		double[] ar2 = new double[5]; // 기본자료형
		Double[] ar3 = new Double[5]; // 객체자료형
		
		// 자료형
		char c = 'A'; // 기본자료형
		Character c2 = c; // 객체자료형
		
		boolean b = true; // 기본자료형
		Boolean b2 = true; // 객체자료형
		
			
	}
		
}
