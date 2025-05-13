package am;

import java.util.Scanner;

public class Ex1_Main {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// 키보드로 부터 컬러문자열을 받는다.
		System.out.println("입력 : ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		// Ex1_Color라는 객체가 필요하다고 가정하자, 그럼 가져와서 생성해야 한다.
		Ex01_Color c1 = new Ex01_Color();
		
		// 생성된 객체가 가지는 color 라는 변수를 출력하자
//		System.out.println(c1.color); // null = 사용할수 없는 값 / 문자형이 아님
		
		//c1이 가지고 있는 color의 값을 반환하는 동작을 호출하자
		String s1 = c1.getColor();
		System.out.println(s1);
		
		System.out.println("---------------키보드로 받은 값을 넣음------------------");
		// 키보드로 받은 색상 문자열을 setColor를 호출하면서 인자로 넣어준다.
		c1.setColor(str);

//		System.out.println(c1.color); // str의 값이 출력되어야 한다
		System.out.println(c1.getColor());
	}

}
