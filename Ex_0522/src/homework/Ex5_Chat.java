package homework;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import pm.Ex2_MyAdap;

public class Ex5_Chat extends JFrame implements ActionListener{

	ImageIcon icon; // 아이콘 주소 찾기
	JLabel icon_lb; // 아이콘 레이블
	JPanel chat1_p1, chat2_p2; // 카드1, 카드2
	JPanel p1_south_p, s_p1, s_p2, p2_south_p;
	JTextField name_tf, input_tf;
	JButton login_bt, send_bt;
	JTextArea ta;
	
	CardLayout card;
	
	public Ex5_Chat() {
		// 현재 창의 레이아웃을 CardLayout으로 지정
		card = new CardLayout();
		this.getContentPane().setLayout(card); // 컨테이너에 지정
		
		// 첫번째 화면 작업
		chat1_p1 = new JPanel(new BorderLayout());
		icon = new ImageIcon("src/images/chat.png");
		icon_lb = new JLabel(icon);
		chat1_p1.add(icon_lb); // 첫번재 화면 가운데에 이미지 표현
		
		s_p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // 오른쪽 정렬
		s_p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // 오른쪽 정렬
		s_p1.add(new JLabel("대화명:"));
		s_p1.add(name_tf = new JTextField(8));
		s_p2.add(login_bt = new JButton("    로그인    "));
		p1_south_p = new JPanel(new GridLayout(2, 1));
		p1_south_p.add(s_p2);
		
		chat1_p1.add(p1_south_p, BorderLayout.SOUTH);
		
		this.getContentPane().add("chat1", chat1_p1);
		
		// 두번째 화면
		chat2_p2 = new JPanel(new BorderLayout());
		chat2_p2.add(new JScrollPane(ta = new JTextArea()));
		p2_south_p = new JPanel(new BorderLayout());
		p2_south_p.add(input_tf = new JTextField());
		p2_south_p.add(send_bt = new JButton("보내기"), BorderLayout.EAST);
		chat2_p2.add(p2_south_p, BorderLayout.SOUTH);
		
		this.getContentPane().add("chat2", chat2_p2);
		
//		card.show(this.getContentPane(), "chat2");
		
		setBounds(300, 100, 400, 500);
		setVisible(true);
		
		this.addWindowListener(new Ex2_MyAdap());
		
		login_bt.addActionListener(this);
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex5_Chat();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == login_bt) {
			// 로그인 버튼을 클릭했을 때
			
			// 사용자가 입력한 대화명 가져오기
			String n = name_tf.getText().trim();
			if(n.length() > 0) {
				// 대화명을 1자라도 입력한 경우 화면(card) 변경
				card.show(this.getContentPane(), "chat2");
			}else 
				JOptionPane.showMessageDialog(this, "대화명을 입력하세요");
		}
		
	}

}
