package pm;

public class Ex5_Main {

	public static void main(String[] args) {
		// 프로그램 시작
		Thread t1 = new Thread(); // run 함수가 비어있기 때문에 하는일이 없는 스레드
		t1.start(); // -> run() 수행
		
		Ex5_Thread t2 = new Ex5_Thread();
		t2.start(); // -> 해당 객체의 run() 수행
		
		System.out.println("메인스레드");
		
	}

}
