package pm;

public class Ex5_Thread extends Thread {

	@Override
	public void run() {
		// 해당 Thread가 해야할 일들
		for(int i = 0; i < 5; i++) {
			System.out.println("t2 수행");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // milli second 는 1/1000라서 1초는 1000를 해야한다
		} // for end
	}
	
}
