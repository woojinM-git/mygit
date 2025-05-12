package am;

public class Ex00_loto {

	public static void main(String[] args) {
		// loto 해설

		int[] loto = new int[6];	// int[배열] loto 변수에 길이가 6인 배열을 선언
		
		for(int i = 0; i < loto.length; ) {			// 배열의 길이만큼 i를 증가하는 반복문
			loto[i] = (int)(Math.random()*45+1);	// loto변수 i번째에 1~45 난수 발생
			boolean chk = true;					// boolean형태의 chk 변수에 true 값을 지정(boolean의 기본값은 false)
			for(int j = 0; j < i; j++) {			// 만약 j와 i의 지정한 난수값이 같다면
				if(loto[j] == loto[i]) {			// 만약 j와 i의 지정한 난수값이 같다면
					chk = false;					// chk에 false를 넣음
					break;							// 과 동시에 현재 반복문을 탈출하고 가장 가까운 반복문 진행
				}	// if문 끝
			}		// 안쪽 for문 끝
			for(int k = 0; k < 1; ++k) {
				System.out.print(loto[i] + ", ");
			}
			if(chk) {								// 만약 if가 처음에 지정한 ture라면
													// (안쪽for의 if를 만나지 않았을 때 = i에 넣은 난수와 j의 난수가 같지 않을 때)
			// if( ) 괄호 안에 값이 있으면 ture를 의미
				++i;								// i를 1 증가(for문을 만족시키기 위해)
			}		// 바깥 for의 if문 끝
		}			// 바깥 for문
		System.out.println();
		System.out.println("로또번호가 끝났습니다");
		
		System.out.println("-----------------------------------------------");
		
		// 기본자료형은 
		
		String[] ar3 = new String[3];	// 객체자료형이므로 heap 변수에 주소를 저장한다
		// 객체자료형은 객체를 만들고 객체에 주소가 할당된다
		// 객체자료형은 기본으로 "null" 값이 들어간다
		
		ar3[0] = "100";		//  "100"이 담긴 객체를 만들고 그 객체의 주소를 ar3[0]에 넣는다
		ar3[1] = "222";
		ar3[2] = "300";
		
	}

}