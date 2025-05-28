package am;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Ex2_File extends JFrame {

	JPanel north_p;
	JTextField input_tf;
	JButton ok_bt, back_bt;
	JList<String> list;
	
	public Ex2_File() {
		
		north_p = new JPanel();
		input_tf = new JTextField(20);
		ok_bt = new JButton("확인");
		back_bt = new JButton("뒤로");
		
		north_p.add(new JLabel("경로: "));
		north_p.add(input_tf);
		north_p.add(ok_bt);
		north_p.add(back_bt);
		this.add(north_p, BorderLayout.NORTH);
		
		this.add(new JScrollPane(list = new JList<String>()));
		
		this.setBounds(300, 100, 450, 500);
		this.setVisible(true);
		
		// 이벤트 감지자 등록
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		ok_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ok_bt를 눌렀을 때만 수행하는 곳이므로
				// e.getSource()를 호출하여 객체를 구별할 필요가 없다.
				
				// 같은 역할 (중복하기 때문에 함수로 지정)
				viewList();
			}
		});
		
		input_tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// JTextField에서 엔터를 치면 ActionEvent다.
				viewList();
			}
		});
		
		back_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			// 1) 사용자가 입력한 값을 변수에 저장
			String str = input_tf.getText().trim();
			
			// 2) 마지막에 있는 / 의 위치를 알아낸다.
			int last = str.lastIndexOf("/");
			
			// 3) 0번지부터 알아낸 위치 직전까지만 문자열 검출
			String delet = str.substring(0, last);
			
			// 4) 위에서 검출된 문자열을 input_tf에 지정한다
			input_tf.setText(delet);
			
			// 같은 역할 (중복하기 때문에 함수로 지정)
			viewList();
			}
		});
		
		list.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// 더블클릭을 했는지? 확인
				int cnt = e.getClickCount();
				if(cnt == 2) {
					// 더블클릭할 때 list에 선택된 값을 가져온다.
					String str = list.getSelectedValue();
//					JOptionPane.showMessageDialog(Ex2_File.this, str);
					StringBuffer sb = new StringBuffer(input_tf.getText().trim());
					sb.append("/");
					sb.append(str);
		
					input_tf.setText(sb.toString());
					viewList();
				}
			}
			
		});
	}
	
	private void viewList() {
		// 해야할 일은 - 사용자가 입력한 경로를 얻어낸다
		String path = input_tf.getText().trim();
		
		if(path.length() <3 && !path.contains("/")) {
			path = path.concat("/");
			input_tf.setText(path);
		}
		
		// 두번째 할일은 경로를 얻어냈으니 이 경로로 File객체 생성
		File f = new File(path);
		
		// 해당 f가 존재하는지? 그리고 폴더인지 판단
		if(f.exists() && f.isDirectory()) {
			String[] ar = f.list();
			
			// 받은 배열을 Jlist에게 적용한다
			list.setListData(ar);
		} // if end
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex2_File();

	}

}
