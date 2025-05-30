package am;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex2_Reader extends JFrame {

	JTextArea ta;
	
	JMenuBar bar;
	JMenu file_menu;
	JMenuItem new_item, open_item, save_item, exit_item;
	
	// 파일로부터 자원을 읽기하기 위한 스트림
	BufferedReader br;
	File selectedFile;
	
	PrintWriter pw;
	
	public Ex2_Reader() {
		
		// 화면 가운데에 ta 를 생성하여 스크롤바에 추가하여 넣는다
		this.add(new JScrollPane(ta = new JTextArea()));
		
		// 메뉴작업
		new_item = new JMenuItem("새파일");
		open_item = new JMenuItem("열기", new ImageIcon("src/images/folder.png"));
		save_item = new JMenuItem("저장", new ImageIcon("src/images/save.png"));
		exit_item = new JMenuItem("종료");
		
		file_menu = new JMenu("파일");
		file_menu.add(new_item);
		file_menu.add(open_item);
		file_menu.add(save_item);
		file_menu.addSeparator(); // 구분선
		file_menu.add(exit_item);
		
		bar = new JMenuBar();
		bar.add(file_menu);
		
		// 현재 창에 메뉴바 설정
		this.setJMenuBar(bar);
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		
		// 감지자 등록
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				closed();
			}
		});
		
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser("c:/my_study");
				// 파일선택기 보여주기
				int cmd = jfc.showOpenDialog(Ex2_Reader.this);
				// 사용자가 [열기]를 선택했다면 cmd에는 JFileChooser.APPROVE_OPTION인
				// 0값이 저장된다
				if(cmd == JFileChooser.APPROVE_OPTION) {
					selectedFile = jfc.getSelectedFile();
					
					readFile();
				}
			}
		});
		
		save_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedFile == null) {
					JFileChooser jfc = new JFileChooser("c:/my_study");
					int cmd = jfc.showSaveDialog(Ex2_Reader.this);
					if(cmd == JFileChooser.APPROVE_OPTION) {
						selectedFile = jfc.getSelectedFile();
						
						// 저장하겠다고 선택한 파일이 이미 존재한다면
						if(selectedFile.exists()) {
							int select = JOptionPane.showConfirmDialog(Ex2_Reader.this, "덮어쓰기 하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION);
							if(select != JOptionPane.YES_OPTION) {
								selectedFile = null;
								return; // 이후는 아무것도 하지 않고 돌아감									
							}
						}
					} else {
						selectedFile = null;
						return;
					}
				}
				saveFile();
				
			}

			private void setTitle(String absolutePath) {
				// TODO Auto-generated method stub
				
			}
		});
		
	} // 생성자 끝
	
	private void saveFile() {
		try {
			pw = new PrintWriter(selectedFile);
			
			String str = ta.getText();
			
			pw.write(str);
			pw.flush();
			
			this.setTitle(selectedFile.getName());
			JOptionPane.showMessageDialog(Ex2_Reader.this, "저장완료");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private void readFile() {
		if(selectedFile != null) {
			try {
				// 선택된 파일이 있으면 스트림을 생성할 수 있다.
				br = new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile)));
				StringBuffer sb = new StringBuffer();
				String str = null;
				while((str = br.readLine()) != null) {
					sb.append(str);
					sb.append("\r\n");
				} // while end
				ta.setText(sb.toString()); // JTextArea에 문자열 변경
				ta.setCaretPosition(0); // 마우스 커서를 맨 위로 이동함
				this.setTitle(selectedFile.getName()); // 파일명으로 제목 변경
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void closed() {
		// 사용되는 스트림이 있다면 먼저 닫아야 한다.
		try {
			if(br != null)
				br.close();
			if(pw != null)
				pw.close();
		} catch (Exception e) { }
		System.exit(0);
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex2_Reader();

	}

}
