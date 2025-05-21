package pm;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lotto extends JFrame implements ActionListener{

	JButton bt;
	JPanel north_p, center_p;
	JLabel[] ar = new JLabel[6];
	TreeSet<Integer> ts;
	FlowLayout flow;
	GridLayout grid;
	
	public Lotto() {
		ts = new TreeSet<Integer>();
		
		flow = new FlowLayout(FlowLayout.RIGHT);
		north_p = new JPanel(flow);
		north_p.add(bt = new JButton("번호 생성"));
		this.add(north_p, BorderLayout.NORTH);
		
		grid = new GridLayout(1, 6); // 1행 6열
		center_p = new JPanel(grid);
		this.add(center_p);
		
		setBounds(300, 100, 800, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 이벤트 감지자 등록
		bt.addActionListener(this);
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Lotto();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 번호생성 버튼을 클릭할 때마다 수행하는 곳
		center_p.removeAll(); // JPanel 청소
		// 1. set구조 생성해서 난수를 6개 가져야 합니다
		ts.clear(); // 청소
		while(true) {
			int su = (int)(Math.random()*45+1);
			ts.add(su);
			if(ts.size() == 6)
				break; // 무한반복문 탈출
		} // 무한반복문의 끝
		
		// ts에 있는 요소들을 하나씩 얻어내어 ImageIcon으로 만들어야 한다
		Iterator<Integer> it = ts.iterator();
		int i = 0;
		while(it.hasNext()) {
			int n = it.next();
			StringBuffer sb = new StringBuffer("src/images/");
			sb.append(n);
			sb.append(".gif");
			ImageIcon icon = new ImageIcon(sb.toString());
//			ImageIcon icon = new ImageIcon("src/images/" + n + ".gif");
			// JLabel배열에 icon을 넣어서 JLable을 생성한다
			ar[i] = new JLabel(icon);
			
			center_p.add(ar[i]);// center_p에 JLable추가
			i++;
		}
		center_p.updateUI(); // 새로고침
	}

}
