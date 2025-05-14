package am;

import java.util.Scanner;

public class Ex4_Insurt {

	public static void main(String[] args) {
		// 코인 go
		Ex4_Machine m1 = new Ex4_Machine();
		m1.setAr();
		Scanner scan = new Scanner(System.in);

		System.out.println("Insurt coin: ");
		int input = scan.nextInt();
		System.out.println("--------------------");
			
		int coin = m1.choose(input);
			
		System.out.println(coin);
			
	}

}
