package am;

public class Ex1_Main {

	public static void main(String[] args) {
		// 원하는 객체 Ex1_Test를 생성하자!
		
		Ex1_Test t1 = new Ex1_Test(); // new 뒤에 오는것은 생성자
		t1.setName("SiST"); // t1 name에 SiST 저장
		t1.setAge(30); // t1 age에 30 저장
		
		Ex1_Test t2 = new Ex1_Test("마루치", 17); // 생성했던 인자의 순서를 지켜서 다시 불러야 한다
		
		
		System.out.printf("t1.name: %s, t1.age: %d\r\n", t1.getName(), t1.getAge()); // t1에는 name에 SiST, age에 30 저장
		System.out.printf("t2.name: %s, t2.age: %d\r\n", t2.getName(), t2.getAge()); // t2에는 name에 마루치, age에 17 저장
		
		t2.setName("마루");

		System.out.printf("t2.name: %s, t2.age: %d\r\n", t2.getName(), t2.getAge()); // t2 name: 마루
		
	}

}
