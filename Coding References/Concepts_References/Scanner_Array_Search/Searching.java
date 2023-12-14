import java.util.Scanner;
public class Searching
{
// this is sequential searching
    public static void main(String[]args)
      {
         int[] arr = {4,6,7,1,10,9,5,12,36,3};
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the searching element: ");
         int key = sc.nextInt();
         int result = seqSearch(arr, key);
         if(result == -1)
            System.out.println("Element is not found");
            else
               System.out.println("Element is found at position " + (result + 1));
               
         }
         
         static int seqSearch(int[] arr, int k)
         {
         for(int i = 0; i < arr.length; i++)
            {
               if(arr[i] == k) // searching element is found at i-th postition
                  return i;
            }
            return -1;// searching element is not found
            }
         
         }