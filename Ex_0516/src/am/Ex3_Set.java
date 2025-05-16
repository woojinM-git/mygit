package am;

import java.util.Iterator;
import java.util.TreeSet;

public class Ex3_Set {

	public static void main(String[] args) {
		// 중복을 허용하지 않고, 인덱스가 없다. 그리고
		// 정렬을 지원하는 Set구조가 TreeSet 이다.
		
		TreeSet<String> set = new TreeSet<String>();

		String s = new String("SiST");
		String s1 = "SiST";
		
		// set 구조에 저장!
		set.add(s);
		set.add(s1);
		set.add("123");
		set.add("abc");
		set.add("SiST");
		
		Iterator<String> it = set.iterator(); // iterator로 하나씩 it에 정의
		while(it.hasNext()) { // 커서 다음칸에 요소가 있는지 확인
			// 다음 요소로 이동하여 요소 가져오기
			String n = it.next();
			System.out.println(n);
		}
		
	}

}
