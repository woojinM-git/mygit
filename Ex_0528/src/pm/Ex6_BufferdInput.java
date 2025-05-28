package pm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex6_BufferdInput {

	public static void main(String[] args) {
		String path = "c:/my_Study/java_study/work/Ex_0528/src/pm/Ex5_fileInput.java";
		
		// FileInputStream을 활용하여 읽은 후 화면에 출력하시오
		
		File f = new File(path); // 파일 객체 생성
		
		FileInputStream fis = null; // 객체 자료형의 기본값은 null이다
		// 변수를 만들때는 초기화를 하고 사용한다.
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream(f); // 파일과 연결하는 배관이 만들어 
			bis = new BufferedInputStream(fis);
			int size = -1;
			byte[] buf = new byte[2048]; // *******************
			
			while((size = bis.read(buf)) != -1) {
				// 배열 buf의 0번지 부터 size가 기억하고 있는 번지까지
				// 가져와서 문자열로 만든다
				String str = new String(buf, 0, size); //  0 번지 부터 1047 까지 가져온다 <- 예시
				
				System.out.println(str);
			} // while end
			
		}catch(Exception e) {
			// 예외가 발생할 경우 오류난 상황을 Stack구조(순차적)로 표현한다.
			e.printStackTrace();
		}finally {
			try {
				fis.close(); // 사용된 스트림 닫기 // 엄청중요*************
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
