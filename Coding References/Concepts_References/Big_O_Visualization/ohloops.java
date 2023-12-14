import java.lang.Math;
public class ohloops
   {
   public static void main(String[] args)
      {
               int n = 10; // The Variable you change
                 
               System.out.println("This is my Linear counting loop");
               int dummyA = 0;                                         // dummy variable that gets printed
               for(int a = 0; a < n; a++)                             
                     {      
                       dummyA = a + 1;                                 // This goes up by 1 in a linear fashion
                       System.out.print(dummyA + ", ");                // Prints Values and adds space
                     }
                     
                     
               System.out.println("\n\nThis is my Logarithmic counting loop");    
               int dummyB = 0;                                         
               for(int b = 1; b <= n; b = b * 2)                       // This is the Logarithmic count. In this case incrementation is going up by times 2. It 
                     {
                       dummyB = b + 1;                                 // dummy increments
                       System.out.print(dummyB + ", ");                // Prints dummy and adds space
                     }
               
               
         
               System.out.println("\n\nThis is my Quadratic counting loop");    
               int dummyC = 0;
               for (int c = 1; c <= n; c++)                            // This is the Quadratic counting loop O(n^2)
                     {
                        System.out.print(c + " Times Iterated: ");     // Way to visalize outer loop
                        for(int d = 1; d <=n; d++)                     // Inner loop iterates n times as well
                              {
                               dummyC = c + d;                         // Simply counting to n
                               System.out.print(d + " ");
                              }
                        System.out.print("\n");                        // Loop has a new line to start on
                      }
    
       }   
 }
      // For the linear O(n) loop it iterates "n times" for both 100 and 10. 
      // For the Logarithmic loop O(log n) it only iterates 5 times for 10 and 7 times for 100. Because it doubles it is able to reach n very quickly.
      // For the Quadratic loop both iterate n times, then for each of those times there is another n times that it iterates.
      // It is clear that nested loops are intensive compared to linear, especially when higher terms are involved
      