package am;

public class Ex02_Main {
	
	public void test(Ex02_Inter n) {
		// Ex02_Inter를 구현한 객체들은 모두 getValue를 재정의하고 있음을
		// 알고 있기 때문에 이안에서 무조건 getValue를 호출하자!
		System.out.println(n.getValue());
	}

	public static void main(String[] args) {
		// 인터페이스는 추상메서드(미완성적 개념)이 있어 직접
		// 인스턴스를 생성할 수 없다.
		// Ex02_Inter inter = new Ex02_Inter(); // 생성 불가능 (오류)
		
		// 인터페이스는 다른 클래스로부터 구현하도록 해야 한다.
		Ex02_Class t1 = new Ex02_Class();
		
		Ex02_Impl t2 = new Ex02_Impl();
		
		// test 함수를 호출하기 위해 Ex02_Main 생성하자
		Ex02_Main main = new Ex02_Main();
		main.test(t1); // 110
		main.test(t2); // 2000
		
	}

}
