package pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex4_InputStream {

	public static void main(String[] args) {
		// 특정파일과 연결된 스트림 생성
		String path = "c:/my_Study/io_test/inputTest.txt";
		
		File f = new File(path); // 경로로 파일객체 생성
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			
			int code = -1;
			while((code = fis.read()) != -1)
				System.out.write(code);// System.out.print((char)code);
			
		}catch(Exception e) {
			System.out.println("예외 발생: 파일이 있는지? 확인하세요");
		}finally {
			try {
				fis.close(); // 사용된 스트림 닫기 // 엄청중요*************
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
