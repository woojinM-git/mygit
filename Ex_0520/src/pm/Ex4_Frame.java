package pm;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Ex4_Frame extends JFrame implements WindowListener{ // implements 구현
	
	public Ex4_Frame() {
		setSize(500, 400);
		setLocation(300, 100);
		setVisible(true);
		
		// 이벤트 감지자 등록
		this.addWindowListener(this); // 현재 객체에서 WindowEvent가
		// 발생할 때마다 addWindowListener(this)로 지정된 this 에게
		// 해당 함수를 찾아서 호출한다. 예를 들어
		// 종료버튼( X )를 클릭하면 this(현재객체)에서 windowClosing이라는
		// 함수를 자동 호출한다.
	}

	public static void main(String[] args) {
		// 프로그램 시작
		Ex4_Frame f = new Ex4_Frame(); // new 다음에 오는 생성자
		

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 창의 종료버튼 (X) 을 클릭할 때 자동 호출되는 곳
		System.exit(0); // 지금 즉시 프로그램 종료!
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("아이콘화");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("비 아이콘화");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
