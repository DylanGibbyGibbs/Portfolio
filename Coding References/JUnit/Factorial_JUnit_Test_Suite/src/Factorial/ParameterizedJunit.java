package Factorial;

import java.util.Arrays;
 import java.util.Collection;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.junit.runners.Parameterized;
 import org.junit.runners.Parameterized.Parameters;
 import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParameterizedJunit {
	private int num1;
	private int num2;
	
	public ParameterizedJunit(int num1, int num2)
	{
		this.num1= num1;
		this.num2 = num2;
	}
	
	
	 //test data generator: a collection of arrays
	 @Parameters
	 public static Collection<Object[]> data() {
	 Object[][] data = new Object[][] { { 3, 6 }, { 4, 24 }, { 2, 2 }, { 5, 120}};
	 return Arrays.asList(data);
	 }
	 
	 
	
	 @Test
	 public void calculationTest() {
		 Factorial_1 f = new Factorial_1();
	 assertTrue(f.factorial(num1)  == num2);
	 }
	 
	 }
	

	
	
	
	


