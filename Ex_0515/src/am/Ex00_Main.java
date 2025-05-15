package am;

import java.util.Scanner;

public class Ex00_Main {

	public static void main(String[] args) {
		Ex00_Machine m1 = new Ex00_Machine();
		Scanner scan = new Scanner(System.in);
		
		m1.setAr(); // 음료수 정보들을 저장
		
		System.out.println("Insurt coin: ");
		int input = scan.nextInt();
		
		String coin = m1.payit(input); // 700을 받으면
		
		System.out.println(coin); // 1.레츠비 2.사이다 3.콜라
		
		System.out.println("Choose one plz: ");
		int num = scan.nextInt(); // 두번째 입력 : 선택
		
		String choose = m1.choice(num);
		
		System.out.println(choose);
//		System.out.println("잔돈은 " + (input - ) + "원 입니다");
//		System.out.println("잔돈을 받으시려면 1을 입력해주세요");
//		String change = m1.change(num);
//		
//		System.out.println(change);


	}

}
