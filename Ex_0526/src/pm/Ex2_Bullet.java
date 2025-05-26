package pm;

public class Ex2_Bullet extends Thread {
	// 스페이스 바를 눌렀을 때 생성되는 총알객체를 의미하는 클래스다.
	
	int x, y; // 총알의 위치
	int w = 8, h = 20;
	
	Ex2_Frame f; // 이 주소가 있어야 ArrayList와 JPanel을 접근할 수 있다.
	
	public Ex2_Bullet(Ex2_Frame f, int x, int y) {
		this.f = f;
		// 총알이 생성되는 위치
		this.x = x;
		this.y = y;
		
	}
	
	
	@Override
	public void run() {
		// 현재 Thread가 해야할 일 (y 좌표 감소 - 그림 다시그리기)
	
		// 일정 시간동안 쉬면서 y 좌표를 감소하는 반복문
		while(true) {
			y -= 5;
			
			// 좌표가 변경되었으므로 그림을 다시 그리자
			f.p.repaint();
			if(y < 0)
				break; // 무한반복문 탈출
			try {
				Thread.sleep(20);
			} catch (Exception e) { }
		}// 무한반복 end
		// Thread가 소멸 직전이므로 f 에 있는 ArrayList에서 자신을 삭제한다.
		f.al.remove(this);
		f.p.repaint();
	}

	
	
}
