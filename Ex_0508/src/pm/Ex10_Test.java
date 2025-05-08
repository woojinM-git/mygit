package pm;

public class Ex10_Test {

	public static void main(String[] args) {
		// 예제
		
		int count = 0; // 지역 변수 선언
		
		String msg = ++count + "little,  " + ++count + "little,  " + count + "little Indian"; // 객체 생성
// 																																	 - 암시적 생성
		// 메모리 관리적으로 매우 안좋은 작성법
		System.out.println(msg);

	}

}
