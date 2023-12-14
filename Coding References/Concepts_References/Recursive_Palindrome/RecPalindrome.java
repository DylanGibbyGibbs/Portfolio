import java.util.Scanner;
public class RecPalindrome
{

 public static void main(String[]args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Please enter a string : ");
      String str = sc.nextLine();
      
      if(pal(str))  // if returns true
      {
         System.out.println("It is a palindrome");
      }
      else // if returns false
      {
         System.out.println("It is not a palindrome");
      }
     
   }

   public static boolean pal(String let)
   {
      if(let.length() == 0 || let.length() == 1) // if just one letter or nothing it technically is a palindrome. 
         return true;                             // when there is nothing left or just one character after ommision it is true
         
      if(let.charAt(0) == let.charAt(let.length() - 1)) // if first value in string is same as last value 
      
         return pal(let.substring(1, let.length() - 1)); // activate the method but with the second letter and the second to last letter 
                                                         // omits the disregarded it and restarts 
      return false; // if it is not a palindrome 
   }
   
   
  }