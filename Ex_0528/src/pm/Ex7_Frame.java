package pm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex7_Frame extends JFrame {

	JTextArea ta;
	
	JMenuItem new_item, open_item, save_item, exit_item;
	JMenu f_menu;
	JMenuBar bar;
	
	// 파일 처리를 위한 객체들
	File f;
	BufferedInputStream bis;
	FileInputStream fis;
	
	public Ex7_Frame() {
		
		this.add(new JScrollPane(ta = new JTextArea()));
		
		// 메뉴작업 - JMenuItem --> JMenu --> JMenuBar
		new_item = new JMenuItem("새파일");
		open_item = new JMenuItem("열기...");
		save_item = new JMenuItem("저장...");
		exit_item = new JMenuItem("종료");
		
		f_menu = new JMenu("파일");
		// 앞서 생성된 JMenuItem들을 JMenu에 추가한다.
		f_menu.add(new_item);
		f_menu.add(open_item);
		f_menu.add(save_item);
		f_menu.addSeparator(); // 구분선 -------------------------------
		f_menu.add(exit_item);
		
		bar = new JMenuBar();
		bar.add(f_menu); // JMenuBar에 파일메뉴를 추가
		
		// JMenuBar를 현재 창에 추가
		this.setJMenuBar(bar);
		
		setBounds(300, 100, 600, 550);
		setVisible(true);
		
		// 이벤트 감지자 등록
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// 종료하기 전에 해야할 일이 있으면 이쯤에서 해야함
				
				System.exit(0);
			}
		
		});
		exit_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 종료하기 전에 해야할 일이 있다면 이쯤에서 해야 한다.
				
				System.exit(0);
			}
		});
		
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 파일선택기를 만든다.
				JFileChooser jfc = new JFileChooser("c:/my_study/java_study");
				int cmd = jfc.showOpenDialog(Ex7_Frame.this);
				if(cmd == JFileChooser.APPROVE_OPTION) {
					// 사용자가 긍정적인 승인을 했을 때만 수행
					// APPROVE_OPTION이면 사용자가 파일을 선택한 경우
					
					f = jfc.getSelectedFile(); // f에 담는다 file형태임
					
					// 위에서 받은 파일을 가지고 존재여부 확인
					if(f.exists()) {}
					try {
						// 스트림과 f를 연동
						fis = new FileInputStream(f);
						bis = new BufferedInputStream(fis);
						
						// size와 byte배열 선언
						int size = -1;
						byte[] buf = new byte[1024 * 3];
						// 반복문 처리하면서 byte배열에 있는 자원을 가지고 문자열 생성
						while((size = fis.read(buf)) != -1) {
							String str = new String(buf, 0, size);
							
							// 생성된 문자열을 ta에 추가
							ta.setText(str);
						} // while end
					
				}catch(Exception e1) {
					// 예외가 발생할 경우 오류난 상황을 Stack구조(순차적)로 표현한다.
					e1.printStackTrace();
				}finally {
					try {
						fis.close(); // 사용된 스트림 닫기 // 엄청중요*************
						bis.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				}
				
			}
		});
	} // 생성자 끝
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex7_Frame();

	}

}
