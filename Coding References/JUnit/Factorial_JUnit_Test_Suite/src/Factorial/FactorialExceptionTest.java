package Factorial;

import org.junit.Test;


public class FactorialExceptionTest {
	
	
	Factorial_1 f = new Factorial_1();
	
	

	
	
	@Test (expected=IllegalArgumentException.class)
	public void illegal_AE_Test() {
	f.factorial(-3);
	}
	


}
