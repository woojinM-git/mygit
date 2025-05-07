package am;

public class Ex3_Oper {

	public static void main(String[] args) {

		int a = 10;
		int b = 7;
		
		boolean res = (10 >= a++) || (++b > 7);
		
		// 각 변수들 a, b, res 의 값을 예측하자면
		
		// a = 11
		// b = 8
		// res = true
		System.out.println(res);
		
		// 논리연산자는 먼저의 식이 true 라면 뒤의 식을 수행하지 않음
		// 먼저 식 10 >= a++(10) = true 식 후에 11로 바뀜
		// ++b > 7 연산을 하지않음
		// b = 7
		
		System.out.println(a);
		System.out.println(b);
		
		boolean res1 = (10 >= a++) || (++b > 7);
		System.out.println(res1);
		
		System.out.println(a);
		System.out.println(b);
	}

}
