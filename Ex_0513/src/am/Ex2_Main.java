package am;

public class Ex2_Main {

	public static void main(String[] args) {
		// 프로그램 시작
		
		// Ex2_Pet 파일을 c1으로 지정하고 가져온다
		Ex2_Pet c1 = new Ex2_Pet();
		
		String name = c1.getName();
		int age = c1.getAge();
		
		// Ex2_Pet의 name을 반환하는 name 함수
		System.out.printf("Name: %s, Age: %d", name, age); // null
		
		// Ex2_pet의 age를 반환하는 age 함수
		// System.out.println(age); // 0
			
		// 값이 비어있는 값을 채워주기
		
		System.out.println("\n---------------------------------------------");
		
		// name = "도진이" 를 넣고
		c1.setName("도진이");
		name = c1.getName();
		
		// age = 8 을 넣는다
		c1.setAge(8);
		age = c1.getAge();
		
		System.out.printf("Name: %s, Age: %d", name, age);
		
		// System.out.println(age);
		
		System.out.println("\n------------------------------------------");
		Ex2_Pet p2 = new Ex2_Pet();
		
		p2.setName("바둑이");
		p2.setAge(5);
		String p1_name = p2.getName();
		int p1_age = p2.getAge();
		
		System.out.printf("p2Name: %s, p2Age: %d", p1_name, p1_age);
	}

}
