package pm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex5_Map {
	
	public static void main(String[] args) {
		// Map구조: 키와 값을 하나의 쌍으로 저장하는 구조
		// 			키들은 중복 **불가**
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		String s1 = new String("SiST"); // 명시적 객체생성
		String s2 = "SiST"; // 암시적 객체생성
		String s3 = "쌍용교육센터";
		String s4 = "SiST"; // 암시적 객체생성
		
		// Map 구조에 저장하자
		map.put(100, s1);
		map.put(200, s4);
		map.put(300, s3);
		map.put(400, s2);
		// 동일한 Key을 저장하면 어떻게 될까?
		// map.put(300, s2); // 변경 - 기존 데이터 s3가 s2로 바뀐다.
		System.out.printf("map.size(): %d\n", map.size()); // 4
		
		// 값(value) 가져오기 (반드시 키를 활용해야 함)
		String v1 = map.get(300); // 키 300과 연결된 value가 v1에 저장된다.
		System.out.printf("map.get(300): %s\n", v1); // SiST
		
		// 삭제기능
		map.remove(100);
		System.out.printf("Key100 삭제후 map.size(): %d\n", map.size()); // 3
		
		// 키를 모를 경우에는 모든 키를 먼저 얻어낸다.
		Set<Integer> set = map.keySet(); // set구조로 key를 전부 가져온다
		Iterator<Integer> it = set.iterator(); // 반복자 얻어내기
		while(it.hasNext()) {
			// it에는 모두 키들만 존재한다
			int key = it.next(); // 200, 300, 400
			String value = map.get(key);
			System.out.printf("Key: %d, Value: %s\n", key, value);
		} // while end
		
	}

}







