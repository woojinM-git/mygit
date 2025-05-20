package am;

public class Ex01_Child extends Ex01_Parent{

	public Ex01_Child() {
		super(100);
	}
	
	public Ex01_Child(int n) {
		super(n);
	}

	@Override
	public void myData() {
		System.out.println("Child myData");
	}

}
