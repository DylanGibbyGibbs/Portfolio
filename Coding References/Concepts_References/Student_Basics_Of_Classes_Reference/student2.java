import java.util.*;
public class student2
      {
          public static void main(String args[]) 
          {
                
             int[] stu_grade = new int[101];         //Grade Array
             String[] stu_name = new String[101];    //Name Array
             int[] id = new int[101];                //Id Array
             int x = 1;                              //Integer for purpose of assigning to x position in Arrays  
             boolean done=false;                     //Boolean Logic
             Scanner input = new Scanner(System.in); //Creates Input
                
             
                                   
              while (!done)                          //Loop to enter students
                {
                    System.out.print("Enter your Student Id 1-100(-1 to exit):");
                    x = input.nextInt();
                    while (x < -1 || x >100)
                        {
                            System.out.print("\nInvalid Entry Enter your Student Id 1-100(-1 to exit):");
                            x = input.nextInt();
                        }
               
                    if (x == -1)
                        {                                             
                            done=true;                              //If they enter -1, entry is complete. Move onto methods below.
                        }    
                   
                    else                                            // Assign values to the cells of the Arrays
                        {
                           id[x] = x;                               // Already have number from above
                           System.out.print("Enter Student Name:");
                           input.nextLine();
                           stu_name[x] = input.nextLine();
                           System.out.print("Enter the Grade:");
                           stu_grade[x] = input.nextInt();     
                        }
                }

           
                // Call Methods
                display(stu_grade, stu_name, id);    
                classavg(stu_grade);  
                findid(stu_grade, stu_name, id); 
                  
                         
             }// End of Main
             
             
             
             
             
             
          // This is to display the list of students
          public static void display(int[] stu_grade , String[] stu_name , int[] id)
          {
                System.out.println("\nHere is the list of Students");
                for (int x = 1; x<101; x++)
                   {         
                     if (stu_grade[x]>0)
                        {
                         System.out.println("Student Id: " + id[x] + " : " + stu_name[x] + "'s Grade is " + stu_grade[x] + "\n");
                        } 
                   }
                System.out.print("\n");
          }
    
          // This Displays the class average
          public static void classavg(int[] stu_grade)
          {
               int total = 0;                                                 //Will take all grades added together
               int stucounter = 0;                                            //Will keep track of how many students there are by seeing if there was any value recorded in grade
               double average = 0;
               for(int x = 1; x < 101; x++)
                  {
                    if(stu_grade[x] > 0)
                       { 
                         total = total + stu_grade[x];                        //Adds grade found to the total
                         stucounter++;                                        //A value was found so this increments
                       }
                   }
               average = total / stucounter;                                  //Total grades / how many students gets average
               System.out.println("The Class Average Is " + average + "%\n");
          }

      //This is to display information based on the student id
          public static void findid(int[] stu_grade , String[] stu_name , int[] id)
          {
               Scanner input = new Scanner(System.in);
               boolean done = false;
               int x = 1;
               while (!done) //Loop to enter students
                    {
                          System.out.print("Enter a Student Id to display Info(-1 to exit):");
                          x = input.nextInt();
                          while (x < -1 || x >100 )
                              {
                                  System.out.print("\nInvalid Entry Enter your Student Id 1-100(-1 to exit):");
                                  x = input.nextInt();
                              }
                        
                              if (x == -1)
                                 {
                                    done=true;
                                 }      
                              else
                                 {
                                    System.out.print("Student Id: " + id[x] + " : " + stu_name[x] +  "'s Grade is " + stu_grade[x] + "\n\n"); // note it will say nulls grade if there is no name. 
                                 }                                                                                                            // It if perfectly functional though.
                    }
          }
      }  
// The o() for the display method is o(n) 1 loop
// The o() for the classavg method is o(n) 1 loop
// The o() for the findid method is o(n^2) Nested loop
// The o() notation for both programs (At least the way that I wrote them) is the same. 
// The program itself is extremely similar to student 1. In student 1 it was 2 parrallel arrays with the id serving as a refernce.
// In this program an array is created for id, and all 3 arrays are parralell in relation to a variable. in this case x. 
// As far as whats better, student 1 would be for a smaller size. But i think the readability of student 2 may be better to visualize with the 3 arrays. 
// For implementation of the 3 arrays (at least the way that I did it) the only thing additional needed should be a variable to assign data to the arrays. 