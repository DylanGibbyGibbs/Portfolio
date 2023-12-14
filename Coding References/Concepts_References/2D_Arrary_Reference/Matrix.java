public class Matrix
   {
      public static void main(String[] args)
         {
         int[][] a ={{2,1,3},
                    {9,8,11},
                    {10,7,4}};
         int[][] b ={{5,-1,3},
                    {2,10,5},
                    {6,4,1}};
         int[][] c = new int[3][3];
         
         // Matrix addition operation
         
         for(int i = 0; i < 3; i++) // matrix rows
            {
              for(int j = 0; j < 3; j++) // matrix columns in each row
                  {
                      c[i][j] = a[i][j] + b[i][j]; // all it is is variables being added, dont freak about the [i][j]
                  }
            }
            
        for(int i = 0; i < c.length; i++) 
            {
              for(int j = 0; j < c[i].length; j++) 
                  {
                  System.out.print(c[i][j] + " ");
                  }
                  System.out.println();
                  
                  }
                  }
                  }
         
         
