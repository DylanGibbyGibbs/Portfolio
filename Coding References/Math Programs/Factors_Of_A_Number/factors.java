public class factors
   {
   public static void main(String[] args)
          {
            for(int i = 1; i <= 100; i++) // iterate 1 to 100
               {
                  System.out.print(i + "'s factors are as follows: "); // Ease of reading improvement
                  System.out.println(printfactor(i)); // Call upon method
               }
            
          }
     
   public static String printfactor(int n) 
       {
           String dummy = "";              // need a return type that isn't intrusive
           
           for(int b = 1; b <= 100; b++)    // iterates potential factors 1 to 100
                {
                  if(n % b == 0)                  // using modulus. if it has no remainder / equal to 0 it is a factor  
                  System.out.print(b + " ");      // print factor and leave a space
                }
    
          return dummy;
       }  
        
   }
   
   /*In the main method the only value that changes is i (increments). so the O() should be O(n) linear
   This should be true for printfactor as well. b increments the same way. If statements shouldn't affect this.*/
   
   