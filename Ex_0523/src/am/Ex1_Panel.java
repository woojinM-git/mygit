package am;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Ex1_Panel extends JPanel {

	int x = 210;
	
	@Override
	protected void paintComponent(Graphics g) {
		// 현재 JPanel과 같은 크기의 이미지객체를 생성하자
		// 이것은 메모리상에 존재하고 화면에 나타나지않는다
		Image buf = createImage(this.getWidth(), this.getHeight());
		
		// buf에만 그림을 그릴 수 있는 붓 객체를 얻어낸다.
		Graphics buf_g = buf.getGraphics(); // buf(Image)가 갖고있는 Graphics 를 얻어와 붓 준비
		buf_g.fillRect(x, 235, 80, 30); // buf 이미지에 그림을 그린다 
		
		// 현재 JPanel에 위에서 준비된 이미지를 붙여넣는다.
		g.drawImage(buf, 0, 0, this);
		
	}

	
}
