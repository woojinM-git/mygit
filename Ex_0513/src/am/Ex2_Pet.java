package am;

public class Ex2_Pet {
	// private 를 꼭 붙여줘야한다
	private String name; // 이름
	private int age; // 나이
	
	// 주의 멤버필드와 지역변수가 변수명이 같다면 지역변수가 우선이다
	// 만약 현재 class의 멤버필드 즉 바깥 변수를 지정하고 싶다면 this. 을 붙여준다
	
	// 이름을 반환하는 getter, setter
	// 인자인 name을 받아서 멤버필드 name에 저장하는 기능
	public void setName(String name) {
		this.name = name;
	}
	// 멤버필드 name의 값을 호출한 곳으로 반환하는 기능
	public String getName() {
		return name;
	}
	
	// 나이를 반환하는 getter, setter
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	// 게터 세터 없는 상태에서 우클릭 -> source -> generate getter setter -> select All -> apply
	// getter, setter 자동완성
	/*
	 * 	물론
	 		private String name; // 이름
			private int age; // 나이
		는 준비되어 있어야 함
	 */
	
}
