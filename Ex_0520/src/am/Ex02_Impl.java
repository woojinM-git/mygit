package am;

public class Ex02_Impl implements Ex02_Inter{

	int su = 20;

	@Override
	public int getValue() {
		return MAX_VALUE * su;
	}
	
	
}
