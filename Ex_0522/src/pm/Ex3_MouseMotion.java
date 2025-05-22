package pm;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Ex3_MouseMotion extends MouseMotionAdapter {

	Ex3_Frame f; // 생성자에서 인자로 받아서 저장해야 함
	
	public Ex3_MouseMotion(Ex3_Frame n) { // 생성자 만들어서 기본생성자는 사라짐
		// n 은 지역변수이므로 곧 사라진다. 그래서 
		// 멤버변수에 저장하자
		f = n;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// 드래그 할 때 위치값(x, y) 얻기
		int x = e.getX(); // x 좌표
		int y = e.getY(); // y 좌표
		
		// 위에서 얻은 x, y 값을 JPanel의 x, y 에 전달해야 한다. 그리고
		// Jpanel 그림을 다시 그리도록 해야 한다.(repaint 호출)
		f.p.x = x; // f 안에 p가 멤버변수로 잡혀있다 때문에 p에 접근할 수 있음(private가 아님)
		f.p.y = y;
		f.p.repaint(); // 위에서 x, y값이 변경되었으므로 그림을 다시 그린다.
	}

	
}
