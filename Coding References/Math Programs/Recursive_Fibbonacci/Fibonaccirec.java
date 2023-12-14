import java.util.Scanner;
public class Fibonaccirec
{
   public static void main(String[] args)
   {
   
   
       System.out.print("Enter a value: ");
       Scanner sc = new Scanner(System.in); // implement user input
            int n = sc.nextInt();
            
            
            
            for(int i = 0; i < n; i++) // loop that stops when i reaches n thus terminating program
            {
            System.out.println(fibo(i)); // go to fibo
            }
            
            
            }
            
             public static int fibo(int n)
               {
            	if(n == 0)
                  {
               		return 0; // i first value is 0 first fibonacci is 0
               	}
               
            	if(n == 1 || n == 2) 
               {
            			return 1; // 1 and 1 are the second and third terms of fibonacci
            		}
                  
                  
            	return fibo(n-2) + fibo(n-1); // calls upon itself and adds values
            	}
               
                           }
                       