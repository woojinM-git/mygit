package homework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import am.Ex1_Frame;
import am.Ex1_MyThread;

public class Copy_Main extends JFrame {

	int x = 220;
	int y = 350;
	JPanel p;
	ArrayList<Copy_Oval> al = new ArrayList<Copy_Oval>();
	
	public Copy_Main() {
		p = new JPanel() {
			// JPanel을 상속받는 익명의 내부클래스 영역이다.

			@Override
			protected void paintComponent(Graphics g) {
				// ArrayList에 있는 Ex1_MyThread 들을 하나씩 가져와서 그림을 그려야 한다.
				// 먼저 더블버퍼링을 위한 Image 객체 준비
				Image buf = createImage(this.getWidth(), this.getHeight());
				// 현재 영역에서 this는 JPanel을 상속받는 이름없는 내부객체를
				
				// buf에만 그림을 그릴 수 있는 전용 붓을 만들자
				Graphics buf_g = buf.getGraphics();
			
				buf_g.setColor(Color.ORANGE);
				buf_g.fillRect(x, y, 80, 30);

			
				for(int i = 0; i < al.size(); i++) {
					Copy_Oval mt = al.get(i); // al의 i 번째에 담겨있는 주소를 mt에 저장
					
					// 붓 색상을 변경
					buf_g.setColor(mt.bg);
					buf_g.fillOval(mt.x, mt.y, mt.width, mt.height);
					// buf_g는 Image buf 에 그림을 그리는 붓
				}
				
				// 임시 이미지객체에 타원을 모두 그린 상태다. 이제 이미지객체를
				// 현재 JPanel에 넣어야 한다.
				g.drawImage(buf, 0, 0, this); // 여기서 this는 그림이 그려졌는지 확인하는 부분
			}
			
		};
		
		this.add(p);
		
		this.setBounds(300, 100, 800, 500);
		this.setVisible(true);
		
		// 종료이벤트 감지자 등록
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 프로그램 종료
			}
		});
		
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				
				switch (keyCode) {
				case KeyEvent.VK_SPACE: {
					Copy_Oval m = new Copy_Oval(Copy_Main.this, Copy_Main.this.x, Copy_Main.this.y);
					al.add(m);
					m.start();
				}
				case KeyEvent.VK_LEFT: {
					x -= 5;
					p.repaint();
					if(x < 0)
						x = 0;
					break;
				}
				case KeyEvent.VK_RIGHT: {
					x += 5;
					if(x > p.getWidth()-80)
						x = p.getWidth()-80;
					break;
				}
			}
			}
		});
		
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Copy_Main();

	}

}