package pm;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex8_Frame extends JFrame {

	JPanel p;
	
	public Ex8_Frame() {
		
		p = new JPanel() {
			
		};
				
		setBounds(300, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 감지자
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				Thread t1 = new Thread() {

					@Override
					public void run() {
						// 
					}
					
				};
			}
		
		});
		
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex8_Frame();

	}

}
