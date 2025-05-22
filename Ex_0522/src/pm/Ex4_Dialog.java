package pm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class Ex4_Dialog extends JDialog implements WindowListener, ActionListener{
	
	JButton red_bt, green_bt, blue_bt;
	JPanel p;
	Ex4_Frame f;
	
	public Ex4_Dialog(Ex4_Frame n) {
		f = n; // *******우선 저장******
		
		// 화면구성
		p = new JPanel();
		p.add(red_bt = new JButton("Red"));
		p.add(green_bt = new JButton("Green"));
		p.add(blue_bt = new JButton("Blue"));
		
		this.add(p);
		
		setBounds(400, 150, 250, 160);
		setVisible(true);
		
		// 종료 이벤트
		this.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		new Ex4_Dialog(this);
		Object obj = e.getSource();
		if(obj == red_bt) {
			f.center_p.setBackground(Color.red);
		}else if(obj == green_bt) {
			f.center_p.setBackground(Color.green);
		}else
			f.center_p.setBackground(Color.blue);
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
