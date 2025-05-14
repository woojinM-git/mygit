package am;

public class Ex4_Machine {
	Ex4_Drink[] drk = new Ex4_Drink[4];
	
	// 음료 4종을 만들어서 배열에 저장
	public void setAr() {
		drk[0] = new Ex4_Drink();
		drk[0].setName("레츠비");
		drk[0].setPrice(500);

		drk[1] = new Ex4_Drink();
		drk[1].setName("사이다");
		drk[1].setPrice(700);
		
		drk[2] = new Ex4_Drink();
		drk[2].setName("콜라");
		drk[2].setPrice(700);
		
		drk[3] = new Ex4_Drink();
		drk[3].setName("웰치스");
		drk[3].setPrice(1000);
	}
	
	// 가격을 인자로 받아
	// 받은 가격보다 같거나 낮은 음료를 표시
	public int choose(int n) {
		int result = 0;;
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < drk.length; ++i) {
			Ex4_Drink drink = drk[i];
			
			int p = drink.getPrice();
			
			if(n <= p) {
				System.out.println();
			}
		}
		
		return result;
	}
	
//	public String text(String n) {
//		
//		
//		return txt2.toString();
}
	
