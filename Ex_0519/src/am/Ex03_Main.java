package am;

public class Ex03_Main {

	public static void main(String[] args) {
		// 원하는 객체 생성
		Ex03_TestRef c = new Ex03_TestRef();
		
		Ex03_Member mem = new Ex03_Member();
		mem.setName("SiST");
		// Name을 "SiST"로 한다
		
		System.out.println(mem.getName()); // SiST
		// mem의 Name이 값고있는 값은 SiST이다
		
		c.test(mem);
		
		System.out.println(mem.getName()); // 쌍용교육센터
		// 하지만 c.test 안에 n.setName("쌍용교육센터"); = Name을 "쌍용교육센터"로 한다

	}

}
