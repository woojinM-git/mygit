package pm;

public class Ex7_Array {

	public static void main(String[] args) {
		// TEST
		/*
		 
		 	"다이아", "금두꺼비", "꽝", 	"로또1등"
		 	"꽝",	  "황금알",   "비누",   "아파트"
		 	"꽝", 	  "천원", 	  "꽝", 	"거품"
		 
		 */
		String[][] ar2 = {		// 2차원 배열을 선언, 생성, 초기화
			{"다이아", "금두꺼비", "꽝", "로또1등"},
			{"꽝", "황금알", "비누", "아파트"},
			{"꽝", "천원", "꽝", "거품"}
		};
		
		int value1 = 0;
		int value2 = 0;
		
		for(int i = 0; i < ar2.length; ++i) {
			value1 = (int)(Math.random()*ar2.length);
			for(int j = 0; j < ar2[i].length; ++j) {
				value2 = (int)(Math.random()*ar2[i].length);
			}
		}
		String msg = ar2[value1][value2];
		
		System.out.printf("%s 선택되었습니다.", msg);
		
		System.out.println("\n-----------강사님 방식-----------");
		
		int row = (int)(Math.random()*ar2.length);
		int col = (int)(Math.random()*ar2[0].length);
		
		String ran = ar2[row][col];
		System.out.println(ran);
		
		
	}
		
}
