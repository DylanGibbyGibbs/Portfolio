import java.util.Scanner;
public class Namepos
{
   public static void main(String[] args)
   {
 
            
            
            
             String[] emp = {"Diana", "Becker", "Ann", "Eve", "Cory"};
               System.out.println("Please enter a name ");
               
               Scanner sc = new Scanner(System.in); // implement user input
               String n = sc.next();
                int result = search(emp, n);
                
         if(result == -1)
            System.out.println("Element is not found");
            else
               System.out.println("Element is found at position " + (result + 1));

               
              } 
              
              
              
               public static int search(String[] emp, String n)
                {  
            
                 for(int i = 0; i < emp.length; i++)
            {
               if(emp[i] == n) // searching element is found at i-th postition
                  return i;
                  }
                   
            return -1;// searching element is not found
           }
            }

            
            