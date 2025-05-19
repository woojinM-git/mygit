package pm;

public class Ex09_Child1 extends Ex09_Parent {

	private String msg = "Chiled1";
	private int value; // 0
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getValue() {
		return value; // 부모의 value가 아닌 자신의 value를 반환
	}
	public void setValue(int value) {
		this.value = value;
	}
}
