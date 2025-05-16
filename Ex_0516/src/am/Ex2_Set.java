package am;

import java.util.HashSet;
import java.util.Iterator;

public class Ex2_Set {

	public static void main(String[] args) {
		// index가 없고, 중복을 허용하지 않는다
		HashSet<String> set = new HashSet<>();
		
		String s = new String("SiST");
		String s1 = "SiST";
		
		// set 구조에 저장!
		set.add(s);
		set.add(s1);
		set.add("123");
		set.add("abc");
		set.add("SiST");
		
		System.out.printf("set.size(): %d\n", set.size()); // 3 .size = 크기(길이)를 알아내는 함수 1부터 시작!
		// 내용이 같은 것들을 모두 같은 것으로 취급한다
		
		// Set구조의 요소들을 반복처리하기 위해서는 Iterator(반복자)를
		// 사용해야 한다. 먼저 set구조로 부터 Iterator를 얻어낸다
		
		// Interpace 추상화
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) { // hasNext() 현재 커서(반복자)의 위치에서 바로
							// 다음 요소에 자원이 있다면 true, 없다면 false다
			// it을 string으로 받아야 함 왜? set을 만들 때 String으로 만들었기 때문
			String n = it.next(); // 커서를 다음 요소로 이동하여 그 자리에 있는
								// 객체를 반환한다. 그것을 변수 n에 저장함
			System.out.println(n);
			
		} // while end 
		
	}

}
