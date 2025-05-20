package pm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex7_Frame extends JFrame implements ActionListener{

	// 멤버변수 생성
	JButton bt1;
	JButton bt2;
	JButton bt3;
	JPanel north_p;
	JPanel center_p;
	
	public Ex7_Frame() {
		// 멤버변수 초기화
		bt1 = new JButton("Red");
		bt2 = new JButton("Green");
		bt3 = new JButton("Blue");
		north_p = new JPanel();
		center_p = new JPanel();
		
		// 상단 jpanel 에 버튼 3개를 추가
		north_p.add(bt1);
		north_p.add(bt2);
		north_p.add(bt3);
		
		// 버튼 3개 모두 가지고 있는 north_p를 현재 창 north영역에 추가
		this.add(north_p, BorderLayout.NORTH);
		
		// 현재 창 가운데에 center_p를 추가
		this.add(center_p);
		
		setBounds(300, 100, 500, 400); // setSize와 SetLocation을 합친 것
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 이벤트 감지자등록
		bt1.addActionListener(this); // 현재 객체가 ActionListener를 포함하고 있다
		bt2.addActionListener(this); // 현재 객체에서 
		bt3.addActionListener(this);
	}
	
	public static void main(String[] args) {
//		Ex7_Frame f = new Ex7_Frame();
		new Ex7_Frame(); // 변수를 사용하지 않는다면 생성자만 만든다

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트를 발생할 때마다 수행하는 곳!
		// 이벤트를 발생시킨 객체를 알아낸다.
		Object obj = e.getSource(); // 이거는 그냥 똑같이 씀
		if(obj == bt1) {
			center_p.setBackground(Color.red);
		}else if(obj == bt2) {
			center_p.setBackground(Color.green);
		}else
			center_p.setBackground(Color.blue);
		
	}

}
