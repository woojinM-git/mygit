package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Company extends JFrame implements ActionListener {

	FlowLayout flow;
	JButton bt1, bt2, bt3, bt4, bt5;
	JPanel left_p, down_p;
	JTextArea ta;
	GridLayout grid;
	JTextField tf;
	
	public Company() {
		
		flow = new FlowLayout(FlowLayout.RIGHT);
		bt1 = new JButton("전체");
		bt2 = new JButton("추가");
		bt3 = new JButton("검색");
		bt4 = new JButton("삭제");
		bt5 = new JButton("취소");
		
		down_p = new JPanel(flow);
		down_p.add(bt1);
		down_p.add(bt2);
		down_p.add(bt3);
		down_p.add(bt4);
		down_p.add(bt5);
		
		tf = new JTextField(5);
		grid = new GridLayout(4, 1);
		
		// 글씨가 담긴 레이블
		JLabel lb1 = new JLabel("사번:");
		JLabel lb2 = new JLabel("이름:");
		JLabel lb3 = new JLabel("직책:");
		JLabel lb4 = new JLabel("부서:");
		
		left_p = new JPanel(grid);
		left_p.add(lb1);
		left_p.add(tf);
		left_p.add(lb2);
		left_p.add(tf);
		left_p.add(lb3);
		left_p.add(tf);
		left_p.add(lb4);
		left_p.add(tf);
		
		
		
		ta = new JTextArea();
		
		this.add(ta);
		this.add(left_p, BorderLayout.WEST);
		this.add(down_p, BorderLayout.SOUTH);
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼을 누르면 해당 버튼과 취소를 제외하고 비활성화

	}

	public static void main(String[] args) {
		// 프로그램 시작
		new Company();
	}

}
