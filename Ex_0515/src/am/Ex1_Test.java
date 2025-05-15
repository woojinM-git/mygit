package am;

public class Ex1_Test {
	// 멤버변수 선언
	private String name;
	private int age;
	
	// 생성자는 반드시 접근제한자가 있어야 하며, 반환형은 명시하지 않는다.(void가 아님)
	// 이름은 반드시 클래스명과 같아야 한다. ******* 중요 ********
	public Ex1_Test(String name, int age) {	// 필요한 정보들을 자료형과 함께 작성해둔다
		// 받은 인자들을 멤버필드에 저장 - ** 인자들은 모두 지역변수 **
		this.name = name; // 지역변수와 멤버변수가 이름이 같아 밖의 멤버필드name을 가리키기 위해 this를 붙여줌 
		this.age = age;
		
	} // 생성자의 끝
	
	public Ex1_Test() {	// 기본생성자의 형태	, 생성자를 만들면 기본생성자를 만들어야 한다.
		// 기본생성자는 개발자가 생성자를 만들지 않았을때 표시되지는 않지만 기본생성자를 만들어 준다
	} // 기본생성자의 끝
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
