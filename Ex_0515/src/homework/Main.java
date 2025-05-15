package homework;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 자판기(Vending)객체 생성
		Vending v1 = new Vending(); 
		v1.init(); // 각 음료들이 배열에 생성되어 저장된다
	
		Scanner scan = new Scanner(System.in);
		System.out.println("insert coin: ");
		int coin = scan.nextInt();
		
		String msg = v1.inertCoin(coin);
		
		System.out.println(msg);
		
		System.out.println("선택: ");
		int num = scan.nextInt(); // 음료번호 선택
		
		msg = v1.change(num, coin);
		System.out.println(msg);
	}

}
