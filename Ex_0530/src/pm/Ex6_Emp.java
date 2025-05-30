package pm;

import java.io.Serializable;

public class Ex6_Emp implements Serializable{
	String empno, ename, pos, hire_data, deptno;

	public Ex6_Emp(String empno, String ename, String pos, String hire_date, String deptno) {
		
		this.empno = empno;
		this.ename = ename;
		this.pos = pos;
		this.hire_data = hire_data;
		this.deptno = deptno;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getHire_data() {
		return hire_data;
	}

	public void setHire_data(String hire_data) {
		this.hire_data = hire_data;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
}
