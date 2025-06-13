package pm.client;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pm.vo.EmpVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends JFrame {


    JPanel north_p;
    JTextField s_tf, e_tf;
    JButton bt;
    JTable table;

    String[] c_name = {"사번", "이름", "입사일", "급여", "부서코드"};
    String[][] data;

    SqlSessionFactory factory;

    public Main() {

        north_p = new JPanel();
        s_tf = new JTextField(10);
        e_tf = new JTextField(10);
        north_p.add(new JLabel("시작일"));
        north_p.add(s_tf);
        north_p.add(new JLabel(", "));
        north_p.add(new JLabel("종료일"));
        north_p.add(e_tf);
        north_p.add(bt = new JButton("검색"));

        this.add(north_p, BorderLayout.NORTH);
        this.add(new JScrollPane(table = new JTable()));
        table.setModel(new DefaultTableModel(data, c_name));

        this.setBounds(300, 100, 500, 500);
        this.setVisible(true);

        init();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });
    } // 생성자 끝

    private void search(){
        // 사용자가 입력한 검색어를 가져온다.
        String str1 = s_tf.getText().trim();
        String str2 = e_tf.getText().trim();
        if(str1.length() > 0 && str2.length() > 0){
            // 사용자가 검색어를 1자라도 입력했을때만 수행함
            Map<String, String> map = new HashMap<>();
            map.put("start_date", str1);
            map.put("end_date", str2);
            SqlSession ss = factory.openSession();
            List<EmpVO> list = ss.selectList("emp.searchDate", map);
            viewTable(list);
            ss.close();
        }
    }

    private void viewTable(List<EmpVO> list){
        // 인자로 받은 List구조를 2차원 배열로 변환한 후 JTable에 표현!
        data = new String[list.size()][c_name.length];
        int i = 0;
        for(EmpVO vo : list){
            data[i][0] = vo.getEmpno(); // 사번
            data[i][1] = vo.getEname(); // 이름
            data[i][3] = vo.getHiredate(); // 입사일
            data[i][2] = vo.getSal(); // 급여
            data[i][4] = vo.getDeptno(); // 부서코드
            i++;
        } // for end
        table.setModel(new DefaultTableModel(data, c_name));
    }

    private void init(){
        try {
            Reader r = Resources.getResourceAsReader("pm/config/conf.xml");
            factory = new SqlSessionFactoryBuilder().build(r);
            r.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
