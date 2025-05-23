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

public class Ex6_Frame extends JFrame {

	JPanel p;
	
	int x = 190;	// 시작 좌표
	int y = 170;	// 시작 좌표
	
	Thread t1 = new Thread() {

		@Override
		public void run() { // 해야할 일을 마친 Thread 는 소멸됌
			// 해당 스레드가 해야할 일
			while(true) {
				x ++;
				if(x > p.getWidth() - 40)
					break;		
				try {
					Thread.sleep(10);
					p.repaint(); // 그림 다시 그리기
				} catch (Exception e) {
					// TODO: handle exception
				}
			} // while의 끝
		}
		
	};
	
	public Ex6_Frame() {
		
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
		
//		t1.start(); // 스레드 구동
		
		// 이벤트 감지자 등록
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
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
	} // 생성자의 끝
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex6_Frame();

	}

}
