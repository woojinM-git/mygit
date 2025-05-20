package pm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ex8_Frame extends JFrame implements ActionListener{
	
	JButton[] bt_ar = new JButton[8];
	JPanel north_p;
	JTextArea ta;
	
	public Ex8_Frame() {
		
		north_p = new JPanel(); // jpanel을 north_p에 담고
		ta = new JTextArea();
		
		for(int i = 0; i < bt_ar.length; i++) {
			StringBuffer sb = new StringBuffer();
			sb.append(i+2);
			bt_ar[i] = new JButton(sb.toString());
			
			north_p.add(bt_ar[i]);
		}
		// 버튼 8개를 갖고있는 north_p를 현재 창 north영역에 추가
		this.add(north_p, BorderLayout.NORTH);
		
		// 현재 창 가운데에 ta를 추가
		this.add(ta);
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int i = 0; i < bt_ar.length; i++) {
			// 버튼의 i번째 클릭 시 
			bt_ar[i].addActionListener(this);
		}
		
	}

	public static void main(String[] args) {
		new Ex8_Frame();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		for(int i = 2; i < bt_ar.length+1; i++) {
			for(int j = 1; j < 10; j++) {
				ta.append("");
				ta.append(i);
				ta.append("--------------");
				ta.append("%d * %d = %d\r\n");
			}
		}
	}

}
