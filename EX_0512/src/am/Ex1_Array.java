package am;

public class Ex1_Array {

	public static void main(String[] args) {
		// 객체자료형 배열을 생성하자
		String[] ar = new String[3];
		ar[0] = "100";	// 암시적객체 생성
		ar[1] = "222";
//		ar[2] = "300";
//		ar[2] = "300";
//		ar[2] = "300";	// 암시적객체 생성
		ar[2] = new String("100");	// 명시적객체 생성
		
		for(int i = 0; i < ar.length; ++i) {
			System.out.printf("%s, ", ar[i]); // 100, 222, 300, = 다 문자열이다
		}
			
		System.out.println("---------------------------------------");
			
		if(ar[0].equals(ar[2])) { // .equals = 내용 비교
			System.out.println("0번지와 2번지의 참조주소 내용이 같다.");
		}else {
			System.out.println("0번지와 2번지의 참조주소 내용이 다르다");
		}
		
		System.out.println("--------------------------------------");
		String str = "쌍용교육센터 : 3강의장 : 오경주";
		
		// str에 저장된 문자열에서 ":" 을 중심으로 분할처리 하여 배열로 반환한다.
		String[] ar1 = str.split(":"); // split() = ()안의 값을 기준으로 배열로 반환한다
		for(int i = 0; i < ar1.length; ++i) {	// 배열로 반환됨을 확인하는 반복문
			System.out.println(ar1[i]);
		}
		/* -배열 출력-
		  쌍용교육센터 
 			3강의장 
 			오경주
		 */
		
	}
	
}
