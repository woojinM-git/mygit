package pm;

import javax.swing.JFrame;

public class Ex11_Frame extends JFrame {

	public Ex11_Frame() { // 기본 생성자
		this.setTitle("내가 만든 창");
		
		// 현재객체(this)가 상속받아서 가지고 있는 setSize 호출
		this.setSize(500, 400);
		this.setLocation(500, 400);
		this.setVisible(true); // 창 보여주기
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 창을 종료하면 모두 소멸
	}	
	
	public static void main(String[] args) {
		// 프로그램 시작
		Ex11_Frame f = new Ex11_Frame();

	}

}
