package pm;

public class Ex6_Array {

	public static void main(String[] args) {
		// 문자열형 4개를 저장할 수 있는 배열 생성
		String[] a1 = new String[4];	// 주소값이 없기때문에 NULL 값이 들어가 있음
		
		// 초기화
		a1[0] = "값1"; // 암시적 객체 생성
		a1[1] = new String("값1"); // 명시적 객체 생성, 기존의 값을 무시하고 새로운 값 만들어냄
		a1[2] = new String("값3");
		a1[3] = "값4"; // 암시적 객체 생성

		String[] a2 = {"val1", "val2", "val3", "val4"};
		
		// a1과 a2라는 1차원 배열을 한곳에 모아두는 2차원 배열을 만들자
		String[][] ar = new String[2][4];
		
		// 준비된 2차원배열 각 요소에 a1과 a2를 저장하자
		ar[0] = a1;
		ar[1] = a2;
		
		// 이제 다시 2차원 배열을 생성하자 이때 초기값들을
		// 다음과 같이 하고자 한다면 선언, 생성, 초기화를 한번에 하면 된다
		/*
		 	v1 v2 v3 v4
		 	n1 n2 n3 n4
		 */
		String[][] ar2 = {		// 2차원 배열을 선언, 생성, 
			{"v1", "v2", "v3", "V4"}, 
			{"n1", "n2", "n3", "n4"}
		};
		
		// 위의 2차원 배열들을 하나로 묶을 수 있는 3차원 배열을 준비하자
		String[][][] ar3 = new String[2][2][4];
		
		ar3[0] = ar; //3차원 배열의 첫번째 요소에 2차원 배열 ar을 저장
		ar3[1] = ar2;
		
		
		
		for(int i = 0; i < ar3.length; ++i) { // 3차원 배열에 저장된 2차원 배열을 반복할 for
			
			System.out.println("2차원배열" + (i+1));
			for(int j = 0; j < ar3[i].length; ++j) { // 2차원 배열에 저장된 1차원 배열을 반복
				System.out.print("\r\n\t"); // 줄바꿈 후 탭을 누른 것
				for(int k = 0; k < ar3[i][j].length; ++k) { // 1차원 배열 반복
					System.out.printf("=> %-5s", ar3[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}

	}

}
