package am;

// Ex07_Car로부터 상속받은 자식클래스
public class Ex07_Sedan extends EX07_Car {
	 // class를 생성할 때 superclass를 EX07_Car로 선택
	private boolean sunroof; // true: 유설치, false: 무설치

	public boolean isSunroof() { // boolean은 get이 is임
		return sunroof;
	}

	public void setSunroof(boolean sunroof) {
		this.sunroof = sunroof;
	}
	
}
