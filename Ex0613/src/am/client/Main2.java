package am.client;

import am.vo.EmpVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        try {
            // 1) conf.xml과 연결되는 스트림
            Reader r = Resources.getResourceAsReader("am/config/conf.xml");

            // 2) SqlSessionFactory 생성
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

            // 3) 리소스 닫기 (factory 생성하면 r(Reader)의 역할은 끝난다)
            r.close();
            // ------------------- 한번만 수행하는 부분 ----------------------

            Map<String, String> map = new HashMap<>();
            map.put("num", "3333");
            map.put("name", "손오공");
            map.put("job", "DEVELOP");
            map.put("hdate", "2025-03-08");

            // 4) SQL문을 호출하기 위해 SqlSession을 factory로부터 얻어낸다.
            SqlSession ss = factory.openSession();
            int cnt = ss.insert("emp.add_map", map); // 저장된 데이터의 수
            if(cnt > 0) {
                ss.commit(); // 작업된 내용을 DB에 적용
                System.out.println("저장완료");
            }else {
                ss.rollback(); // 작업 취소
                System.out.println("저장실패");
            }
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
