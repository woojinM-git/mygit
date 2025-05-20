package am;

public class Ex02_Class implements Ex02_Inter{

	private int v1 = 10;
	
	@Override
	public int getValue() {
		// 반드시 구현하겠다고 명시한 인터페이스의
		// 추상메서드 모두를 재정의 해야 한다.
		return MAX_VALUE + v1;
	}
	
	public void test() {
		System.out.printf("구현객체의 v1: %d\n", v1);
	}
	
}
