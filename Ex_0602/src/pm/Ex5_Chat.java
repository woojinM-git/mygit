package pm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex5_Chat extends JFrame implements ActionListener {

	ImageIcon icon;
	JLabel icon_lb;
	JPanel chat1_p1, chat2_p2; // 화면
	JPanel p1_south_p, s_p1, s_p2, p2_south_p;
	JTextField name_tf, input_tf;
	JButton login_bt, send_bt;
	JTextArea ta;
	
	CardLayout card;
	
	// 서버접속에 필요한 객체들
	Socket s;
	ObjectInputStream in;
	ObjectOutputStream out;
	
	// 서버로부터 전달되어오는 프로토콜을 받는 스레드
	Thread t = new Thread() {

		@Override
		public void run() {
			// 항상 in.readObjcet를 수행해야 한다.
			bk:while(true) {
				try {
					Object obj = in.readObject();
					if(obj != null) {
						Ex3_Protocol protocol = (Ex3_Protocol) obj;
						switch(protocol.cmd) {
						case 2: 
							ta.append(protocol.getMsg());
							ta.append("\r\n");
							break;
						case 3:
							break bk;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // 무한반복
			try {
				if(in != null)
					in.close();
				if(out != null)
					out.close();
				if(s != null)
					s.close();
				System.exit(0);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	};
	
	public Ex5_Chat() { // 생성자
		// 현재 창의 레이아웃을 CardLayout으로 지정
//		card = new CardLayout();
		this.getContentPane().setLayout(card = new CardLayout());
		
		// 첫번째 화면
		chat1_p1 = new JPanel(new BorderLayout()); // BorderLayout을 해야 영역을 정의하기 쉬움
		icon = new ImageIcon("src/images/chat.png"); // img 경로 지정
		
		Image img = icon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		
		icon_lb = new JLabel(new ImageIcon(img)); // 경로에 있는 이미지를저장한 icon을 icon_lb에 담음
		
		chat1_p1.add(icon_lb); // 첫번째 화면 가운데에 이미지 표현
		s_p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // 우측정렬을 위한 FlowLayout
		s_p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		s_p1.add(new JLabel("대화명: ")); // 대화명 레이블 추가
		s_p1.add(name_tf = new JTextField(8)); // 입력창 추가
		s_p2.add(login_bt = new JButton("   로그인   ")); // 로그인 버튼 추가
		
		p1_south_p = new JPanel(new GridLayout(2, 1)); // 그리드 씌우기
		p1_south_p.add(s_p1); // grid 1번(위칸)에 대화명, 입력 추가
		p1_south_p.add(s_p2); // grid 2번(아래)에 로그인 버튼 추가
		
		chat1_p1.add(p1_south_p, BorderLayout.SOUTH);
	
		// 현재 객체에 
		this.getContentPane().add("chat1", chat1_p1); // chat
		
		// 두번째 화면
		chat2_p2 = new JPanel(new BorderLayout());
		// chat2_p2에 scroll 기능이 있는 TextArea 삽입
		chat2_p2.add(new JScrollPane(ta = new JTextArea()));
		p2_south_p = new JPanel(new BorderLayout());
		p2_south_p.add(input_tf = new JTextField());
		// p2_south_p에 "보내기"가 있는 버튼을 BorderLayout영역 중 EAST에 넣는다
		p2_south_p.add(send_bt = new JButton("보내기"), BorderLayout.EAST);
		// chat2_p2에 p2_south_p를 BorderLayout 영역 중 SOUTH에 넣는다
		chat2_p2.add(p2_south_p, BorderLayout.SOUTH);
		
		this.getContentPane().add("chat2", chat2_p2);
		
		setBounds(300, 100, 400, 500);
		setVisible(true);
		
		 // x 버튼 누르면 모두 종료되는 기능이 있는 class를 사용하기 위해 생성
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// 접속이 안되어있다면 프로그램 종료!
				if(s == null)
					System.exit(0); // 프로그램 종료
				else {
					// 프로토콜 생성, cmd에 3 저장 후 서버로 프로토콜 전송
					Ex3_Protocol p = new Ex3_Protocol();
					p.cmd = 3;
					try {
						out.writeObject(p); // 접속해제를 위한 프로토콜 보내기
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		
		});
		
		// login_bt에 기능을 추가
		login_bt.addActionListener(this);
		
		send_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						Ex3_Protocol p = new Ex3_Protocol();
						p.cmd = 2;
						p.msg = input_tf.getText();
						out.writeObject(p);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == login_bt) {
			// 로그인 버튼을 클릭했을 때
			
			// 사용자가 입력한 대화명 가져오기
			// 사용자가 입력한 글이 담긴 name_tf의 값을 n에 저장 그 과정에서 불필요한 공백은 제거
			String n = name_tf.getText().trim();
			if(n.length() > 0) {
				try {
					// 접속!!!!!!!!!!
					s = new Socket("192.168.10.100", 5555);
					
					// 나의 복사(Ex3_CopyClient)본이 서버에 숨어들었다.
					// 복사본과 통신하기위해 스트림 생성
					out = new ObjectOutputStream(s.getOutputStream());
					in = new ObjectInputStream(s.getInputStream());
					
					// in을 계속 read하는 Thread 구동시켜야 한다.
					
					Ex3_Protocol p = new Ex3_Protocol();
					p.cmd = 1;
					p.msg = n; // 이름 (nickName)
					
					out.writeObject(p);
					
					// 대화명을 1자라도 입력한 경우 card 변경
					card.show(this.getContentPane(), "chat2");
					t.start();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}else
				// 현재 객체에 메세지dialog를 보여줌 내용은 "대화명을 입력하세요"
				JOptionPane.showMessageDialog(this, "대화명을 입력하세요");
		}
		

	}

	public static void main(String[] args) {
		// 프로그램 시작
		new Ex5_Chat();
	}

}
