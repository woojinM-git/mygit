package am;

import javax.swing.JFrame;

public class Ex1_Frame extends JFrame {

	Ex1_Panel p;
	
	public Ex1_Frame() {
		add(p = new Ex1_Panel()); // 가운데에 p 객체 생성 후 추가
		p.setFocusable(true); // 포커스를 잡아준다
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		
		// 이벤트 감지자
		addWindowListener(new Ex1_WinAdap());
		p.addKeyListener(new Ex1_KeyAdap(this));
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex1_Frame();

	}

}
