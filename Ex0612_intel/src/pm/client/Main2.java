package pm.client;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import pm.vo.EmpVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Reader;
import java.util.List;

public class Main2 extends JFrame {

    JPanel north_p;
    JButton bt;
    JTextField input_tf;
    JTable table;

    JMenu menu;
    JMenuBar bar;
    JMenuItem empno_item, job_item, deptno_item;
    
    String[] c_name = {"사번", "이름", "직종", "부서코드"};
    String[][] data = null;

    SqlSessionFactory factory;

    public Main2(){

        empno_item = new JMenuItem("사번검색");
        job_item = new JMenuItem("직종검색");
        deptno_item = new JMenuItem("부서코드검색");
        
        menu = new JMenu("추가검색");
        menu.add(empno_item);
        menu.add(job_item);
        menu.add(deptno_item);

        bar = new JMenuBar();
        bar.add(menu);

        this.setJMenuBar(bar);

        north_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        north_p.add(new JLabel("검색할 이름:"));
        north_p.add(input_tf = new JTextField(15));
        north_p.add(bt = new JButton("검색"));
        this.add(north_p, BorderLayout.NORTH);

        this.add(new JScrollPane(table = new JTable()));
        table.setModel(new DefaultTableModel(data, c_name));

        this.setBounds(300,100,500,500);
        this.setVisible(true);

        init(); // 공장 준비 완료!

        // 이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               System.exit(0); // 프로그램 종료
            }
        });

        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 사용자가 입력한 검색할 이름을 가져온다.
                String n = input_tf.getText().trim();
                if(n.length() < 1 ){
                    JOptionPane.showMessageDialog(Main2.this, "검색할 이름을 입력해 주세요");
                }else{
                    // DB 호출
                    search(n);
                }
            }
        });

        empno_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        job_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        deptno_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void search(String n){
        // SQL 문장을 통해 n을 전달하여 결과를 얻어내야 한다.
        SqlSession ss = factory.openSession();
        List<EmpVO> list = ss.selectList("emp.search_name", n);
        if(list != null && list.size()>0){ // DB로부터 받은 데이터가 있을 때만...
            // 받은 list를 JTable에 표현하기 위해 2차원 배열로 변환해야 한다.
            data = new String[list.size()][c_name.length];
            int i = 0;
            for(EmpVO vo : list){
                data[i][0] = vo.getEmpno(); // 사번
                data[i][1] = vo.getEname(); // 이름
                data[i][2] = vo.getJob(); // 직종
                data[i][3] = vo.getDeptno(); // 부서코드
                i++;
            }
            // JTable 갱신
            table.setModel(new DefaultTableModel(data, c_name));
        }
        ss.close();
    }

    private void init(){
        try {
            // Reader 생성
            Reader r = Resources.getResourceAsReader("pm/config/conf.xml");

            // 공장 생성
            factory = new SqlSessionFactoryBuilder().build(r);

            // 리소스 닫기
            r.close();
            this.setTitle("준비완료!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main2();
    }

}
