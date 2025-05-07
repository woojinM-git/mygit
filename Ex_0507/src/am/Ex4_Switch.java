package am;

public class Ex4_Switch {

	public static void main(String[] args) {
		// 문제) 1~20까지의 수들 중 난수를 받아 su라는 변수에 저장한다.
		// su의 값이 짝수인지? 홀수인지? 를 판단하는 프로그램을
		// switch 문으로 구현하시오
		
		int su = (int)(Math.random()*20+1);
		
		switch(su%2) { // 식이 아닌 값이기 때문에 =만 들어가지 않으면 된다
			case 0:
				System.out.println(su + " = 짝수");
				break;
			case 1:
				System.out.println(su + " = 홀수");
		}

	}

}
