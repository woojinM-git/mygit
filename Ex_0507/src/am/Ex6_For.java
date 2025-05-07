package am;

public class Ex6_For {

	public static void main(String[] args) {
		// 1~20까지 반복처리하는 반복문을 구현하자
		// 단, 3의 배수만 출력해야 한다
		
		int i = 1;
		
		for(i = 1; i <= 20; i++) { // 20번 반복수행
			if(i%3 == 0)
				System.out.print("-" + i + "-, ");
			else
				System.out.print(i + ", ");
		}
		System.out.println();
		System.out.println(i);
		
		System.out.println("---------------------------");
		for(int j = 3; j <=20; j+=3) { // 6번 반복수행
			System.out.print(j + ", ");
		}
		
	}

}
