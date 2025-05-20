package am;

public class Ex03_Main {

	public void test(Ex03_Inter n) {
		n.print();
		n.testValue();
		// n.getValue(); // 오류 이유는 현재 메서드로 들어오면서
		// 사용범위가 Ex03_Inter로 변경되어 getValue는 없기 때문이다
	}
	
	public static void main(String[] args) {
		
		Ex03_Class t1 = new Ex03_Class();
		
		Ex03_Impl t2 = new Ex03_Impl();
		
		// 현재클래스가 가지고 있는 test함수를 호출하기 위해
		// 현재객체 생성
		Ex03_Main main = new Ex03_Main();
		main.test(t1);
		System.out.println("-----------------------");
		main.test(t2);

	}

}
