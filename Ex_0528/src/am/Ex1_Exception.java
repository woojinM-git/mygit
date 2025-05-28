package am;

import java.util.Scanner;

public class Ex1_Exception {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// catch는 여러번 사용 가능 왜?
		// 무슨 오류가 생길지 모르기 때문 
		
		int v1 = 100;
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 입력: ");
		int v2 = scan.nextInt();
		try {
			int res = v1/v2;
			
			if(v2 == 1)
				return;
			
			System.out.printf("%d/%d=%d\n", v1, v2, res);
		
		}catch(ArithmeticException e) {
			v2 = 1;
			int res = v1/v2;
			System.out.printf("%d/%d=%d\n", v1, v2, res);			
		}catch(Exception e) {
			// 혹시나 다른 예외가 발생할 것을 우려한 catch
			System.err.println("혹시나~~!");
		}finally {
			// 예외발생 여부에 대해 상관없이 무조건 수행
			System.out.println("Finally~~");
		}
		
		System.out.println("프로그램 끝!");
		
	}

}
