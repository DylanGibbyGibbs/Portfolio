package Triangle;

public class Triangle 
{
	long lborderA = 0;
	long lborderB = 0;
	long lborderC = 0;

	public Triangle(long lborderA,long lborderB,long lborderC){
		this.lborderA = lborderA;
		this.lborderB = lborderB;
		this.lborderC = lborderC;
	}
	// Check if the given input is a triangle or not 
	public boolean isTriangle() {
		boolean isTrue = false; 
		//The sum of two edges is greater that the third edge?
		if( (lborderA < (lborderB + lborderC)) &&(lborderB < (lborderA + lborderC)) &&(lborderC < (lborderA + lborderB)) &&lborderA>0 && lborderB>0 && lborderC>0)
			isTrue = true;
		return isTrue;
	}

	// Check what types of triangle, return "equilateral" "isosceles" "scalene" or "non-triangle"
	public String getType(){
		String strType = "non-triangle";
		if(isTriangle()){
			//equilateral triangle
			if( lborderA == lborderB && lborderB == lborderC )
				strType = "equilateral";
			else
				//scalene 
				if( (lborderA != lborderB) &&(lborderB != lborderC) &&(lborderA != lborderC))
 					strType = "scalene";
				else
					// isosceles
					strType = "isosceles";
		}
		return strType;
	}
}
