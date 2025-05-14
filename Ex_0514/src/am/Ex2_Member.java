package am;

public class Ex2_Member {
	// 필요한 정보들을 멤버필드로 선언한다.
	// private String name, phone;
	
	private String name;	// 이름
	private String phon_num;	// 전화번호
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhon_num() {
		return phon_num;
	}
	public void setPhon_num(String phon_num) {
		this.phon_num = phon_num;
	}
	
}
