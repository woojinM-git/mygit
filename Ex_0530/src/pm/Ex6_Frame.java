package pm;

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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex6_Frame extends JFrame {

	JTable table;
	
	// 컬럼명
	String[] c_name = {"사번", "이름", "직책", "입사일", "부서코드"};
	
	Object[][] data;
	
	ArrayList<Ex6_Emp> e_list = new ArrayList<Ex6_Emp>();
	
	JMenuBar bar;
	JMenu file_menu;
	JMenuItem new_item, add_item, open_item, save_item, exit_item;
	
	// 파일로부터 자원을 읽기하기 위한 스트림
	ObjectInputStream ois;
	ObjectOutputStream oos;
	File selectedFile;
	
	public Ex6_Frame() {
		
		// 화면 가운데에 ta 를 생성하여 스크롤바에 추가하여 넣는다
		this.add(new JScrollPane(table = new JTable(new DefaultTableModel(null, c_name))));
		
		// 메뉴작업
		new_item = new JMenuItem("새파일");
		add_item = new JMenuItem("추가");
		open_item = new JMenuItem("열기", new ImageIcon("src/images/folder.png"));
		save_item = new JMenuItem("저장", new ImageIcon("src/images/save.png"));
		exit_item = new JMenuItem("종료");
		
		file_menu = new JMenu("파일");
		file_menu.add(new_item);
		file_menu.add(add_item);
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
		readFile();
		
		

		// 감지자 등록
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				closed();
			}
		});
		
		add_item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ex6_AddDialog add = new Ex6_AddDialog(Ex6_Frame.this);
			}
		});
		
		open_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser("c:/my_study");
				// 파일선택기 보여주기
				int cmd = jfc.showOpenDialog(Ex6_Frame.this);
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
//				if(selectedFile == null) {
//					JFileChooser jfc = new JFileChooser("c:/my_study");
//					int cmd = jfc.showSaveDialog(Ex6_Frame.this);
//					if(cmd == JFileChooser.APPROVE_OPTION) {
//						selectedFile = jfc.getSelectedFile();
//						
//						// 저장하겠다고 선택한 파일이 이미 존재한다면
//						if(selectedFile.exists()) {
//							int select = JOptionPane.showConfirmDialog(Ex6_Frame.this, "덮어쓰기 하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION);
//							if(select != JOptionPane.YES_OPTION) {
//								selectedFile = null;
//								return; // 이후는 아무것도 하지 않고 돌아감									
//							}
//						}
//					} else {
//						selectedFile = null;
//						return;
//					}
//				}
				saveFile();
				
			}

			private void setTitle(String absolutePath) {
				// TODO Auto-generated method stub
				
			}
		});
		
	} // 생성자 끝
	
	private void saveFile() {
		String path = "c:/my_study/test/abc.txt";
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
			oos.writeObject(e_list);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void readFile() {
		String path = "c:/my_study/test/abc.txt";
		try {
			ois = new ObjectInputStream(new FileInputStream(new File(path)));
			Object obj = ois.readObject(); // 객체 읽기
			e_list = (ArrayList<Ex6_Emp>) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		viewTable();
	}
	
	private void closed() {
		// 작성한 ArrayList가 있다면 abc.txt.에 저장한다
		try {
			if(ois != null)
				ois.close();
			if(oos != null)
				oos.close();
		} catch (Exception e) { }
		saveFile();
		System.exit(0);
	}
	
	public void addData(String empno, String ename, String pos, String hdate, String deptno) {
		Ex6_Emp emp = new Ex6_Emp(empno, ename, pos, hdate, deptno);
		e_list.add(emp); // 멤버변수인 e_list라는 ArrayList에 저장!!!
		viewTable();
	}
	
	public void viewTable() {
		// 멤버변수인 e_list를 가지고 2차원 배열을 만든다
		data = new Object[e_list.size()][c_name.length];
		
		for(int i=0; i<e_list.size(); i++) {
			// ArrayList에서 저장된 요소 가져오기
			Ex6_Emp emp = e_list.get(i);
			
			data[i][0] = emp.getEmpno(); // 사번
			data[i][1] = emp.getEname(); // 이름
			data[i][2] = emp.getPos(); // 직책
			data[i][3] = emp.getHire_data(); // 입사일
			data[i][4] = emp.getDeptno(); // 부서코드
		}
		// 위의 반복문으로 테이블에 사용할 모델 자원이 준비되었다.
		// 모델 객체 생성한 후 그것을 테이블에 적용하면 끝
		table.setModel(new DefaultTableModel(data, c_name));
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex6_Frame();

	}

}
