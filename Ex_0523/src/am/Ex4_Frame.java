package am;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex4_Frame extends JFrame {
	
	JPanel p;
	
	int x = 210;
	
	public Ex4_Frame() {
		
		add(p = new JPanel() {
			// JPanel을 상속받는 anonymous Inner class 영역이다
			@Override
			protected void paintComponent(Graphics g) {
				Image buf = createImage(this.getWidth(), this.getHeight());
				// 현재객체(JFrame)의 너비와 높이를 준다
				
				Graphics buf_g = buf.getGraphics();
				
				int red = (int)(Math.random()*256);
				int green = (int)(Math.random()*256);
				int blue = (int)(Math.random()*256);
				Color c = new Color(red, green, blue);
				buf_g.setColor(c);
				
				buf_g.fillRect(x, 235, 180, 60); // buf라는 이미지에 사각형 그린다.
				
				// 사각형이 그려진 이미지 객체를 현재 JPanel에 넣는다.
				g.drawImage(buf, 0, 0, this);
			}
			
		});
		
		// 이벤트 감지자
		p.addKeyListener(new KeyAdapter() {
			// keyAdapter를 상속받는 anonymous Inner class 영역
			@Override
			public void keyPressed(KeyEvent e) {
				
				// 누른 키의 코드값 받기
				int keyCode = e.getKeyCode();
				
				// 좌측 우측 방향키만 선별하는 비교문
				switch(keyCode) {
				case KeyEvent.VK_LEFT: // 왼쪽 방향키
					x -= 5;
					if(x < 0)
						x = 0;
						break;
				case KeyEvent.VK_RIGHT: // 오른쪽 방향키
					x += 5;
					if(x > p.getWidth() - 80)
						x = p.getWidth() - 80;
						break;
				} // switch end
				
				p.repaint(); // update -> paint 호출
			}
		});
		
		p.setFocusable(true); // 포커스를 잡아준다
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		
		// 창 종료기능
		this.addWindowListener(new WindowAdapter() {
			// WindowAdapter를 상속받는 anonymous Inner class 영역
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex4_Frame();

	}

}
