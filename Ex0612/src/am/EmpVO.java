package am;

public class EmpVO {
	// emp테이블에서 필요로 하는 컬럼들을 멤버변수로 선언
	private String empno, ename, job, hiredate;
	// DB에서 데이터를 가져오면 문자열로 가져온다.
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
}
