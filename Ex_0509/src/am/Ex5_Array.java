package am;

public class Ex5_Array {

	public static void main(String[] args) {
		// 문자를 4개 저장할 수 있는 배열을 생성한 후 
		// 반복문을 이용하여 'A', 'B', 'C', 'D' 가 순서대로 저장되도록 초기화하시오!
		
		char[] arr = new char[4];
		
		char ch = 'A'; // char에 A를 넣고 반복문으로 1씩 증가시켜 A B C D 출력
		
		for(int i = 0; i < arr.length; ++i) {
			arr[i] = ch;
			ch++; // ch 에 담긴 A(65)가 ++(1씩 증가) .. B .. C .. D
			System.out.printf("arr[%d]=%c", i, arr[i]);
		}

	}

}
