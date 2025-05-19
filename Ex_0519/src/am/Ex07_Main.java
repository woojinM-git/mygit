package am;

public class Ex07_Main {

	public static void main(String[] args) {
		// 원하는 세단클래스를 생성
		Ex07_Sedan gr1 = new Ex07_Sedan();
		gr1.setModel("그랜져300"); // 부모가 갖고 있는 함수
		gr1.setMin_price(2700); // 부모가 갖고 있는 함수
		gr1.setSunroof(true); // Sedan이 갖고 있는 함수
		
		Ex07_Sedan g80 = new Ex07_Sedan();
		g80.setModel("G80");
		g80.setMin_price(6000);
		g80.setSunroof(false);
		
		if(gr1.equals(g80))
			System.out.println("서로 내용이 같다");
		else
			System.out.println("서로 내용이 다르다");
	}

}
