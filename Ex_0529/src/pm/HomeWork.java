package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class HomeWork extends JFrame {

	JPanel north_p;
	JTextField tf;
	JButton bt;
	
	JTable table;
	
	String[] c_name = {"파일명", "수정날짜", "용량"};
	
	String[][] data;
	
	public HomeWork() {
		// 표 도안
		
		table = new JTable(); // 테이블 초기화
		this.add(new JScrollPane(table));
		
		
		// north_p
		north_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		north_p.add(new JLabel("경로 : "));
		north_p.add(tf = new JTextField(40));
		north_p.add(bt = new JButton("확인"));
		this.add(north_p, BorderLayout.NORTH);
		
		
		// 창 구성
		this.setBounds(300, 100, 600, 500);
		this.setVisible(true);
		
		// 이벤트 감지자 등록
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 지금 바로 프로그램 종료
			}
		});
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				JFileChooser jfc = new JFileChooser("c:/my_study");
				
				// JTextField에 있는 사용자가 입력한 값을 받아온다
				String str = tf.getText().trim();
				
				File f = new File(str);
				
				if(f.isDirectory()) {
					File[] sub = f.listFiles();
					
					data = new String[sub.length][c_name.length];
					for(int i = 0; i < sub.length; i++) {
						File sub_file = sub[i];
						
						try {
						// 얻어낸 파일의 정보를 얻어내기 위해 Map구조 생성
						Map<String, Object> att = Files.readAttributes(
								Paths.get(sub_file.getAbsolutePath()), "*");
							
							data[i][0] = sub_file.getName(); // 파일명
							FileTime ft = (FileTime) att.get("lastModifiedTime"); // 최종 수정
							data[i][1] = ft.toString();
								
							data[i][2] = String.valueOf(sub_file.length());
						} catch (Exception e2) { } // catch end
					}
					DefaultTableModel model = new DefaultTableModel(data, c_name);
					table.setModel(model);
					for(int i = 0; i < data.length; i++) {
						for(int j = 0; j < data[i].length; j++) {
							System.out.printf("%s, ", data[i][j]);
						}
						System.out.println();
					}
				}
				
			}
		});
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new HomeWork();

	}

}
