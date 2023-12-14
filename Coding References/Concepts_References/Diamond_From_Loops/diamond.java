import java.util.Scanner;
public class diamond 
      {

      public static void main(String args[]) 
           {
         
               System.out.println("Please enter an integer");         // Create user input.
               Scanner sc = new Scanner(System.in);  
               int size = sc.nextInt();
               while(size < 1)                                        // Create infinte loop unless value is more than one.
                 {
                     System.out.println("Please enter a value more than 1");
                     size = sc.nextInt();
                     continue;                                        // Check condition again
                 }
               
              
               int rows = 0; 
               int cols = 0;
               
              for(rows = 1; rows <= size; rows++)                     // The outer loop controls how it goes from 1 row to the next
                   {
                          for(cols = 1; cols <= size - rows; cols++)  // This will print the spaces. So if it is the first row it will have size - row spaces, for a size of 3 it will have 2 spaces.
                              {
                                  System.out.print(" ");
                              }
                          for(cols = 1; cols <= 2*rows-1; cols++)     // once it reaches the amount of space required it will print a star and continue the outer loop
                              {
                                 System.out.print("*");
                               }
                          System.out.print("\n");                     // new line and onto incrementation of row.
                   }       
                                 
                                 
              for(rows = size - 1; rows >=1; rows--)                  // This is just like above except it is decrementing. It wont print size amount of rows because that row was taken care of.
                   {     
                          for(cols = 1; cols <= size - rows; cols ++)
                          System.out.print(" ");
                          for(cols = 1; cols <=2*rows-1; cols++)
                          System.out.print("*");
                          System.out.print("\n");
                   }
    
            }
         
                
     }

// With this program there is nested for loops. Thus the big oh notation would be quadratic. O(n)^2
// I think that the growth function would be f(size) = (size)^2 + rows(size) + cols(size) + 0. Where the leading term (size)^2 is the most important.
// The amount of time that the program takes is greater the larger of the input. That is due to the nested loops.
