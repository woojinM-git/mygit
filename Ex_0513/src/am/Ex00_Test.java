package am;

import java.util.Scanner;

public class Ex00_Test {

	public static void main(String[] args) {
		// 배열끼리 비교해야 하기때문에 배열을 2개 준비
		int[] game = new int[3];
		int[] user = new int[3];
		
		int strike_count = 0; // 이 변수가 3이 될 때 프로그램 종료
		int ball_count = 0;
		int cnt = 0; // 시도한 회차수
		
		// 키보드로 부터 입력 받기 위한 스케너 준비
		Scanner scan = new Scanner(System.in);
		
		// 컴퓨터가 가지는 수를 정하는 반복문 - 중복되면 안됨
		for(int i = 0; i < game.length;) {	// 중복을 확인하고 나중에 i 증가해야함
			game[i] = (int)(Math.random()*9+1);		// game[i]번째에 난수 발생
			boolean chk = true;		// 불리언으로 true를 지정
			for(int j = 0; j < i; ++j) {	// i에 들어간 값을 j가 상승하면서
				if(game[j] == game[i]) {	// i와 j가 같은 값이 존재한다면
					chk = false;	// chk를 false로 변경하고
					break;	// 반복문을 빠져나가 아래로 내려간다
				}
			}
			if(chk) {		// chk가 true라면 
				++i;		// i 증가
			}
		}
		System.out.printf("%-2d, %-2d, %-2d", game[0], game[1], game[2]);
		System.out.println();
		// 사용자로 하여금 입력하도록 유도 한다. - 반복수행 하는 것이 좋음
		do {	// do = 우선 while 위의 입력된 값을 모두 실행
			
			++cnt;
			System.out.println(cnt + "차 : ");	// cnt(1)을 1 증가시키면서 차 : 를 붙여 출력
			String str = scan.nextLine();	// str에 입력값을 받음
			for(int i = 0; i < str.length(); i++) {	// str을 한번씩 증가하면
				char ch = str.charAt(i);	// 하나씩 빼서 ch에 해당하는 자리의 수를 담음
				user[i] = ch-48; // '1'이 코드값으로 49이므로 48을 빼면 1이 user[i]번째에 저장
			} // 문자형 숫자 -48(0의 코드값) = 숫자가 됌
		
			// 스트라이크 카운트하는 반복문: 같은 자리의 값들만 비교한다
			strike_count = 0;
			for(int i = 0; i < game.length; ++i) { // game배열의 길이만큼 반복
					if(game[i] == user[i]) {	// 컴퓨터의 값과 유저의 값이 같은지만 비교
						strike_count++;		// 만약 같은 자리의 값이 같다면 ++
					}	// 이 값이 다 채워지면 while을 만족하게 됌
			}

			// 볼 카운트하는 반복문
			ball_count = 0;
			for(int i = 0; i < game.length; ++i) {	// 배열의 길이만큼 반복
				if(user[i] == game[(i+1)%game.length]) { // user[i]의 값이 game[(i+1)%3] 과 같은지 비교
					ball_count++;	// 같다면 ball_count를 1 증가
				}else if(user[i] == game[(i+1)%game.length]) { // user[i]의 값이 game[(i+2)%3] 과 같은지 비교
					ball_count++;	// 같다면 ball_count를 1 증가
				}
			}
			System.out.printf("%d: 스트라이크, %d: 볼\r\n", strike_count, ball_count);
			System.out.println();
		}while(strike_count != 3);	// strike_count가 3이 되면 종료
		
		System.out.println(cnt + "회차에 성공");
		
	}
}