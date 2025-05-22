package homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.concurrent.Flow;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TalkApp extends JFrame {

	JPanel south_p, center_p, textarea, btarea;
	JLabel image_l, text_l;
	JButton login;
	JTextField search;
	ImageIcon icon;
	
	public TalkApp() {

		icon = new ImageIcon("src/images/Talk.gif");
		image_l = new JLabel(icon);
		this.add(image_l);
		
		south_p = new JPanel(new GridLayout(2, 1));
		
		textarea = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		textarea.add(text_l = new JLabel("대화명"));
		textarea.add(search = new JTextField(10));
		
		
		
		south_p.add(text_l);
		south_p.add(login = new JButton("로그인"));
		
		this.add(south_p, BorderLayout.SOUTH);
		
		setBounds(300, 100, 800, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new TalkApp();

	}

}
