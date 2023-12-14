import java.util.*;
import java.util.regex.*;
import java.util.Scanner;


//The Purpose of this class is to take user input. Numbers and a operation. This works with Calculation
class Lab_1
{
 public static void main (String args[])
      {
         try
            {
            Scanner in = new Scanner(System.in); 
            boolean loop = true;
            String firstnum = "";
            String secondnum = "";                                                         
            String opr = "";
            double firstdub;
            double seconddub;
                                                                                       
            System.out.println("____________________Calculator____________________");
            System.out.println("__________________________________________________");
            
           
           
            
            //Take user input with respective dummy proof methods
            firstnum = dubcheck(firstnum);
            opr = opcheck(opr);
            secondnum = dubcheck(secondnum);
            
            //Make sure that division by any sort of 0 is not allowed. 
            if(opr.equals("/") == true)
               { 
               if(secondnum.equals("0") == true || secondnum.matches("0*\\.0*") == true)
                  {
                  System.out.println("Division by 0 is not allowed");
                  System.exit(0);
                  }
               }
            
            //make these values doubles to handle decimals   
            firstdub = Double.parseDouble(firstnum);
            seconddub = Double.parseDouble(secondnum);
            
            //create a calculation   
            Calculation newcalc = new Calculation(firstdub, seconddub); 
            
            //Take the operation and switch case it
            switch(opr)
               {
                  case "+":
                    newcalc.add();
                    break;
                  case "-":
                    newcalc.sub();
                    break;
                  case "*":
                    newcalc.mul();
                    break;
                  case "/":
                    newcalc.div();
                    break;

               }
            
            
            
            
            
            
            }
            //The most basic error handling
            catch (Exception e) 
               {
               
               System.out.println("error");
               }
        } //End Of Main




      //Basic logic for checking passed number values
      public static String dubcheck(String dbl)
               {
               Scanner in = new Scanner(System.in); 
               boolean b = false;                                                           
               while(b == false)
                  {                                                                                            
                     System.out.print("Number:    "); 
                     dbl = in.nextLine();
                     
                     if(dbl.length() == 0)
                           {
                              System.out.println("Input Can't Be Blank.");
                              continue;
                           }
                     if(dbl.matches("(\\-?[0-9]*)") == false)
                           {
                              System.out.println("Please limit input to Integers");
                              continue;
                           }       
                     break;
                  
                  }
                return dbl;
               
               }//end of dubcheck
        
        
        //opcheck is a userproof way of taking in one of the 4 main operation values of math
        public static String opcheck(String op)
               {
               Scanner in = new Scanner(System.in); 
               boolean b = false;                                                           
               while(b == false)
                  {                                                                                            
                     System.out.print("Operation: "); 
                     op = in.nextLine();
                     
                     if(op.length() == 0)
                           {
                              System.out.println("Input Can't Be Blank.");
                              continue;
                           }
                     if(op.equals("+") == false && op.equals("-") == false && op.equals("/") == false && op.equals("*") == false)
                           {                               
                              System.out.println("Please limit input to 1 operation character");
                              continue;
                           }
                     break;
                    }
                  return op;
                  }//End of opcheck
                  
 }//end of program
               
             
               
         


