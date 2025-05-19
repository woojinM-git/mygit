package am;

public class Ex02_Main {

	public static void main(String[] args) {
		// 원하는 객체 생성
		Ex02_Ref b = new Ex02_Ref();
		
		int[] ar = new int[3];
		ar[0] = 100;
		ar[1] = 200;
		ar[2] = 300;
		
		// b 객체가 가지는 test함수를 호출하면서
		// 인자로 ar을 전달하자!
		b.test(ar);
		
		System.out.println(ar[0]);
		
//		Call by Reference(참조) 개념 = 참조(객체)자료형을 인자로 잡으면
//
//				**함수 호출 시 인수로 전달되는 변수의 참조 값(주소)을 함수 내부로 전달하는 방식**
//
//				(이 방식에서는 함수 내에서 인자로 전달된 변수의 값을 변경하면, 호출한 쪽에서도 해당 변수의 값이 변경된다)
	}

}
