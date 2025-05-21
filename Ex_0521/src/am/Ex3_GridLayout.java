package am;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex3_GridLayout extends JFrame {

	JButton[] ar = new JButton[5];
	GridLayout gl; // GridLayout을 멤버변수 지정
	JPanel center_p;
	
	public Ex3_GridLayout() {
		center_p = new JPanel();
		gl = new GridLayout(3, 3, 100, 100); // 3행 3열, 즉 9개의 셀이 만들어 진다.
		center_p.setLayout(gl); // 기본레이아웃이 FlowLayout이었던 것을 
								// GridLayout으로 변경
		for(int i = 0; i < ar.length; i++) {
			ar[i] = new JButton(String.valueOf(i+1)); // String.valueOf() ()안의 숫자를 문자열 형태로 바꿈
			center_p.add(ar[i]); // center_p 에 버튼객체 추가
		}
		for(int i = 0; i < 3; i++) // 3행 3열의 모양을 유지하기 위해 공백을 JLable로 만들어서 추가
			center_p.add(new JLabel("이름")); // JLabel(): 기본적으로 왼쪽정렬이며 글씨를 넣을 수 있다
		
		this.add(center_p);
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex3_GridLayout();

	}

}
