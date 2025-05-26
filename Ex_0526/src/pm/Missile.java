package pm;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Missile extends Thread {
	// 스페이스 바를 눌렀을 때 생성되는 총알객체를 의미하는 클래스다.
	int m_x, m_y;
	int m_w = 19;
	int m_h = 88;
	
	Frame f;
	
	public Missile(Frame f, int x, int y) {
		m_x = x;
		m_y = y;
		this.f = f;
	}

	@Override
	public void run() {
		while(true) {
			m_y -= 5;
			
			f.p.repaint();
			try {
				Thread.sleep(20);
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(m_y < 0) 
				break;
		} // while end
		f.al.remove(this);
		f.p.repaint();
	}
	
}
