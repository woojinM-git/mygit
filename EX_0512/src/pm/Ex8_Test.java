package pm;

import java.util.Scanner;

public class Ex8_Test {

	public static void main(String[] args) {
		// 3칸에 1~9까지의 수가 중복없이 들어간다
		/*
		 	1) 1차 3 4 5 입력 시 같은자리에 같은 숫자가 들어가면 스트라이크
		 	0 strike,
		 	2) 난수 발생한 숫자를 입력한 문자열과 비교하려면 정수형으로 변경해야함
		 	3) str.length 3을 넘어가면 안됌
		 */
		
		int[] game = new int[3];
		int[] user = new int[3];
		
		int strike_count = 0; // 이 변수가 3이 될 떄 프로그램 종료
		int ball_count = 0;
		int cnt = 1; // 시도한 회차수
		
		// 키보드로 부터 입력 받기 위한 스케너 준비
		Scanner scan = new Scanner(System.in);
		
		// 컴퓨터가 가지는 수를 정하는 반복문 - 중복되면 안됨
		for(int i = 0; i < game.length;) {
			game[i] = (int)(Math.random()*9+1);
			boolean chk = true;
			for(int j = 0; j < i; ++j) {
				if(game[j] == game[i]) {
					chk = false;
					break;
				}
			}
			if(chk) {
				++i;
			}
		}
		System.out.printf("%-2d, %-2d, %-2d", game[0], game[1], game[2]);
		System.out.println();
		// 사용자로 하여금 입력하도록 유도 한다. - 반복수행 하는 것이 좋음
		do {
			System.out.println(cnt++ + "차 : ");
			String str = scan.nextLine();
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				user[i] = ch-48; // '1'이 코드값으로 49이므로 48을 빼면 1이 user[i]번째에 저장
			}
			
			strike_count = 0; // 이 변수가 3이 될 떄 프로그램 종료
			ball_count = 0;
			// 스트라이크 카운트하는 반복문
			for(int i = 0; i < game.length; ++i) {
					if(game[i] == user[i]) {
						strike_count++;
					}else { // i와 j가 같지 않을때
						for(int j = 0; j < str.length(); ++j)
							if(game[i] == user[j]) {
								ball_count++;
								break;
							}
					}
				}
			// 볼 카운트하는 반복문
			System.out.printf("%d: 스트라이크, %d: 볼", strike_count, ball_count);
		}while(strike_count != 3);
		System.out.println("\n스트라이크 성공");
	}	
 }

