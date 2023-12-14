

package studentquiz;
import java.util.Random;
import java.text.DecimalFormat;

// The purpose of this class is to generate random integer numbers for the quiz.
public class quiz {
    Random rand = new Random();
    int firstnum = rand.nextInt(101);
    int operation = rand.nextInt(4);
    int secondnum = rand.nextInt(101);
    
    
  public int getfirst()
{
    return firstnum;
}
    public int getoper()
{
    return operation;
}
     public int getsecond()
{
    return secondnum;
} 
  
  
    public String quest()
    {
        String opr = "";
        String fullquest = "";
       
        switch(this.getoper())
        {
            case 0:
                opr = "+";
                break;
            case 1:
                opr = "-";
                break;
            case 2:
                opr = "*";
                break;
            case 3: 
                opr = "/";
                break;
        }
        
        fullquest = (this.getfirst() + " " + opr + " " + this.getsecond() + " =");
       
     return fullquest;
    }      
    
    public String Answer()
    {
        double ans = 0;
        double firstdub = Double.valueOf(this.getfirst());
        double seconddub = Double.valueOf(this.getsecond());
        String reans ="";
        
        switch(this.getoper())
        {
        case 0:
                ans = firstdub+seconddub;
                break;
            case 1:
                ans = firstdub-seconddub;
                break;
            case 2:
                ans = firstdub*seconddub;
                break;
            case 3: 
                ans = firstdub/seconddub;
                break;    
        }
        
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        reans = df.format(ans);
        return reans;
    }
            
   // System.out.println(firstnum);
   // System.out.println(opr);
   // System.out.println(secondnum);
}
