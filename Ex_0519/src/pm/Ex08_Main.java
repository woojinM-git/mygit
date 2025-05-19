package pm;

import am.EX07_Car;
import am.Ex07_Sedan;

public class Ex08_Main {
	
	public static void test(EX07_Car n) {
		System.out.println(n.getMin_pirce());
		
		// 인자로 넘어온 n이 가리키는 인스턴스 안에 Ex08_SUV
		if(n instanceof Ex08_SUV) {
			// 여기는 n이 가리키는 인스턴스 안에 Ex08_SUV가 있을 때만 수행함!
			Ex08_SUV suv = (Ex08_SUV)n;
			System.out.println(suv.isHud());
		}else if(n instanceof Ex07_Sedan) {
			Ex07_Sedan sedan = (Ex07_Sedan) n;
			System.out.println(sedan.isSunroof());
		}
	}

	public static void main(String[] args) {
		// 원하는 객체를 생성
		Ex08_SUV gv90 = new Ex08_SUV();
		gv90.setModel("GV90");
		gv90.setMin_price(10000);
		gv90.setHud(true);
		
		Ex07_Sedan g90 = new Ex07_Sedan();
		g90.setModel("G90");
		g90.setMin_price(9000);
		g90.setSunroof(true);
		
		////////////////////////////////////////////
		Ex08_Main main = new Ex08_Main(); // 같은 class에 있어도 일단 생성을 해야한다
		main.test(gv90);
		main.test(g90);
		
		
		

	}

}
