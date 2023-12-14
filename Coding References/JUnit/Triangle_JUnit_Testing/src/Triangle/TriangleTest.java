package Triangle;

import static org.junit.Assert.*;
import org.junit.Test;





public class TriangleTest {

	@Test
	public void Is_Triangle_test() {
		Triangle t = new Triangle(50,65,79);
		assertTrue(t.isTriangle() == true);
	}
	
	@Test
	public void Not_Triangle_test() {
		Triangle t = new Triangle(0,0,79);
		assertFalse(t.isTriangle() == true);
	}
	
	@Test
	public void Is_Triangle_Not_test() {
		Triangle t = new Triangle(0,0,79);
		assertTrue(t.getType() == "non-triangle");
	}
	
	
	@Test
	public void Is_Triangle_Equilateral_test()
	{
		Triangle t = new Triangle(50,50,50);
		assertTrue(t.getType() == "equilateral");
	}
	
	@Test
	public void Is_Triangle_Scalene_test()
	{
		Triangle t = new Triangle(50,25,30);
		assertTrue(t.getType() == "scalene");
	}
	
	@Test
	public void Is_Triangle_Isosceles_test()
	{
		Triangle t = new Triangle(50,25,50);
		assertTrue(t.getType() == "isosceles");
	}
	
	
	
	
	

}
