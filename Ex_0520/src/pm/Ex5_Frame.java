package pm;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex5_Frame extends JFrame implements MouseListener{

	// 현재 창에 보여질 것들은 모두 멤버변수로 선언하자!
	// private JButton bt1, bt2, bt3;
	private JButton[] bt_ar = new JButton[3];
	
	public Ex5_Frame() { // 기본 생성자
		FlowLayout fl = new FlowLayout();
		this.setLayout(fl); // Layoutmanager가 FlowLayout에 포함되어있다
		
		for(int i = 0; i < bt_ar.length; i++) {
			StringBuffer sb = new StringBuffer("버튼");
			sb.append(i+1);
			bt_ar[i] = new JButton(sb.toString());
			this.add(bt_ar[i]); // 현재 창에 추가
			
			bt_ar[i].addMouseListener(this);
			// 버튼 객체에게 Mouse 이벤트를 감지하는 객체를 등록한다.
			// 그 Mouse이벤트를 감지하는 객체가 바로 this(현재객체)다.
		}
		
		setSize(500, 400);
		setLocation(300, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		Ex5_Frame f = new Ex5_Frame();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 마우스 버튼을 가지고 클릭할 때마다 수행하는 곳
		System.out.println("Clickes!!!!!!!");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
