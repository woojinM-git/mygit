package pm;

import java.util.Scanner;

public class Ex7_Array {

	public static void main(String[] args) {
		// 각 월에 마지막 날을 저장한 배열을 만든다
		// 2월 29일 고정
		int[] month_array = {31,29,31,30,31,30,31,31,30,31,30,31}; 
		// 선언, 생성, 초기화를 한번에
		
		// 키보드로 월을 입력 받아서 해당 월이 몇일까지 있는지?
		// 출력해보자!
		
		Scanner scan = new Scanner(System.in);
		String cmd = "n";
		do {
			// 월 입력을 유도하자!
			System.out.println("월 입력(1~12) : ");
			int month = scan.nextInt(); // 월 받기
			
			System.out.printf("%-3d월은 %d일까지 입니다.\n", month, month_array[month-1]);
			// month에 3을 입력한다고 하면 3월은 2(3빼기1)일까지 가 출력됌
			
			// 숫자는 month에 들어갔지만 엔터값은 아직 스케너에 남아있다.
			scan.nextLine();// 엔터값 처리
			System.out.println("계속 하시겠습니까?(y/n) : ");
			cmd = scan.nextLine();
			
		}while(!cmd.equalsIgnoreCase("n")); // n이 아닐 때 반복수행
		// equalsIgnoreCase = 대소문자를 구분하지 않음
		System.out.println("프로그램 종료!");
		
	}

}
