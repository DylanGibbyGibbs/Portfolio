import java.util.*;

class TestException {

    public static void main(String s[]) {
    
        Scanner scanner = new Scanner(System.in);
        
        boolean valid=false;
        
        // validation loop
        while (!valid) {
           try {
               System.out.println("Enter integer:");
               int number = scanner.nextInt();  // may throw an exception
               System.out.println("You entered "+ number);
               valid=true;
           } catch(Exception e) {
               scanner.nextLine();  // clears out the junk from the scanner input
               System.out.println("ERROR: Must enter a number!!!");
           }
        }
    }
}