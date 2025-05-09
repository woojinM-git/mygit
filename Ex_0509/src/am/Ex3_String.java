package am;

public class Ex3_String {

	public static void main(String[] args) {
		String str = "안녕하세요! 금요일이군요.";
		
		int size = str.length(); // 문자열의 길이를 구하는 함수
		
		// str이 기억하고 있는 문자열에서 "하" 가 있는 위치
		// index값(정수)을 알아내자
		int idx = str.indexOf("하");
		System.out.println("str.indexOf(\"하\") : " + idx);
//				str.indexOf(String str, int fromIndex)
		
		// "요" 위치를 찾아보자
		int idx2 = str.indexOf("요"); // 기본적으로 왼쪽에서 가장 처음 만난 "요" 전달
		System.out.println("str.indexOf(\"요\") : " + idx2);
		
		// 찾은 "요" 이후에 있는 "요"를 검색하자 / 	str.indexOf(String str, int fromIndex)
		int idx3 = str.indexOf("요", idx2+1); // (str, int) 에서 str은 찾을 글자, int는 몇번째 자리에서 부터
		System.out.println("str.indexOf(\"요\", idx2+1) : " + idx3);
		
//		int idx4 = str.indexOf("요", idx3+1); / 아래 lastIndexOf와 같은 결과
		int idx4 = str.lastIndexOf("요"); // 검색을 뒤에서 시작한다
		// 하지만 index값이 바뀌지는 않는다 (index는 문자열에서 정해진 약속이 있음)
		System.out.println("str.lastIndexOf(\"요\") : " + idx4); // 12
		System.out.println("----------------------------------------------------------");
		
		String file_name = "  Ex1.java  "; // 외부에서 인자로 받았다고 가정하고
		// 내용은 모른다고 생각하자
		// 받은 파일이 자바파일 또는 텍스트파일인지 판단하자
		
		String t_fname = file_name.trim(); // 문자 밖 공백을 제거한 값("Ex1.java")
		// trim() = 무의미한 공백을 제거(문자 밖의 공백을 제거한다)
		// trim() -> 앞 뒤 공백을 제거하고 String형태로 반환(새로 생성)한다
		// String이 불변적 특징을 가져서 편집은 불가능함
		
		// endsWith(String suffix) = String이 true인지 false인지 확인할 수 있게 바꿔줌
		if(file_name.endsWith(".java") || file_name.endsWith(".txt")) { // file_name이 .java 또는(||) .txt 파일인지 확인
			System.out.println("자바 또는 텍스트파일입니다.");
		}else {
			System.out.println("처리할 수 없습니다.");
		}
		
		// a를 찾아서 *로 변경하자 // replaceAll : 문자를 바꿔준다 (바꾼 형태의 문자열을 새로 생성)
		String ss = t_fname.replaceAll("a", "*"); // a 를 * 로 바꾸어 새로 생성한 문자열을 ss에 저장
		System.out.println(t_fname); // Ex1.java = t_fname의 값은 그대로
		System.out.println(ss); // Ex1.j*v* = ss의 값은 t_fname에서 a 를 *로 바꿔서 저장한 문자열이 저장됨
		
	}

}