package pm;

import am.EX07_Car; // 파일의 위치가 달라 import를 해줘야 함

public class Ex08_SUV extends EX07_Car {
	
	private boolean hud;

	public boolean isHud() {
		return hud;
	}

	public void setHud(boolean hud) {
		this.hud = hud;
	}
}
