package am;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex2_FlowLayout extends JFrame implements ActionListener {

	JPanel north_p;
	JButton bt1, bt2, bt3;
	
	public Ex2_FlowLayout() { // 생성자는 객체가 생성될때 단 한번 호출되면서
						// 멤버변수들에 대한 초기화를 목적으로 한다.
		north_p = new JPanel();
		bt1 = new JButton("Left");
		bt2 = new JButton("Center");
		bt3 = new JButton("Right");
		
		north_p.add(bt1);
		north_p.add(bt2);
		north_p.add(bt3);
		
		// 버튼 3개를 가지는 north_p를 현재 창의 North영역에 추가
		this.add(north_p, BorderLayout.NORTH);
		
		setBounds(300, 100, 500, 400); // x, y, w, h
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료
		
		// 이벤트 감지자 등록
		bt1.addActionListener(this); // 인자는 ActionListener를 구현한 객체의 주소
		bt2.addActionListener(this); 
		bt3.addActionListener(this); 
		
	} // 생성자 끝
	
	public void create() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 각 버튼을 클릭할 때마다 수행하는 곳
		String str = e.getActionCommand(); // 클릭한 버튼의 문자열 얻기
		
		if(str.equals("Left")) {
			// 버튼들을 왼쪽맞춤 수행
			FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
			// 위에서 만든 레이아웃을 다시 north_p에 적용시키자
			north_p.setLayout(fl);
			north_p.updateUI(); // 새로 만든 UI를 적용하는 문장
		}else if(str.equalsIgnoreCase("Right")) { // 대소문자 구분없이 비교
			FlowLayout fl = new FlowLayout(FlowLayout.RIGHT);
			
			north_p.setLayout(fl);
			north_p.updateUI();
		}else {
			FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
		
			north_p.setLayout(fl);
			north_p.updateUI();
		}
	}

	public static void main(String[] args) {
		// 프로그램 시작
		new Ex2_FlowLayout();
	}

}
