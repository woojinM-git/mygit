package pm;

public class Ex3 {

	public static void main(String[] args) {
		// 프로그램 시작
		// int형 미만들(byte, short) - 32비트 미만들 끼리 연산하면
		//							32비트로 자동 승격이 일어난다.
		byte b1 = 10;
		short b2 = 7;
		
		// b1과 b2를 더하여 새로운 변수 b3에 저장한다.
		int b3 = b1 + b2;
		System.out.println(b3);
		
		// 승격된 자료형을 강제로 형변환 시키는 법(CASTING)
		byte b4 = (byte)(b1 + b2);
		System.out.println(b4);
	}
}
