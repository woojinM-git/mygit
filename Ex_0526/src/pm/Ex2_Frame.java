package pm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex2_Frame extends JFrame {

	JPanel p;
	int w = 80; // 상자의 너비
	int h = 30; // 상자의 높이
	int x, y; // 상자의 위치
	
	// 스페이스바를 누를때마다 생성되는 총알객체(Thread)를 저장할 ArrayList
	ArrayList<Ex2_Bullet> al = new ArrayList<Ex2_Bullet>();
	
	public Ex2_Frame() {
		this.add(p = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// 더블버퍼링 기법 - 현 JPanel과 같은 크기의 Image 객체 준비
				Image buf = createImage(this.getWidth(), this.getHeight());
				
				// 준비된 이미지 객체에만 그림을 그릴 수 있는 붓객체 준비
				Graphics buf_g = buf.getGraphics();
				
				buf_g.fillRect(x, y, w, h);
				
				// 총알들 그리기 위해 필요한 반복문
				for(int i = 0; i < al.size(); i++) {
					// 총알객체를 ArrayList로부터 하나씩 얻어내어 b라는 변수에 저장
					Ex2_Bullet b = al.get(i); // al.get(i) **************************************************
					
					// 얻어낸 총알을 그린다.
					buf_g.fillRect(b.x, b.y, b.w, b.h);
				}
				
				// 이렇게 그려진 Image를 다시 현 JPanel에 이미지를 놓는다.
				g.drawImage(buf, 0, 0, this);
				
			}
			
		});
		
		this.setBounds(300, 100, 600, 500);
		p.setFocusable(true);
		
		this.setVisible(true); // 창 보여주기
		// 상자의 위치를 잡아주기 위해 setVisible 이후에 x, y좌표를 지정해야 한다.
		x = p.getWidth()/2 - w/2;
		y = p.getHeight() - (h + 10);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 프로그램 종료
			}
		
		});
		p.addKeyListener(new KeyAdapter() {
			// 먼저 사용자가 누른 키의 값 얻기
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_SPACE:
					// 스페이스바를 누를 때마다 총알객체 생성
					Ex2_Bullet b = new Ex2_Bullet(Ex2_Frame.this, x+35, y-10);
					
					// 생성된 총알객체를 ArrayList에 저장
					al.add(b);
					
					// 총알은 스스로 올라가기 위해 Thread로 부터 상속 받았다.
					b.start();
					break;
				case KeyEvent.VK_RIGHT:
					x += 5;
					if(x > p.getWidth()-w) 
						x = p.getWidth()-w;
						break;
				case KeyEvent.VK_LEFT:
					x -= 5;
					if(x < 0) 
						x = 0;
						break;
				} // switch end
				p.repaint(); // 그림 다시 그리기
			}
			
		});
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex2_Frame();

	}

}
