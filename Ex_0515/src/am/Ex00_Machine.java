package am;

public class Ex00_Machine {
	Ex00_Drink[] d1 = new Ex00_Drink[4];
	
	public void setAr() {
		d1[0] = new Ex00_Drink();
		d1[0].setNum(1);
		d1[0].setName("레츠비");
		d1[0].setPrice(500);
		
		d1[1] = new Ex00_Drink();
		d1[1].setNum(2);
		d1[1].setName("사이다");
		d1[1].setPrice(700);
		
		d1[2] = new Ex00_Drink();
		d1[2].setNum(3);
		d1[2].setName("콜라");
		d1[2].setPrice(700);
		
		d1[3] = new Ex00_Drink();
		d1[3].setNum(4);
		d1[3].setName("음료수");
		d1[3].setPrice(1000);
	}
	
	public String payit(int c) {
		StringBuffer c1 = new StringBuffer();
		for(int i = 0; i < d1.length; ++i) {
			Ex00_Drink drink = d1[i];
			
			int p = drink.getPrice();
			
			if(p <= c) {
				c1.append(drink.getNum());
				c1.append(".");
				c1.append(drink.getName());
			}
		}
		
		return c1.toString();
	}
	int t = 0;
	public String choice(int s) {
		StringBuffer ch = new StringBuffer();
		for(int i = 0; i < d1.length; ++i) {
			Ex00_Drink turn = d1[i];
		
			t = turn.getNum(); // 음료의 순번 저장
			if(s == t) {
				ch.append(turn.getName());
				ch.append("를 선택하셨습니다.");
			}
		}
		return ch.toString();
	}
	// 사용자가 입력한 값과, 선택한 음료의 금액을 - 하는 기능
	public String change(int cg) {
		StringBuffer chan = new StringBuffer();
		for(int i = 0; i < d1.length; ++i) {
			Ex00_Drink coin = d1[i];
			
//			int t = 0; // 잠시
			
			int c = coin.getPrice();
			if(cg == t) {
				chan.append("잔돈 ");
				chan.append(cg - c);
				chan.append("원 입니다.");
			}
		}
		
		return chan.toString();
	}
	
}
