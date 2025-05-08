package pm;

public class Ex6_Dowhile {

	public static void main(String[] args) {
		// do while문의 구성
		/*
		  	do{
		  		실행할 문장들;
		  	}while(조건식);		<-- 세미콜론 잊지말자
		  	
		  	앞서 배운 for와 while 문과 다르게 선처리,  후비교
		  	무조건 한번은 수행하는 형태다.
		  	
		  	'@'문자를 5번 반복하는 문장을 do while로 구현하자
		 */
		
		int i = 0;
		do {
			System.out.printf("%-2c", '@');
			++i;
			
			if(i%3==0) { // i 가 3이 되면 반복을 멈춘다(break)
				break;
			}
		}while(i<5);

		System.out.println("-----------------------------------------------------");
		// 1~10까지 반복 수행한다. 이때 3의 배수는 출력하지 않아야 한다.
		// do while을 사용하자
		
		i = 1;
		do {
			if(i%3!=0) { // i 를 3으로 나눈 값이 0이 아닐 때
			System.out.println(i); // true 면 이곳 문장을 출력한다
			}
			++i;		// if 문과 상관없이 무조건 수행해야 하므로 따로 구현해 준다.
		}while(i < 11);
		
		System.out.println("-----------------------------------------------------");
		// 1~10까지 반복 수행한다. 이때 3의 배수는 출력하지 않아야 한다.
		// do while을 사용하자
		
		int j = 0;
		do {
			++j;		// if 문과 상관없이 무조건 수행해야 하므로 따로 구현해 준다.
			
			if(j%3 == 0 || j > 10) // 3의 배수를 찾는다
				continue; // 다음 반복회차로 이동
			
			System.out.println(j); // true 면 이곳 문장을 출력한다
			
		}while(j < 11);
		
		/*
		 * 	제어문
		 * 
		 * 비교문
		 * 	if, switch
		 * 반복문
		 * for, while, do while
		 * 탈출문
		 * 	break, break Label
		 * continue 문
		 * 	다음 반복회차로 도라감
		 */
		
	}

}
