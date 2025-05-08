package pm;

public class Ex7_String {

	public static void main(String[] args) {
		// 문자열 객체 생성
		String str = "SiST"; // str 변수에 "SiST"라는 문자열이 저장
										 // 암시적 객체생성
		// new : 기존꺼를 무시하고 새로 만든다
		String str2 = new String("SiST"); // str2 변수에
										// "SiST" 라는 문자열이 저장 - 명시적 객체생성
		// 객체는 메모리 안의 Heap(힙)이라는 영역에 만들어 진다
		// Heap(힙)영역에 변수가 있으며, 변수에 주소가 저장되어 있다
		
		if(str == str2) // Object(객체)의 주소비교
			System.out.println("서로 주소가 같다");
		else
			System.out.println("서로 주소가 다르다");

		System.out.println("------------------------------------------");
		if(str.equals(str2)) // 문자열 객체의 내용비교는 equals를 사용한다
			System.out.println("서로 내용이 같아");
		else
			System.out.println("서로 내용이 달라");
		
		System.out.println("------------------------------------------");
		String str3 = "SiST";
		
		if(str == str3) // Object(객체)의 주소비교
			System.out.println("서로 주소가 같다");
		else
			System.out.println("서로 주소가 다르다");
		
//		 문자열 즉, String 객체는 생성법이 2가지로 나뉜다.
//		 - 명시적 객체생성법 : new 라는 키워드로 생성하며 무조건
//		 					새로운 객체를 생성하고 주소할당함
//		 - 암시적 객체생성법 : 그냥 ""로 된 문자열을 저장하며
//							이는 앞서 같은 암시적 생서법으로 같은 내용을
//		 					만든 것이 있다면 기존 것을 재사용함
		
		// 그리고 정말 특이한 것은
		// 자바의 String객체는 불변적 특징을 가진다는 것이다.
	}

}
