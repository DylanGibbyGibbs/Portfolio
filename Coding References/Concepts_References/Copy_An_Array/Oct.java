public class Oct
{
   public static void main(String[] args)
      {
      //int size = 10; // if variable is initialized we can use it in array declaration.
      //int[] a = {1,2,3,4,5,6,7,8,9,10}; // valid array declaration that still outputs length
      //int[] a = new int[size]; // 
      
      int[] a = {1,2,3,4,5};
      int[] b = new int[a.length]; // creates an array the size of a
      
    //  for(int i = 0; i < a.length; i++) // this is the array copy operation
          //  b[i] = a[i];
          
          a = b; // doing this does not copy and create a new array
          
      for(int i = 0; i < a.length; i++)
      System.out.print(b[i] + " ");      
             
     // System.out.println(a.length);
      }
}