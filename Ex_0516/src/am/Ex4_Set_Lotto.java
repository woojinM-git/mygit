package am;

import java.math.MathContext;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class Ex4_Set_Lotto {

	public static void main(String[] args) {
		// set구조로 로또를 완성하시오
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		
		int[] ran = new int[6];
		for(int i = 0; i < ran.length; i++) {
			ran[i] = (int)(Math.random()*45+1);
			
			lotto.add(ran[i]);
		}
		
		Iterator<Integer> it = lotto.iterator(); // iterator로 하나씩 it에 정의
		while(it.hasNext()) { // 커서 다음칸에 요소가 있는지 확인
			// 다음 요소로 이동하여 요소 가져오기
			Integer n = it.next();
			System.out.println(n);
		}
		
		System.out.println("------------강사넴 방법---------------");
		TreeSet<Integer> lotto2 = new TreeSet<Integer>();
		
		while(true) {
			int n2 = (int)(Math.random()*45+1); // 난수 발생
			lotto2.add(n2); // set 구조에 추가
			if(lotto2.size() == 6)
				break; // 무한반복 탈출
		}// 무한반복의 끝
		System.out.println(lotto2); // 자체적으로 [ ] 를 넣어서 출력해줌
		
		// 반복자 처리
		Iterator<Integer> it2 = lotto2.iterator();
		while(it2.hasNext()) {
			int su = it2.next();
			System.out.printf("%-3d", su);
		}

	}

}
