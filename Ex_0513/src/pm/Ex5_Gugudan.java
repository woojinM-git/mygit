package pm;

public class Ex5_Gugudan {
	
	private int dan;

	public void setDan(int dan) {
		this.dan = dan;
	}
	
	public void print() {
		System.out.println(dan+"단");
		System.out.println("-------------");
		for(int i = 1; i < 10; ++i)
			System.out.printf("%d * %d = %d", dan, i, dan*i);
	}
	
	public String result() {
		// 문자열 편집하기 위해 필요한 객체 생성
		StringBuffer sb = new StringBuffer();
		sb.append(dan);
		sb.append("단\r\n");
		sb.append("---------------------\r\n");
		for(int i = 1; i < 10; i++) {
			sb.append(dan);
			sb.append("*");
			sb.append(i);
			sb.append("=");
			sb.append(dan*i);
			sb.append("\r\n");
		} // for의 끝
		
		
		return sb.toString();
	} // result 함수의 끝
}
