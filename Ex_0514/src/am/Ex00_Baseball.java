package am;

import java.util.Scanner;

public class Ex00_Baseball {

	public static void main(String[] args) {
		// 숫자야구게임을 하기 위해 필요한 객체(Ex00_Baseball) 준비
		Ex00_Baseball_class game = new Ex00_Baseball_class();
		// 컴퓨터가 가지는 수를 설정하자!
		game.initcom();
		
		// 컴퓨터가 가지는 수를 컨닝하는 문자
		String msg = game.getCom();
		System.out.printf("com: %s\r\n", msg);
		System.out.println("-------------------");
		
		// 키보드로부터 값을 받기 위해 스캐너 객체 생성
		Scanner scan = new Scanner(System.in);
		int cnt = 0;
		int s1 = 0;
		do {
			// 반복 수행하는 곳
			cnt++;
			System.out.printf("%d차: ", cnt);
			String input = scan.nextLine(); // 키보드로 부터 문자 한줄을 받음
			if(input.length() > 3) {
				System.out.println("3자 입력하셔야 합니다.");
				continue;
			}
			game.setUser(input); // 사용자가 입력한 문자열을 숫자화 시켜 user배열에 저장함
			
			s1 = game.countStricke(); // 스트라이크 수 받기
			int b1 = game.countBall(); // 볼 수 받기
			
			System.out.printf("%d차 시도", cnt);
			System.out.printf("\r\n%d 스트라이크, %d 볼\r\n", s1, b1);
			System.out.println("---------------------------");
		}while(s1 != game.com.length); // game.com.length = 3 배열 길이가 달라져도 알아서 바뀜
		System.out.printf("%d차에 성공", cnt);
		
	}
}