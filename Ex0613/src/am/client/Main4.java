package am.client;

import am.vo.EmpVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main4 {
    public static void main(String[] args) {
        try {
            // 1) conf.xml과 연결되는 스트림
            Reader r = Resources.getResourceAsReader("am/config/conf.xml");

            // 2) SqlSessionFactory 생성
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

            // 3) 리소스 닫기 (factory 생성하면 r(Reader)의 역할은 끝난다)
            r.close();
            // ------------------- 한번만 수행하는 부분 ----------------------

            // 4) SQL문을 호출하기 위해 SqlSession을 factory로부터 얻어낸다.
            SqlSession ss = factory.openSession();

            Map<String, String> map = new HashMap<>();
//            map.put("no", "10");
//            map.put("job", "DEVELOP");
            List<EmpVO> list = ss.selectList("emp.search", map);

            System.out.println(list.size());
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
