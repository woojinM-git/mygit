package pm;

public class Ex8_loto {

	public static void main(String[] args) {
		// 정수 6개를 기억하는 배열 생성!
		int[] loto = new int[6];
		
		// 중복 제거
		// 현재 진행하고 있는 반복문과 이미 값이 나온 반복문을 비교하는 반복문을 만들고
		// 값이 같다면 i값 증가 안함
		// loto[i] 보다 작은 loto[i] 들을 비교하는 반복문
		// 만약 같다면 i값을 증가하지 않고 다시 난수를 발생
		// 난수를 다시 발생시키고 값이 같지 않다면 i++
		
		// 난수 발생하여 배열 채우기
		for(int i = 0; i < loto.length; ++i) {
			loto[i] = (int)(Math.random()*45+1);
				for(int j = 0; j < i; ++j) {
					if(loto[j] == loto[i]) { // i(2) = 26, j(2)
						System.out.println("일치해서 다시 돌림");
						--i;
					}
				}
		}
		System.out.printf("%d, %d, %d, %d, %d, %d", loto[0], loto[1], loto[2], loto[3], loto[4], loto[5]);

		//System.out.printf("%-3d, ", loto[i]);	// System.out.printf("%-3d", ar[i]);
	}

}
