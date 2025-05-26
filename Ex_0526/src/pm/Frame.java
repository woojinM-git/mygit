package pm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

	JPanel p;
	Image background, gunship, missile;
	
	int bgY;
	int bgHeight;
	int shipX = 250;
	int shipY = 600;
	boolean end = true;
	
	// 스페이스바를 누를때마다 생성되는 총알객체(Thread)를 저장할 ArrayList
	ArrayList<Missile> al = new ArrayList<Missile>();
	
	// 배경을 움직이게 하는 스레드
	Thread t = new Thread() {

		@Override
		public void run() {
			while(end) {
				p.repaint(); // paintcomponent가 호출되며, 여기서 bgY가 증가함
				
				// 배경 위치 업데이트
				bgY += 2;
				if(bgY >= bgHeight) // 화면 아래에 도달한 경우
					bgY = 0; // 다시 초기값 0을 넣어서 위로 올린다
				try {
					Thread.sleep(30);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}// 무한반복
		}
		
	};
	
	public Frame() {
		
		background = new ImageIcon("src/images/space.jpg").getImage();
		gunship = new ImageIcon("src/images/gunship.png").getImage();
		missile = new ImageIcon("src/images/missile.png").getImage();
		
		p = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				Image buf = createImage(this.getWidth(), this.getHeight());
				
				Graphics buf_g = buf.getGraphics();
				
				// 배경 그리기
				bgHeight = background.getHeight(this); // 배경 이미지의 높이값
				buf_g.drawImage(background, 0, bgY, getWidth(), bgHeight, null);
				buf_g.drawImage(background, 0, bgY-bgHeight, getWidth(), bgHeight, null);
				
				// 비행기 그리기
				buf_g.drawImage(gunship, shipX, shipY, 60, 60, null);
				
				// 총알들 그리기 위해 필요한 반복문
				for(int i = 0; i < al.size(); i++) {
					Missile m = al.get(i);
					
					// 얻어낸 총알을 그린다.
					buf_g.drawImage(missile, m.m_x, m.m_y, m.m_w, m.m_h, this);
				}
				
				// 화면에 나타내기 위해 이미지를 패널에 붙여넣는다.
				g.drawImage(buf, 0, 0, this);
			}
			
		};
		add(p);
		p.setFocusable(true); // 패널을 활성화
		
		this.setBounds(300, 100, 600, 800);
		
		this.setVisible(true);
		
		t.start();
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 프로그램 종료
			}
		});
		p.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// 선택한 키의 코드값을 얻어낸다.
				int keyCode = e.getKeyCode();
				int step = 5;
				switch (keyCode) {
				case KeyEvent.VK_LEFT:
					shipX = Math.max(shipX - step, 0); // 둘 중에 최대값 줘
					break;
				case KeyEvent.VK_RIGHT:
					shipX = Math.min(shipX + step, p.getWidth() - 60);
					break;
				case KeyEvent.VK_UP:
					shipY = Math.max(shipY - step, 0);
					break;
				case KeyEvent.VK_DOWN:
					shipY = Math.min(shipY + step, p.getHeight() - 60);
					break;
				case KeyEvent.VK_SPACE:
					Missile m = new Missile(Frame.this, shipX+(gunship.getWidth(p)/2 - (19/2)), shipY - gunship.getHeight(p));
				
					al.add(m); // arrayList에 추가
					m.start();
					break;
				} // switch 끝
				p.repaint(); // 비행선의 좌표가 변경되었으니 그림을 다시 그림
			}
			
		});
			
	} // 생성자 끝
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Frame();

	}

}
