package pm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex4_Frame extends JFrame implements ActionListener{

	JPanel north_p, center_p;
	JButton bt;
	
	public Ex4_Frame() {
		
		// 화면 구성
		north_p = new JPanel();
		north_p.add(bt = new JButton("색상"));
		this.add(north_p, BorderLayout.NORTH);
		
		this.add(center_p = new JPanel()); // 위치 지정안해서 자동 Center 위치
		
		setBounds(300, 100, 450, 450);
		setVisible(true);
		
		// 이벤트 감지자 등록
		this.addWindowListener(new Ex2_MyAdap());
		bt.addActionListener(this);
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex4_Frame();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 색상 버튼을 클릭할 때마다 수행하는 곳
		Ex4_Dialog d = new Ex4_Dialog(this);
		
	}

}
