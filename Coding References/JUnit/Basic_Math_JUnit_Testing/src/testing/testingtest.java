package testing;
import static org.junit.Assert.*;

import org.junit.Test;

public class testingtest{

	@Test
	public void divisiontest()
	{
		testing t = new testing();
		assertTrue(3 == t.division(3, 1));
	}
	
	@Test
	public void additiontest()
	{
		testing t = new testing();
		assertTrue(3 == t.addition(1, 2));
		
	}
	
	@Test
	public void subtractiontest()
	{
		testing t = new testing();
		assertTrue(3 == t.subtraction(5, 2));
	}
	
	@Test
	public void multiplicationtest()
	{
		testing t = new testing();
		assertTrue(3 == t.multiplication(3, 1));
		
	}

}
