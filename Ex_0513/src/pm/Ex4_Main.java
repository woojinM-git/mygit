package pm;

import am.Ex2_Pet;

public class Ex4_Main {

	public static void main(String[] args) {
		// 문자열 객체 생성
		String s1 = new String("SiST");

		String s2 = s1.concat("교육센터");
		System.out.println("s1: " + s1);	// SiST
		System.out.println("s2: " + s2);	// SiST교육센터
		
		System.out.println();
		// String은 편집할 수 없다. 무조건 새로 만들어진다
		// 문자열 편집을 위해 StringBuffer 를 사용하자
		StringBuffer sb = new StringBuffer("SiST");
		StringBuffer sb2 = sb.append("교육센터");
		// StringBuffer != String 둘은 다르다
		
		System.out.println("sb " + sb.toString()); 
		System.out.println("sb2 " + sb2.toString());
		// toString = 다른 형태를 String형태로 바꿔준다
		
		if(sb == sb2)
			System.out.println("서로 주소가 같다"); // ********
		else
			System.out.println("서로 주소가 다르다");
		
//		Ex2_Pet pp = new Ex2_Pet();
//		pp.setName(sb.toString());	() 안에는 String형태가 들어갈 수 있는데 sb는 StringBuffer 형태라서 
	}
}
