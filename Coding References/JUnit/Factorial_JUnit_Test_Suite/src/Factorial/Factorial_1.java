
package Factorial;

public class Factorial_1 {
	
	

	   public int factorial(int n) {
	          if (n < 0) 
	             throw new IllegalArgumentException( "factorial cannot handle negative numbers!!" );
	 
	          if (n == 0) 
	               return 1;
		     else 
	               return n * factorial(n - 1);
	   }
	   
	   
	   
	   
	   
	   
	}

	
	
	

