package am;

public class Ex2_Switch {

	public static void main(String[] args) {
		// 프로그램 시작
		// switch 문의 구성
		/*
		 * switch(조건값){
		 * 	case 비교값1:
		 * 		조건값이 비교값1 같을 때 수행;
		 * 		break;
		 * 	case 비교값2:
		 * 		조건값이 비교값2 같을 때 수행;
		 * 		break;
		 * 		.....
		 * 		.....
		 * 	case 비교값n;
		 * 		조건값이 비교값n 같을 때 수행;
		 * 		break;
		 * default: 
		 * 		조건값과 모든 비교값이 같이 않을 때 수행;
		 * 		(마지막에는 break 문 생략 가능)
		 * }
		 * 
		 * 문제) 1~3까지의 수들 중 난수를 발생시켜 su라는 변수에 저장하자
		 * 난수가 1일 경우엔 "초급" 출력
		 * 난수가 2일 경우엔 "중급" 출력
		 * 난수가 3일 경우엔 "고급" 출력
		 */
		
		int su = (int)(Math.random()*3+1);
		
		switch(su) {
			case 1:
				System.out.println("초급");
				break;
			case 2:
				System.out.println("중급");
				break;
			case 3:
				System.out.println("고급");
				break;
		}
		System.out.println("-----------------------------------");
		if(su == 1)
			System.out.println("초급");
		else if(su == 2)
			System.out.println("중급");
		else if(su == 3)
			System.out.println("고급");
		else 
			System.out.println("잘 못된 값");
	}

}
