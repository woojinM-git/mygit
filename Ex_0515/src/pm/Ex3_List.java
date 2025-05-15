package pm;

import java.util.ArrayList;

public class Ex3_List {

	public static void main(String[] args) {
		// 배열과 List 구조 생성
		ArrayList<Integer> al = new ArrayList<>(3); // ArrayList<E> = Generic 의 Element(요소) 

		// 현재 List 구조의 사이즈를 얻어내자
		int size = al.size();
		System.out.printf("al.size(): %d\n", size); // 0 이유 = 3을 넣었지만 들어가 있는 값이 없기 때문에 size가 0이다
		
		al.add(100);	// list에 값을 저장할 때는 add *****
		size = al.size();
		System.out.printf("al.size(): %d\n", size); // 1 
		
		for(int i = 1; i < 11; ++i) { // 10번 반복해서 i값 추가
			al.add(i);
		}
		
		size = al.size();
		System.out.printf("al.size(): %d\n", size); // 11
		
		
		// List구조에서 저장된 요소들을 하나씩 얻어내어 출력하는 반복문
		for(int i = 0; i < al.size(); i++) {
			// List 구조에 저장된 요소들을 하나씩 얻어낼 때는
			// 반드시 저장된 요소의 자료형을 알아야 한다
			// 자동으로 객체자료형, 기본자료형으로 만들어줘서 오토박싱, 언박싱으로 칭함
			Integer v1 = al.get(i);	// list에서 값을 가져올 때는 get
			System.out.printf("%-4d", v1);
		}// for end
		System.out.println(); // 줄바꿈
		
		al.remove(1); // ArrayList에서 1번지, 즉 두번째 요소를 삭제한다
		for(int i = 0; i < al.size(); i++) {
			Integer v1 = al.get(i);
			System.out.printf("%-4d", v1);
		}// for end
		System.out.println(); // 줄바꿈
		
		System.out.printf("\n삭제후 al.size(): " + al.size()); // 10
		System.out.println();
		// 원하는 위치에 추가하기 - insert
		al.add(3, 400);
		for(int i = 0; i < al.size(); i++) {
			Integer v1 = al.get(i);
			System.out.printf("%-4d", v1);
		}// for end
		System.out.println(); // 줄바꿈
		
		// 현재 ArrayList에 99가 있는지 확인하자
		
		
		//	내 방법
		//  al.add(99);
		int num = 0;
//		for(int i = 0; i < al.size(); i++) {
//			num = al.get(i);
//		}
//		if(num == 99) {
//			System.out.println("true");
//		}else
//			System.out.println("false");
		
		//	강사님 방법
//		boolean chk = false;
//		for(int i = 0; i < al.size(); i++) {
//			int v = al.get(i);
//			if( v == 99 ) {
//				chk = true;
//				break;
//			}
//		}
//		if(chk)
//			System.out.println("99가 있습니다.");
//		else
//			System.out.println("99가 없습니다.");
		
		// boolean chk = al.contains(99); // contains = 배열안에 있는 값들중에 ()안에 적은 값이 있는지 확인하는 값
		if(al.contains(99))
			System.out.println("99가 있습니다.");
		else
			System.out.println("99가 없습니다.");
		
		if(al.contains(400))
			System.out.println("99가 있습니다.");
		else
			System.out.println("99가 없습니다.");
		
		if(al.contains(400)) {
			int idx = al.indexOf(400); // String의 indexOf와 같은 이름인데 객체의 함수들은 같은이름, 같은 형태, 같은 용도로 사용 (완전 같은건 아님)
			System.out.printf("400이 %d위치에 있습니다.\r\n", idx);
		}
		
		al.clear(); // 모든 요소 삭제
		System.out.printf("clear후 사이즈: %d\n", al.size()); // 0
		System.out.printf("리스트가 비어있나요: %b", al.isEmpty()); // 비었으면 ture , 비어있지않다면 false
		
		// 리스트 구조에서 알아야 할 메서드(함수)들
		// - add : 추가, add(3, 400): 3번 위치에 400을 추가
		// - get : 추출
		// - remove : 삭제
		// - size : 저장된 요소 수
		// - contains : 포함여부 확인
		// - clear : 모두 삭제
		// - isEmpty : 비어있는지 확인
	}
		
}
