package am;

import java.util.Scanner;

public class Ex8_if {

	public static void main(String[] args) {
		// if를 사용하여 20대라면
		// "20대 입니다" 를 출력하시오
		// 조건1 : 키보드로 값을 받으시오
		// 조건2 : if문을 사용하시오
		
		Scanner scan = new Scanner(System.in);
		System.out.println("나이입력 : ");
		
		int age = scan.nextInt();
		
		if(age >= 20 && age < 30) {
			System.out.println("20대 입니다.");
		}else {
				System.out.println("20대가 아닙니다.");
		}
				
//		if (scan >= 20 && scan < 30) {
//			System.out.println("20개 입니다.");
//		}else {
//			System.out.println("20대가 아닙니다.");
//		}

		scan.close();
	}

}
