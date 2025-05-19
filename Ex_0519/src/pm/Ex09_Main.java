package pm;

public class Ex09_Main {

	public void test(Ex09_Parent p) {
		
		System.out.println(p.getValue());
	}
	
	public static void main(String[] args) {
		// 원하는 객체 생성
		Ex09_Child1 c1 = new Ex09_Child1();
		
		Ex09_Child2 c2 = new Ex09_Child2();
	
		// 5번 행에 있는 test 함수를 호출하기 위해 현재 Ex09_Main객체 생성
		Ex09_Main m = new Ex09_Main();
		m.test(c1); // 0
		m.test(c2); // 10
		
	}

}
