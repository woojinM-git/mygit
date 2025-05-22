package am;

public abstract class Ex1_Abs {
	// 추상클래스는 클래스가 abstract로 선언된 클래스를 말한다.
	// 내부에 추상메서드를 하나라도 가지면 해당 클래스는
	// abtract 로 선언되어야 한다.
	
	String msg; // 변수 선언
	final int V100 = 100;
	
	public int getV100() { // 일반 메서드
		return V100;
	}
	
	public void print() { // Empty Method
		
	} // 만약 추상클래스를 만들지 않고 Empty Method를 만들어 둔다면 
	// 해당 함수를 재정의해도 되고, 안해도 되고 라는 의미
	
	public abstract void test(); // 추상메서드 - 미완성적 개념
	// 추상메서드가 포함되어있는 클래스는 사용하기 위해서는
	// 추상메서드를 모두 오버라이딩(재정의)를 해서 사용해야 한다
}
