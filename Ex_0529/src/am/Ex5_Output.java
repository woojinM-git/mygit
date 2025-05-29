package am;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex5_Output extends JFrame {

	JTextArea ta;
	
	// 메뉴 관련 객체들
	JMenuBar bar;
	JMenu file_menu, color_menu;
	JMenuItem new_item, open_item, save_item, exit_item;
	JMenuItem red_item, green_item, blue_item, orange_item;
	
	// 스트링 객체들
	BufferedInputStream bis;
	BufferedOutputStream bos;
	
	File selectedFile; // 선택된 파일
	
	public Ex5_Output() {
		this.add(new JScrollPane(ta = new JTextArea()));
		
		// 메뉴 작업
		new_item = new JMenuItem("새파일");
		open_item = new JMenuItem("열기...");
		save_item = new JMenuItem("저장");
		exit_item = new JMenuItem("종료");
		
		
		// 서브메뉴 작업 ---------------------------------------
		red_item = new JMenuItem("빨강");
		green_item = new JMenuItem("초록");
		blue_item = new JMenuItem("파랑");
		orange_item = new JMenuItem("오렌지");
		
		color_menu = new JMenu("색상");
		color_menu.add(red_item);
		color_menu.add(green_item);
		color_menu.add(blue_item);
		color_menu.add(orange_item);
		// ------------------------------------------------------
		file_menu = new JMenu("파일");
		file_menu.add(new_item);
		file_menu.add(open_item);
		file_menu.add(color_menu); // 서브메뉴
		file_menu.add(save_item);
		file_menu.addSeparator(); // 구분선
		file_menu.add(exit_item);
		
		bar = new JMenuBar();
		bar.add(file_menu);
		
		// JMenuBar를 현재 창에 설정한다.
		this.setJMenuBar(bar);
		
		this.setBounds(300, 100, 600, 600);
		this.setVisible(true);
		
		// 이벤트 감지자 등록
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// 닫기를 위한 메서드 호출
				closed();
			}
		
		});
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// [열기]를 눌렀을 때만 수행하는 곳!
				JFileChooser jfc = new JFileChooser("c:/my_study"); // 그냥 생성하면 딜레이가 생김
				// 위와 같이 파일선택기가 생성되어도 화면에는 나타나지 않는다.
				int cmd = jfc.showOpenDialog(Ex5_Output.this);
				
				if(cmd == JFileChooser.APPROVE_OPTION) {
					// 사용자가 입력을 하던, 선택한 파일을 받아낸다.
					selectedFile = jfc.getSelectedFile();
					
					readFile();
					
				}
			}
		});
		
		save_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// [저장]을 클릭할 때만 수행하는 곳
				// 선택된 파일이 null이 아니고 파일이 존재해야 한다.
				if(selectedFile != null) {
					saveFile();
				} else {
					// 선택된 파일이 없는 상황이기 때문에
					// 어디에 저장할 건지 파일선택기를 보여주면서 사용자로 하여금
					// 저장 위치를 지정하도록 해야한다.
					JFileChooser jfc = new JFileChooser("c:/my_study");
					int cmd = jfc.showSaveDialog(Ex5_Output.this);
					if(cmd == JFileChooser.APPROVE_OPTION) { // APPROVE_OPTION 저장 버튼
						// [저장]버튼을 클릭했을 때
						// 사용자가 선택한 파일정보를 얻어내어 selectedFile에 저장
						selectedFile = jfc.getSelectedFile();
						
						// 파일이 이미 존재할 경우에 덮어쓸건지? 물어본다.
						if(selectedFile.exists()) { // selectedFile이 존재한다면?
							int chk = JOptionPane.showConfirmDialog(Ex5_Output.this,  "덮어쓰기 하시겠습니까?",
									"경고",JOptionPane.YES_NO_OPTION);
							if(chk != JOptionPane.YES_OPTION) {
								selectedFile = null;
								return; // 이후는 아무것도 하지 않고 돌아감									
							}
						}
						saveFile();
					}
				}
				
			}
		});
		
	} // 생성자의 끝
	
	private void readFile() {
		// 먼저 선택된 파일이 있어야 하고, 파일이 존재해야 한다.
		if(selectedFile != null && selectedFile.exists()) {
			// 읽기할 스트링 생성
			try {
				bis = new BufferedInputStream(new FileInputStream(selectedFile));
				
				
				int size = -1;// 읽은 수를 저장할 변수
				byte[] buf = new byte[1024 * 4];// 바구니 역할을 해주는 배열이 필요함
				StringBuffer sb = new StringBuffer();
				
				while((size = bis.read(buf)) != -1) { // buf의 있는 내용을 bis에 적재한다. // 
					String str = new String(buf, 0, size); // 배열에 있는 자원들을
					// 가져와서 문자열 객체로 생성
					sb.append(str);
				} // while end
				// 모든 데이터는 sb에 적재되어 있다.
				ta.setText(sb.toString());
				this.setTitle(selectedFile.getAbsolutePath()); // 제목설정
				ta.setCaretPosition(0); // 화면을 맨 위로 이동 (마우스 커서)
			} catch (Exception e) {
				e.printStackTrace(); // 콘솔창에 오류 출력
			}
		}
	}
	
	private void closed() {
		// 각 스트림들 생성여부 확인 후 닫기한다.
		try {
			if(bis != null) 
				bis.close();
			if(bos != null)
				bos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.exit(0); // 지금 바로 프로그램 종료!!!!
	}
	
	// 파일에 저장하는 함수
	private void saveFile() {
		try {
			bos = new BufferedOutputStream(new FileOutputStream(selectedFile));
			// 쓰기할 데이터는 JTextArea에 있다 모두 가져온다
			String str = ta.getText();
			
			byte[] buf = str.getBytes();
			
			bos.write(buf, 0, buf.length);
			bos.flush();
			
			// 제목을 바꾸고 저장완료 라는 창을 띄운다 (큰 의미 없음)
			this.setTitle(selectedFile.getAbsolutePath());
			JOptionPane.showMessageDialog(this, "저장완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new  Ex5_Output();
	}

}
