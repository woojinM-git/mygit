package am;

public interface Ex02_Inter {
	// 상수와 추상메서드만 정의할 수 있다.

	
	final int MAX_VALUE = 100; // 상수는 이름을 모두 대문자로 표기한다.
	
	// 추상메서드는 일반메서드와 달리 body를 가지지 못한다.
	public int getValue(); // 추상메서드
}
