package am;

public class Ex03_TestRef {
	
	// test 함수를 호출하기 위해서는 반드시 인자를
	// Ex03_Member 객체의 주소를 넣어야 한다.
	
	public void test(Ex03_Member n) {
		n.setName("쌍용교육센터");
	} // 함수의 끝을 만나면
	// 호출한 곳으로 돌아간다. 이떄
	// 지역 변수인 n 은 소멸된다.
}
