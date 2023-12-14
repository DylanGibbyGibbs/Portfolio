public class testException  

   {
      public static void main(String [] args)
      {
      
      
      try
         {

               //Harvester
               Harvester parhar = new Harvester(16, 42, 28, 3);
               parhar.owner = "Dylans";
               System.out.println(parhar.toString());
               
               //Tractor
               Tractor partrac = new Tractor(5, 69, 4);
               System.out.println(partrac.toString());
               
               //Loader
               Loader parload = new Loader(6, 6, 9, 3);
               System.out.println(parload.toString());
                     
               
          } 
       catch (TractorException e)
           {
              System.out.println(e.getMessage());
           } 
       catch (Exception e)
           {
              System.out.println("General Exception");
           }
      
       
      
      }
   }
   