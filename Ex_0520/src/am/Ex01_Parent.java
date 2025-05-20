package am;

public class Ex01_Parent {
	
	int value;
	
	public Ex01_Parent(int n) { // 생성자 만들어서 기본생성자가 없음
		this.value = n;
	}
//	public Ex01_Parent() {} // 기본 생성자 지정
	
	public void myData() { // 메서드
		System.out.println("Parent myData");
	}
	public int getValue() { // 메서드
		return value;
	}
}
