package am;

import java.util.Scanner;

public class Ex8_For {

	public static void main(String[] args) {
		// 문제 1) 키보드로부터 숫자를 하나 받아서 변수 v1에 저장한 후
		// 1부터 v1인 만큼 반복하여 합을 구하는 프로그램을 구현 
		
		// 문제 2) 10~50까지의 수들 중 난수를 발생하여 
		// 변수 su에 저장한 후 1부터 su인 만큼 반복하여 
		// 합을 구하시오
		
		// 문제 1)
		Scanner scan = new Scanner(System.in); // scanner 키보드 정수받기
		System.out.println("숫자 입력 : "); // 키보드로 받는 항목 생성
		
		int v1 = scan.nextInt(); 
		int sum = 0; // 누적을 위한 변수 선언
		
		for(int i = 1; i <= v1; i++) {
			sum += i; // 누적
		}
		System.out.println("1부터 " + v1 + "까지의 합 = " + sum);
		
		System.out.println("---------------------------------");
		
		// 문제 2)
		int su = (int)(Math.random()*41+10);
		sum = 0; // 변수 재사용 (선언X)
		for(int i = 1; i <= su; i++) {
			sum += i; // 누적
		}
		System.out.println("1부터 " + su + "까지의 합 = " + sum);
	}

}



