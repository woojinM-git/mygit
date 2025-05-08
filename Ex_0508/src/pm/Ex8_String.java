package pm;

public class Ex8_String {

	public static void main(String[] args) {
		// 자바의 String 객체는 불변적 특징을 가졌다.
		
		String str = "SiST"; // - 암시적 객체생성
		// 둘은 하나의 주소를 가리킴
		String str2 = "SiST"; // - 암시적 객체생성
		
		String str3 = str.concat("1234"); // 기존의 str이 기억하고 있는 값 뒤에
											// "1234" 를 붙여준다.
		System.out.println(str);
		System.out.println(str3);
		
		if(str == str3) {
			System.out.println("서로 주소가 같다");
		}else {
			System.out.println("서로 주소가 다르다");
		}
		
	}

}
