public class Shape
{
public static void main(String[] args)
{
int i = 0;
int j = 0;
int a = 6;
//Outer loop work for rows  
for (i=0; i<a; i++)   
{  
//inner loop work for space      
for (j=2*(a-i); j>=0; j--)         
{  
//prints space between two stars      
System.out.print(" ");   
}   
//inner loop for columns  
for (j=0; j<=i; j++ )   
{   
//prints star      
System.out.print("* ");   
}   
//throws the cursor in a new line after printing each line  
System.out.println();   
}   


   for(i=0; i<a; i++)
      {
        for(j=2*(a-i); j >= 0; j--)
            { 
               System.out.print("");
             }
        for(j= 0; j<=i; j++) 
        {
            System.out.println("*");
            }

        System.out.println();
       }
                
            }
            }
            
            