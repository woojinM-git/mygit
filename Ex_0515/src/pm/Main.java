package pm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Comp c1 = new Comp();
		
		ArrayList<Emp> a1 = new ArrayList<>();
		Emp e1 = new Emp("사번", "이름", "직책", "부서");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("선택: "); 
		System.out.println("사번검색: 1, 이름검색: 2, 직책검색: 3, 부서검색: 4");
//		Emp emp1 = new Emp("홍길동", "청소", "클린", 1985);
//		Emp emp2 = new Emp("둘리", "요리", "주방", 1003);
//		Emp emp3 = new Emp("또치", "백수", "집지키미", 1998);
//		Emp emp4 = new Emp("도우너", "배달", "배민", 1990);
		
		int input = scan.nextInt();
		
		
		String num = c1.choose(input);
//		String num = com.choose(input);
	}

}
