package am;

public class Ex4_Char {

	public static void main(String[] args) {

		char c = 'B';
		System.out.println("c = " + c);
		
		// 자바의 char 형은 2byte이며 내부적으로는
		// 코드값으로 처리 (유니코드), 즉 'B' = 66
		++c; // 66 + 1
		System.out.println("c = " + c);
		
		int ch = 97;
		
		System.out.println("ch = " + ch); // 97
		System.out.println("ch = " + (char)ch); // a
		
		char a = 96;
		
		for (int i = 0; i < 26; i++) {
				a++;
				System.out.println(a);
		}
			
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		}
	}

