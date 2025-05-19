package am;

public class Ex01_Main {

	public static void main(String[] args) {
		// 원하는 객체 생성
		Ex01_Value a = new Ex01_Value();
		
		int value = 100; // 인자로 전달할 값
		
		// value값을 넣어서 a의 test함수 호
		a.test(value);
		
		System.out.println(value); // 100
		
//		 Call by Value(값) 개념 = 기본자료형을 인자로 잡으면
//
//			**함수에 값을 전달할 때 값을 복사해서 전달하는 방식**
//
//			(함수 내에서 매개변수를 변경해도 원본 변수의 값에는 영향을 미치지 않는다. 
//   		함수에 전달되는 값은 원본이 아닌 복사된 값이기 때문)
	}

}
