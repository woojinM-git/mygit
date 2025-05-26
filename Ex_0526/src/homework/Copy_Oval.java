package homework;

import java.awt.Color;

// 클릭할 때마다 생성되는 타원을 의미하는 클래스
public class Copy_Oval extends Thread {
	int x, y;
	int width, height;
	Color bg;
	int speed;
	
	Copy_Main f; // Ex1_Frame안에 있는 p를 접근하여
				// 필요할 때 p에게 다시 그림을 그리도록 해야 하기 때문에
				// p를 가지고 있는 객체 Ex1_Frame의 주소를
				// 현재 객체가 생성될 때 받아야 한다.
	
	public Copy_Oval(Copy_Main f, int x, int y) {
		this.f = f;
		
		width = 30;
		height = 30;
		this.x = x-(width/2)+40; // 클릭한 지점을 타원 가운데로 맞추기 위해
		this.y = y;
//		speed = (int)(Math.random()*1000);
		
		
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		bg = new Color(red, green, blue);
	}

	@Override
	public void run() {
		// 현재 스레드는 JPanel의 높이값에서 -100(height) 값을 뺀 값까지를
		// y 좌표의 한계점으로 본다.
		while(true) { // 무한반복
			y -= 5;
			
			// JPanel의 높이값과 y의 값을 비교한 후
			// 무한반복을 탈출할지? 말지? 판단!!!!
			if(y == 0) { // p의 높이 - 그림의 높이(변수 height)
				break; // 무한반복 탈출하면서 스레드 소멸
			}
			
			// JPanel의 그림을 다시 그리도록 한다.
			f.p.repaint();
			
			// 일정 시간동안 휴식
			try {
				Thread.sleep(20); // 0.5초 동안 휴식
			} catch (Exception e) {
				// TODO: handle exception
			}
		} // while end
		// 스레드 소멸 직전
		// 현재 객체가 저장된 ArrayList에서 자신을 삭제
//		f.al.remove(this); // 현재 객체가 지워져야하기에 this를 한다
//		f.p.repaint();
		
	}
	
}