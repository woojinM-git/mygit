package pm;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex6_Frame extends JFrame implements MouseListener{
	
	// 현재 창에 들어가는 모든 것들을 멤버로 선언
	JPanel north_p;
	JButton bt1, bt2, bt3;
	JTextArea ta; // JTextArea 를 만들어두기
	
	public Ex6_Frame() {
		// 멤버변수는 생성자 안에서 초기화를 해야한다
		north_p = new JPanel();
		bt1 = new JButton("Red");
		bt2 = new JButton("Green");
		bt3 = new JButton("Blue");
		ta = new JTextArea();
		
		// 위에서 생성한 객체들을 배치시켜야 한다.
		// 먼저 North영역에 들어갈 버튼들을 North_p에 추가
		north_p.add(bt1);
		north_p.add(bt2);
		north_p.add(bt3);
		// 현재 창 North영역에 north_p를 추가한다.
		this.add(north_p, BorderLayout.NORTH);
		
		// 스크롤바의 역할을 하는 객체 생성
		JScrollPane jp = new JScrollPane(ta);
		
		// 현재 창 가운데 ta를 추가한다.
		this.add(jp, BorderLayout.CENTER); // 생략하면 가운데 들어감
		
		// 이벤트 감지자 등록
		bt1.addMouseListener(this); // bt1을 클릭하면 상호작용
		bt2.addMouseListener(this); // bt2을 클릭하면 상호작용
		bt3.addMouseListener(this); // bt3을 클릭하면 상호작용
		
		setSize(500, 400);
		setLocation(300, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		// 프로그램 시작
		Ex6_Frame f = new Ex6_Frame();

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// 마우스 버튼을 누를 때마다 호출하여 수행하는 곳
		// 이벤트를 발생시킨 객체를 얻어낸다.
		Object obj = e.getSource(); // obj 가 이벤트를 발생시킨 객체이다
		if(obj == bt1) {
			// 이벤트를 발생시킨 객체가 bt1일때 수행한다.
			ta.append("Red\r\n");
		}else if(obj == bt2) {
			ta.append("Green\r\n");
		}else
			ta.append("Blue\r\n");
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
