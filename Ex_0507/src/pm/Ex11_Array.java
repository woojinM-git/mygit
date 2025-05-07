package pm;

public class Ex11_Array {

	public static void main(String[] args) {
		// 1차원 배열
		// 배열: 같은 자료형 여러 개를 하나로 묶은 것
		// 정수 6개를 저장할 수 있는 배열준비
		int su1 = 0;
		int su2 = 0;
		int su3 = 0;
		int su4 = 0;
		int su5 = 0;
		int su6 = 0;
		// 위는 변수들을 한번에 여러 개를 만든 것
		// 모아둔 것은 아니다
		int[] ar = new int[6]; // []배열기호를 꼭 붙여주기
		// new = 기존꺼를 무시하고 새로 만들어줘
		for(int i = 0; i < 6; i++) { // index = 절대적으로 0부터 시작
			ar[i] = (int)(Math.random()*45+1); // 1~45중 난수 발생
		} // for 끝
		System.out.println("----------------배열출력----------------");
		
		for(int i = 0; i < 6; i++) {
			System.out.printf("%-3d", ar[i]);
		}
		
	}

}
