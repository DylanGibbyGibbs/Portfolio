import java.io.*;
import java.math.*;
import java.util.regex.*;
class BigNumberExample{

   //String checker. Makes sure whatever string you pass is numerical, else the user has to enter it again. Gives feedback based upon both non integers and empty strings
   public static String checker() throws IOException
    {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int a = 0;
      
      String ph = "";                                                            //placeholder
      String isem = "";                                                          //is empty checker string
      
      while(a == 0)                                                              //Loop until a string of only numbers is entered
        {
         ph = in.readLine();                 
         if(ph.length() == 0)
            {
              System.out.println("Error: There is no input. Please Try Again");
              continue;
            }
         
         isem = ph.replaceAll("[^0-9]", "");                                     //get rid of any non numbers replace with blank space
         if(isem.length() != ph.length())                                        // if there is any difference in length. This means a non character was present and removed
            {
              System.out.println("Error: Non Digit In Input. Please Try Again");
              continue;                                                          //Reiterate loop
            }
         else                                                                    //If it is only numbers
            {
            return ph;                                                           //Apply the value to the waiting variable in main
            }
        }                                                                        //End of While
            return ph;                                                           //Emergency return. Should never use
    }    
      
      
     
      

   public static void main (String args[]) {
      try {
      
      //Take User Input By Utilizing the checker
      System.out.println("Enter number m");
      String mval = checker();
      System.out.println("Enter number e");
      String eval = checker();
      System.out.println("Enter number d");
      String dval = checker();
      System.out.println("Enter number n");
      String nval = checker();
      
      //Initialize BigIntegers
      BigInteger m = new BigInteger(mval);
      BigInteger e = new BigInteger(eval);
      BigInteger d = new BigInteger(dval);
      BigInteger n = new BigInteger(nval);
      
      //Perform Homework Operations 1-6 Using BigInteger API
      System.out.println("\n1. "+e.subtract(d));
      System.out.println("\n2. "+d.xor(e));
      System.out.println("\n3. "+ (m.and(d).xor(d)));                         //combine operations
      System.out.println("\n4. "+ d.xor(e).not());                            //xnor just combine an xor with a not
      System.out.println("\n5. "+ m.shiftRight(3));
      System.out.println("\n6. "+ m.shiftLeft(5));
      
      //Note on 7 and 8: I kept the ability to use 0. Originally could use negative too, but checker takes care of that problem now
      
      //7.
      String cval = "0";                                                      //initialize a number string. Shouldn't matter, value will be tossed. 
      BigInteger c = new BigInteger(cval);                                    //Creates a big integer c from that string
      if(n.compareTo(c) == 1)                                                 //If n.compareTo(c) (mattering for mod n) is not 1, meaning it is equal to or less than 0 thus invalid
         {
          c = m.modPow(e, n);                                                 //The big integer c goes through a modPow. m^e mod n. This changes the value of c to the answer we want
          System.out.println("\n7. "+c);                                      //Prints the value of c
         }
      else{
          System.out.println("\n7. Error: Modulus N shouldn't be 0");
          }
     
      //8.
      String gval = "0";                      
      BigInteger g = new BigInteger(gval); 
      if(n.compareTo(g) == 1)                         
         {    
           g = c.modPow(d, n);                    
           System.out.println("\n8. "+g);
         }
     else
         {
     System.out.println("\n8. Error: Modulus N shouldn't be 0");
         }

      
      }
      //Basic Error Handling That Gives A Useful Message To The User. Not Weakpoints That Could Be Exploited.
      catch(Exception e) {
             // e.printStackTrace();
         System.out.println("\nError: Please Make Sure All Variables Have Values And Are Only Numerical");
         }
  
     } 
   }
   

