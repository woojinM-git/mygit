package am;

import java.io.File;
import java.io.FileOutputStream;

public class Ex3_FileOutput {

	public static void main(String[] args) {
		// 파일에 저장할 문자열
		String str = "Test입니다. - 파일에 저장할 문자열 \r\n12345";
		
		File f = new File("c:/my_study/test/abc.txt");
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f);
			
			// 준비된 OutputStream을 통해 쓰기를 수행한다.
			// 먼저 저장할 문자열을 byte형 배열로 변환한다.
			byte[] ar = str.getBytes();
			
			// write 아래에서 바로 flush 해야한다
			fos.write(ar, 0, ar.length);
			fos.flush(); // 스트림을 비우는 동작인데 이것을 다르게 말하면
			// 스트림에 있는 자원들을 지금당장 방출하라는 뜻이다.
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos != null)
					fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
