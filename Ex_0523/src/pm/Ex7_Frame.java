package pm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex7_Frame extends JFrame {

	JPanel p;
	
	int x = 190;	// 시작 좌표
	int y = 170;	// 시작 좌표
	
	int cmd;
	
	final int up = 1;
	final int down = 2;
	final int right = 3;
	final int left = 4;
	
	Thread t1 = new Thread() {

		@Override
		public void run() { // 해야할 일을 마친 Thread 는 소멸됌
			// 해당 스레드가 해야할 일

			
			while(true) {
				int cmd = (int)(Math.random()*4 + 1);
				switch(cmd) {
					case up:
						y += 10;
						break;
					case down:
						y -= 10;
						break;
					case right:
						x += 10;
						break;
					case left:
						x -= 10;
						break;
			}
				if(x == 0 || y == 0 || x > p.getWidth()-80 || y > p.getHeight()-80)
					break;		
				try {
					Thread.sleep(500);
					p.repaint(); // 그림 다시 그리기
				} catch (Exception e) {
					// TODO: handle exception
				}
			} // while의 끝
		}
		
	};
	
	public Ex7_Frame() {
		
		p = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				Image buf = createImage(this.getWidth(), this.getHeight());
				
				Graphics buf_g = buf.getGraphics(); // 이미지에 그리는 전용 붓
				buf_g.setColor(Color.orange);
				
				buf_g.fillRect(x, y, 40, 40); // 이미지 객체에 사각형 그리기
				
				// 사각형이 그려진 이미지를 JPanel에 넣기
				g.drawImage(buf, 0, 0, this); // 여기서 this는 JPanel을 상속받는 익명객체다
			}
			
		};
		
		this.add(p);
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		
		// 이벤트 감지자 등록
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		this.addKeyListener(new KeyAdapter() {
			// keyAdapter를 상속받는 anonymous Inner class 영역
			@Override
			public void keyPressed(KeyEvent e) {
				
				// 누른 키의 코드값 받기
				int keyCode = e.getKeyCode();
				
				// 좌측 우측 방향키만 선별하는 비교문
				switch(keyCode) {
				case KeyEvent.VK_UP: // 위쪽 방향키
					y -= 5;
					if(y < 0)
						y = 0;
						break;
				case KeyEvent.VK_DOWN: // 아래쪽 방향키
					y += 5;
					if(y > p.getHeight() - 40)
						y = p.getHeight() - 40;
						break;
				case KeyEvent.VK_RIGHT: // 아래쪽 방향키
					x += 5;
					if(x > p.getWidth() - 40)
						x = p.getWidth() - 40;
						break;
				case KeyEvent.VK_LEFT: // 왼쪽 방향키
					x -= 5;
					if(x < 0)
						x = 0;
						break;
				} // switch end
				
				p.repaint(); // update -> paint 호출
			}
		});
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				
				if(keyCode == KeyEvent.VK_SPACE) {
					t1.start();
				}
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex7_Frame();

	}

}
