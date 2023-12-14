import java.util.Scanner;
   public class Powersrec
   {
    public static void main(String[] args) 
    { 
    
     System.out.print("Enter a value: ");
       Scanner sc = new Scanner(System.in); // implement user input
            int n = sc.nextInt();
      System.out.print("Enter another value: "); 
              int p = sc.nextInt();  
            
  
        System.out.println(power(n, p)); // takes 2 int
  
      
       }
  
   
    static int power(int a, int b) 
    { 
        if (b == 0) // anything to the 0 is 1
            return 1; 
        else
            return a * power(a, b - 1); 
    } 

}
