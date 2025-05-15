package pm;

import java.util.ArrayList;

public class Comp {
	ArrayList<Emp> a1 = new ArrayList<>();
	Emp e1 = new Emp("사번", "이름", "직책", "부서");
	
	public String choose(int c) {
		StringBuffer str = new StringBuffer();
		for(int i = 0; i < a1.size(); ++i) {
			Emp emp = a1.get(i);
			
			String emp1 = emp.getName();
			
			if(c == i) {
				str.append("검색할 ");
				str.append(emp1);
			}
		}
		
		return str.toString();
	}
}
