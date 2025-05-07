package am;

public class Ex7_For {

	public static void main(String[] args) {
		// 1~10까지의 합을구하는 반복문을 구현
		
		int sum = 0; // 반복문 안에서 사용된 i 의 값을 누적시킬 변수

		for(int i = 1; i <= 10; i++) { // 1~10까지를 반복하는 문
			System.out.println(i); // 반복하면서 증가하는 i 를 출력
			sum += i; // sum = sum+i, 증가하는 i의 값을 sum에 누적함
		}
		
		System.out.println("1~10까지의 합:" + sum);

	}

}
