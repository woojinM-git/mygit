package am;

public class Ex6_Oper {

	public static void main(String[] args) {
		
		// 대입연산자: =, +=, -=, *=, /=, %=
		// 우선순위가 가장 낮다
		
		int a = 7;
		int b = 5;
		
		int c = 0;
		c += a; // c = c + a;
		System.out.println("c + a = " + c); // 7
		
		c += b; /// c = c + b;
		
		System.out.println("c + b = " + c); // 12
		
		c *= b; // c = c * b;
		System.out.println("c * b = " + c); // 60
		
		c /= a; // c = c / a;
		System.out.println("c / a = " + c); // 8

		// 연산자 종류
		
//		산술연산자 + - * / %
//		비교연산자 >(크다) <(작다) =(같다) >=(크거나 같다)
//		논리연산자 &&(AND) ||(OR)
//		증감연산자 ++ -- 
//		삼항연산자 (조건)? (참) : (거짓)
//		대입연산자 == += -= *= /= %=
//		비트연산자 & | 
//		부정연산자 !=
	}

}
