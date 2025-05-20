package am;

public class Ex03_Impl implements Ex03_Inter {

	@Override
	public void print() {
		System.out.println("Ex03_Impl의 프린트");

	}

	@Override
	public void testValue() {
		System.out.println("Ex03_Impl의 테스트벨류");

	}
	
	// Ex03_Impl의 독단적 기능들
	public void getValue() {
		System.out.println("Ex03_Impl의 겟벨류");
	}

}
