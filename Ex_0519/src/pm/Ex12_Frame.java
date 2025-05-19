package pm;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// 현재 객체는 Jframe으로부터 상속을 받았으므로
// 현재 객체를 생성하는 것이 바로 창틀을 만드는 것과 같다.
public class Ex12_Frame extends JFrame {
	
	// 현재 창 객체가 가지는 모든 것들을 멤버변수로 선언한다.
	private JButton bt1, bt2, bt3;
	
	public Ex12_Frame() {
		setTitle("버튼을 가진 창");
		
		// 버튼객체들 생성
		bt1 = new JButton("버튼1");
		bt2 = new JButton("버튼2");
		bt3 = new JButton("버튼3");
		
		// 현재 창(this)에 추가(add)해야 한다.
		this.add(bt1, BorderLayout.NORTH); // North영역에 bt1추가
		add(bt2, BorderLayout.CENTER); // 생략하면 CENTER
		this.add(bt3, BorderLayout.EAST); // EAST영역에 bt3추가
		
		setSize(500, 400);
		setLocation(300, 100);
		setVisible(true);
		
		// 종료버튼을 클릭할 때 프로그램 종료
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	} // 생성자의 끝
	
	public static void main(String[] args) {
		// 프로그램 시작
		Ex12_Frame f = new Ex12_Frame();

	}

}
