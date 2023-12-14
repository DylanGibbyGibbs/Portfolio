import java.util.Scanner;
public class Password
{
   public static void main(String[] args)
   {
   
   
       System.out.print("Enter a password: ");
       Scanner sc = new Scanner(System.in); // implement user input
            String n = sc.nextLine();
            
            
            if(passValidity(n))
            System.out.println("The password is valid");
            else
            System.out.println("The password is invalid");
            
            }
            
            
            
            
            public static boolean passValidity(String p)
            {
            if(p.length() < 8)
            {
            System.out.println("Length Invalid");
            return false;
           }
           
            boolean let = p.matches(".*[a-zA-Z]+.*");
            
            
            if(let == false)
            {
            System.out.println("Must contain 1 letter");
            return false;
            }
        
            
              boolean zer = p.contains("0");  boolean one = p.contains("1"); boolean two = p.contains("2");boolean thr = p.contains("3"); boolean fou = p.contains("4");  boolean fiv = p.contains("5");boolean six = p.contains("6");  boolean sev = p.contains("7"); boolean eig = p.contains("8"); boolean nin = p.contains("9");
           
              if(zer||one||two||thr||fou||fiv||six||sev||eig||nin == true) 
              
              

            
            
            return true;
            else
            {
            System.out.println("Must contain 1 number");
            return false;
            }
            
           
            }
            }
            