package pm;

public class Ex2_Main {

	public static void main(String[] args) {
		// 원하는 객체 생성(정수)
		Ex2_Test<Integer> t1 = new Ex2_Test<Integer>();
		t1.setValue(10000);
		
		System.out.printf("t1.getValue(): %d", t1.getValue());

		// 원하는 객체를 하나 더 생성(문자)
		Ex2_Test<String> t2 = new Ex2_Test<String>();
		// t2.setValue("10000"); // 허용할 수 없다.
		System.out.printf("t2.getValue(): %s", t2.getValue()); // String이라서 
		
		// 불린을 넣는 객체 생성
		Ex2_Test<Boolean> t3 = new Ex2_Test<Boolean>();

		
		// 실수를 넣는 객체 생성
		Ex2_Test<Float> t5 = new Ex2_Test<Float>();
		
		// 만약 소문자로 넣으면?
		Ex2_Test<Long> t6 = new Ex2_Test<Long>();
	}

}
