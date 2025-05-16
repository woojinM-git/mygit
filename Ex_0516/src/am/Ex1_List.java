package am;

import java.util.ArrayList;

public class Ex1_List {

	public static void main(String[] args) {
		// List구조는 배열과 같이 index로 요소를 접근하고
		// 중복(된 값)을 허용한다.
		
		ArrayList<String> list = new ArrayList<>(); // String 만 저장할 수 있는 ArrayList
		String s = new String("SiST"); // 명시적 객체생성
		String s1 = "SiST";	// 암시적 객체생성
		
		//저장기능
		list.add(s1);	// 암시적 객체생성
		list.add("123");	// 암시적 객체생성
		list.add("abc");	// 암시적 객체생성
		list.add(s); // s를 가리키는 주소를 저장 
		list.add("SiST");	// 암시적 객체생성
		
		System.out.printf("list.size(): %d\n", list.size()); // 5
		System.out.println("-----------------------------------");
		
		// 변수 s와 같은 객체가 어디에 저장되었는지? 알아보는 반복문
		for(int i = 0; i < list.size(); i++) {
			String v1 = list.get(i); // ArrayList에서 하나씩 얻어낸다.
			if(v1 == s1) {
				System.out.printf("찾으시는 s가 index %d에 있습니다.\n", i); // 0 , 4 암시적객체생성으로 만들어서 0번지와 4번지가 같은거다
			}
		}
		
		System.out.println("------------------------------------");
		if(list.contains(s1)) {
			int idx = list.indexOf(s1);
			System.out.printf("%d 번지에 s1이 list에 존재합니다.", idx);
		}
		else
			System.out.println("s1이 lsit에 존재하지 않습니다");
		// sontains로 있는지 유무를 따지고 위치를 indexOf로 알아낸다
		// 알아낸 위치를 get으로 불러온다

	}

}
