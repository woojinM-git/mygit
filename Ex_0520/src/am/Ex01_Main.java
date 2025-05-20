package am;

public class Ex01_Main {
	
	public void test(Ex01_Parent n) {
		n.myData(); // 사용범위가 부모로 재설정되었지만
		// myData함수는 재정의가 되었으므로 부모의 myData가 숨겨지고
		// Ex01_Child의 myData가 우선권을가져서 사용범위에서 벗어났다고 해도
		// myData만큼은 Ex01_Child의 함수로 호출된다.
	}

	public static void main(String[] args) {
		//원하는 객체 생성
		Ex01_Child c1 = new Ex01_Child();

		// test함수를호출하기 위해서
		// test함수를 가지고 있는 클래스를 객체 생성함
		Ex01_Main main = new Ex01_Main();
		main.test(c1); // c1이 가리키는 인스턴스에 Child가 있지만 상위요소에 Parent도 있기 때문이다
		
	}

}
