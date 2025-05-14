package am;

public class Ex00_Baseball_class {
	int[] com = new int[3];		// 멤버변수
	int[] user = new int[3];
	
	int strike_count = 0;	
	int ball_count = 0;
	
	// 컴퓨터가 가지는 정수 3개 셋팅하는 기능
	public void initcom() {
		for(int i=0; i<com.length; ) {
	         com[i] = (int)(Math.random()*9+1); // com[] 배열에 난수 저장
	         boolean chk = true;
	         for(int j=0; j<i; j++) {
	            if(com[i] == com[j]) {
	               chk = false;
	               break;
	            }
	         }
	         if(chk)
	            ++i;
	      }
	} // initcom()의 끝
	// 컴퓨터가 가지는 값을 문자열로 반환하는 기능
	public String getCom() {
		StringBuffer sb = new StringBuffer();
		// com 배열에 있는 숫자 3개를 하나씩 얻어내어 sb에 추가하는 반복문
		for(int i = 0; i < com.length; i++) {
			sb.append(com[i]);
			
			// 마지막에는 ", "를 넣지 않도록 하기 위한 비교문
			if(i < com.length-1) // i가 2보다 작을 때만
				sb.append(","); // 콤마를 추가한다
		}
		return sb.toString();
	}
	
	// 사용자가 입력한 문자열을 정수 3개로 변환하여 배열에 저장하는 기능
	public void setUser(String n) { // String 으로 입력값을 받기에 String 변수 지정
		// (숫자가 들어갔는지 확인하는 반복문)
		for(int i = 0; i < user.length; i++) {
			char ch = n.charAt(i); // '1' --> 내부적으로 49로 기억된다
			user[i] = ch - 48;
		}
	}
	
	// 스트라이크 카운트 기능
	public int countStricke() {
		strike_count = 0;
		for(int i = 0; i < com.length; i++) {
			if(com[i] == user[i])
				strike_count++;
		}
		return strike_count;
	}
	
	// 볼 카운트 기능
	public int countBall() {
		ball_count = 0;
		for(int i=0; i<com.length; i++) {
            if(user[i] == com[(i+1)%com.length])
               ball_count++;
            else if(user[i] == com[(i+2)%com.length])
               ball_count++;
         }
		return ball_count;
	}
}
