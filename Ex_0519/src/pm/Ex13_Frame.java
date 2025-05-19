package pm;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex13_Frame extends JFrame {
	
	private JButton bt1, bt2, bt3, bt4, bt5;
	
	public Ex13_Frame() {
		setTitle("버튼을 가진 창");
		
		bt1 = new JButton("버튼1");
		bt2 = new JButton("버튼2");
		bt3 = new JButton("버튼3");
		bt4 = new JButton("버튼4");
		bt5 = new JButton("버튼5");
		
		add(bt1, BorderLayout.SOUTH);
		add(bt2, BorderLayout.WEST);
		add(bt3, BorderLayout.CENTER);
		add(bt4, BorderLayout.NORTH);
		add(bt5, BorderLayout.EAST);
		
		setSize(500, 500);
		setLocation(300, 100);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// 프로그램 시작
		Ex13_Frame f = new Ex13_Frame();

	}

}
