package pm;

public class Ex3_Gugudan {
	private int dan;
	
	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}
	
	public void print() {
		System.out.println("-------------------------");
		for(int i = 1; i < 10; ++i) {
			System.out.printf("%d * %d = %d\n", dan, i, dan * i);
		}
	}
	
} // 클래스의 끝
